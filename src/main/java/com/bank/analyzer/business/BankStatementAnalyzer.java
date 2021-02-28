package com.bank.analyzer.business;

import com.bank.analyzer.csv.BankStatementParser;
import com.bank.analyzer.domain.BankTransaction;
import com.bank.analyzer.domain.SummaryStatistics;
import com.bank.analyzer.exception.BankAnalyzerException;
import com.bank.analyzer.exception.CsvSyntaxException;
import com.bank.analyzer.export.Exporter;
import com.bank.analyzer.validation.FileValidator;
import org.apache.log4j.Logger;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class BankStatementAnalyzer {

    private static final String RESOURCES = "src/main/resources/";
    private static final Logger log = Logger.getLogger(BankStatementAnalyzer.class);
    private BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(null);

    public void analyze(final String fileName, final BankStatementParser bankStatementParser) throws IOException {
        final String METHOD_NAME = "Method = analyze - ";


        try{
            final Path path = Paths.get(RESOURCES + fileName);
            final List<String> lines = Files.readAllLines(path);

            final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);
            bankStatementProcessor = new BankStatementProcessor(bankTransactions);

        }
        catch(NoSuchFileException nsfe){
            log.error(METHOD_NAME + nsfe.getClass() + " - " + nsfe.getMessage());
        }
        catch(BankAnalyzerException bae){
            log.error(METHOD_NAME + bae.getClass() + " - " + bae.getMessage());
        }

    }

    public String export(final Exporter exporter){
        //TODO: check if this is catually ok
        return exporter.export(bankStatementProcessor.getSummary());
    }

}
