# Projeto: sala de chat com anti-pattern (Mediator)

Sala de chat simplificada em que cada **usuário** fala diretamente com os
demais. O código funciona, mas os usuários se conhecem entre si, formando uma
**malha de referências**.

O objetivo deste projeto é **rastrear** o problema de design e propor uma
solução usando o padrão **Mediator**. Não é um projeto pronto: o código funciona,
mas as ligações estão espalhadas e mudam a cada entrada ou saída de usuário.

## Como rodar

O projeto é Maven (Java 17) e abre direto no Eclipse/IntelliJ.

- **Eclipse/IntelliJ:** importe a pasta do projeto e execute a classe `Main`.
- **Linha de comando:**
  ```bash
  mvn compile
  java -cp target/classes br.venson.net.designpatterns.mediator.Main
  ```

## O cenário

- `Usuario`: nome e uma lista de **contatos** (outros usuários).
- `Usuario.adicionarContato(...)`: cria a ligação direta com outro usuário.
- `Usuario.enviar(...)`: percorre a lista e chama `receber(...)` em cada contato.
- `Main`: cria três usuários e **liga cada um a todos os outros** na mão.

## O que observar

1. Cada `Usuario` guarda referências **diretas** aos demais: N usuários geram
   N × (N − 1) ligações.
2. Incluir um usuário novo obriga a adicionar contatos em **todas** as listas.
3. Remover um usuário pode deixar **referências soltas**.
4. As regras de conversa (todos falam? só o admin? privado?) ficariam
   **espalhadas** em cada `Usuario`.
5. É possível reusar `Usuario` em outra sala, ou em um contexto privado, sem
   reescrever a classe?

## Tarefa

Rastreie os problemas de design deste código e proponha uma refatoração com o
padrão **Mediator**, deixando claros os papéis: **interface de mediador**
(`MediadorChat`), **mediador concreto** (`SalaChat`) e **colegas** (`Usuario`)
que passam a conhecer apenas o mediador.
