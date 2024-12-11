package org.devolpex.backend.handler;

import java.util.List;

import org.springframework.http.HttpStatus;

public class OwnException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private OwnErrorRES res;

    public OwnException(String message) {
        super(message);
    }

    public OwnException(String message, Throwable cause) {
        super(message, cause);
    }

    public OwnException(Throwable cause) {
        super(cause);
    }

    public OwnException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    // For simple message
    public OwnException(String msg, HttpStatus status) {
        this.res = OwnErrorRES.builder().message(msg).status(status).build();
    }

    // For message with field errors
    public OwnException(String msg, String field, HttpStatus status) {
        // Build a list of field errors
        this.res = OwnErrorRES.builder()
                .status(status)
                .fieldErrors(List.of(OwnFieldError.builder().field(field).message(msg).build())).build();
    }

    public OwnErrorRES getRes() {
        return res;
    }

    public void setRes(OwnErrorRES res) {
        this.res = res;
    }

}
