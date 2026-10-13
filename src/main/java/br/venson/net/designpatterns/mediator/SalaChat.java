package br.venson.net.designpatterns.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * Papel: MEDIADOR CONCRETO.
 * Unico lugar que conhece a lista de participantes e as regras de conversa
 * (aqui: todos recebem, menos o remetente; privado so para quem esta na sala).
 */
public class SalaChat implements MediadorChat {
    private final String nome;
    private final List<Usuario> membros = new ArrayList<>();

    public SalaChat(String nome) {
        this.nome = nome;
    }

    @Override
    public void entrar(Usuario usuario) {
        if (membros.contains(usuario)) {
            return;
        }
        membros.add(usuario);
        usuario.setMediador(this);
        avisar(usuario.getNome() + " entrou na sala " + nome, usuario);
    }

    @Override
    public void sair(Usuario usuario) {
        if (membros.remove(usuario)) {
            usuario.setMediador(null); // sem referencia solta
            avisar(usuario.getNome() + " saiu da sala " + nome, usuario);
        }
    }

    @Override
    public void enviar(String mensagem, Usuario remetente) {
        exigirMembro(remetente);
        for (Usuario membro : new ArrayList<>(membros)) {
            if (membro != remetente) {
                membro.receber(remetente.getNome(), mensagem);
            }
        }
    }

    @Override
    public void enviarPrivado(String mensagem, Usuario remetente, String nomeDestinatario) {
        exigirMembro(remetente);
        Usuario destinatario = membros.stream()
                .filter(m -> m.getNome().equalsIgnoreCase(nomeDestinatario))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        nomeDestinatario + " nao esta na sala " + nome));
        destinatario.receber(remetente.getNome() + " (privado)", mensagem);
    }

    private void avisar(String aviso, Usuario exceto) {
        for (Usuario membro : membros) {
            if (membro != exceto) {
                membro.receber("Sala " + nome, aviso);
            }
        }
    }

    private void exigirMembro(Usuario usuario) {
        if (!membros.contains(usuario)) {
            throw new IllegalStateException(usuario.getNome() + " nao pertence a sala " + nome);
        }
    }
}