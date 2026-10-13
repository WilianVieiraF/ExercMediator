package br.venson.net.designpatterns.mediator;

/**
 * Papel: COLEGA.
 * Conhece apenas o mediador, nunca os outros usuarios.
 */
public class Usuario {
    private final String nome;
    private MediadorChat mediador;

    public Usuario(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    /** Chamado pelo mediador quando o usuario entra ou sai. */
    public void setMediador(MediadorChat mediador) {
        this.mediador = mediador;
    }

    public void enviar(String mensagem) {
        exigirMediador().enviar(mensagem, this);
    }

    public void enviarPrivado(String nomeDestinatario, String mensagem) {
        exigirMediador().enviarPrivado(mensagem, this, nomeDestinatario);
    }

    public void receber(String remetente, String mensagem) {
        System.out.println(nome + " recebeu de " + remetente + ": " + mensagem);
    }

    private MediadorChat exigirMediador() {
        if (mediador == null) {
            throw new IllegalStateException(nome + " nao esta em nenhuma sala/chat.");
        }
        return mediador;
    }
}