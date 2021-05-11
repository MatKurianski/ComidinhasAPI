package com.kurianski.comidinhas.domain.exception;

public class CategoriaNaoExisteException extends BusinessException {
    public CategoriaNaoExisteException() {
        super();
    }

    public CategoriaNaoExisteException(String message) {
        super(message);
    }

    public CategoriaNaoExisteException(String message, Throwable cause) {
        super(message, cause);
    }

    public CategoriaNaoExisteException(Throwable cause) {
        super(cause);
    }

    protected CategoriaNaoExisteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
