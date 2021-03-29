import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void p1InvalidInput() {
        Game g = new Game();

        Exception exception1 = assertThrows(IllegalArgumentException.class, () -> g.setP1RPS("peko"));
        String expectedMsg = "Bad Choice!";
        String actualMsg = exception1.getMessage();
        assertEquals(expectedMsg, actualMsg);
    }

    @Test
    void p2InvalidInput() {
        Game g = new Game();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> g.setP2RPS("peko"));
        String expectedMsg = "Bad Choice!";
        String actualMsg = exception.getMessage();
        assertEquals(expectedMsg, actualMsg);
    }

    @Test
    void setP1RPS() {
        Game g = new Game();
        g.setP1RPS("paper");
        assertEquals("paper", g.getP1RPS());
    }

    @Test
    void setP2RPS() {
        Game g = new Game();
        g.setP2RPS("scissors");
        assertEquals("scissors", g.getP2RPS());
    }

    @Test
    void getP1RPS() {
        Game g = new Game();
        g.setP1RPS("rock");
        assertEquals("rock", g.getP1RPS());
    }

    @Test
    void getP2RPS() {
        Game g = new Game();
        g.setP2RPS("paper");
        assertEquals("paper", g.getP2RPS());
    }

    @Test
    void p1LoseByRock() {
        Game g = new Game();

        String expectedMsg = "Player 2 win!";
        g.setP1RPS("rock");
        g.setP2RPS("paper");
        assertEquals(expectedMsg, g.whoWin());
    }

    @Test
    void p1LoseByPaper() {
        Game g = new Game();

        String expectedMsg = "Player 2 win!";
        g.setP1RPS("paper");
        g.setP2RPS("scissors");
        assertEquals(expectedMsg, g.whoWin());
    }

    @Test
    void p1LoseByScissors() {
        Game g = new Game();

        String expectedMsg = "Player 2 win!";
        g.setP1RPS("scissors");
        g.setP2RPS("rock");
        assertEquals(expectedMsg, g.whoWin());
    }

    @Test
    void p1WinByRock() {
        Game g = new Game();

        String expectedMsg = "Player 1 win!";
        g.setP1RPS("rock");
        g.setP2RPS("scissors");
        assertEquals(expectedMsg, g.whoWin());
    }

    @Test
    void p1WinByPaper() {
        Game g = new Game();

        String expectedMsg = "Player 1 win!";
        g.setP1RPS("paper");
        g.setP2RPS("rock");
        assertEquals(expectedMsg, g.whoWin());
    }

    @Test
    void p1WinByScissors() {
        Game g = new Game();

        String expectedMsg = "Player 1 win!";
        g.setP1RPS("scissors");
        g.setP2RPS("paper");
        assertEquals(expectedMsg, g.whoWin());
    }

    @Test
    void DrawByRock() {
        Game g = new Game();

        String expectedMsg = "Draw!";
        g.setP1RPS("rock");
        g.setP2RPS("rock");
        assertEquals(expectedMsg, g.whoWin());
    }

    @Test
    void DrawByPaper() {
        Game g = new Game();

        String expectedMsg = "Draw!";
        g.setP1RPS("paper");
        g.setP2RPS("paper");
        assertEquals(expectedMsg, g.whoWin());
    }

    @Test
    void DrawByScissors() {
        Game g = new Game();

        String expectedMsg = "Draw!";
        g.setP1RPS("scissors");
        g.setP2RPS("scissors");
        assertEquals(expectedMsg, g.whoWin());
    }
}