public class Calculator {
    public int add(String numbers){
        if(numbers.isEmpty()){
            return 0;
        }
        String[] numberList = numbers.split(","); // split the string using ',' as separator
        if(numberList.length < 2) { // why less than 2? just to support length == 1
            return Integer.valueOf(numberList[0]);
        }else {
            int sum = 0;
            for(int i =0 ; i < numberList.length; i++) {
                sum += Integer.valueOf(numberList[i]);
            }
            return sum;
        }
    }
}
