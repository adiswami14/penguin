package com.AdiAyush.EZPZ.AST;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import com.AdiAyush.EZPZ.Lexer.Lexer;
import com.AdiAyush.EZPZ.Lexer.Token;
import com.AdiAyush.EZPZ.Lexer.TokenType;

public class Parser {
    private Lexer lexer;
    private ArrayList<Token> tokenList;
    private Token currToken;
    private int tokenCounter = 0;

    public Parser(Lexer lexer) throws FileNotFoundException {
        // initializing private variables for this class

        this.lexer = lexer;
        tokenList = lexer.tokenize();
        currToken = (tokenList.isEmpty()) ? null : tokenList.get(0); // if tokenList is empty, then set currToken to null, will serve as a check in other methods
    }

    public void ThrowSyntaxError() {
        System.err.println("The syntax passed in is invalid");
    }

    private void consume(TokenType desiredType) {
        if(currToken == null) return;

        if(currToken.getType() == desiredType) {
            tokenCounter++;
            if(tokenCounter < tokenList.size()) currToken = tokenList.get(tokenCounter);
        } else ThrowSyntaxError();
    }    

    private void groupExpression() {

    }

    private void evaluateExpression() {
        groupExpression(); //this code is bound to change
    }

    public void parse() {
        evaluateExpression();
    }
}
