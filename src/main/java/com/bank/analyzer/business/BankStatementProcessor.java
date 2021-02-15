package com.bank.analyzer.business;

import com.bank.analyzer.domain.BankTransaction;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BankStatementProcessor {

    private final List<BankTransaction> bankTransactions;

    public BankStatementProcessor(final List<BankTransaction> bankTransactions){
        this.bankTransactions = bankTransactions;
    }

    public double calculateTotalInMonth(final Month month){
        return summarizeTransactions((acc, bankTransaction) ->
            bankTransaction.getDate().getMonth() == month ? acc + bankTransaction.getAmount() : acc
        );
    }

    public double calculateTotalForCategory(final String category){
        return summarizeTransactions((acc, bankTransaction) ->
            bankTransaction.getDescription().equals(category) ? acc + bankTransaction.getAmount() : acc
        );
    }

    public double calculateTotalAmount(){
        return summarizeTransactions((acc, bankTransaction) ->
            acc + bankTransaction.getAmount()
        );
    }

    //This is a iterator method which will give the initial input of the accumulator and the transaction
    //to get as result the total amount fo selected transactions
    public double summarizeTransactions(final BankTransactionSummarizer bankTransactionSummarizer){
        double result = 0;
        for(final BankTransaction bankTransaction: bankTransactions){
            result = bankTransactionSummarizer.summarize(result, bankTransaction);
        }

        return result;
    }

    public List<BankTransaction> findTransactionsGreaterThanEqual(final int amount){
        return findTransactions(bankTransaction ->
            bankTransaction.getAmount() >= amount
        );
    }

    //This is a iterator method which will test the transaction filter and if pass then add to the list
    public List<BankTransaction> findTransactions(final BankTransactionFilter bankTransactionFilter){
        final List<BankTransaction> result = new ArrayList<>();
        for(final BankTransaction bankTransaction: bankTransactions){
            if(bankTransactionFilter.test(bankTransaction)){
                result.add(bankTransaction);
            }
        }
        return result;
    }
}
