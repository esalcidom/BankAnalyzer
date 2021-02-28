package com.bank.analyzer.validation;

import java.util.ArrayList;
import java.util.List;

public class Notification {
    private final List<String> errors = new ArrayList<>();

    public void addError(Exception exception){
        errors.add(exception.getClass() + " - " + exception.getMessage());
    }

    public void addError(String errorMessage){
        errors.add("Error - " + errorMessage);
    }

    public String errorMessage(){
        return errors.toString();
    }

    public boolean hasErrors(){
        return !errors.isEmpty();
    }

    public List<String> getErrors(){
        return errors;
    }
}
