package com.abheekd;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ParserTest {
    @Test
    public void strip() {
        Parser parser = new Parser(
                "1 +++++ +++               Set Cell #0 to 8\n" +
                        "2 [\n" +
                        "3     >++++               Add 4 to Cell #1; this will always set Cell #1 to 4\n" +
                        "4     [                   as the cell will be cleared by the loop\n" +
                        "5         >++             Add 4*2 to Cell #2\n" +
                        "6         >+++            Add 4*3 to Cell #3\n" +
                        "7         >+++            Add 4*3 to Cell #4\n" +
                        "8         >+              Add 4 to Cell #5\n");
        assertTrue(parser.getSourceStripped().equals("++++++++[>++++[>++>+++>+++>+"));
    }

    @Test
    public void nextToken() {
        Parser parser = new Parser(
                "1 +++++ +++               Set Cell #0 to 8\n" +
                        "2 [\n" +
                        "3     >++++               Add 4 to Cell #1; this will always set Cell #1 to 4\n" +
                        "4     [                   as the cell will be cleared by the loop\n" +
                        "5         >++             Add 4*2 to Cell #2\n" +
                        "6         >+++            Add 4*3 to Cell #3\n" +
                        "7         >+++            Add 4*3 to Cell #4\n" +
                        "8         >+              Add 4 to Cell #5\n");
        assertTrue(parser.getNextToken() == Parser.Command.INC_CELL);
    }

    @Test
    public void EOF() {
        Parser parser = new Parser("");
        assertTrue(parser.getNextToken() == Parser.Command.EOF);
    }
}
