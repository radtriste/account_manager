package fr.tradisson.account.manager.database.internal.filesystem;

import java.time.LocalDate;
import java.util.Properties;

import fr.tradisson.account.manager.model.Transaction;

public class TransactionStorageFS extends StorageFS<Transaction> {
  
  public TransactionStorageFS() {
    super("transactions");
  }

  @Override
  Properties transformData(Transaction data) {
    Properties props = new Properties();
    props.put("year", data.getDate().getYear());
    props.put("month", data.getDate().getMonthValue());
    props.put("day", data.getDate().getDayOfMonth());
    props.put("source.payee.name", data.getSourcePayeeName());
    props.put("source.payee.internal", data.isSourcePayeeInternal());
    props.put("target.payee.name", data.getTargetPayeeName());
    props.put("target.payee.internal", data.isTargetPayeeInternal());
    props.put("category", data.getCategory());
    props.put("comment", data.getComment());
    props.put("checked", data.isChecked());
    props.put("value", data.getValue());
    return props;
  }

  @Override
  Transaction transformData(Properties props) {
    Transaction data = new Transaction();
    data.setDate(LocalDate.of(Integer.valueOf(props.getProperty("year")), Integer.valueOf(props.getProperty("month")), Integer.valueOf(props.getProperty("day"))));
    data.setSourcePayeeName(props.getProperty("source.payee.name"));
    data.setSourcePayeeInternal(Boolean.valueOf(props.getProperty("source.payee.internal")));
    data.setTargetPayeeName(props.getProperty("target.payee.name"));
    data.setTargetPayeeInternal(Boolean.valueOf(props.getProperty("target.payee.internal")));
    data.setCategory(props.getProperty("category"));
    data.setComment(props.getProperty("comment"));
    data.setChecked(Boolean.valueOf(props.getProperty("checked")));
    data.setValue(Integer.valueOf(props.getProperty("value")));
    return data;
  }

  @Override
  String getFileName(Transaction data) {
    StringBuilder sb = new StringBuilder();
    sb.append(data.getDate().getYear());
    sb.append(data.getDate().getMonthValue());
    sb.append(data.getDate().getDayOfMonth());
    return sb.toString();
  }
}
