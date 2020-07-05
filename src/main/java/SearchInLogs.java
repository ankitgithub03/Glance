import java.util.HashMap;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SearchInLogs {

  public  void searchValue(List<String> filterlogs, String search){
    String pattern = ".*"+search+".*";
    Pattern logPattern = Pattern.compile(pattern);
    String splitPattern = ".+([0-9]{4})+\\s+[A-Z]+\\s[\\w.]+(:|\\s+:)";
    HashMap<String, Long> search_logs = (HashMap<String, Long>) filterlogs.stream()
        .filter(logPattern.asPredicate())
        .map(l -> l.split(splitPattern)[1]).filter(l -> !l.trim().isEmpty())
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    System.out.println("\n\nMatching Strings =>" + search);
    System.out.println("==============\n");
    System.out.println("Matching String | # of Occurrences");
    search_logs.forEach((k,v) -> System.out.println(k + " | " + v));
  }

}
