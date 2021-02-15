package com.bank.analyzer.csv;

import java.util.List;

import com.bank.analyzer.domain.BankTransaction;

public interface BankStatementParser {

    BankTransaction parseFrom(String line);

    List<BankTransaction> parseLinesFrom(List<String> lines);
}
