# Brainf*ck interpreter
## Introduction
### What is brainf*ck?  
Brainf*ck is an **esoteric language**. According to [esolangs.org](https://esolangs.org/wiki/Esoteric_programming_language), an esoteric language is:
> An esoteric programming language (ess-oh-terr-ick), or esolang, is a computer programming language designed to experiment with weird ideas, to be hard to program in, or as a joke, rather than for practical use.  

Brainf*ck is one of the most popular of such languages, along with [Befunge](https://en.wikipedia.org/wiki/Befunge).  
### How does it work?
The interpreter operates on an array of 30,000 memory cells all set to 0, and a pointer that keeps track of the current cell. brainf*ck is made up of 8 different characters, or "commands", which are used to manipulate the cells, the data in these cells, and perform input/output:
| Command       | Usage         |
| ------------- | ------------- |
| `>`  | Increment the pointer  |
| `<`  | Decrement the pointer  |
| `+`  | Increment the current cell  |
| `-`  | Decrement the current cell  |
| `.`  | Output character at the current cell  |
| `,`  | Get single character input to current cell  |
| `[` | Jump past the matching `]` if the current cell is 0 |
| `]` | Jump back to the matching `[` if the current cell is not 0 |

### Necessary concepts
Before you begin writing the interpreter, it's important to know some concepts.
1. It's important to understand the way numbers and characters work. In memory, basic integer and character types are just stored as a set of 0s and 1s, called bits. The `char` type in Java is 8 bits (a byte) that represent a number in binary, which corresponds to a character like `a` or `-` or even `%`. Since there are 8 bits, there are 2<sup>8</sup> = 256 possible characters, meaning `char` is just a subset of `int` which is 32 bits, or 4 bytes. `UTF-8` is a form of interpreting numbers as characters, meaning that we can also interpret integers as characters. For this reason we can store the memory cells as an array of integers and cast them for interpretation.  

2. Additionally, maps and hashmaps are important concept for utilizing brainf*ck brackets. A map simply stores data in key-value pairs, and can be used similar to an Array or ArrayList, except instead of indexes incrementing you can set the index. In this way, we can create two maps -- one that maps closing brackets to opening brackets as well as the reverse. Here's an example if an opening and closing bracket pair had indexes 10 and 12 respectively.
    ```java
    HashMap<Integer, Integer> openToClose = new HasMap<Integer, Integer>();
    HashMap<Integer, Integer> closeToOpen = new HasMap<Integer, Integer>();
    openToClose.put(10, 12);
    closeToOpen.put(12, 10);

    // get open bracket when at index 12
    closeToOpen.get(12); // returns 10

    // get close bracket when at index 10
    closeToOpen.get(10); // returns 12
    ```

## Writing the interpreter
### Step 1 (parsing):
Begin by filling in the indicated code for `Parser.java`, with the constructor and the `getNextToken` function.  
**How the parser works**: the parser utilizes an [enum](https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html), which is basically just a strict list of values a type can have and allows us to easily keep track of what type of command we are parsing. We utilize a pointer for the token to keep track of which character we're on, incrementing unless we need to jump around for loops. We can use the function to get the next token in the interpreter later.

### Step 2 (interpreting):
The interpreter is where the magic really happens. It's the part that actually understands what the parser is reading and correspondingly executes what needs to be executed. Define the properties listed, such as the memory cells and the parser that will be utilized to go through the source brainf*ck. Make sure to initialize the parser that will be stored as a property in the constructor. Then, fill in the `run` function, which loops through each token until `EOF` (end-of-file) and calls `handleToken` on it, which checks what kind of command it is and runs a different segment of code. Finally, fill in all of these segments of code, utilizing getters and setters for the parser if you need to change the index.

Tests have been included to test incremental and final progress:  
![Testing Demo](https://user-images.githubusercontent.com/67982792/208330243-a8d0f84c-efb4-492c-a918-cea51f13997b.gif)

