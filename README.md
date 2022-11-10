# Blog CRUD

Aplicação de CRUD para posts em um blog usando Java Spring Boot e Thymeleaf para fazer as telas, além de uma base de
dados postgres.

## Dependências

- Spring Boot: 2.2.2
- spring-boot-starter-data-jpa
- spring-boot-starter-thymeleaf
- spring-boot-starter-web
- spring-boot-devtools
- postgresql
- spring-boot-starter-test
- slf4j-api: 1.7.30

## Rotas

|      Rota      |                  Função                 |
|:--------------:|:---------------------------------------:|
|      `/`       |        Tela inicial da aplicação        |
|     `/add`     | Abre formulário para o cadastro do post |
|  `/edit/{id}`  |  Abre formulário para o edição do post  |
| `/delete/{id}` |       Deleta o post da base dados       |
|    `/save`     |   Salva as alterações na base de dados  |