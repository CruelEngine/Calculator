public class Calculator {
    public int add(String numbers){
        if(numbers.isEmpty()){
            return 0;
        }
        String[] numberList = numbers.split(","); // split the string using ',' as separator
        int sum = 0;
        for(int i =0 ; i < numberList.length; i++) {
            sum += Integer.valueOf(numberList[i]);
        }
        return sum;
    }
}
