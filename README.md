# 📅 Agenda Semanal

> Aplicação full stack para organizar a rotina da semana entre vida profissional, espiritual, atividade física e estudos: cadastre seus compromissos por dia e horário e veja a semana inteira de uma vez.

![Status](https://img.shields.io/badge/status-em%20desenvolvimento-orange)
![Java](https://img.shields.io/badge/Java-21-red?logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3-6DB33F?logo=springboot&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-4169E1?logo=postgresql&logoColor=white)
![React](https://img.shields.io/badge/React-61DAFB?logo=react&logoColor=black)

---

## 💡 Sobre o projeto

A **Agenda Semanal** nasceu de uma necessidade real: organizar a minha rotina e equilibrar quatro áreas da vida:

| Categoria | Exemplos |
|---|---|
| 💼 Profissional | trabalho, reuniões, projetos |
| 🙏 Espiritual | igreja, oração, leitura |
| 🏃 Atividade física | academia, corrida, esportes |
| 📚 Estudos | cursos, faculdade, programação |

Cada compromisso tem um dia, um horário de início e fim, um título e uma categoria:

```
Segunda | 07:00 - 17:00 | Trabalho | Profissional
```

Com isso, a aplicação monta a visão da semana, avisa quando dois compromissos entram em conflito de horário e mostra quantas horas por semana vão para cada área.

Este projeto também é o meu laboratório de estudos em desenvolvimento back-end com Java e Spring. Ele está sendo construído em etapas, do Java puro até o deploy.

## ✨ Funcionalidades

- [ ] Cadastrar compromissos (dia da semana, início, fim, título e categoria)
- [ ] Listar a semana ordenada por dia e horário
- [ ] Editar e excluir compromissos
- [ ] Filtrar compromissos por dia e por categoria
- [ ] Resumo semanal de horas por categoria
- [ ] Bloquear conflitos de horário no mesmo dia
- [ ] Validação de dados (ex.: horário de fim depois do início)
- [ ] Documentação interativa da API com Swagger
- [ ] Interface web com a grade da semana em 7 colunas
- [ ] Deploy online

## 🛠️ Tecnologias

| Camada | Tecnologia |
|---|---|
| Linguagem | Java 21 |
| Framework | Spring Boot (Web, Data JPA, Validation) |
| Banco de dados | PostgreSQL |
| Documentação | Swagger / springdoc-openapi |
| Testes | JUnit 5 |
| Front-end | React + Vite |
| Versionamento | Git e GitHub |

## 🔌 API REST (planejada)

| Método | Endpoint | Descrição |
|---|---|---|
| `GET` | `/compromissos` | Lista todos os compromissos |
| `GET` | `/compromissos?dia=SEGUNDA` | Lista os compromissos de um dia |
| `GET` | `/compromissos?categoria=ESTUDOS` | Lista os compromissos de uma categoria |
| `GET` | `/compromissos/resumo` | Horas da semana por categoria |
| `GET` | `/compromissos/{id}` | Busca um compromisso pelo id |
| `POST` | `/compromissos` | Cria um compromisso |
| `PUT` | `/compromissos/{id}` | Atualiza um compromisso |
| `DELETE` | `/compromissos/{id}` | Remove um compromisso |

Exemplo de corpo para criar um compromisso:

```json
{
  "titulo": "Trabalho",
  "dia": "SEGUNDA",
  "inicio": "07:00",
  "fim": "17:00",
  "categoria": "PROFISSIONAL"
}
```

## 🗺️ Roadmap

- [ ] **Etapa 1:** Fundamentos de Java e versão em console
- [ ] **Etapa 2:** API REST com Spring Boot (dados em memória)
- [ ] **Etapa 3:** Persistência com PostgreSQL e CRUD completo
- [ ] **Etapa 4:** Validações, regra de conflito, tratamento de erros, Swagger e testes
- [ ] **Etapa 5:** Front-end em React consumindo a API
- [ ] **Etapa 6:** Deploy da API, do banco e do front-end

## 🚀 Como executar

> As instruções serão atualizadas conforme o projeto evoluir.

**Pré-requisitos:** Java 21, Git e (a partir da Etapa 3) PostgreSQL.

```bash
# Clonar o repositório
git clone https://github.com/DevPedroBarreto/agenda-semanal.git
cd agenda-semanal
```

## 👨‍💻 Autor

**Pedro Barreto**

[![GitHub](https://img.shields.io/badge/GitHub-DevPedroBarreto-181717?logo=github)](https://github.com/DevPedroBarreto)
