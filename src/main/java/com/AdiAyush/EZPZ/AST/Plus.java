package com.AdiAyush.EZPZ.AST;

import com.AdiAyush.EZPZ.Lexer.TokenType;

public class Plus extends Operator {
    public Plus(Expression left, Expression right) {
        super(left, right);
    }
}
