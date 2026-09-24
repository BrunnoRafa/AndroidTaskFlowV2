# 📐 Convenções do Projeto

Este documento reúne as convenções adotadas durante o desenvolvimento do TaskFlow.

---

# Organização

## Screens

Responsáveis apenas por estruturar a tela.

Devem:

- utilizar Scaffold;
- orquestrar Components.

Não devem:

- possuir lógica de negócio.

---

## Components

Responsáveis por representar partes reutilizáveis da interface.

Exemplos:

- TopBar
- TaskCard
- EmptyState

---

## ViewModel

Responsável por:

- estado da tela;
- regras de negócio;
- comunicação com Repository.

---

# Jetpack Compose

## Modifier

Sempre que um Composable reutilizável permitir customização visual deverá receber:

```kotlin
modifier: Modifier = Modifier
```

---

## Organização

Preferir:

```kotlin
Modifier
    .fillMaxWidth()
    .padding(16.dp)
```

Evitar:

```kotlin
Modifier.fillMaxWidth().padding(16.dp)
```

Motivo:

Maior legibilidade.

---

## Estado

Composables deverão ser preferencialmente Stateless.

O estado ficará concentrado na ViewModel.

---

# Nomeação

Screens

- HomeScreen
- SettingsScreen

Components

- TaskCard
- AppTopBar

ViewModels

- HomeViewModel

Repositories

- TaskRepository

---

# Boas práticas

- Uma responsabilidade por componente.
- Evitar duplicação.
- Preferir reutilização.
- Utilizar Material 3.
- Seguir convenções oficiais do Android.