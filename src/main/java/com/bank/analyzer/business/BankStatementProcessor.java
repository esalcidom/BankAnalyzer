package com.bank.analyzer.business;

import com.bank.analyzer.domain.BankTransaction;
import lombok.AllArgsConstructor;

import java.time.Month;
import java.util.List;

@AllArgsConstructor
public class BankStatementProcessor {

    private final List<BankTransaction> bankTransactions;

    public double calculateTotalAmount(){
        double total = 0;
        for(final BankTransaction bankTransaction: bankTransactions){
            total =+ bankTransaction.getAmount();
        }
        return total;
    }

    public double calculateTotalInMonth(final Month month){
        double total = 0;
        for(final BankTransaction bankTransaction: bankTransactions){
            if(bankTransaction.getDate().getMonth() == month){
                total += bankTransaction.getAmount();
            }
        }
        return total;
    }

    public double calculateTotalForCategory(final String category){
        double total = 0;
        for(final BankTransaction bankTransaction:bankTransactions){
            if(bankTransaction.getDescription().equals(category)){
                total += bankTransaction.getAmount();
            }
        }
        return total;
    }
}