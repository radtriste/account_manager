package fr.tradisson.account.manager;

import java.nio.file.Paths;
import java.time.LocalDate;

import fr.tradisson.account.manager.database.internal.filesystem.AbstractStorageDS;
import fr.tradisson.account.manager.database.internal.filesystem.TransactionStorageFS;
import fr.tradisson.account.manager.model.Transaction;

public class Main {
  
  public static void main(String[] args) {
    AbstractStorageDS<Transaction> storage = new TransactionStorageFS();

    Transaction transaction = new Transaction();
    transaction.setDate(LocalDate.now());
    transaction.setCategory("category");
    transaction.setComment("comment");
    transaction.setSourcePayeeName("CheckingAccount");
    transaction.setSourcePayeeInternal(true);
    transaction.setTargetPayeeName("boucherie");
    transaction.setValue(100.00);

    storage.storeData(transaction);

    Transaction readTransaction = storage.readData(Paths.get("./database",  "transactions", "2022424.fsdb"));
    System.out.println(readTransaction);
  }
}
