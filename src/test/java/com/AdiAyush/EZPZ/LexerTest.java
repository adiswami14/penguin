package com.AdiAyush.EZPZ;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import java.io.File;
import java.io.FileNotFoundException;

import com.AdiAyush.EZPZ.Lexer.Lexer;
import com.AdiAyush.EZPZ.Lexer.Token;
import com.AdiAyush.EZPZ.Lexer.Util.LexerUtilities;
import com.AdiAyush.EZPZ.Lexer.Util.Pair;
import com.AdiAyush.EZPZ.Lexer.FSM.FiniteStateMachine;
import com.AdiAyush.EZPZ.Lexer.FSM.State;

import org.junit.Test;

public class LexerTest{
    @Test
    public void BasicStateTest() throws FileNotFoundException {
        Lexer testLexer = new Lexer(new File("src/test/java/com/AdiAyush/EZPZ/testCode/test.txt"));
        String testInput = testLexer.parseInput();
        assertEquals("x = 1 + 3;\ny = x + 5;\n", testInput);
    }

    @Test
    public void ReadTokenTest() throws FileNotFoundException {
        Lexer testLexer = new Lexer(new File("src/test/java/com/AdiAyush/EZPZ/testCode/test.txt"));
        testLexer.readToken();
        boolean equalZero = testLexer.currentPosition == 0;
        assertEquals(true, equalZero);

    }

    @Test
    public void NumberFSMTest(){
        FiniteStateMachine numberFSM = Lexer.buildNumberFSM();
        Pair<State, String> pair = numberFSM.testInput("123456asdf.1234");
        System.out.println(pair.a+"  "+pair.b);
    }

    @Test
    public void LexerUtilitiesTest(){
        assertEquals(true, LexerUtilities.isLetter('Z'));
        assertEquals(false, LexerUtilities.isLetter('1'));
    }

    @Test
    public void LexerTokenTest() throws FileNotFoundException {
        Lexer testLexer = new Lexer(new File("src/test/java/com/AdiAyush/EZPZ/testCode/test.txt"));
        System.out.println("hello");
        ArrayList<Token> list = testLexer.tokenize();
        System.out.println(list);
    }
}
