package br.venson.net.designpatterns.mediator;

public class Main {

    public static void main(String[] args) {
        SalaChat sala = new SalaChat("Turma");

        Usuario ana = new Usuario("Ana");
        Usuario bruno = new Usuario("Bruno");
        Usuario carla = new Usuario("Carla");

        // Cada usuario so precisa entrar na sala: N ligacoes (nao N x (N - 1)).
        sala.entrar(ana);
        sala.entrar(bruno);
        sala.entrar(carla);

        System.out.println("--- mensagem para o grupo ---");
        ana.enviar("Bom dia, pessoal!");

        System.out.println("--- incluindo o Diego: 1 chamada ---");
        Usuario diego = new Usuario("Diego");
        sala.entrar(diego);
        diego.enviar("Oi, cheguei!");

        System.out.println("--- mensagem privada ---");
        bruno.enviarPrivado("Ana", "Voce fez o exercicio 2?");

        System.out.println("--- removendo a Carla: 1 chamada ---");
        sala.sair(carla);
        ana.enviar("A Carla nao recebe mais nada.");

        System.out.println("--- mesma classe Usuario em um chat privado ---");
        ChatPrivado privado = new ChatPrivado();
        privado.entrar(ana);
        privado.entrar(bruno);
        ana.enviar("Agora estamos so nos dois.");
    }
}