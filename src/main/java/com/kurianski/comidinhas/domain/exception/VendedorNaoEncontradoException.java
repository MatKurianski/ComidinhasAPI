package com.kurianski.comidinhas.domain.exception;

public class VendedorNaoEncontradoException extends BusinessException {
    public VendedorNaoEncontradoException() {
        super();
    }

    public VendedorNaoEncontradoException(String message) {
        super(message);
    }

    public VendedorNaoEncontradoException(String message, Throwable cause) {
        super(message, cause);
    }

    public VendedorNaoEncontradoException(Throwable cause) {
        super(cause);
    }

    protected VendedorNaoEncontradoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
