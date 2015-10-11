/**
 * Created by admin on 9/10/15.
 */

package com.bowlingGame;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BowlingGameTest {
    /*
    JUnit 4 cheatsheet:
    @Before
    @After
    @Ignore (before @Test)
    @Test (expected = Exception.class)
    @Test(timeout = 1000) after 1000 it fails
    assertEquals(expected, actual);
    */

    private Game game;

    @Before
    public void setUp() {
        game = new Game();
    }

    private void rollMany(int n, int pins) {
        for (int i=0; i<n; i++)
            game.roll(pins);
    }

    @Test
    public void gutterGame() {
        rollMany(20, 0);
        assertEquals(0, game.score());
    }

    @Test
    public void allOnes() {
        rollMany(20, 1);
        assertEquals(20, game.score());
    }

    @Test
    public void oneSpare() {
        game.roll(5);
        game.roll(5); // spare
        game.roll(3);

        rollMany(17, 0);

        assertEquals(16, game.score());
    }
}