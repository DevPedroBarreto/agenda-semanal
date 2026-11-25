# 📅 Agenda Semanal

> API REST para organizar a rotina da semana entre vida profissional, espiritual, atividade física e estudos: cadastre seus compromissos por dia e horário e consulte a semana inteira, ordenada.

![Status](https://img.shields.io/badge/status-em%20desenvolvimento-orange)
![Java](https://img.shields.io/badge/Java-21-red?logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1-6DB33F?logo=springboot&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-4169E1?logo=postgresql&logoColor=white)
![Angular](https://img.shields.io/badge/Angular-em%20breve-DD0031?logo=angular&logoColor=white)

---

## 💡 Sobre o projeto

A **Agenda Semanal** nasceu de uma necessidade real: organizar a minha rotina e equilibrar quatro áreas da vida.

| Categoria | Valor na API | Exemplos |
|---|---|---|
| 💼 Profissional | `PROFISSIONAL` | trabalho, reuniões, projetos |
| 🙏 Espiritual | `ESPIRITUAL` | igreja, oração, leitura |
| 🏃 Atividade física | `ATIVIDADE_FISICA` | academia, corrida, bicicleta |
| 📚 Estudos | `ESTUDOS` | faculdade, cursos, programação |

Cada compromisso tem um título, um dia da semana, um horário de início e fim e uma categoria:

```
SEGUNDA | 07:00 - 17:00 | Trabalho | PROFISSIONAL
```

O projeto começou como um programa de console em Java puro (veja a tag [`v0.1-console`](https://github.com/DevPedroBarreto/agenda-semanal/tree/v0.1-console)) e evoluiu para uma API REST com Spring Boot e PostgreSQL. O próximo passo é a interface web em Angular.

## ✨ Funcionalidades

- [x] Cadastrar compromissos (título, dia da semana, início, fim e categoria)
- [x] Listar a semana ordenada por dia e horário de início
- [x] Buscar um compromisso pelo id
- [x] Editar e excluir compromissos
- [x] Recusar horários inválidos (o fim precisa ser depois do início)
- [x] Persistência em banco de dados PostgreSQL
- [ ] Bloquear conflitos de horário no mesmo dia
- [ ] Filtrar compromissos por dia e por categoria
- [ ] Resumo semanal de horas por categoria
- [ ] Documentação interativa com Swagger
- [ ] Testes automatizados
- [ ] Interface web em Angular
- [ ] Deploy online

## 🛠️ Tecnologias

| Camada | Tecnologia |
|---|---|
| Linguagem | Java 21 |
| Framework | Spring Boot 4.1 (Spring Web) |
| Persistência | Spring Data JPA + Hibernate |
| Banco de dados | PostgreSQL |
| Build | Maven (com Maven Wrapper) |
| Testes de API | Postman |
| Front-end | Angular *(em desenvolvimento)* |

## 🏗️ Arquitetura

O projeto segue a arquitetura em camadas, em que cada uma tem uma única responsabilidade:

```
Cliente (Postman / navegador)
        │  HTTP + JSON
        ▼
┌──────────────────────┐
│  Controller          │  recebe requisições e devolve respostas com o status HTTP certo
├──────────────────────┤
│  Service             │  aplica as regras de negócio (validação de horário, ordenação)
├──────────────────────┤
│  Repository          │  acessa o banco via Spring Data JPA
└──────────────────────┘
        │  SQL (gerado pelo Hibernate)
        ▼
    PostgreSQL
```

```
src/main/java/com/pedro/agenda_semanal/
├── AgendaSemanalApplication.java
├── controller/   → CompromissosController, PingController
├── service/      → CompromissoService
├── repository/   → CompromissoRepository
└── model/        → Compromisso (entidade JPA), Dia, Categoria
```

## 🔌 Endpoints

| Método | Endpoint | Descrição | Respostas |
|---|---|---|---|
| `GET` | `/compromissos` | Lista todos os compromissos, ordenados por dia e início | `200` |
| `GET` | `/compromissos/{id}` | Busca um compromisso pelo id | `200` · `404` |
| `POST` | `/compromissos` | Cria um compromisso (o id é gerado pelo banco) | `201` · `400` |
| `PUT` | `/compromissos/{id}` | Substitui um compromisso existente | `200` · `400` · `404` |
| `DELETE` | `/compromissos/{id}` | Remove um compromisso | `204` · `404` |
| `GET` | `/ping` | Verifica se a API está no ar (responde `pong`) | `200` |

### Exemplo: criar um compromisso

**Requisição**

```http
POST /compromissos
Content-Type: application/json

{
  "titulo": "Pedalar",
  "dia": "QUARTA",
  "inicio": "17:40",
  "fim": "18:40",
  "categoria": "ATIVIDADE_FISICA"
}
```

**Resposta** `201 Created`

```json
{
  "id": 17,
  "titulo": "Pedalar",
  "dia": "QUARTA",
  "inicio": "17:40:00",
  "fim": "18:40:00",
  "categoria": "ATIVIDADE_FISICA"
}
```

### Valores aceitos

| Campo | Valores |
|---|---|
| `dia` | `SEGUNDA`, `TERCA`, `QUARTA`, `QUINTA`, `SEXTA`, `SABADO`, `DOMINGO` |
| `categoria` | `PROFISSIONAL`, `ESPIRITUAL`, `ATIVIDADE_FISICA`, `ESTUDOS` |
| `inicio`, `fim` | horário no formato `HH:mm` (ex.: `07:00`) |

### Regras de negócio

- O horário de **fim precisa ser depois do início**. Caso contrário, a API responde `400 Bad Request` e nada é salvo. Isso vale para `POST` e `PUT`.
- No `PUT`, o compromisso é **substituído por inteiro**: envie todos os campos, mesmo os que não mudaram.

## 🚀 Como executar

### Pré-requisitos

- [Java 21](https://adoptium.net/) (JDK)
- [PostgreSQL](https://www.postgresql.org/download/) rodando na porta padrão `5432`
- Git

O Maven não precisa ser instalado: o projeto inclui o Maven Wrapper (`mvnw`).

### 1. Clonar o repositório

```bash
git clone https://github.com/DevPedroBarreto/agenda-semanal.git
cd agenda-semanal
```

### 2. Criar o banco de dados

No pgAdmin ou no `psql`, crie um banco chamado `agenda`:

```sql
CREATE DATABASE agenda;
```

A tabela `compromissos` é criada automaticamente pelo Hibernate na primeira execução.

A aplicação se conecta com o usuário `postgres` em `localhost:5432` (veja `src/main/resources/application.properties`).

### 3. Informar a senha do banco

Por segurança, a senha **não fica no código**: ela é lida da variável de ambiente `DB_PASSWORD`. Defina-a no mesmo terminal em que vai rodar a aplicação.

**Windows (PowerShell)**

```powershell
$env:DB_PASSWORD="sua_senha"
```

**Linux, macOS ou Git Bash**

```bash
export DB_PASSWORD="sua_senha"
```

### 4. Rodar a aplicação

**Windows (PowerShell)**

```powershell
.\mvnw.cmd spring-boot:run
```

**Linux, macOS ou Git Bash**

```bash
./mvnw spring-boot:run
```

Quando aparecer `Tomcat started on port 8080`, a API está disponível em `http://localhost:8080`. Teste com:

```bash
curl http://localhost:8080/ping
```

## 🧪 Testando com o Postman

A pasta [`postman/`](postman/) tem uma Collection pronta com as requisições da API.

1. No Postman, clique em **Import** e selecione o arquivo `.json` da pasta `postman/`.
2. Com a aplicação rodando, execute as requisições da Collection.

## 🗺️ Roadmap

- [x] **Etapa 1:** Fundamentos de Java e versão em console ([`v0.1-console`](https://github.com/DevPedroBarreto/agenda-semanal/tree/v0.1-console))
- [x] **Etapa 2:** API REST com Spring Boot (dados em memória)
- [x] **Etapa 3:** Persistência com PostgreSQL, camada service e CRUD completo
- [ ] **Etapa 4:** DTOs, regra de conflito de horário, tratamento de erros, Swagger e testes
- [ ] **Etapa 5:** Front-end em Angular consumindo a API
- [ ] **Etapa 6:** Deploy da API, do banco e do front-end

## 👨‍💻 Autor

**Pedro Barreto**

[![GitHub](https://img.shields.io/badge/GitHub-DevPedroBarreto-181717?logo=github)](https://github.com/DevPedroBarreto)
