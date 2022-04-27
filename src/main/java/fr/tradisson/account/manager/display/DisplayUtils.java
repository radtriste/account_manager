package fr.tradisson.account.manager.display;

import java.util.Collection;
import java.util.List;

import fr.tradisson.account.manager.model.Transaction;

public class DisplayUtils {

  public static String displayTransactions(Collection<Transaction> transactions) {

    String[] headers = { "", "Date", "Account", "Payee", "Category", "Comment", "Value" };
    Table table = new Table(headers);

    transactions.stream().forEach(t -> {
        table.addRow(new String[] {
          t.isChecked() ? "x" : "",
          t.getDate().toString(),
          (t.isSourcePayeeInternal() ? "(account) " : "") + t.getSourcePayeeName(),
          (t.isTargetPayeeInternal() ? "(account) " : "") + t.getTargetPayeeName(),
          t.getCategory(),
          t.getComment(),
          t.getValue().toString()
          }
        );
    });
    return table.getOutput();
  }

}
