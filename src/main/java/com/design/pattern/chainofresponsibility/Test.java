package com.design.pattern.chainofresponsibility;

/**
 * @Author: 98050
 * @Time: 2019-01-11 19:26
 * @Feature:
 */
public class Test {

    private static AbstractLogger getChainOfLoggers(){
        AbstractLogger errorLogger = new ERRORLogger(AbstractLogger.ERROR);
        AbstractLogger fileLogger = new DEBUGLogger(AbstractLogger.DEBUG);
        AbstractLogger consoleLogger = new INFOLogger(AbstractLogger.INFO);
        errorLogger.setNext(fileLogger);
        fileLogger.setNext(consoleLogger);
        return errorLogger;
    }

    public static void main(String[] args) {
        AbstractLogger loggerChain = getChainOfLoggers();
        loggerChain.logMessage(AbstractLogger.INFO, "INFO");
        System.out.println("---------------------------------------");
        loggerChain.logMessage(AbstractLogger.DEBUG, "DEBUG");
        System.out.println("---------------------------------------");
        loggerChain.logMessage(AbstractLogger.ERROR, "ERROR");
    }
}
