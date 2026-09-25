# 📋 TaskFlow

TaskFlow é um aplicativo Android para gerenciamento de tarefas desenvolvido com **Kotlin** e **Jetpack Compose**, seguindo uma arquitetura baseada em **MVVM** e princípios da **Clean Architecture**.

O projeto está sendo desenvolvido com foco em:

* boas práticas de arquitetura;
* organização de código;
* separação de responsabilidades;
* componentização;
* desenvolvimento Android moderno;
* persistência local de dados;
* documentação técnica;
* aprendizado contínuo das tecnologias utilizadas.

---

# 🎯 Objetivo

Construir um aplicativo Android completo que sirva como referência para estudos sobre desenvolvimento Android moderno utilizando:

* Kotlin
* Jetpack Compose
* Material Design 3
* MVVM
* StateFlow
* Room
* Navigation Compose
* Repository Pattern
* Clean Architecture

O foco do projeto é privilegiar **qualidade de código**, **manutenibilidade**, **separação de responsabilidades** e **boas práticas arquiteturais**, em vez de apenas implementar funcionalidades.

---

# 🛠 Stack Tecnológica

| Tecnologia         | Status |
| ------------------ | :----: |
| Kotlin             |    ✅   |
| Jetpack Compose    |    ✅   |
| Material Design 3  |    ✅   |
| Android Studio     |    ✅   |
| Gradle Kotlin DSL  |    ✅   |
| Version Catalog    |    ✅   |
| ViewModel          |    ✅   |
| StateFlow          |    ✅   |
| Coroutines         |    ✅   |
| Navigation Compose |    ✅   |
| Room               |    ✅   |
| Repository Pattern |    ✅   |
| Mapper             |    ✅   |
| Hilt               |    ⏳   |
| Testes             |    ⏳   |
| Modularização      |    ⏳   |

---

# 📦 Principais versões

As versões das principais dependências são centralizadas no **Version Catalog**.

Atualmente o projeto utiliza:

| Tecnologia            | Versão     |
| --------------------- | ---------- |
| Android Gradle Plugin | 8.5.2      |
| Kotlin                | 1.9.0      |
| Compile SDK           | 34         |
| Target SDK            | 34         |
| Min SDK               | 26         |
| Compose BOM           | 2024.04.01 |
| Compose Compiler      | 1.5.1      |
| Room                  | 2.6.1      |
| Lifecycle             | 2.6.1      |
| Activity Compose      | 1.8.0      |

As versões devem ser alteradas de forma controlada, evitando atualizações simultâneas de várias tecnologias sem necessidade.

---

# 🏗 Arquitetura

O projeto utiliza uma adaptação da **Clean Architecture** combinada com o padrão **MVVM**.

Fluxo principal da aplicação:

```text
UI / Screen
     │
     ▼
 ViewModel
     │
     ▼
Repository
     │
     ▼
Local Data Source
     │
     ▼
 Room / DAO
```

A aplicação também possui uma camada de domínio responsável pelos modelos e contratos utilizados pela aplicação.

Estrutura conceitual:

```text
Presentation
     │
     ▼
 ViewModel
     │
     ▼
 Domain
     │
     ▼
Repository
     │
     ▼
 Data
     │
     ▼
 Room / DAO
```

---

# 🧱 Camadas

## Presentation

Responsável pela interface da aplicação.

Contém:

* Screens
* Components
* Navigation
* Theme
* UI State

A camada de apresentação não deve conter regras de acesso ao banco de dados.

---

## ViewModel

Responsável por:

* controlar o estado da tela;
* processar eventos da interface;
* executar operações relacionadas à tela;
* comunicar-se com o Repository;
* expor o estado através de `StateFlow`.

A ViewModel não deve conhecer detalhes de implementação da UI.

---

## Domain

Responsável pelas regras e modelos centrais da aplicação.

Atualmente contém:

* modelos de domínio;
* tipos utilizados pela aplicação;
* contratos de Repository.

Exemplo:

```text
Task
TaskType
TaskRepository
```

---

## Data

Responsável pelo acesso e transformação dos dados.

Atualmente utiliza:

* Room;
* DAO;
* Entity;
* Repository implementation;
* Mapper.

Estrutura:

```text
Room
  │
  ▼
 DAO
  │
  ▼
Entity
  │
  ▼
Mapper
  │
  ▼
Domain Model
```

---

# 🗂 Estrutura do Projeto

