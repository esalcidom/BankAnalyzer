import com.bank.analyzer.business.BankStatementAnalyzer;
import com.bank.analyzer.business.BankStatementProcessor;
import com.bank.analyzer.csv.BankStatementCSVParser;
import com.bank.analyzer.csv.BankStatementParser;
import com.bank.analyzer.export.JsonExporter;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.IOException;

public class BankTransactionAnalyzerApp {

    private static final Logger log = Logger.getLogger(BankTransactionAnalyzerApp.class);

    public static void main(String... args) throws IOException{

        PropertyConfigurator.configure("log4j.properties");

        final BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();
        final BankStatementParser bankStatementParser = new BankStatementCSVParser();
        final JsonExporter jsonExporter = new JsonExporter();

        bankStatementAnalyzer.analyze("wrong_transactions.csv", bankStatementParser);
        String json = bankStatementAnalyzer.export(jsonExporter);
        log.trace("Summary " + json);

    }


}
