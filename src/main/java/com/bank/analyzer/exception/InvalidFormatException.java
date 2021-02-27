package com.bank.analyzer.exception;

public class InvalidFormatException extends RuntimeException{

    public InvalidFormatException(){
        super("Invalid format in file. Check only 3 values are set separated by comma");
    }
}
