package fr.tradisson.account.manager.model;

import java.util.ArrayList;
import java.util.List;

public class MonthSummary {

  private String month;
  private String year;
  
  private Integer startValue;
  private Integer endValue;

  // This dependency on Transaction will make a listener on transactions folder to update MonthSummaries
  private List<Transaction> transactions = new ArrayList<>();

  public String getMonth() {
    return month;
  }

  public void setMonth(String month) {
    this.month = month;
  }

  public String getYear() {
    return year;
  }

  public void setYear(String year) {
    this.year = year;
  }

  public Integer getStartValue() {
    return startValue;
  }

  public void setStartValue(Integer startValue) {
    this.startValue = startValue;
  }

  public Integer getEndValue() {
    return endValue;
  }

  public void setEndValue(Integer endValue) {
    this.endValue = endValue;
  }

  public List<Transaction> getTransactions() {
    return transactions;
  }

  public void setTransactions(List<Transaction> transactions) {
    this.transactions = transactions;
  }

  
}
