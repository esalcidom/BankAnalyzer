package com.bank.analyzer.csv;

import java.util.List;

import com.bank.analyzer.domain.BankTransaction;
import com.bank.analyzer.exception.BankAnalyzerException;

public interface BankStatementParser {

    BankTransaction parseFrom(String line) throws BankAnalyzerException;

    List<BankTransaction> parseLinesFrom(List<String> lines) throws BankAnalyzerException ;
}
