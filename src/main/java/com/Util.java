package main.java.com;

public class Util {
    public static boolean isAnOperator(char c) {
        switch (c) {
            case '*':
            case '/':
            case '+':
            case '-':
            case '=':
            case '{':
            case '}':
                return true;
            default:
                return false;
        }
    }
    
    public static boolean isArithmetic(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!isAnOperator(input.charAt(i)) && !Character.isDigit(input.charAt(i))){
                return false;
            }
        }
        return true;
    }

    public static boolean validateCircular(State state, String cellValue, int index) {
        if(!cellValue.contains("=")){
            return true;
        }
        for (int i = 0; i < cellValue.length(); i++) {
            if(cellValue.charAt(i)== '{'){
                int calculateIndex = Character.getNumericValue(cellValue.charAt(++i));
                if(calculateIndex == index){
                    System.out.println("Circular dependencies detect, Cell was not updated");
                    return false;
                }
                return validateCircular(state , state.getState().get(calculateIndex).getValue(), index);
            }
        }
        return true;
    }

}
