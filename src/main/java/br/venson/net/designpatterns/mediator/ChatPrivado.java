package br.venson.net.designpatterns.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * Outro MEDIADOR CONCRETO: conversa entre exatamente duas pessoas.
 * A classe Usuario e reaproveitada sem nenhuma alteracao.
 */
public class ChatPrivado implements MediadorChat {
    private static final int LIMITE = 2;
    private final List<Usuario> participantes = new ArrayList<>();

    @Override
    public void entrar(Usuario usuario) {
        if (participantes.contains(usuario)) {
            return;
        }
        if (participantes.size() >= LIMITE) {
            throw new IllegalStateException("Chat privado ja tem " + LIMITE + " participantes.");
        }
        participantes.add(usuario);
        usuario.setMediador(this);
    }

    @Override
    public void sair(Usuario usuario) {
        if (participantes.remove(usuario)) {
            usuario.setMediador(null);
        }
    }

    @Override
    public void enviar(String mensagem, Usuario remetente) {
        for (Usuario p : participantes) {
            if (p != remetente) {
                p.receber(remetente.getNome(), mensagem);
            }
        }
    }

    @Override
    public void enviarPrivado(String mensagem, Usuario remetente, String nomeDestinatario) {
        enviar(mensagem, remetente); // so existe um destinatario possivel
    }
}