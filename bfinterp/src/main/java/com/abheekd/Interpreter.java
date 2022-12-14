package com.abheekd;

import java.util.HashMap;

public class Interpreter {
    // initialize an array of memory cells. what datatype would work best?
    private int[] cells = new int[30000];

    // create a "pointer" (something that keeps track of the index of the current
    // cell)
    private int pointer = 0;

    // store the parser as a property
    private Parser parser;

    // create the two maps the map opening brackets to closing brackets and closing
    // brackets to opening brackets
    private HashMap<Integer, Integer> openToClose = new HashMap<Integer, Integer>();
    private HashMap<Integer, Integer> closeToOpen = new HashMap<Integer, Integer>();

    // create the constructor here, taking the source as the input and defining a
    // new parser:
    public Interpreter(String source) {
        // code goes here:
        this.parser = new Parser(source);

        // this just fills the maps you will later use to move between brackets
        fillBracketMaps();
    }

    // DO NOT TOUCH
    private void fillBracketMaps() {
        for (int i = 0; i < parser.getSourceStripped().length(); i++) {
            if (parser.getSourceStripped().charAt(i) == '[') {
                char closeBracket = '[';
                int depth = 0;
                int j = i;
                while (closeBracket != ']' || depth >= 0) {
                    j++;
                    String strippedSource = parser.getSourceStripped();
                    closeBracket = strippedSource.charAt(j);
                    if (closeBracket == '[')
                        depth++;
                    else if (closeBracket == ']')
                        depth--;
                }
                openToClose.put(i, j);
                closeToOpen.put(j, i);
            }
        }
    }

    // main loop function
    public void run() {
        Parser.Command command = parser.getNextToken();
        do {
            int currentTokenIdx = parser.getIndex() - 1;
            handleCommand(command, currentTokenIdx);
            command = parser.getNextToken();
        } while (command != Parser.Command.EOF);
    }

    private void handleCommand(Parser.Command command, int idx) {
        switch (command) {
            case POINTER_RIGHT:
                pointer++;
                break;
            case POINTER_LEFT:
                pointer--;
                break;
            case INC_CELL:
                cells[pointer]++;
                break;
            case DEC_CELL:
                cells[pointer]--;
                break;
            case INPUT:
                try {
                    cells[pointer] = (char) System.in.read();
                } catch (Exception e) {
                    System.out.println(e);
                }
                break;
            case OUTPUT:
                System.out.print((char) cells[pointer]);
                break;
            case OPEN_BRACKET:
                if (cells[pointer] == 0)
                    parser.setIndex(openToClose.get(idx) - 1);
                break;
            case CLOSE_BRACKET:
                if (cells[pointer] != 0) {
                    int newIdx = closeToOpen.get(idx);
                    parser.setIndex(newIdx);
                }
                break;
            case EOF: // never happens
        }
    }
}
