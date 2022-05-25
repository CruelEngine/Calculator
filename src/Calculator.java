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
        numbers = replaceExpression(squareBracketRegexp,"",numbers);
        String delimiterPattern = "\\/\\/(.*?)\\n"; // regexp tested using regexp101. NOTE: In java we need to double escape
        Pattern pattern = Pattern.compile(delimiterPattern);
        Matcher patternMatcher = pattern.matcher(numbers);
        String delimiter=  "\n";
        if(patternMatcher.find()) {
            String delimiterBoundary = patternMatcher.group(0);
            delimiter = patternMatcher.group(1);
            numbers = numbers.replace(delimiterBoundary, "");
        }
        numbers = numbers.replace(delimiter, ",");
        /**
         * Matches all the characters in the delimiter (delimiter enclosed inside [] )
         * and + matches the characters unlimited times
         */
        String delimiterRegexp = "[" + delimiter + "]+"; // tested once again using regexp101
        numbers =replaceExpression(delimiterRegexp, ",", numbers);
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

    private String replaceExpression(String regexp , String replacement, String numbers) {
        return numbers.replaceAll(regexp,replacement);
    }
}
