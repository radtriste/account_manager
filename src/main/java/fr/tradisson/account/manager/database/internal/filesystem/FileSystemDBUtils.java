package fr.tradisson.account.manager.database.internal.filesystem;

import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.nio.file.Path;
import java.util.Properties;

public class FileSystemDBUtils {

  static Path getRootPath() {
    return Path.of("./database");
  }

  public static void load(Class<?> configClass, String file) {
    try {
      Properties props = new Properties();
      try (FileInputStream propStream = new FileInputStream(file)) {
        props.load(propStream);
      }
      for (Field field : configClass.getDeclaredFields()){
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
