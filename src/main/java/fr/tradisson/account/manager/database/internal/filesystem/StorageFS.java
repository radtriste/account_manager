package fr.tradisson.account.manager.database.internal.filesystem;

import java.nio.file.Path;

public interface StorageFS<T> {

  public void storeData(T data);

  public T readData(Path path);
}