```text
TaskFlow
│
├── app
│   │
│   └── src
│       │
│       └── main
│           │
│           ├── java
│           │   └── com.brunorafael.taskflow
│           │       │
│           │       ├── data
│           │       │   ├── dao
│           │       │   ├── database
│           │       │   ├── mapper
│           │       │   ├── model
│           │       │   └── repository
│           │       │
│           │       ├── di
│           │       │
│           │       ├── domain
│           │       │   ├── model
│           │       │   └── respository
│           │       │
│           │       ├── ui
│           │       │   ├── components
│           │       │   ├── navigation
│           │       │   ├── screens
│           │       │   │   ├── addtask
│           │       │   │   └── home
│           │       │   ├── state
│           │       │   ├── theme
│           │       │   └── viewmodel
│           │       │
│           │       ├── MainActivity.kt
│           │       └── TaskFlowApplication.kt
│           │
│           └── res
│
├── docs
│   ├── architecture.md
│   ├── architecture-decisions.md
│   ├── conventions.md
│   └── roadmap.md
│
├── gradle
│   └── libs.versions.toml
│
├── build.gradle.kts
├── settings.gradle.kts
└── README.md
```

---

# 🧭 Navegação

A aplicação utiliza **Navigation Compose**.

Atualmente existem duas rotas principais:

```text
home
  │
  └── addTask
```

Fluxo atual:

```text
HomeScreen
    │
    │ adicionar tarefa
    ▼
AddTaskScreen
    │
    │ voltar
    ▼
HomeScreen
```

A navegação é controlada pela camada de navegação e as Screens recebem callbacks para executar ações de navegação.

As Screens não devem conhecer diretamente o `NavController` quando isso não for necessário.

---

# 🖥️ Estado da UI

A Home utiliza um estado representado por `HomeUiState`.

Estados atuais:

```text
Loading
Empty
Success
Error
```

Representação:

```kotlin
sealed class HomeUiState {

    data object Loading : HomeUiState()

    data object Empty : HomeUiState()

    data class Success(
        val tasks: List<Task>
    ) : HomeUiState()

    data class Error(
        val type: HomeErrorType
    ) : HomeUiState()
}
```

A UI reage ao estado exposto pela ViewModel através de `StateFlow`.

---

# 💾 Persistência

O projeto utiliza **Room Database** para persistência local.

Estrutura atual:

```text
TaskDatabase
     │
     ▼
 TaskDao
     │
     ▼
TaskEntity
     │
     ▼
TaskMapper
     │
     ▼
   Task
```

O banco atualmente possui a tabela:

```text
tasks
```

A entidade possui:

* `id`
* `description`
* `type`
* `createdAt`
* `isCompleted`

O DAO já possui operações para:

* buscar tarefas;
* inserir tarefa;
* atualizar tarefa;
* excluir tarefa.

A integração completa dessas operações com a interface ainda está em desenvolvimento.

---

# 🧩 Repository Pattern

A aplicação utiliza o padrão Repository para evitar que a ViewModel tenha conhecimento direto sobre o Room.

Fluxo:

```text
HomeViewModel
      │
      ▼
TaskRepository
      │
      ▼
TaskRepositoryImpl
      │
      ▼
TaskDao
```

A interface `TaskRepository` pertence ao domínio, enquanto sua implementação pertence à camada de dados.

Essa separação permite alterar a fonte de dados sem alterar diretamente a ViewModel.

---

# 🧱 Componentização

A interface utiliza componentes independentes e reutilizáveis.

Atualmente existem componentes como:

* `HomeTopBar`
* `EmptyState`
* `AddTaskButton`
* `TaskItem`

Exemplo:

```text
HomeScreen
    │
    ├── HomeTopBar
    ├── EmptyState
    ├── TaskItem
    └── AddTaskButton
```

O objetivo é evitar que uma Screen concentre toda a implementação visual.

---

# 📝 Adicionar tarefa

A aplicação possui uma `AddTaskScreen`.

Atualmente a tela permite:

* informar a descrição da tarefa;
* selecionar o tipo da tarefa;
* visualizar os tipos disponíveis;
* retornar para a Home;
* acionar o botão de salvar.

Os tipos disponíveis são:

```text
WORK
FUN
STUDY
MARKET
OTHER
```

A persistência da nova tarefa ainda será conectada à ViewModel e ao Repository.

---

# 📚 Documentação

A documentação técnica está organizada na pasta `docs`.

| Documento                   | Descrição                          |
| --------------------------- | ---------------------------------- |
| `architecture.md`           | Arquitetura da aplicação           |
| `architecture-decisions.md` | Decisões arquiteturais             |
| `conventions.md`            | Convenções de desenvolvimento      |
| `roadmap.md`                | Planejamento e evolução do projeto |

Novos documentos serão adicionados conforme novos conceitos arquiteturais forem introduzidos.

---

# 🗺 Roadmap

## Fase 1 — Fundação ✅

