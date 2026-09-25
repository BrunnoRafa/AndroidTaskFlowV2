# 📋 TaskFlow

TaskFlow é um aplicativo Android para gerenciamento de tarefas desenvolvido com **Kotlin** e **Jetpack Compose**, seguindo as recomendações atuais da plataforma Android para construção de aplicações modernas.

O projeto está sendo desenvolvido com foco em:

- boas práticas de arquitetura;
- organização de código;
- componentização;
- desenvolvimento Android moderno;
- documentação técnica.

---

# 🎯 Objetivo

Construir um aplicativo Android completo que sirva como referência para estudos sobre desenvolvimento Android moderno utilizando:

- Kotlin
- Jetpack Compose
- Material Design 3
- MVVM
- StateFlow
- Room
- Navigation Compose
- Repository Pattern

O foco do projeto é privilegiar **qualidade de código**, **manutenibilidade** e **boas práticas**, em vez de apenas implementar funcionalidades.

---

# 🛠 Stack Tecnológica

| Tecnologia | Status |
|------------|:------:|
| Kotlin | ✅ |
| Jetpack Compose | ✅ |
| Material Design 3 | ✅ |
| Android Studio Meerkat | ✅ |
| Gradle Kotlin DSL | ✅ |
| Version Catalog | ✅ |
| ViewModel | ⏳ |
| StateFlow | ⏳ |
| Navigation Compose | ⏳ |
| Room | ⏳ |
| Coroutines | ⏳ |
| Hilt | ⏳ |
| Testes | ⏳ |

---

# 🏗 Arquitetura

O projeto utiliza uma adaptação da **Clean Architecture** com **MVVM**.

```text
Presentation
      │
 ViewModel
      │
 Repository
      │
Local Data Source
```

Mais detalhes:

- 📄 docs/architecture.md

---

# 📂 Estrutura do Projeto

```text
TaskFlow
│
├── app
│
├── docs
│   ├── architecture.md
│   ├── architecture-decisions.md
│   ├── changelog.md
│   ├── conventions.md
│   └── roadmap.md
│
└── README.md
```

---

# 📚 Documentação

Toda a documentação técnica está organizada na pasta `docs`.

| Documento | Descrição |
|-----------|-----------|
| architecture.md | Arquitetura da aplicação |
| architecture-decisions.md | Architecture Decision Records (ADR) |
| conventions.md | Convenções adotadas no projeto |
| roadmap.md | Planejamento das próximas entregas |
| changelog.md | Histórico das implementações |

---

# 🚀 Roadmap

O planejamento completo do projeto pode ser consultado em:

```text
docs/roadmap.md
```

---

# 📐 Convenções

Durante o desenvolvimento serão adotadas as recomendações atuais para aplicações Android modernas.

Entre elas:

- Material Design 3
- MVVM
- Componentes reutilizáveis
- Stateless Composables
- State Hoisting
- Version Catalog
- Code Review em todas as implementações
- Architecture Decision Records (ADR)

As convenções detalhadas encontram-se em:

```text
docs/conventions.md
```

---

# 📖 Como executar o projeto

## Pré-requisitos

- Android Studio Meerkat ou superior
- JDK 17
- Android SDK
- Emulador Android ou dispositivo físico

## Executando

```bash
git clone https://github.com/<usuario>/TaskFlow.git
```

Abra o projeto no Android Studio e execute a aplicação.

---

# 📋 Status do Projeto

🚧 Em desenvolvimento.

Atualmente o projeto possui:

- Estrutura inicial
- Organização por componentes
- HomeScreen
- Introdução ao Jetpack Compose
- Modifier
- Column
- Scaffold

As próximas entregas podem ser acompanhadas em:

```text
docs/changelog.md
```

---

# 👨‍💻 Desenvolvedor

**Bruno Rafael**

---

# 📄 Licença

Projeto desenvolvido para fins de estudo e evolução técnica.