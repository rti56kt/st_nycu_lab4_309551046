import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    String p1WinMsg = "Player 1 win!";
    String p2WinMsg = "Player 2 win!";
    String drawMsg = "Draw!";
    String invalidMsg = "Bad Choice!";

    static Stream<Arguments> allP1WinCases() {
        return  Stream.of(
                Arguments.of("rock", "scissors"),
                Arguments.of("paper", "rock"),
                Arguments.of("scissors", "paper")
        );
    }
    static Stream<Arguments> allP1LoseCases() {
        return  Stream.of(
                Arguments.of("rock", "paper"),
                Arguments.of("paper", "scissors"),
                Arguments.of("scissors", "rock")
        );
    }
    static Stream<Arguments> allDrawCases() {
        return  Stream.of(
                Arguments.of("rock", "rock"),
                Arguments.of("paper", "paper"),
                Arguments.of("scissors", "scissors")
        );
    }
    static Stream<Arguments> allValidInput() {
        return  Stream.of(
                Arguments.of("rock"),
                Arguments.of("paper"),
                Arguments.of("scissors")
        );
    }
    static Stream<Arguments> allInvalidInput() {
        return  Stream.of(
                Arguments.of("A"),
                Arguments.of("Peko"),
                Arguments.of("Ahoy")
        );
    }

    @ParameterizedTest
    @MethodSource("allP1WinCases")
    public void allP1WinCasesTest(String p1RPS, String p2RPS) {
        Game g = new Game();

        g.setP1RPS(p1RPS);
        g.setP2RPS(p2RPS);
        assertEquals(p1WinMsg, g.whoWin());
    }
    @ParameterizedTest
    @MethodSource("allP1LoseCases")
    public void allP1LoseCasesTest(String p1RPS, String p2RPS) {
        Game g = new Game();

        g.setP1RPS(p1RPS);
        g.setP2RPS(p2RPS);
        assertEquals(p2WinMsg, g.whoWin());
    }
    @ParameterizedTest
    @MethodSource("allDrawCases")
    public void allDrawCasesTest(String p1RPS, String p2RPS) {
        Game g = new Game();

        g.setP1RPS(p1RPS);
        g.setP2RPS(p2RPS);
        assertEquals(drawMsg, g.whoWin());
    }
    @ParameterizedTest
    @MethodSource("allValidInput")
    public void allP1ValidInputTest(String RPS) {
        Game g = new Game();

        assertDoesNotThrow(() -> g.setP1RPS(RPS));
    }
    @ParameterizedTest
    @MethodSource("allValidInput")
    public void allP2ValidInputTest(String RPS) {
        Game g = new Game();

        assertDoesNotThrow(() -> g.setP2RPS(RPS));
    }
    @ParameterizedTest
    @MethodSource("allInvalidInput")
    public void allP1InvalidInputTest(String RPS) {
        Game g = new Game();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> g.setP2RPS(RPS));
        assertEquals(invalidMsg, exception.getMessage());
    }
    @ParameterizedTest
    @MethodSource("allInvalidInput")
    public void allP2InvalidInputTest(String RPS) {
        Game g = new Game();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> g.setP2RPS(RPS));
        assertEquals(invalidMsg, exception.getMessage());
    }
}