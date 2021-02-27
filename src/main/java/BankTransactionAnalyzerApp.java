import com.bank.analyzer.business.BankStatementAnalyzer;
import com.bank.analyzer.csv.BankStatementCSVParser;
import com.bank.analyzer.csv.BankStatementParser;

import java.io.IOException;

public class BankTransactionAnalyzerApp {


    public static void main(String... args) throws IOException{

        final BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();
        final BankStatementParser bankStatementParser = new BankStatementCSVParser();

        bankStatementAnalyzer.analyze("transactions.csv", bankStatementParser);
    }


}
