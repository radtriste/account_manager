package fr.tradisson.account.manager.model;

import java.time.LocalDate;

public class Transaction {

  private LocalDate date;

  private String sourcePayeeName;
  private Boolean sourcePayeeInternal = false;
  private String targetPayeeName;
  private Boolean targetPayeeInternal = false;

  private String category;
  private String comment;

  private Boolean checked = false;

  private Double value;

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

  public Boolean isSourcePayeeInternal() {
    return sourcePayeeInternal;
  }

  public void setSourcePayeeInternal(Boolean sourcePayeeInternal) {
    this.sourcePayeeInternal = sourcePayeeInternal;
  }

  public String getTargetPayeeName() {
    return targetPayeeName;
  }

  public void setTargetPayeeName(String targetPayeeName) {
    this.targetPayeeName = targetPayeeName;
  }

  public Boolean isTargetPayeeInternal() {
    return targetPayeeInternal;
  }

  public void setTargetPayeeInternal(Boolean targetPayeeInternal) {
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

  public Double getValue() {
    return value;
  }

  public void setValue(Double value) {
    this.value = value;
  }

  public Boolean isChecked() {
    return checked;
  }

  public void setChecked(Boolean checked) {
    this.checked = checked;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((category == null) ? 0 : category.hashCode());
    result = prime * result + ((checked == null) ? 0 : checked.hashCode());
    result = prime * result + ((comment == null) ? 0 : comment.hashCode());
    result = prime * result + ((date == null) ? 0 : date.hashCode());
    result = prime * result + ((sourcePayeeInternal == null) ? 0 : sourcePayeeInternal.hashCode());
    result = prime * result + ((sourcePayeeName == null) ? 0 : sourcePayeeName.hashCode());
    result = prime * result + ((targetPayeeInternal == null) ? 0 : targetPayeeInternal.hashCode());
    result = prime * result + ((targetPayeeName == null) ? 0 : targetPayeeName.hashCode());
    result = prime * result + ((value == null) ? 0 : value.hashCode());
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
    Transaction other = (Transaction) obj;
    if (category == null) {
      if (other.category != null)
        return false;
    } else if (!category.equals(other.category))
      return false;
    if (checked == null) {
      if (other.checked != null)
        return false;
    } else if (!checked.equals(other.checked))
      return false;
    if (comment == null) {
      if (other.comment != null)
        return false;
    } else if (!comment.equals(other.comment))
      return false;
    if (date == null) {
      if (other.date != null)
        return false;
    } else if (!date.equals(other.date))
      return false;
    if (sourcePayeeInternal == null) {
      if (other.sourcePayeeInternal != null)
        return false;
    } else if (!sourcePayeeInternal.equals(other.sourcePayeeInternal))
      return false;
    if (sourcePayeeName == null) {
      if (other.sourcePayeeName != null)
        return false;
    } else if (!sourcePayeeName.equals(other.sourcePayeeName))
      return false;
    if (targetPayeeInternal == null) {
      if (other.targetPayeeInternal != null)
        return false;
    } else if (!targetPayeeInternal.equals(other.targetPayeeInternal))
      return false;
    if (targetPayeeName == null) {
      if (other.targetPayeeName != null)
        return false;
    } else if (!targetPayeeName.equals(other.targetPayeeName))
      return false;
    if (value == null) {
      if (other.value != null)
        return false;
    } else if (!value.equals(other.value))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Transaction [category=" + category + ", checked=" + checked + ", comment=" + comment + ", date=" + date
        + ", sourcePayeeInternal=" + sourcePayeeInternal + ", sourcePayeeName=" + sourcePayeeName
        + ", targetPayeeInternal=" + targetPayeeInternal + ", targetPayeeName=" + targetPayeeName + ", value=" + value
        + "]";
  }

  
}
