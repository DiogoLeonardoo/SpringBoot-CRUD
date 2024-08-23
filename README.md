# API New SIGAA

## Descrição

Este projeto é uma API RESTful desenvolvida em Java utilizando o framework Spring Boot. A API é destinada à gestão de professores e disciplinas, permitindo operações CRUD (Create, Read, Update, Delete) e consultas específicas.

## Tecnologias Utilizadas

- **Java**
- **Spring Boot**
- **Maven**
- **Jakarta Validation**
- **SQL**

## Estrutura do Projeto

### Pacotes Principais

- `controller`: Contém os controladores REST que expõem os endpoints da API.
- `dto`: Contém os Data Transfer Objects (DTOs) utilizados para transferir dados entre as camadas da aplicação.
- `model`: Contém as classes de modelo que representam as entidades do banco de dados.
- `repository`: Contém as interfaces de repositório que interagem com o banco de dados.
- `service`: Contém as classes de serviço que implementam a lógica de negócios da aplicação.

### Endpoints Principais

#### ProfessorController

- `GET /professor`: Obtém todos os professores.
- `GET /professor/{id}`: Obtém um professor pelo ID.
- `GET /professor/findByMat/{mat}`: Obtém um professor pela matrícula.
- `POST /professor`: Cria um novo professor.
- `PUT /professor`: Atualiza um professor existente.
- `DELETE /professor/{id}`: Deleta um professor pelo ID.
- `DELETE /professor/deletar/{matricula}`: Deleta um professor pela matrícula.
- `GET /professor/ObterDisciplinasPorProfessor/{matricula}`: Obtém um professor e suas disciplinas pela matrícula.

#### DisciplinaService

- `ObterDisciplinasPorProfessor(String matricula)`: Obtém as disciplinas de um professor pela matrícula.
- `ObterDisciplinaPorIds(List<Integer> discplinaIds)`: Obtém disciplinas por uma lista de IDs.
- `ObterDisciplinaPorId(Integer id)`: Obtém uma disciplina pelo ID.
- `ObterTodas()`: Obtém todas as disciplinas.
- `ObterDisciplinasComAlunos()`: Obtém todas as disciplinas com seus respectivos alunos.
- `ObterDisciplinaComAlunosPorId(Integer id)`: Obtém uma disciplina com seus alunos pelo ID.


#### Conclusão 

- Projeto realizado como forma de avaliação da disciplina de PROGRAMAÇÃO 1, do curso de Análise e Desenvolvimento de Sistema
- Instituto Federal de Sergipe
- Diogo Leonardo Lima e Silva