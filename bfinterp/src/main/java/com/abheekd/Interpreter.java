package com.abheekd;

import java.util.HashMap;

public class Interpreter {
    // initialize an array of memory cells. what datatype would work best?

    // create a "pointer" (something that keeps track of the index of the current
    // cell)

    // store the parser as a property called "parser"

    // here are the two maps the map opening brackets to closing brackets and
    // closing
    // brackets to opening brackets
    private HashMap<Integer, Integer> openToClose = new HashMap<Integer, Integer>();
    private HashMap<Integer, Integer> closeToOpen = new HashMap<Integer, Integer>();

    // create the constructor here, taking the source as the input and defining
    // the parser property with the source
    public Interpreter(String source) {
        // code goes here:

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
        // write code here to loop through all parser tokens until EOF
        // calling the `handleCommand` function to determine what to do depending on
        // the token type

    }

    // this function takes the command and the current character index in case
    // you would like to use it
    private void handleCommand(Parser.Command command, int idx) {
        switch (command) {
            case POINTER_RIGHT:
                // code goes here
                break;
            case POINTER_LEFT:
                // code goes here
                break;
            case INC_CELL:
                // code goes here
                break;
            case DEC_CELL:
                // code goes here
                break;
            case INPUT:
                // code goes here
                break;
            case OUTPUT:
                // code goes here
                break;
            case OPEN_BRACKET:
                // code goes here
                break;
            case CLOSE_BRACKET:
                // code goes here
                break;
            case EOF: // never happens
        }
    }
}
