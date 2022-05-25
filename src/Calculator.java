import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Calculator {
    public int add(String numbers){
        if(numbers.isEmpty()){
            return 0;
        }
        String squareBracketRegexp = "[\\[\\]]+";
        numbers = numbers.replaceAll(squareBracketRegexp, "");
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
        /**
         * Matches all the characters in the delimiter (delimiter enclosed inside [] )
         * and + matches the characters unlimited times
         */
        String delimiterRegexp = "[" + delimitter + "]+"; // tested once again using regexp101
        numbers = numbers.replaceAll(delimiterRegexp, ",");
        List<Integer> numberList = Arrays.stream(numbers.split(","))
                .map((number) -> Integer.valueOf(number)).collect(Collectors.toList()); // split the string using ',' as separator
        return calculateSum(numberList);
    }

    private int calculateSum(List<Integer> numbers) {
        int sum = 0;
        Iterator iterator = numbers.iterator();
        while(iterator.hasNext()) {
           Integer number = (Integer) iterator.next();
           if(number<0) {
               throw new IllegalArgumentException("negatives not allowed");
           }
           if(number > 1000) {
               continue;
           }
           sum += number;
        }
        return sum;
    }
}
