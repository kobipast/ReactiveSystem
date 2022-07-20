package main.java.com;

import java.util.ArrayList;


public class State {
    ArrayList<Cell> state;

    public State() {
        this.state = new ArrayList<>();
    }

    public ArrayList<Cell> getState() {
        return state;
    }

    public void displayState() {
        for (int i = 0; i < state.size(); i++) {
            if(i < state.size()-1){
                System.out.print("["+i+": "+state.get(i).getValueAsInt()+"],");
            }
            else{
                System.out.println("["+i+": "+state.get(i).getValueAsInt()+"]");
            }
        }
    }


    public void updateState(String input) {
        String[] inputArray = input.split(" ");
        if(inputArray.length == 3){
            int index = Integer.valueOf(inputArray[1]);
            String newValue =  inputArray[2];
            if(Util.isArithmetic(newValue)){
                System.out.println("Cell #"+index+" changed to "+newValue);
                state.get(index).setValue(newValue);
            }
        }
    }
}
