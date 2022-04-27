package fr.tradisson.account.manager.database.internal.filesystem;

import java.nio.file.Path;

public interface StorageFS<T> {

  public void writeFile(T data);

  public T readFile(Path path);
  
  public void clear();
}
