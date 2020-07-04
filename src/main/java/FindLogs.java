import com.mgnt.utils.TextUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class FindLogs {

  static  HashMap<String, Integer> uniqueFetal_exception = new HashMap<>();


  public static List<String> findFetalExceptions(List<String> filterlogs){

    String fetal_exception = "FATAL EXCEPTION";
    List<String> exceptions = filterlogs.stream().filter(l->l.contains(fetal_exception)).collect(Collectors.toList());
//    System.out.println(exceptions);
    for(String txt : exceptions) {
      int lineNumber = filterlogs.indexOf(txt);
      int exceptionLineNumber = lineNumber + 2;
      String e = filterlogs.get(exceptionLineNumber);
//      System.out.println("exception: \n" + e);
      String pattern = ".+[A-Z]+\\s+[\\w]+:+\\s";
      String exception_msg = e.split(pattern)[1].trim();
      if (uniqueFetal_exception.containsKey(exception_msg)) {
        uniqueFetal_exception.put(exception_msg, uniqueFetal_exception.get(exception_msg)+1);
      } else {
        uniqueFetal_exception.put(exception_msg,1);
      }
    }
    System.out.println("FATAL EXCEPTION");
    System.out.println("==============");
    System.out.println("Exception Message| # of Occurrences");
    uniqueFetal_exception.forEach((key, value) -> System.out.println(key+" |"+ value));
    return exceptions;
  }


public static void stacktraces(List<String> fetal_exceptions, List<String> filterlogs){






}

}
