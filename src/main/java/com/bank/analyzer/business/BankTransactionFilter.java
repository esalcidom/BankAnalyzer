package com.bank.analyzer.business;

import com.bank.analyzer.domain.BankTransaction;

@FunctionalInterface
public interface BankTransactionFilter {

    boolean test(BankTransaction bankTransaction);
}
