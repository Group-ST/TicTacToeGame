package test;

import static org.junit.Assert.*;
import org.junit.Test;
import tictactoegame.TicTacToeGame;

public class TicTacToeGameTest {
    @Test
    public void testCheckWin() {
        TicTacToeGame game = new TicTacToeGame();
        assertEquals(game.checkWin(), 0
        );

        // Test horizontal win
        game.makeMove(0, 0); // X
        game.makeMove(1, 1); // O
        game.makeMove(0, 1); // X
        game.makeMove(1, 2); // O
        game.makeMove(0, 2); // X
        assertEquals('X', game.checkWin());

        // Test diagonal win
        game.reset();
        game.makeMove(0, 0); // X
        game.makeMove(1, 1); // O
        game.makeMove(1, 0); // X
        game.makeMove(1, 2); // O
        game.makeMove(2, 2); // X
        assertEquals('X', game.checkWin());
    }

    @Test
    public void testDraw() {
        TicTacToeGame game = new TicTacToeGame();
        assertFalse(game.draw());

        // Fill the board without a win
        game.makeMove(0, 0); // X
        game.makeMove(0, 1); // O
        game.makeMove(0, 2); // X
        game.makeMove(1, 0); // O
        game.makeMove(1, 2); // X
        game.makeMove(1, 1); // O
        game.makeMove(2, 0); // X
        game.makeMove(2, 2); // O
        game.makeMove(2, 1); // X
        assertTrue(game.draw());
    }

    @Test
    public void testReset() {
        TicTacToeGame game = new TicTacToeGame();
        game.makeMove(0, 0); // X
        game.makeMove(1, 1); // O
        game.reset();
        assertFalse(game.draw());
    }
}
