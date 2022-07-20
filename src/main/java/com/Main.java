package main.java.com;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    static ReactiveSystem system = new ReactiveSystem();
    public static void main(String[] args) throws IOException {
        List<String> fileLines = Files.readAllLines(Paths.get(args[0]));
        String baseState = fileLines.get(0);
        if(!baseState.isEmpty()){
            system.setBaseState(baseState);
            system.run();
        }

    }
}
