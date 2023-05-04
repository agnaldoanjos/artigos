*** Settings ***
Library     ../library/gerar_cpf.py

*** Test Cases ***
Gerar CPF Aleatório
    ${cpf}    Gerar CPF
    Should Match Regexp    ${cpf}    \d{3}\\.\d{3}\\.\d{3}\\-\d{2}
