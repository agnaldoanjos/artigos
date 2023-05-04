*** Settings ***
Library     ../library/gerar_cnpj.py

*** Test Cases ***
Gerar CNPJ Aleatório
    ${cnpj}    Gerar CNPJ
    Should Match Regexp    ${cnpj}    \d{2}\\.\d{3}\\.\d{3}\\/\d{4}\\-\d{2}
