package main.java.com;

public class Cell {
    private String value;
    private State baseState;

    public Cell(String value, State baseState) {
        this.value = value;
        this.baseState = baseState;
    }

    public int getValueAsInt() {
        int result = 0;
        int prevValue = 0;
        int currentValue;
        if(!value.contains("=")){
            return Integer.parseInt(value);
        }
        for (int i = 0; i < value.length(); i++) {
            if(value.charAt(i) == '}' || value.charAt(i) == '=')
                continue;
            if(Character.isDigit(value.charAt(i))){
                prevValue = Character.getNumericValue(value.charAt(i));
            }
            else{
                if(value.charAt(i)== '{'){
                    prevValue = baseState.getState().get(Character.getNumericValue(value.charAt(++i))).getValueAsInt();
                }
                else{
                    char operator = value.charAt(i);
                    if(i < value.length() - 1 && value.charAt(i+1)=='{'){
                        currentValue = baseState.getState().get(Character.getNumericValue(value.charAt(i+2))).getValueAsInt();
                        i = i+2;
                    }
                    else{
                        currentValue=Character.getNumericValue(value.charAt(++i));
                    }
                    if(operator == '+'){
                        result = prevValue + currentValue;
                    }
                    else if(operator == '-'){
                        result = prevValue - currentValue;
                    }
                    else if(operator == '*'){
                        result = prevValue * currentValue;
                    }
                    else if(operator == '/'){
                        result = prevValue / currentValue;
                    }
                    prevValue = result;
                }
            }
        }
        return result;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
}
