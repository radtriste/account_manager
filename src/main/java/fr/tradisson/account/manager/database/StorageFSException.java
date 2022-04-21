package fr.tradisson.account.manager.database;

public class StorageFSException extends RuntimeException {

  public StorageFSException() {
  }

  public StorageFSException(String message) {
    super(message);
  }

  public StorageFSException(Throwable cause) {
    super(cause);
  }

  public StorageFSException(String message, Throwable cause) {
    super(message, cause);
  }
  
}
