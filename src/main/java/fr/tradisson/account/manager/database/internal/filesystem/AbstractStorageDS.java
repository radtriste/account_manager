package fr.tradisson.account.manager.database.internal.filesystem;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

import fr.tradisson.account.manager.database.StorageFSException;

public abstract class AbstractStorageDS<T> implements StorageFS<T> {

  protected static final String DB_FILE_EXTENSION = ".fsdb";

  private String folder;

  AbstractStorageDS(String folder) {
    this.folder = folder;
  }

  public void storeData(T data) {
    Properties props = transformData(data);
    Path finalPath = getParentPath().resolve(getFileName(data) + DB_FILE_EXTENSION);
    finalPath.getParent().toFile().mkdirs();

    try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
      props.store(byteArrayOutputStream, "");
      Files.write(finalPath, byteArrayOutputStream.toByteArray());
    } catch (IOException e) {
      throw new StorageFSException(e);
    }
  }

  public T readData(Path path) {
    Properties props = new Properties();
    try (FileInputStream fis = new FileInputStream(path.toFile())) {
      props.load(fis);
      return transformData(props);
    } catch (IOException e) {
      throw new StorageFSException(e);
    }
  }

  private Path getParentPath() {
    return FileSystemDBUtils.getRootPath().resolve(folder);
  }

  abstract Properties transformData(T data);

  abstract T transformData(Properties data);

  abstract String getFileName(T data);
}
