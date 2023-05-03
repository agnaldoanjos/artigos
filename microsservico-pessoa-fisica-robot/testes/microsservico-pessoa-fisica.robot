*** Settings ***
Library             RequestsLibrary
Library             FakerLibrary    locale=pt_BR
Resource            ./robot_variables.robot
Suite Setup         Initialize Suite
Suite Teardown      Teardown Suite

*** Variables ***
${cpf}              ${EMPTY}
${nome}             Agnaldo Fernandes dos Anjos
${dataNascimento}   1972-10-08

*** Test Cases ***
Criar pessoa fisica
    [Tags]    POST
    Generate CPF
    &{headers}=    Create Dictionary    Content-Type=${CONTENT_TYPE}
    ${payload}=    Create Dictionary    id=0    nome=${nome}    cpf=${cpf}    dataNascimento=${dataNascimento}
    ${response}=    POST On Session    pessoa_fisica_session    ${API_ENDPOINT}    json=${payload}    headers=${headers}
    Should Be Equal As Strings    ${response.status_code}    201

Atualizar pessoa fisica
    [Tags]    PUT
    &{headers}=    Create Dictionary    Content-Type=${CONTENT_TYPE}
    ${payload}=    Create Dictionary    nome=${nome} - Atualizado    cpf=${cpf}    dataNascimento=${dataNascimento}
    ${response}=    PUT On Session    pessoa_fisica_session    ${API_ENDPOINT}/${cpf}    json=${payload}    headers=${headers}
    Should Be Equal As Strings    ${response.status_code}    200

Obter pessoa fisica
    [Tags]    GET
    ${response}=    GET On Session    pessoa_fisica_session    ${API_ENDPOINT}/${cpf}
    Should Be Equal As Strings    ${response.status_code}    200
    ${nome_retornado}=    Set Variable    ${response.json()["nome"]}
     Should Be Equal As Strings    ${nome} - Atualizado    ${nome_retornado}

Excluir pessoa fisica
    [Tags]    DELETE
    ${response}=    DELETE On Session    pessoa_fisica_session    ${API_ENDPOINT}/${cpf}
    Should Be Equal As Strings    ${response.status_code}    204

*** Keywords ***
Initialize Suite
    Create Session    pessoa_fisica_session    ${BASE_URL}

Teardown Suite
    Delete All Sessions

Generate CPF
    ${cpf}    FakerLibrary.cpf
    Set Global Variable    ${cpf}

