# 🌳 Git Conventions

Este documento descreve as convenções de Git adotadas no projeto TaskFlow.

---

# Objetivo

Manter um histórico de commits limpo, organizado e fácil de entender.

Cada commit deve representar uma única alteração lógica.

---

# Estrutura dos commits

Seguiremos o padrão inspirado no Conventional Commits.

```text
tipo(escopo): descrição
```

Exemplos:

```text
feat(home): add Scaffold structure

feat(task): create TaskCard component

refactor(home): move FAB to Scaffold

fix(ui): correct EmptyState spacing

docs: update architecture documentation

chore: update dependencies
```

---

# Tipos de commit

## feat

Nova funcionalidade.

Exemplo:

```text
feat(home): create HomeScreen
```

---

## fix

Correção de bug.

Exemplo:

```text
fix(task): prevent empty task creation
```

---

## refactor

Mudança estrutural sem alterar comportamento.

Exemplo:

```text
refactor(home): extract TopBar component
```

---

## docs

Alteração apenas na documentação.

Exemplo:

```text
docs: update README
```

---

## style

Alterações de formatação.

Sem mudança de comportamento.

Exemplo:

```text
style(home): format HomeScreen
```

---

## chore

Configurações e manutenção.

Exemplo:

```text
chore: update Gradle wrapper
```

---

## test

Criação ou alteração de testes.

Exemplo:

```text
test(home): add HomeViewModel tests
```

---

# Boas práticas

## Um commit = uma responsabilidade

✔️ Correto

```text
feat(home): add EmptyState component
```

❌ Evitar

```text
feat: create screen, update README, change theme and fix bug
```

---

## Commits pequenos

Prefira vários commits pequenos em vez de um commit muito grande.

---

## Mensagens objetivas

Prefira:

```text
feat(task): add priority selector
```

Evite:

```text
changes
```

ou

```text
update
```

---

# Idioma

Os commits serão escritos em inglês.

Motivos:

- padrão adotado pela comunidade;
- facilita colaboração internacional;
- histórico consistente.

---

# Fluxo de trabalho

```text
Implementação

↓

Testes

↓

Commit

↓

Push
```

Nunca realizar commit com código quebrado.

---

# Convenção adotada

Todos os commits deste projeto seguirão este documento.