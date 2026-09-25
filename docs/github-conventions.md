# 🐙 GitHub Conventions

Este documento descreve a organização do repositório TaskFlow.

---

# Objetivo

Manter o repositório organizado e preparado para crescimento.

---

# Estrutura

```text
TaskFlow
│
├── .github
│
├── app
│
├── docs
│
├── README.md
│
├── LICENSE
│
└── .gitignore
```

---

# Pasta docs

Toda documentação técnica ficará nesta pasta.

```text
docs
│
├── architecture.md
├── architecture-decisions.md
├── changelog.md
├── conventions.md
├── roadmap.md
├── git-conventions.md
└── github-conventions.md
```

---

# README

O README possui apenas a função de apresentar o projeto.

Ele não deve conter documentação detalhada.

---

# Changelog

Todas as implementações importantes deverão ser registradas em:

```text
docs/changelog.md
```

---

# ADR

Toda decisão arquitetural importante deverá ser registrada em:

```text
docs/architecture-decisions.md
```

---

# Organização das Branches

Inicialmente utilizaremos apenas:

```text
main
```

Quando o projeto crescer:

```text
main

develop

feature/*
```

Exemplos:

```text
feature/home-screen

feature/task-list

feature/navigation

feature/room
```

---

# Pull Requests

Mesmo trabalhando sozinho, toda funcionalidade deverá ser considerada uma Pull Request.

Fluxo:

```text
Planejamento

↓

Implementação

↓

Code Review

↓

Correções

↓

Merge
```

---

# Releases

No futuro utilizaremos tags seguindo Versionamento Semântico.

Exemplo:

```text
v0.1.0

v0.2.0

v1.0.0
```

---

# Issues

Quando o projeto crescer, utilizaremos Issues para registrar:

- melhorias;
- bugs;
- novas funcionalidades.

---

# Actions

No futuro serão adicionadas GitHub Actions para:

- Build
- Testes
- Lint
- Quality Gate

---

# Objetivo final

O repositório deverá seguir uma organização semelhante à utilizada em projetos Android profissionais.