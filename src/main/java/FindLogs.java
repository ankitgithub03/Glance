import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class FindLogs {

  HashMap<String, Integer> uniqueFetal_exception = new HashMap<>();
  HashMap<Integer, StringBuilder> unique_stacktrace = new HashMap<>();
  HashMap<String, Long> unique_error_logs = new HashMap<>();


  public List<String> findFetalExceptions(List<String> filterlogs) {
    List<String> exceptions = filterlogs.stream().filter(l -> l.contains("FATAL EXCEPTION"))
        .collect(Collectors.toList());
    List<String> fetal_exceptions = new ArrayList<>();
    for (String txt : exceptions) {
      int lineNumber = filterlogs.indexOf(txt);
      int exceptionLineNumber = lineNumber + 2;
      String e = filterlogs.get(exceptionLineNumber);
      String pattern = ".+[A-Z]+\\s+[\\w]+:+\\s";
      String exception_msg = e.split(pattern)[1].trim();
      if (uniqueFetal_exception.containsKey(exception_msg)) {
        uniqueFetal_exception.put(exception_msg, uniqueFetal_exception.get(exception_msg) + 1);
      } else {
        uniqueFetal_exception.put(exception_msg, 1);
        fetal_exceptions.add(e);
      }
    }
    System.out.println("FATAL EXCEPTION");
    System.out.println("=================\n");
    System.out.println("Exception Message| # of Occurrences");
    uniqueFetal_exception.forEach((key, value) -> System.out.println(key + " |" + value));
    return fetal_exceptions;
  }


  public void findStacktrace(List<String> fetal_exceptions, List<String> filterlogs) {

    int counter = 0;
    for (String txt : fetal_exceptions) {
      StringBuilder stackTrace = new StringBuilder();
      int lineNumber = filterlogs.indexOf(txt);
      String pattern = ".+[A-Z]+\\s+[\\w]+:+\\s";
      String e = filterlogs.get(lineNumber);
      stackTrace.append(e.split(pattern)[1].trim());
      stackTrace.append("\n");
      pattern = ".+[A-Z]+\\s+[\\w]+:\\s+at+\\s";
      String line = filterlogs.get(++lineNumber);
      while (Pattern.compile(pattern).matcher(line).find()) {
        line = line.replaceAll(pattern, "at ");
        stackTrace.append("\t");
        stackTrace.append(line + "\n");
        line = filterlogs.get(++lineNumber);
      }
      stackTrace.append("\n");
//      System.out.println(stackTrace);
      unique_stacktrace.put(++counter, stackTrace);
    }

    System.out.println("\n\nStacktrace:");
    System.out.println("==============\n");
    unique_stacktrace.forEach((key, value) -> System.out.println("#" + key + ") " + value));
  }


  public void findErrors(List<String> filterlogs) {
//    String pattern = ".+\\s+E\\s+[\\w]+\\s*:\\s+";
    String pattern = ".+\\s+E\\s+[\\w]+(:|\\s+:)+(?!\\s+at)";
    Pattern logPattern = Pattern.compile(pattern);
    unique_error_logs = (HashMap<String, Long>) filterlogs.stream().filter(logPattern.asPredicate())
        .map(l -> l.split(pattern)[1])
        .filter(l -> !l.isEmpty())
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    System.out.println("\n\nErrors");
    System.out.println("==============\n");
    System.out.println("Error Message| # of Occurrences");
    unique_error_logs.forEach((k, v) -> System.out.println(k + " | " + v));
  }


}
