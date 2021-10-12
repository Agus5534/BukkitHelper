package com.agus5534.bukkithelper.utils;

public class InvalidGameModeException extends Exception{
    private final Throwable cause;

    public InvalidGameModeException(Throwable throwable) {
        this.cause = throwable;
    }

    public InvalidGameModeException() {
        this.cause = null;
    }
    public InvalidGameModeException(Throwable cause, String message) {
        super(message);
        this.cause = cause;
    }
    public InvalidGameModeException(String message){
        super(message);
        this.cause = null;
    }
    public Throwable getCause() {
        return this.cause;
    }
}
    