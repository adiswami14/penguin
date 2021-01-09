package com.AdiAyush.EZPZ;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;

import com.AdiAyush.EZPZ.Lexer.Lexer;
import com.AdiAyush.EZPZ.Lexer.LexerUtilities;
import com.AdiAyush.EZPZ.Lexer.FSM.FiniteStateMachine;

import org.junit.Test;

public class LexerTest{
    @Test
    public void BasicStateTest() throws FileNotFoundException {
        Lexer testLexer = new Lexer(new File("/Users/ayush/ezpz/src/test/java/com/AdiAyush/EZPZ/testCode/test.txt"));
        String testInput = testLexer.parseInput();
        assertEquals("x = 1 + 3;\ny = x + 5;\n", testInput);
    }
    
    @Test
    public void NumberFSMTest(){
        FiniteStateMachine numberFSM = Lexer.buildNumberFSM();
        assertEquals(true, numberFSM.testInput("1234"));
        assertEquals(true, numberFSM.testInput("12.34"));
        assertEquals(false, numberFSM.testInput("12..34"));
        assertEquals(false, numberFSM.testInput("12.a34"));
    }

    @Test
    public void ReadTokenTest() throws FileNotFoundException {
        Lexer testLexer = new Lexer(new File("/Users/ayush/ezpz/src/test/java/com/AdiAyush/EZPZ/testCode/test.txt"));
        testLexer.readToken();

    }

    @Test
    public void LexerUtilitiesTest(){
        assertEquals(true, LexerUtilities.isLetter('Z'));
        assertEquals(false, LexerUtilities.isLetter('1'));
    }
}
