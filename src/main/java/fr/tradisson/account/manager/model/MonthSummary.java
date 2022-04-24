package fr.tradisson.account.manager.model;

import java.util.ArrayList;
import java.util.List;

public class MonthSummary {

  private String month;
  private String year;
  
  private Double startValue;
  private Double endValue;

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

  public Double getStartValue() {
    return startValue;
  }

  public void setStartValue(Double startValue) {
    this.startValue = startValue;
  }

  public Double getEndValue() {
    return endValue;
  }

  public void setEndValue(Double endValue) {
    this.endValue = endValue;
  }

  public List<Transaction> getTransactions() {
    return transactions;
  }

  public void setTransactions(List<Transaction> transactions) {
    this.transactions = transactions;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((endValue == null) ? 0 : endValue.hashCode());
    result = prime * result + ((month == null) ? 0 : month.hashCode());
    result = prime * result + ((startValue == null) ? 0 : startValue.hashCode());
    result = prime * result + ((transactions == null) ? 0 : transactions.hashCode());
    result = prime * result + ((year == null) ? 0 : year.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    MonthSummary other = (MonthSummary) obj;
    if (endValue == null) {
      if (other.endValue != null)
        return false;
    } else if (!endValue.equals(other.endValue))
      return false;
    if (month == null) {
      if (other.month != null)
        return false;
    } else if (!month.equals(other.month))
      return false;
    if (startValue == null) {
      if (other.startValue != null)
        return false;
    } else if (!startValue.equals(other.startValue))
      return false;
    if (transactions == null) {
      if (other.transactions != null)
        return false;
    } else if (!transactions.equals(other.transactions))
      return false;
    if (year == null) {
      if (other.year != null)
        return false;
    } else if (!year.equals(other.year))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "MonthSummary [endValue=" + endValue + ", month=" + month + ", startValue=" + startValue + ", transactions="
        + transactions + ", year=" + year + "]";
  }

  
}
