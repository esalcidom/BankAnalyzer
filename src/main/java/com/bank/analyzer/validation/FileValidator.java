package com.bank.analyzer.validation;

import com.bank.analyzer.exception.InvalidFormatException;

import java.util.List;

public class FileValidator {

    public void validateFileFormat(List<String> lines) throws InvalidFormatException{
        for(String line: lines){
            if(!validCSVLine(line)) {
                throw new InvalidFormatException();
            }
        }
    }

    private boolean validCSVLine(String line){
        if(line.split(",").length != 3){
            return false;
        }
        return true;
    }


}
