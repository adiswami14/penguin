package com.AdiAyush.EZPZ.Lexer.FSM;

import java.util.ArrayList;

public class FiniteStateMachine{
    /*
        We use Finite State Machines to help dictate whether or not
        certain tokens belong within the grammar of our language.
        Example:
            123456_*()124 does not belong in our language. We would throw an error.
            1234567891234 is a number within our language and fits the grammar of the language. We accept this.
    */
    State currentState;
    ArrayList<State> acceptingStates;
    MoveState transitionFunction;

    public FiniteStateMachine(State currentState, ArrayList<State> acceptingStates, MoveState moveState){
        this.currentState = currentState;
        this.acceptingStates = acceptingStates;
        this.transitionFunction = moveState;
    }

    /*
        Tests the current input (a token) and whether it fits within the grammar of the language.
    */

    public boolean testInput(String input){
        //Here, the current state is the "start State" of the code
        char[] chars = input.toCharArray(); //splitting into character array for faster processing of longer lines of code

        State tempState =  currentState;
        for(char ch : chars)
            tempState = transitionFunction.moveState(currentState, ch);

        for(State state : acceptingStates)
            if(tempState.equals(state))
                return true;
        return false;
        
    }
}
