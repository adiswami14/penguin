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
        LIST,
        FUNCTION,
        RETURN,

    // Identifiers
        END_OF_INPUT,

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
        NINE,
        TEN;
}
