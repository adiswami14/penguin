package com.AdiAyush.EZPZ.Lexer.FSM;

/*
    An interface used to help create transition functions for the Finite State Machine.
*/
public interface MoveState{
    State moveState(State currentState, Character startCharacter);
}