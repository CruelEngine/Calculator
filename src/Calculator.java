import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public int add(String numbers){
        if(numbers.isEmpty()){
            return 0;
        }
        String delimitterPattern = "\\/\\/(.*?)\\n";
        Pattern pattern = Pattern.compile(delimitterPattern);
        Matcher patternMatcher = pattern.matcher(numbers);
        String delimitter=  "\n";
        if(patternMatcher.find()) {
            System.out.print(patternMatcher.group(0));
            String delimitterBoundary = patternMatcher.group(0);
            System.out.print(patternMatcher.group(1));
            delimitter = patternMatcher.group(1);
            numbers = numbers.replace(delimitterBoundary, "");
            System.out.println(numbers);
        }

        // replace newline with comma
        numbers = numbers.replace(delimitter, ",");
        System.out.println(numbers);
        String[] numberList = numbers.split(","); // split the string using ',' as separator
        int sum = 0;
        for(int i =0 ; i < numberList.length; i++) {
            sum += Integer.valueOf(numberList[i]);
        }
        return sum;
    }
}
