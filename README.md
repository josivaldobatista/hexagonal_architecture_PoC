# PoC para Arquitetura Hexagonal
## Arquitetura Hexagonal

Nesse projeto foi apenas abordado os aspectos relacionados a Arquitetura Hexagonal, outros temas como segurança, validações e outros temas não foram implementado.

![Arquitetura](https://github.com/josivaldobatista/hexagonal_architecture_PoC/blob/main/img/hexagonal_architecture.png) 
## Fluxo do projeto
![Arquitetura](https://github.com/josivaldobatista/hexagonal_architecture_PoC/blob/main/img/hexagonal_architecture_kafka.png)

# Tecnologias utilizadas
## Back end
- Java
- Spring Boot
- JPA / Hibernate
- Gradle
- MongoDB
- Kafka
- Spring Cloud OpenFeign

# Como executar o projeto
## Back end
- Pré-requisitos: Java 17
- Docker

Após baixar o projeto com o comando ```git clone https://github.com/josivaldobatista/hexagonal_architecture_PoC.git``` vá até a pasta raiz do projeto e rode o comando no terminal ```docker compose up``` com isso irá subir as imagens do docker. Depois disso, ainda na pasta raiz rode o comando ```./gradlew bootRun``` para executar a aplicação.

Foi usado o Wiremock para simular a Api de consulta de endereço e para a validação de CPF publicamos uma mensagem para testar o consumer.
Mensagem enviada logo abaixo. Obs: Adeque a suas necessidades.
```bash
{
	"id": "63fa9aca37d8832eec61ed24",
	"name": "Fulano de Tal",
	"zipCode": "38400000",
	"cpf": "98765432100",
	"validCpf": true
}
```

Comandos:
```bash
docker compose up
```
```bash
./gradlew bootRun
```

Deixei algumas collections na pasta CI que foram feitas no Insomnia pode baixar clicando aqui https://insomnia.rest/download 


