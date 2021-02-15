package com.bank.analyzer.export;

import com.bank.analyzer.domain.SummaryStatistics;

public interface Exporter {
    
    String export(SummaryStatistics summaryStatistics);
}
