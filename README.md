# PoC para Arquitetura Hexagonal
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/josivaldobatista/pesquisa-game/blob/main/LICENSE)
## Arquitetura Hexagonal
![Arquitetura](https://github.com/josivaldobatista/hexagonal_architecture_PoC/blob/main/img/hexagonal_architecture.png) 
## Kafka
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

Comandos:
```bash
docker compose up
```
```bash
./gradlew bootRun
```

Deixei algumas collections na pasta CI que foram feitas no Insomnia pode baixar clicando aqui https://insomnia.rest/download 


