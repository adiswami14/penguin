package com.AdiAyush.EZPZ.Lexer.FSM;

import java.util.List;

/*
    An interface used to help create transition functions for the Finite State Machine.
*/
public interface MoveState{
    State moveState(State currentState, List<State> states, Character startCharacter);
}