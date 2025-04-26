package test;

import org.junit.jupiter.api.Test;
import main.Board;
import main.Player;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Scanner;

public class PlayerTesting {
    Scanner input = new Scanner(System.in);
    Board board = new Board(26);
    Player test = new Player("Ryan");

    // Testing Taking the First Turn
    @Test
    void takeFirstTurn() {
        System.out.println("// Start of Board Test: ");
        System.out.println("----------------------");
        // test.takeTurn(); // Commented out as in both versions
        System.out.println();
    }

    // Testing Taking a turn when about to complete a lap of the board
    @Test
    void takeTurnEndBoard() {
        System.out.println("// End of Board Test: ");
        System.out.println("----------------------");

        // test.setPositionToEnd(); // Commented out as in both versions
        System.out.println("Ryan is at square " + test.getPosition() + ".");
        // test.takeTurn(); // Commented out as in both versions
        System.out.println();
    }
}
