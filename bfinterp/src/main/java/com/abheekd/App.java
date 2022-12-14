package com.abheekd;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) throws IOException {
        Interpreter interpreter = new Interpreter(Files.readString(Paths.get("input")));
        interpreter.run();
    }
}
