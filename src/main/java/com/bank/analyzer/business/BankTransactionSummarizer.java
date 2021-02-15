package com.bank.analyzer.business;

import com.bank.analyzer.domain.BankTransaction;

@FunctionalInterface
public interface BankTransactionSummarizer {

    double summarize(double accumulator, BankTransaction bankTransaction);
    
}
