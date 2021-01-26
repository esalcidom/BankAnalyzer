package com.bank.analyzer.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@AllArgsConstructor
public class BankTransaction {

    private final LocalDate date;
    private final double amount;
    private final String description;

    public String toString(){
        return "BankTransaction { date = " + date + ", amount = " + amount + ", description = " + description + " }";
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankTransaction that = (BankTransaction) o;
        return Double.compare(that.amount, amount) == 0 &&
                date.equals(that.date) &&
                description.equals(that.description);
    }

    public int hashCode(){
        return Objects.hash(date, amount, description);
    }
}
