package com.AdiAyush.EZPZ.Lexer;

public class LexerUtilities {
    public static boolean isOperator(Character ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '=' || ch == '>' || ch == '<' || ch == '!' || ch == '&' || ch == '|' || ch == '%' || ch == '~' || ch == '$' || ch == '~' || ch == '^';
    }
    public static boolean isNumber(Character ch) {
        return ch <= 57 && ch >= 48;
    }
    public static boolean isLetter(Character ch) {
        return (ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122);
    }
}
