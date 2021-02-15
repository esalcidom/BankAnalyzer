package com.bank.analyzer.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class SummaryStatistics {

    private final double sum;
    private final double max;
    private final double min;
    private final double average;
    
}
