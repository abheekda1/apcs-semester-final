package com.abheekd;

public class Parser {
    // an enum is just a way to have a defined set of possible values
    public enum Command {
        POINTER_RIGHT,
        POINTER_LEFT,
        INC_CELL,
        DEC_CELL,
        OUTPUT,
        INPUT,
        OPEN_BRACKET,
        CLOSE_BRACKET,
        EOF
    }

    private String source;
    private String sourceStripped;
    private int tokenPointer = 0;

    public Parser(String source) {
        // set the source

        // use the stripSource function to set the sourceStripped property
    }

    // function to strip away all unecessary characters for source
    private void stripSource() {
        for (char c : source.toCharArray()) {
            if (new String("><+-.,[]").indexOf(c) != -1)
                sourceStripped += c;
        }
    }

    public String getSourceStripped() {
        return sourceStripped;
    }

    public int getIndex() {
        return tokenPointer;
    }

    public void setIndex(int index) {
        this.tokenPointer = index;
    }

    public Command getNextToken() {
        // return EOF if it's past the last token:

        // create a ret var of type Command:

        switch (sourceStripped.charAt(tokenPointer)) {
            case '>':
                ret = Command.POINTER_RIGHT;
                break;
            case '<':
                ret = Command.POINTER_LEFT;
                break;
            case '+':
                ret = Command.INC_CELL;
                break;
            case '-':
                ret = Command.DEC_CELL;
                break;
            case '.':
                ret = Command.OUTPUT;
                break;
            case ',':
                ret = Command.INPUT;
                break;
            case '[':
                ret = Command.OPEN_BRACKET;
                break;
            case ']':
                ret = Command.CLOSE_BRACKET;
                break;
        }

        // increment the tokenPointer to move to the next token when the function is
        // called again

        return ret;
    }
}
