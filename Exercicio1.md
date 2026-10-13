# Padrão Mediator (Mediador)

## Exercício 1: Aplicações

### 1. Sala de chat com vários usuários

**Faz sentido usar Mediator.**

O padrão Mediator permite que os usuários se comuniquem por meio de um mediador, sem que cada um precise conhecer os demais. Isso facilita a alteração das regras de comunicação, privacidade e notificações sem modificar cada usuário.

### 2. Tela de diálogo com widgets interdependentes

**Faz sentido usar Mediator.**

O Mediator centraliza a comunicação entre os componentes da tela, evitando que cada widget dependa diretamente dos outros. Assim, fica mais fácil controlar as ações, como habilitar um botão ou limpar um campo de texto quando um checkbox é marcado.

### 3. Central de despacho de entregas

**Faz sentido usar Mediator.**

O Mediator pode centralizar a comunicação entre motoristas, pedidos e entregas, aplicando as regras de distribuição. Dessa forma, quando as regras mudarem, será possível alterar a lógica de coordenação sem modificar todas as classes envolvidas.

### 4. Impressora e Spooler com comunicação simples

**Não faz sentido usar Mediator.**

A comunicação entre a impressora e o Spooler é simples, fixa e envolve poucos objetos. Criar um mediador adicionaria complexidade desnecessária ao sistema, sem trazer benefícios significativos.

### 5. Classe Ponto que apenas guarda coordenadas

**Não faz sentido usar Mediator.**

A classe `Ponto` apenas armazena as coordenadas `x` e `y` e não precisa coordenar a comunicação entre outros objetos. Utilizar o Mediator nesse caso seria um excesso de complexidade, pois não existe uma rede de interações para organizar.