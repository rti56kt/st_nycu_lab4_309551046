public class Game {
    private String p1RPS, p2RPS;

    public void validateInput(String RPS) throws IllegalArgumentException {
        if(!RPS.equals("rock") && !RPS.equals("paper") && !RPS.equals("scissors")) {
            throw new IllegalArgumentException("Bad Choice!");
        }
    }

    public void setP1RPS(String p1RPS) {
        validateInput(p1RPS);
        this.p1RPS = p1RPS;
    }
    public void setP2RPS(String p2RPS) {
        validateInput(p2RPS);
        this.p2RPS = p2RPS;
    }
    public String getP1RPS() {
        return p1RPS;
    }
    public String getP2RPS() {
        return p2RPS;
    }
    public String whoWin() {
        if(p1RPS.equals(p2RPS)) {
            return "Draw!";
        }
        else if((p1RPS.equals("rock") && p2RPS.equals("scissors")) || (p1RPS.equals("scissors") && p2RPS.equals("paper")) || (p1RPS.equals("paper") && p2RPS.equals("rock"))) {
            return "Player 1 win!";
        }
        else {
            return "Player 2 win!";
        }
    }
}
