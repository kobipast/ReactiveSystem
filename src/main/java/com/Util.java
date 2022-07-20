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
}
