package main.java.com;

import java.util.Scanner;

public class ReactiveSystem {
    private String baseStateString;
    private State baseState;

    void run(){
        init(baseStateString);
        Scanner scanner = new Scanner(System.in);
        String input;

        displayMenu();
        input = scanner.nextLine();
        while(input.startsWith("a")  || input.startsWith("b")){
            if(input.startsWith("a"))
            {
                displayCurrentState(baseState);
            }
            else if (input.startsWith("b"))
            {
                updateState(baseState,input);
            }

            System.out.print("# ");
            input = scanner.nextLine();
        }
    }


    public void init(String baseStateString) {
        baseState = new State();
        String[] baseStateArray = baseStateString.split(",");

        for (int i = 0; i < baseStateArray.length; i++) {
            Cell cell = new Cell(baseStateArray[i],baseState);
            baseState.getState().add(cell);
        }
    }

    private void displayCurrentState(State currentState) {
        currentState.displayState();
    }

    private void updateState(State currentState, String input) {
        currentState.updateState(input);
    }

    private void displayMenu() {
        System.out.println(baseStateString+"\n--------\n");
        System.out.println("Menu:\n a.Print current state\n b.Change a value");
        System.out.print("# ");
    }

    public void setBaseState(String baseState) {
        this.baseStateString = baseState;
    }

    public State getBaseState() {
        return this.baseState;
    }

}
