package com.AdiAyush.EZPZ.Lexer;

 /*
        These are token identifiers.
        The four token identifiers are either
            Operators,
            Keywords,
            Identifiers,
            Numbers
*/
public enum TokenType {

    // Operators
        EQUALS,
        PLUS,
        MINUS,
        DIVISOR,
        MULTIPLIER,
        MATRIX_MULT,

    //Keywords (add more as language progresses)
        INTEGER,
        STRING,
        BOOL,
        CHAR,
        DECIMAL,
        LONG,
        VOID,
        CONSTANT,
        STATIC,
        VECTOR,
        FUNCTION,
        RETURN,

    // Identifiers
        END_OF_INPUT,
        ERROR,
        SEMICOLON,
        NEW_LINE,
        VARIABLE,

    // Numbers
        ZERO,
        ONE,
        TWO, 
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT,
        NINE;
}
