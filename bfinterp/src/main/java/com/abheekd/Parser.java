package com.abheekd;

import java.util.ArrayList;

public class Parser {
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
        this.source = source;
        this.sourceStripped = "";
        stripSource();
    }

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
        if (tokenPointer >= sourceStripped.length()) return Command.EOF;
        Command ret = Command.EOF;
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
        tokenPointer++;
        return ret;
    }
}
