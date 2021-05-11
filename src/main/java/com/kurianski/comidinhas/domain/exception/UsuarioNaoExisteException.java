package com.kurianski.comidinhas.domain.exception;

public class UsuarioNaoExisteException extends BusinessException {
    public UsuarioNaoExisteException() {
    }

    public UsuarioNaoExisteException(String message) {
        super(message);
    }

    public UsuarioNaoExisteException(String message, Throwable cause) {
        super(message, cause);
    }

    public UsuarioNaoExisteException(Throwable cause) {
        super(cause);
    }

    public UsuarioNaoExisteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
