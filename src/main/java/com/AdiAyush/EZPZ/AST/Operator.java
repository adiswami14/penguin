package com.AdiAyush.EZPZ.AST;

public class Operator {
    protected Expression left, right; // for now, only focus on numbers

    public Operator(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }
}