* [x] Estrutura do projeto
* [x] Packages
* [x] Primeira Screen
* [x] Componentes reutilizáveis
* [x] Modifier
* [x] Column
* [x] Scaffold
* [x] Material Theme

---

## Fase 2 — Interface ✅

* [x] Material Design 3
* [x] TopAppBar
* [x] FloatingActionButton
* [x] Empty State
* [x] TaskItem
* [x] Espaçamentos
* [x] Tipografia
* [x] Cores
* [x] Tela de adicionar tarefa
* [x] Seleção de tipo de tarefa

---

## Fase 3 — Estado e arquitetura 🚧

* [x] Estado com Compose
* [x] `remember`
* [ ] `rememberSaveable`
* [ ] State Hoisting completo
* [x] ViewModel
* [x] StateFlow
* [x] UI State
* [x] Eventos da UI

---

## Fase 4 — Dados 🚧

* [x] Room
* [x] Database
* [x] Entity
* [x] DAO
* [x] Repository
* [x] Repository Implementation
* [x] Mapper
* [x] Leitura das tarefas
* [ ] Criar tarefa pela interface
* [ ] Atualizar tarefa pela interface
* [ ] Excluir tarefa pela interface
* [ ] Concluir tarefa pela interface
* [ ] Fluxo completo de CRUD

---

## Fase 5 — Navegação 🚧

* [x] Navigation Compose
* [x] NavController
* [x] NavHost
* [x] Rotas
* [x] Navegação Home → AddTask
* [x] Navegação de retorno
* [ ] Argumentos de navegação
* [ ] Navegação para edição de tarefa

---

## Fase 6 — Recursos avançados ⏳

* [ ] Testes unitários
* [ ] Testes de ViewModel
* [ ] Testes de Repository
* [ ] Testes de UI
* [ ] Hilt
* [ ] Animações
* [ ] Tratamento avançado de erros
* [ ] Modularização
* [ ] Melhorias de performance

---

# 📐 Convenções

Durante o desenvolvimento serão adotadas boas práticas para aplicações Android modernas.

Entre elas:

* MVVM;
* princípios da Clean Architecture;
* Material Design 3;
* componentes reutilizáveis;
* Composables preferencialmente Stateless;
* State Hoisting;
* StateFlow;
* Repository Pattern;
* Version Catalog;
* separação entre Domain e Data;
* uma responsabilidade por componente;
* evitar lógica de negócio dentro dos Composables;
* evitar acesso direto ao banco pela UI;
* registrar decisões arquiteturais importantes através de ADR.

As convenções detalhadas encontram-se em:

```text
docs/conventions.md
```

---

# 🧠 Princípios de desenvolvimento

O TaskFlow possui também um objetivo educacional.

As funcionalidades serão implementadas buscando compreender:

1. **Por que uma determinada arquitetura foi escolhida;**
2. **Qual responsabilidade pertence a cada camada;**
3. **Como os dados percorrem a aplicação;**
4. **Como o estado da UI é controlado;**
5. **Como o Compose reage às mudanças de estado;**
6. **Como a persistência é separada da interface;**
7. **Como tornar o código testável e manutenível.**

O projeto não tem como objetivo apenas produzir uma aplicação funcional, mas também servir como material de estudo sobre desenvolvimento Android moderno.

---

# 🚀 Como executar o projeto

## Pré-requisitos

* Android Studio compatível com o projeto;
* JDK 17;
* Android SDK;
* Emulador Android ou dispositivo físico.

## Executando

Clone o repositório:

```bash
git clone https://github.com/BrunnoRafa/AndroidTaskFlowV2.git
```

Abra o projeto no Android Studio e aguarde a sincronização do Gradle.

Depois:

1. selecione um dispositivo ou emulador;
2. execute a configuração `app`;
3. aguarde a compilação;
4. execute a aplicação.

---

# 📋 Status do Projeto

🚧 **Em desenvolvimento.**

Atualmente o projeto possui:

* estrutura de arquitetura;
* Kotlin;
* Jetpack Compose;
* Material Design 3;
* HomeScreen;
* UI State;
* ViewModel;
* StateFlow;
* Repository Pattern;
* Room Database;
* DAO;
* Entity;
* Mapper;
* Navigation Compose;
* AddTaskScreen;
* seleção de tipo de tarefa;
* componentes reutilizáveis.

O próximo foco de desenvolvimento é conectar o formulário de criação de tarefa ao fluxo:

```text
AddTaskScreen
      │
      ▼
ViewModel
      │
      ▼
Repository
      │
      ▼
Room
```

---

# 👨‍💻 Desenvolvedor

**Bruno Rafael**

---

# 📄 Licença

Projeto desenvolvido para fins de estudo e evolução técnica.
