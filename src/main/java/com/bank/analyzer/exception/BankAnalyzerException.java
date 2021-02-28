package com.bank.analyzer.exception;

public class BankAnalyzerException extends Exception{

    public BankAnalyzerException(String message){
        super("Something wrong happened..." + message);
    }
}
