package com.bank.analyzer.export;

import com.bank.analyzer.domain.SummaryStatistics;

public class XMLExporter implements Exporter {

    @Override
    public String export(SummaryStatistics summaryStatistics) {
        String result = "<SummaryStatisctics>";
        result += "<sum>" + summaryStatistics.getSum() + "</sum>";
        result += "<average>" + summaryStatistics.getAverage() + "</average>";
        result += "<max>" + summaryStatistics.getMax() + "</max>";
        result += "<min>" + summaryStatistics.getMin() + "</min>";
        result += "</SummaryStatistics>";
        return result;
    }
    
}
