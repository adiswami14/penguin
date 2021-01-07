package com.AdiAyush.EZPZ;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;

import com.AdiAyush.EZPZ.Lexer.Lexer;

import org.junit.Test;

public class LexerTest {
    @Test
    public void BasicStateTest() throws FileNotFoundException {
        Lexer testLexer = new Lexer(new File("/Users/ayush/ezpz/src/test/java/com/AdiAyush/EZPZ/testCode/test.txt"));
        String testInput = testLexer.parseInput();
        assertEquals("x = 1 + 3;\ny = x + 5;\n", testInput);
    }
}
