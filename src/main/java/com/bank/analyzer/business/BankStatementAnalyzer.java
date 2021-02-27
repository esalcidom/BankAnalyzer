package com.bank.analyzer.business;

import com.bank.analyzer.csv.BankStatementParser;
import com.bank.analyzer.domain.BankTransaction;
import org.apache.log4j.Logger;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class BankStatementAnalyzer {

    private static final String RESOURCES = "src/main/resources/";
    private static final Logger log = Logger.getLogger(BankStatementAnalyzer.class);

    //TODO: set validator to analize list line

    public void analyze(final String fileName, final BankStatementParser bankStatementParser) throws IOException {

        try{
            final Path path = Paths.get(RESOURCES + fileName);
            final List<String> lines = Files.readAllLines(path);
            final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);
            final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);
            collectSummary(bankStatementProcessor);
        }
        catch(IOException e){
            log.error(e.getMessage());
        }
    }

    private void collectSummary(final BankStatementProcessor bankStatementProcessor){
        log.trace("The total for all transactions is " + bankStatementProcessor.calculateTotalAmount());
        log.trace("The total for transactions in January is " + bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));
        log.trace("The total for transactions in February is " + bankStatementProcessor.calculateTotalInMonth(Month.FEBRUARY));
        log.trace("The total salary received is " + bankStatementProcessor.calculateTotalForCategory("Salary"));
    }
}
