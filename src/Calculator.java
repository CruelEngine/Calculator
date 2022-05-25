import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public int add(String numbers){
        if(numbers.isEmpty()){
            return 0;
        }
        numbers = numbers.replace("[", "");
        numbers = numbers.replace("]", "");
        String delimitterPattern = "\\/\\/(.*?)\\n"; // regexp tested using regexp101. NOTE: In java we need to double escape
        Pattern pattern = Pattern.compile(delimitterPattern);
        Matcher patternMatcher = pattern.matcher(numbers);
        String delimitter=  "\n";
        if(patternMatcher.find()) {
            String delimitterBoundary = patternMatcher.group(0);
            delimitter = patternMatcher.group(1);
            numbers = numbers.replace(delimitterBoundary, "");
        }
        numbers = numbers.replace(delimitter, ",");
        if(delimitter.length() > 1) {
            String[] delimiterList = delimitter.split("");
            for(int j  =0 ; j < delimiterList.length ;j++) {
                numbers = numbers.replace(delimiterList[j], ",");
            }
        }
        String[] numberList = numbers.split(","); // split the string using ',' as separator
        int sum = 0;
        for(int i =0 ; i < numberList.length; i++) {
            if(Integer.valueOf(numberList[i]) < 0) {
                throw new IllegalArgumentException("negatives not allowed");
            }
            if(Integer.valueOf(numberList[i]) > 1000) {
                continue;
            }
            sum += Integer.valueOf(numberList[i]);
        }
        return sum;
    }
}
