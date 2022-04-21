package fr.tradisson.account.manager.model;

import java.time.LocalDate;

public class Transaction {

  private LocalDate date;

  private String sourcePayeeName;
  private boolean sourcePayeeInternal;
  private String targetPayeeName;
  private boolean targetPayeeInternal;

  private String category;
  private String comment;

  private boolean checked;

  private Integer value;

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public String getSourcePayeeName() {
    return sourcePayeeName;
  }

  public void setSourcePayeeName(String sourcePayeeName) {
    this.sourcePayeeName = sourcePayeeName;
  }

  public boolean isSourcePayeeInternal() {
    return sourcePayeeInternal;
  }

  public void setSourcePayeeInternal(boolean sourcePayeeInternal) {
    this.sourcePayeeInternal = sourcePayeeInternal;
  }

  public String getTargetPayeeName() {
    return targetPayeeName;
  }

  public void setTargetPayeeName(String targetPayeeName) {
    this.targetPayeeName = targetPayeeName;
  }

  public boolean isTargetPayeeInternal() {
    return targetPayeeInternal;
  }

  public void setTargetPayeeInternal(boolean targetPayeeInternal) {
    this.targetPayeeInternal = targetPayeeInternal;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public Integer getValue() {
    return value;
  }

  public void setValue(Integer value) {
    this.value = value;
  }

  public boolean isChecked() {
    return checked;
  }

  public void setChecked(boolean checked) {
    this.checked = checked;
  }

  
}
