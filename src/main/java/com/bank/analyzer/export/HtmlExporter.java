package com.bank.analyzer.export;

import com.bank.analyzer.domain.SummaryStatistics;

public class HtmlExporter implements Exporter {

    private final String OPEN_LIST_TAG = "<li>";
    private final String CLOSE_LIST_TAG = "</li>";
    private final String STRONG_TAG = "<strong>";

    @Override
    public String export(SummaryStatistics summaryStatistics) {
        
        String result = "<!doctype html>";
        result += "<html lang='en'>";
        result += "<head><title>Bank Transaction Report</title></head>";
        result += "<body>";
        result += "<ul>";
        result += OPEN_LIST_TAG + STRONG_TAG + "The sum is</strong>: " + summaryStatistics.getSum() + CLOSE_LIST_TAG;
        result += OPEN_LIST_TAG + STRONG_TAG + "The average is</strong>: " + summaryStatistics.getAverage() + CLOSE_LIST_TAG;
        result += OPEN_LIST_TAG + STRONG_TAG + "The max is</strong>: " + summaryStatistics.getMax() + CLOSE_LIST_TAG;
        result += OPEN_LIST_TAG + STRONG_TAG + "The min is</strong>: " + summaryStatistics.getMin() + CLOSE_LIST_TAG;
        result += "</ul>";
        result += "</body>";
        result += "</html>";
        return result;
    }
    
}
