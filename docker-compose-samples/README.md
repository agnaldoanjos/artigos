# KAFKA
## Demonstração de spring boot integrado ao kafka kafka

Para execução desses projetos é necessário instalação do Docker e  execução do comanda o diretório raiz (.\kafka):

```console
## Executa o arquivo docker-compose.yml por padrão, o nome da composição será o nome da pasta atual
docker-compose up -d

ou 

## Executa o coloca o nome kafka por padrão e carrega o arquivo docker-compose-kafka.yml

docker-compose -p kafka -f docker-compose-kafka.yml up -d

docker-compose -p db-mogo -f docker-compose-mongo.yml up -d

docker-compose -p db-postgres -f docker-compose-postgres.yml up -d
```

O comando **docker-compose up -d** criará a network e os containers esperados, realizando inclusive o download das imagens se as mesmas ainda não existirem na máquina considerada.

![dockerdesktop imagens](img/kafka_imagens_dockerdesktop.png)

![dockerdesktop containers](img/kafka_dockerdesktop.png)

