# 🏗 Arquitetura

## Objetivo

Documentar a arquitetura adotada no projeto TaskFlow e as decisões relacionadas à organização do código.

---

# Arquitetura

O projeto utiliza uma adaptação da Clean Architecture combinada com o padrão MVVM.

```text
Presentation
      │
 ViewModel
      │
 Repository
      │
Local Data Source
```

---

# Camadas

## Presentation

Responsável pela interface da aplicação.

Contém:

- Screens
- Components
- Theme
- Navigation

Nenhuma regra de negócio deve ser implementada nesta camada.

---

## ViewModel

Responsável por:

- controlar o estado da tela;
- processar eventos da interface;
- comunicar-se com o Repository.

A ViewModel nunca deve conhecer detalhes da UI.

---

## Repository

Responsável por fornecer dados para a aplicação.

É a camada intermediária entre a ViewModel e as fontes de dados.

---

## Data

Responsável pelo acesso aos dados.

Inicialmente utilizará:

- Room Database

Futuramente poderá integrar APIs REST.

---

# Estrutura dos pacotes

```text
com.brunorafael.taskflow
│
├── data
│
├── domain
│
├── ui
│   ├── components
│   ├── navigation
│   ├── screens
│   └── theme
│
├── utils
│
└── viewmodel
```

---

# Convenções

- Toda Screen utilizará Scaffold.
- Componentes reutilizáveis ficarão em ui/components.
- A lógica de negócio não ficará em Composables.
- Toda Screen deverá possuir apenas uma responsabilidade.

---

# Evolução

Este documento será atualizado durante o desenvolvimento do projeto.