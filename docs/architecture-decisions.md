# 📚 Architecture Decision Records (ADR)

Este documento registra decisões arquiteturais importantes tomadas durante o desenvolvimento do projeto.

---

# ADR-001

## Organização dos componentes

### Status

Aprovado

### Decisão

Componentes reutilizáveis serão armazenados em:

```text
ui/components
```

### Motivo

Evitar duplicação de código e facilitar reutilização entre Screens.

---

# ADR-002

## Estrutura da HomeScreen

### Status

Aprovado

### Decisão

Toda Screen utilizará Scaffold como componente raiz.

### Motivo

Scaffold é a estrutura recomendada pelo Material Design 3.

Benefícios:

- gerenciamento automático de TopBar;
- FloatingActionButton;
- Snackbar;
- BottomBar;
- Window Insets.

---

# ADR-003

## Organização da UI

### Status

Aprovado

### Decisão

A estrutura da tela será separada do conteúdo.

Exemplo:

- Scaffold → estrutura
- Column → organização
- Components → interface

### Motivo

Maior legibilidade e escalabilidade.