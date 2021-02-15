package com.bank.analyzer.export;

import com.bank.analyzer.domain.SummaryStatistics;
import com.google.gson.Gson;

public class JsonExporter implements Exporter {

    @Override
    public String export(SummaryStatistics summaryStatistics) {
        
        String result = new Gson().toJson(summaryStatistics);
        return result;
    }
    
}
