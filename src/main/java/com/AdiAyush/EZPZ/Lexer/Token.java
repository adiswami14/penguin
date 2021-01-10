package com.AdiAyush.EZPZ.Lexer;


    /*
        A token is a lexeme with a certain identifier. We use this to identify what each lexeme 
        within the original EZPZ code does within the code and is the first step in getting 
        all the pieces of the puzzle to coordinate with eachother.
    */
    
public class Token{
    TokenType type;
    String value;
    int lineNumber;
    int col;
    
    public Token(TokenType type, String value, int lineNumber, int col){
        this.type = type;
        this.value = value;
        this.lineNumber = lineNumber;
        this.col = col;
    }
    public String toString(){
        return "{"+this.type+", "+this.value+"}";
    }
}