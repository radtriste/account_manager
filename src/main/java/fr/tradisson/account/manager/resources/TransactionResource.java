package fr.tradisson.account.manager.resources;

import java.time.LocalDate;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.tradisson.account.manager.database.internal.filesystem.TransactionStorageFS;
import fr.tradisson.account.manager.display.DisplayUtils;
import fr.tradisson.account.manager.model.Transaction;

@Path("transaction")
public class TransactionResource {

  @Inject
  TransactionStorageFS storage;

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String getAllTransactions() {
    return DisplayUtils.displayTransactions(storage.readAllFiles());
  }

  @POST
  public void addTransaction() {
    Transaction transaction = new Transaction();
    transaction.setDate(LocalDate.now());
    transaction.setCategory("category");
    transaction.setComment("comment");
    transaction.setSourcePayeeName("CheckingAccount");
    transaction.setSourcePayeeInternal(true);
    transaction.setTargetPayeeName("boucherie");
    transaction.setValue(100.00);

    storage.writeFile(transaction);
  }
}
