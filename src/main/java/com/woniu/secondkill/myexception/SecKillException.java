package com.woniu.secondkill.myexception;

public class SecKillException extends RuntimeException {
    public SecKillException() {
        super();
    }

    public SecKillException(String message) {
        super(message);
    }

    public SecKillException(String message, Throwable cause) {
        super(message, cause);
    }

    public SecKillException(Throwable cause) {
        super(cause);
    }

    protected SecKillException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
