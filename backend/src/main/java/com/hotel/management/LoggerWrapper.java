package com.hotel.management;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerWrapper {

    private final Logger logger;

    private LoggerWrapper(final Logger logger) {
        this.logger = logger;
    }

    public static LoggerWrapper getLogger(final Class<?> clazz) {
        return new LoggerWrapper(LoggerFactory.getLogger(clazz));
    }

    private static String getMessage(final String message) {
        return String.format(message);
    }

    public void trace(final String message, final Object... arguments) {
        this.logger.trace(getMessage(message), arguments);
    }

    public void debug(final String message, final Object... arguments) {
        this.logger.debug(getMessage(message), arguments);
    }

    public void warn(final String message, final Object... arguments) {
        this.logger.warn(getMessage(message), arguments);
    }

    public void warn(final String message, final Throwable throwable) {
        this.logger.warn(getMessage(message), throwable);
    }

    public void error(final String message, final Throwable throwable) {
        this.logger.error(getMessage(message), throwable);
    }

    public void error(final String message, final Object... arguments) {
        this.logger.error(getMessage(message), arguments);
    }

    public void info(final String message, final Object... arguments) {
        this.logger.info(getMessage(message), arguments);
    }

    public boolean isDebugEnabled(){
        return this.logger.isDebugEnabled();
    }

    public boolean isInfoEnabled(){
        return this.logger.isInfoEnabled();
    }

    public boolean isTraceEnabled(){
        return this.logger.isTraceEnabled();
    }
}
