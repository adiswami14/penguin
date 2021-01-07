package com.AdiAyush.EZPZ.Lexer.FSM;

/*
    Small supporting class for the Finite State Machine class. 
*/
public class State{

    int stateNumber;
    String stateName;

    public State(int stateNumber, String stateName){
        this.stateNumber = stateNumber;
        this.stateName = stateName;
    }

    public State(String stateName){
        this.stateName = stateName;
    }

    public State(int stateNumber){
        this.stateNumber = stateNumber;
    }

    /*
        Checks if the two state numbers are equal.
    */
    public boolean equals(State state){
        return this.stateNumber == state.getStateNumber() || this.stateName.equals(state.getStateName());
    }
    public int getStateNumber(){
        return this.stateNumber;
    }
    public String getStateName(){
        return this.stateName;
    }
    public String toString(){
        return this.stateName;
    }
}