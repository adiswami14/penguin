package com.AdiAyush.EZPZ.Lexer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.AdiAyush.EZPZ.Lexer.FSM.*;

/**
 * Main Lexer wrapper class, all other classes in Lexer folder will feed into
 * this
 */
public class Lexer {

    /**
     * The lexer of the language (also known as the tokenizer) is a program that
     * breaks down the input code into tokens, which are lexemes with different
     * identifiers.
     * 
     * @param input The file consisting of the code to be compiled
     */

    File input;
    String inputString;
    int currentPosition = 0;
    int currentRow  = 0; //Whenever there is a \n, we must add to this
    int currentCol = currentPosition;
    int inputLength;

    public Lexer(File input) throws FileNotFoundException {
        this.input = input;
        inputString = parseInput();
    }

    /**
     * Turns the input file into a string. Allows the input file to be tokenized
     * through the tokenize method.
     * 
     * @return String - The string that contains the input file.
     * @throws FileNotFoundException - Throws exception if the file is not found.
     */
    public String parseInput() throws FileNotFoundException {
        inputString = "";

        Scanner readInput = new Scanner(input);
        
        while(readInput.hasNextLine()){
            inputString+=readInput.nextLine();
            inputString+="\n";
        }
        
        readInput.close();
        
        inputLength = inputString.length();

        return inputString;

    }

    /**
     * Begins the tokenization of the input file.
     * 
     * @return ArrayList<Token> - The list of tokens in the input file.
     * @throws FileNotFoundException Throws exception if the file is not found.
     */
    public ArrayList<Token> tokenize() throws FileNotFoundException {
        ArrayList<Token> tokens = new ArrayList<Token>();

        Token token;

        do{
            token = readToken();
            tokens.add(token);
        }while(token.type != TokenType.END_OF_INPUT); 

        return tokens;
    }

    /**
     * Creates tokens based on the current position of the input. Uses the character at the input to determine what type of token to create.
     * @param inputString - The input but in string form.
     * @return Token - Returns a token based on the character at the input point.
     */
    public Token readToken(){
        if(currentPosition > inputLength) return new Token(TokenType.END_OF_INPUT, "", currentRow, currentCol);
        skipSpace(inputString);
        System.out.println(currentPosition);
        return null;
    }   

    /**
     * Builds a finite state machine that recognizes both integers and floats.
     * @return FiniteStateMachine - A machine that recognizes both integers and floats.
     */
    public static FiniteStateMachine buildNumberFSM(){

        State currentState = new State("Integer");
        List<State> acceptingStates = Arrays.asList(new State("Float"), new State("Integer"));
        List<State> allStates = Arrays.asList(new State("Float"), new State("Integer"), new State("Invalid"));
        MoveState transitionFunction = (state, states, character) -> {
            switch(state.getStateName()){
                case "Integer":
                    if(character == 46) // If there is a decimal
                        return states.get(0);
                    else if(character <= 57 && character >= 48) // If the character is 0-9
                        return states.get(1);
                    else //If the character is not a decimal nor 0-9
                        return states.get(2);
                case "Float":
                    if(character == 46) // If there is a decimal
                        return states.get(2);
                    else if(character <= 57 && character >= 48) // If the character is 0-9
                        return states.get(1);
                    else //If the character is not a decimal nor 0-9
                        return states.get(2);
            }
            return states.get(2);
        };
        return new FiniteStateMachine(currentState, acceptingStates, allStates, transitionFunction);
    }

    /**
     * Skips all of the white spaces in the input. This makes it so there are no unnecessary white spaces in the token.
     * @param inputString - The input, but string version.
     */
    public void skipSpace(String inputString){
        while(currentPosition < inputLength && inputString.charAt(currentPosition) == ' '){
            currentPosition++;
            currentCol++;
        }
    }
}