import java.io.File;

public class LogForPID {

  static String filePath =
      System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
          + File.separator + "resources" + File.separator
          + "bugreport-N2G47H-2019-08-27-19-02-04.txt";

  public static void main(String[] args) {
    new GetFilterLogs().getLogsForGlance(filePath, "4667");
  }

}
