# User Service

Microsserviço responsável pelo cadastro de usuários e pela publicação de mensagens para processamento assíncrono de e-mails.

O serviço faz parte de um conjunto de microsserviços desenvolvido com Java e Spring Boot, utilizando RabbitMQ para comunicação entre serviços.

## Arquitetura

Fluxo simplificado:

```text
Cliente
   │
   ▼
User Service
   │
   │ mensagem
   ▼
RabbitMQ
   │
   ▼
Email Service
```

Após o cadastro, o serviço publica uma mensagem para que o Email Service realize o processamento do e-mail.

## Responsabilidades

- Cadastrar usuários
- Validar dados recebidos
- Persistir usuários
- Publicar mensagens para processamento assíncrono
- Documentar a API com OpenAPI
- Disponibilizar informações de saúde e métricas
- Tratar exceções da API

## Tecnologias

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Validation
- Spring AMQP
- RabbitMQ / CloudAMQP
- PostgreSQL
- Springdoc OpenAPI
- Spring Boot Actuator
- Docker
- JUnit 5
- Mockito

## Requisitos

- Java 21
- Maven
- PostgreSQL
- RabbitMQ ou CloudAMQP

## Configuração

As configurações de banco de dados e RabbitMQ podem ser fornecidas por variáveis de ambiente.

| Variável | Descrição | Exemplo |
|---|---|---|
| `DB_URL` | URL de conexão com o PostgreSQL | `jdbc:postgresql://localhost:5432/microservice-usuario` |
| `DB_USERNAME` | Usuário do PostgreSQL | `postgres` |
| `DB_PASSWORD` | Senha do PostgreSQL | `admin` |
| `JPA_DDL_AUTO` | Estratégia de atualização do schema | `update` |
| `RABBITMQ_ADDRESSES` | Endereço do RabbitMQ ou CloudAMQP | `amqps://...` |
| `RABBITMQ_EMAIL_QUEUE` | Nome da fila utilizada pelo Email Service | `...` |

## Executando

Clone o repositório:

```bash
git clone https://github.com/bispobr/Spring-java-microservice-usuario.git
cd Spring-java-microservice-usuario
```

Compile e execute:

```bash
./mvnw clean package
./mvnw spring-boot:run
```

A aplicação utiliza a porta `8081`.

## API

### Cadastrar usuário

```http
POST /usuario
Content-Type: application/json
```

Exemplo:

```json
{
  "nome": "Nome do usuário",
  "email": "usuario@email.com"
}
```

## Documentação da API

Com a aplicação em execução:

```text
http://localhost:8081/swagger-ui/index.html
```

## Actuator

Endpoint de saúde:

```text
http://localhost:8081/actuator/health
```

O Actuator também disponibiliza métricas da aplicação.

## Docker

O projeto possui configuração relacionada a Docker documentada no repositório. A execução deve ser feita de acordo com os arquivos de infraestrutura presentes na versão atual do projeto.

## Testes

```bash
./mvnw test
```

## Serviços relacionados

- [Email Service](https://github.com/bispobr/Spring-java-microservice-email)
- [Order Service](https://github.com/bispobr/Spring-java-microservice-pedido)
- [Processing Service](https://github.com/bispobr/Spring-java-microservice-processamento)

## Status

Projeto de estudo desenvolvido para praticar APIs REST, persistência com PostgreSQL, tratamento de exceções e comunicação assíncrona utilizando RabbitMQ.
