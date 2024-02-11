package tech.devinhouse.labvaccine.service;

public class ClienteNaoEncontradoException extends RuntimeException {

    public ClienteNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
