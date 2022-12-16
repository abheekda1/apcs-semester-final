package com.abheekd;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

// you can run this to test the interpreter
// once you're done
public class InterpreterTest {
    @Test
    public void helloWorld() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Interpreter interpreter = new Interpreter(
                ">++++++++[<+++++++++>-]<.>++++[<+++++++>-]<+.+++++++..+++.>>++++++[<+++++++>-]<++.------------.>++++++[<+++++++++>-]<+.<.+++.------.--------.>>>++++[<++++++++>-]<+.");

        interpreter.run();
        assertTrue(out.toString().equals("Hello, World!"));
    }
}
