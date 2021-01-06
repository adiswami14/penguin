package com.AdiAyush.EZPZ;

import static org.junit.Assert.assertEquals;

import com.AdiAyush.EZPZ.Lexer.FSM.State;

import org.junit.Test;

public class StateTest {
    @Test 
    public void BasicStateTest() {
        State state = new State(3, "State");
        assertEquals(3, state.getStateNumber());
        assertEquals("State", state.getStateName());
    }
}
