package br.venson.net.designpatterns.mediator;

/**
 * Papel: MEDIADOR (interface).
 * Define o contrato que os colegas (Usuario) usam para conversar,
 * sem saber quem sao os outros participantes.
 */
public interface MediadorChat {

    void entrar(Usuario usuario);

    void sair(Usuario usuario);

    /** Mensagem para o grupo (as regras de quem recebe ficam no mediador). */
    void enviar(String mensagem, Usuario remetente);

    /** Mensagem privada para um unico participante, identificado pelo nome. */
    void enviarPrivado(String mensagem, Usuario remetente, String nomeDestinatario);
}