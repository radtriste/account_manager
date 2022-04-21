package fr.tradisson.account.manager.database.internal.filesystem;

import java.nio.file.Path;

public class FileSystemDBUtils {

  static Path getRootPath() {
    return Path.of(".");
  }

}
