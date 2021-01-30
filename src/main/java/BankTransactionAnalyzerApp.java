import com.bank.analyzer.business.BankStatementAnalyzer;
import com.bank.analyzer.business.BankStatementProcessor;
import com.bank.analyzer.csv.BankStatementCSVParser;
import com.bank.analyzer.csv.BankStatementParser;
import com.bank.analyzer.domain.BankTransaction;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class BankTransactionAnalyzerApp {


    public static void main(String... args) throws IOException{
        final BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();
        final BankStatementParser bankStatementParser = new BankStatementCSVParser();

        bankStatementAnalyzer.analyze(args[0], bankStatementParser);
    }


}
