package fr.tradisson.account.manager.database.internal.filesystem;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

import org.eclipse.microprofile.config.inject.ConfigProperty;

public abstract class AbstractStorageFS<T> implements StorageFS<T> {

  @ConfigProperty(name = "fsdb.root-path", defaultValue = "./database")
  private String dbRootPath;

  private String folder;

  AbstractStorageFS(String folder) {
    this.folder = folder;
  }

  public void writeFile(T data) {
    Properties props = transformData(data);
    Path finalPath = getParentPath().resolve(getFileName(data) + StorageFSUtils.DB_FILE_EXTENSION);
    finalPath.getParent().toFile().mkdirs();

    try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
      props.store(byteArrayOutputStream, "");
      Files.write(finalPath, byteArrayOutputStream.toByteArray());
    } catch (IOException e) {
      throw new StorageFSException(e);
    }
  }

  public T readFile(Path path) {
    Properties props = new Properties();
    try (FileInputStream fis = new FileInputStream(path.toFile())) {
      props.load(fis);
      return transformData(props);
    } catch (IOException e) {
      throw new StorageFSException(e);
    }
  }

  public List<T> readAllFiles() {
    return StorageFSUtils.listDBFiles(getParentPath()).stream().map(this::readFile).collect(Collectors.toList());
  }

  private Path getParentPath() {
    return getRootPath().resolve(folder);
  }

  public void clear() {
    try {
      Files.delete(getRootPath());
    } catch(IOException e) {
      throw new StorageFSException("Unable to clear FS database", e);
    }
  }

  abstract Properties transformData(T data);

  abstract T transformData(Properties data);

  abstract String getFileName(T data);

  protected Path getRootPath() {
    return Path.of(dbRootPath);
  }
}
