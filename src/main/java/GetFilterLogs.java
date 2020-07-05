import static java.util.stream.Collectors.toList;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class GetFilterLogs {

  public List<String> getFilteredLog(String filePath, String filterKeyword) {

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
    return filteredLines;

  }

  public void getLogsForGlance(String filePath, String pid){
    List<String> filterLogs = getFilteredLog(filePath,pid);
    FindLogs findLogs = new FindLogs();
    List<String> fetal_exceptions  = findLogs.findFetalExceptions(filterLogs);
    findLogs.findStacktrace(fetal_exceptions,filterLogs);
    findLogs.findErrors(filterLogs);
    SearchInLogs searchInLogs = new SearchInLogs();
    searchInLogs.searchValue(filterLogs,"WARNING");
    searchInLogs.searchValue(filterLogs,"OOM");
    searchInLogs.searchValue(filterLogs,"OutOfMemoryError");

  }

}
