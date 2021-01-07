package com.AdiAyush.EZPZ.Lexer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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
    int currentPosition;

    public Lexer(File input) {

        this.input = input;

        //filler function
        MoveState tempTransitionFunction = (state, character) -> {
            return new State(1);
        };

        FiniteStateMachine FSMTest = new FiniteStateMachine(new State(0, ""), new ArrayList<State>(),
                tempTransitionFunction);

    }

    /**
     * Begins the tokenization of the input file.
     * 
     * @return ArrayList<Token> - The list of tokens in the input file.
     * @throws FileNotFoundException Throws exception if the file is not found.
     */
    public ArrayList<Token> tokenize() throws FileNotFoundException {
        ArrayList<Token> tokens = new ArrayList<Token>();

        // String inputString = parseInput(this.input);

        // int inputSize = inputString.length();

        // Token token;

        // while(token.type != TokenType.END_OF_INPUT){
        //     token = readToken(inputString);
        //     tokens.add(token);
        // } 

        return tokens;
    }

    /**
     * Turns the input file into a string. Allows the input file to be tokenized
     * through the tokenize method.
     * 
     * @return String - The string that contains the input file.
     * @throws FileNotFoundException - Throws exception if the file is not found.
     */
    public String parseInput() throws FileNotFoundException {
        String inputString = "";

        Scanner readInput = new Scanner(input);
        
        while(readInput.hasNextLine()){
            inputString+=readInput.nextLine();
            inputString+="\n";
        }
        
        readInput.close();

        // System.out.println(inputString);

        return inputString;
    }
}