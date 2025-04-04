# Spring-Java-Microservice-Usuario
Este repositório contém a primeira parte de um projeto de microserviço desenvolvido em Java Spring. O serviço realiza comunicação assíncrona utilizando RabbitMQ e Cloud AMQP. O objetivo é praticar a construção de microserviços com Java Spring.

## Instalação

1. Clone o repositório 1:

```bash
git https://github.com/bispobr/Spring-java-microservice-usuario.git
```
2. Clone o repositório 2:

```bash
git https://github.com/bispobr/Spring-java-microservice-email.git
```

3. Instale as dependências com Maven

## Como usar

1. Inicie a aplicação 
2. API está acessível através do endereço http://localhost:8081


## API Endpoints
API contem os seguintes endpoints:

```http request
Post /usuario - cadastra um novo usuario.
```

```http request
POST /produto - Registra um novo Dado.
Content-Type: application/json

{
  "nome": "aaaaaaaaa",
  "email": "xxxxxxxxx@xxxxx.xxx"
}
```
## Banco de Dados
Esse projeto utiliza o PostgresSQL como Banco de Dados.