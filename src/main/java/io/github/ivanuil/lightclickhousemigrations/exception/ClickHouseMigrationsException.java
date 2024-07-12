package io.github.ivanuil.lightclickhousemigrations.exception;

public class ClickHouseMigrationsException extends Exception {

    public ClickHouseMigrationsException(final String message) {
        super(message);
    }

    public ClickHouseMigrationsException(final String message, final Throwable cause) {
        super(message, cause);
    }

}
