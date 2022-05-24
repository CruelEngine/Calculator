public class Calculator {
    public int add(String numbers){
        if(numbers.isEmpty()){
            return 0;
        }else {
            String[] numberList = numbers.split(","); // split the string using ',' as separator
            if(numberList.length == 1) {
                return Integer.valueOf(numberList[0]);
            }else {
                return Integer.valueOf(numberList[0]) + Integer.valueOf(numberList[1]);
            }
        }
    }
}
