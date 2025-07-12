# Microserviço de Cadastro de Usuário - Java Spring

Este repositório contém a primeira parte de um projeto de microserviços desenvolvido com **Java Spring**, com foco, na prática de comunicação assíncrona entre serviços e uso de boas práticas de observabilidade e documentação.

## Descrição

A API oferece um endpoint para **cadastro de usuários**, contendo os campos `nome` e `email`. Após o cadastro, uma mensagem personalizada de boas-vindas é gerada e enviada para o e-mail do usuário por meio de uma fila de mensagens, utilizando **RabbitMQ**.

## Tecnologias  Utilizadas

- **Java + Spring Boot** – Framework principal da aplicação.
- **RabbitMQ** com **CloudAMQP** – Comunicação assíncrona entre serviços.
- **PostgreSQL** – Persistência dos dados dos usuários.
- **Lombok** – Uso da anotação `@Slf4j` para geração de logs.
- **Springdoc OpenAPI (Swagger)** – Documentação  dos endpoints da API.
- **Spring Boot Actuator** – Monitoramento da aplicação.
- Integração entre **Actuator e Swagger** para exposição de métricas via documentação da API.

## Requisitos

- Java 21+
- Maven
- PostgreSQL

## Executando o Projeto

1. Clone o repositório 1:

```bash
git https://github.com/bispobr/Spring-java-microservice-usuario.git
```
2. Clone o repositório 2:

```bash
git https://github.com/bispobr/Spring-java-microservice-email.git
```

3. Altere o arquivo de configuração **application.properties** com as credenciais de login do PostgreSQL do seu ambiente,juntamente com suas credenciais de email.

## Como usar

1. Inicie a aplicação
2. A API está acessível através do endereço http://localhost:8081
3. A documentação da API está acessível através do Link http://localhost:8081/swagger-ui/index.html#/
4. O endpoint de saúde e métricas do Actuator está acessível através do Link http://localhost:8081/actuator/health


## API Endpoints
API contem os seguintes endpoints:

```http request
Post /usuario - Endpoint REST para cadastro de usuários
Content-Type: application/json

{
  "nome": "aaaaaaaaa",
  "email": "xxxxxxxxx@xxxxx.xxx"
}
```
| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `nome` | `String` | **Obrigatório**. O nome do usuário 
| `email` | `String` | **Obrigatório**. O email do usuário