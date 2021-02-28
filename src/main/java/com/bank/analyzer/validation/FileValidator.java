package com.bank.analyzer.validation;

import com.bank.analyzer.exception.BankAnalyzerException;
import com.bank.analyzer.exception.CsvSyntaxException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;

public class FileValidator {

    private static final Notification notification = new Notification();

    public static void validate(String[] columns) throws BankAnalyzerException{
        int size = columns.length;
        String description = columns[2];

        if(size != 3){
            notification.addError(new CsvSyntaxException("There should be only 3 values. Check line " +
                    Arrays.toString(columns)));
        }

        try{
            LocalDate date = LocalDate.parse(columns[0], DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            if(date.isAfter(LocalDate.now())){
                notification.addError("Invalid date, transaction from the future is not possible");
            }
        }
        catch(DateTimeParseException dtpe){
            notification.addError(dtpe + " check if is a date " + columns[0]);
        }

        try{
            Double.parseDouble(columns[1]);
        }
        catch(NumberFormatException nfe){
            notification.addError(nfe + " check if is a number" + columns[1]);
        }

        if(description.isEmpty()){
            notification.addError("Description is empty");
        }
        else if(description.length() > 100){
            notification.addError("Description to long. Length should be less than 100");
        }

        if(notification.hasErrors()){
            throw new BankAnalyzerException(notification.errorMessage());
        }
    }

}
