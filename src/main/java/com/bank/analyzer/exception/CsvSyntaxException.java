package com.bank.analyzer.exception;

public class CsvSyntaxException extends Exception{

    public CsvSyntaxException(){
        super("Invalid format in file. Check only 3 values are set separated by comma");
    }

    public CsvSyntaxException(String message){
        super(message);
    }
}
