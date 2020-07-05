import static java.util.stream.Collectors.toList;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class GetFilterLogs {

  static String filePath =
      System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
          + File.separator + "resources" + File.separator
          + "bugreport-N2G47H-2019-08-27-19-02-04.txt";

  public static void main(String[] args) {

    List<String> filterLogs = getFilteredLog(filePath, "4667");
    List<String> fatelExceptions = FindLogs.findFetalExceptions(filterLogs);
    FindLogs.stacktraces(fatelExceptions, filterLogs);
    FindLogs.findErrors(filterLogs);


  }


  public static List<String> getFilteredLog(String filePath, String filterKeyword) {

    final Pattern logPattern = Pattern.compile(filterKeyword);
    List<String> filteredLines = null;

    try {
      Stream<String> stream = Files.lines(Paths.get(filePath));
      filteredLines = stream
          .filter(logPattern.asPredicate())
          .collect(toList());
    } catch (IOException e) {
      e.printStackTrace();
    }
//    System.out.println("filtered values----------");
//  System.out.println(filteredLines);
//  for (int i = 0; i < filteredLines.size(); i++) {
//    System.out.println(filteredLines.get(i));
//    if(i == 100){
//      break;
//    }
//  }
    return filteredLines;

  }


}
