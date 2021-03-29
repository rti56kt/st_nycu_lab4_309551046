import java.util.Scanner;

public class Main {
    private static Game g = new Game();

    public static void welcomeMessage() {
        System.out.println("=== Welcome to Rock-Paper-Scissors game ===");
    }

    private static void getPlayerOneInput() {
        System.out.println("Enter Player 1 choice (rock, paper or scissors):");
        Scanner sc = new Scanner(System.in);
        String p1Choice = sc.nextLine();
        g.setP1RPS(p1Choice);
    }

    private static void getPlayerTwoInput() {
        System.out.println("Enter Player 2 choice (rock, paper or scissors):");
        Scanner sc = new Scanner(System.in);
        String p2Choice = sc.nextLine();
        g.setP2RPS(p2Choice);
    }

    public static void main(String[] args) {
        welcomeMessage();
        getPlayerOneInput();
        getPlayerTwoInput();
        System.out.println(g.whoWin());
    }
}
