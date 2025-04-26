package main;

import java.util.*;

public class Game {

    public static void main(String[] args) {

        // Creating scanner for input
        Scanner input = new Scanner(System.in);

        // Initialising board object
        int numOfSquares = 26;
        Board board = new Board(numOfSquares);

        // Creating players and adding their initial resources
        List<Player> players = null;
        players = setUpPlayers(input);

        // Displaying the interface
        displayMenu();
        displayBoard();
        displayPlayers();
        displayObjectives();
        displayTutorial();
        configureAccessibility();

        // Keeping track of the turns
        int currentTurn = 1;
        int currentPlayerIndex = 0; // Starts with the first player
        Player currentPlayer = players.get(currentPlayerIndex);

        // Looping through the players' turns until conditions are met to end the game
        boolean victory = false;

        do {

            System.out.println(currentPlayer.getName() + " it's your turn!");
            board = nextTurn(currentPlayer, board); // Execute the current turn and updates board

            // Check if all objectives are completed or max turns reached
            boolean allTasksCompleted = board.allObjectivesCompleted();
            boolean maxTurnsReached = currentTurn >= 50;

            if (allTasksCompleted) {
                victory = true; // Game won
                break;
            } else if (maxTurnsReached) {
                victory = false; // Game lost
                break;
            }

            // Move to the next player
            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();

            // If we've looped through all players, increment the round number
            if (currentPlayerIndex == 0) {
                currentTurn++;
            }

        } while (true); // Loop continues until a condition breaks it

        // Ending the game
//      endGameSequence(victory);
//      displayStatistics();

    }

    public static Board nextTurn(Player player, Board board) {
        Board newBoard = player.takeTurn(board); // Player takes their turn to modify the board
        return newBoard; // Returning updated board
    }

    /*
     * - setUpPlayers() Takes input from the user to create the desired number of
     * players and their names.
     */
    public static List<Player> setUpPlayers(Scanner input) {

        int playerCount = 0;
        do {
            try {
                System.out.print("Enter the number of players (2-4): ");
                playerCount = input.nextInt();
                input.nextLine(); // Clear the newline character from the buffer

                // Validate the number of players
                if (playerCount >= 2 && playerCount <= 4) {
                    break; // Exit the loop if input is valid
                } else {
                    System.out.println("Please enter a number between 2 and 4.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number between 2 and 4.");
                input.nextLine(); // Clear the invalid input from the buffer
            }
        } while (true);

        List<Player> players = new ArrayList<>();

        // Creating desired number of players
        for (int i = 0; i < playerCount; i++) {

            System.out.print("Enter name for Player " + (i + 1) + ": ");
            String name = input.nextLine(); // taking user input

            Player newPlayer = new Player(name); // creating player instance
            players.add(newPlayer); // storing player object in players arrayList
        }

        System.out.println("Players set up complete!");
        return players;
    }

    public static void displayMenu() {

    }

    public static void displayBoard() {

    }

    public static void displayPlayers() {

    }

    public static void displayObjectives() {

    }

    public static void displayTutorial() {

    }

    public static void configureAccessibility() {

    }
}
