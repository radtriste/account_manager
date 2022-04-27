package fr.tradisson.account.manager.database.internal.filesystem;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StorageFSUtils {

  static final String DB_FILE_EXTENSION = ".fsdb";

  static List<Path> listDBFiles(Path folderPath) {
    if (!Files.isDirectory(folderPath)) {
      throw new StorageFSException("Given path is not a folder: " + folderPath.toAbsolutePath().toString());
    }

    try (Stream<Path> walk = Files.walk(folderPath)) {
      return walk
          .filter(Files::isRegularFile) // is a file
          .filter(p -> p.getFileName().toString().endsWith(DB_FILE_EXTENSION))
          .collect(Collectors.toList());
    } catch (IOException e) {
      throw new StorageFSException("Unable to list files from folder: " + folderPath, e);
    }
  }

  public static void load(Class<?> configClass, String file) {
    try {
      Properties props = new Properties();
      try (FileInputStream propStream = new FileInputStream(file)) {
        props.load(propStream);
      }
      for (Field field : configClass.getDeclaredFields()) {
        field.set(null, getValue(props, field.getName(), field.getType()));
      }
    } catch (Exception e) {
      throw new RuntimeException("Error loading configuration: " + e, e);
    }
  }

  private static Object getValue(Properties props, String name, Class<?> type) {
    String value = props.getProperty(name);
    if (value == null)
      throw new IllegalArgumentException("Missing configuration value: " + name);
    if (type == String.class)
      return value;
    if (type == boolean.class)
      return Boolean.parseBoolean(value);
    if (type == int.class)
      return Integer.parseInt(value);
    if (type == double.class)
      return Double.parseDouble(value);
    throw new IllegalArgumentException("Unknown configuration value type: " + type.getName());
  }

}
