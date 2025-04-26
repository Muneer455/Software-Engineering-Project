//package EcojoziBackEnd;
//import java.util.*;
//
///**
// * Game class: 
// * - Setting up the game when ran [ setUpGame ]
// * 
// * - Displays Menu: i) Start Game ii) View Tutorial iii) Configure Accessibility Settings [  ]
// * 
// * - Sets up players and their names
// * 
// * - Loops through each players turn until the end conditions are met
// * 
// */
//public class Game {
//	
//	// Instance variables:
//	private Board board;
//	private List<Player> players;
//	private Player player;
//	private int currentTurn;
////	private int currentSquareIndex;
////	private Task currentTask;
////	private AllianceManager alliance;
////	private Task task;
//	
//	
//	//Constructor: Initialises the game board
//	public Game() {
//		this.board = new Board(26);
//		board.addEvent("Game has been setup"); // Logging event: Game Has Begun
//		this.players = new ArrayList<>();
//		this.currentTurn = 0;
//		//this.currentTask=currentTask;
//		
//	}
//	
//		
//	/**
//	 * Displays the Main Menu
//	 */
//	public void displayMenu() {
//		System.out.println("+----------------------------------+");
//		System.out.println("|           Ecojozi                |");
//		System.out.println("+----------------------------------+");
//        System.out.println("|1. Start Game                     |");
//        System.out.println("|2. View Tutorial                  |");
//        System.out.println("|3. Configure Accessibility Options|");
//        System.out.println("|4. Quit                           |");
//        System.out.println("+----------------------------------+");
//	}
//	
//	
//	/**
//	 * 2. View Tutorial
//	 */
//	public void displayTutorial() {
//		System.out.println("+--------------------------------------------------+");
//		System.out.println("|                Ecojozi Tutorial                  |");
//		System.out.println("+--------------------------------------------------+");
//        System.out.println("| - Roll dice to move across the board.            |");
//        System.out.println("| - Complete tasks to earn points.                 |");
//        System.out.println("| - Form alliances with other players.             |");
//        System.out.println("| - The player with the most tasks completed wins! |");
//        System.out.println("+--------------------------------------------------+");
//	}
//	
//	
//	/**
//	 * This is the Mini-Menu that appears when a player lands on a Square
//	 */
//	public void playerMenu() {
//		System.out.println("+----------------------------------+");
//		System.out.println("|           Player Menu            |");
//		System.out.println("+----------------------------------+");
//        System.out.println("|1. Form Alliance                  |"); // -- 
//        System.out.println("|2. Allocate Resources             |"); // current active task: 1. 2. (sharing with someone else, whenever u form an alliance, it automatically groups both players tasks)
//        System.out.println("|3. Claim Task                     |"); // ---- just display task
//        System.out.println("|4. End Turn                       |"); // ------ nextTurn();
//        System.out.println("+----------------------------------+");
//	}
//	
//	
//	/**
//	 * This is the Mini-Menu that appears when a player (WHO IS IN AN ALLIANCE) lands on a Square
//	 */
//	public void alliancePlayerMenu() {
//		System.out.println("+----------------------------------+");
//		System.out.println("|           Player Menu            |");
//		System.out.println("+----------------------------------+");
//        System.out.println("|1. Allocate Resources             |"); // 
//        System.out.println("|2. Claim Task                     |"); // ---- just display task
//        System.out.println("|3. End Turn                       |"); // ------
//        System.out.println("+----------------------------------+");
//	}
//	
//	
//	/**
//	 * Returns the index of the current player (i)
//	 * @return
//	 */
//	public int getCurrentPlayer() {
//		return this.currentTurn;
//	}
//	
//	
//	
//	
//	/**
//	 * 3. Configure Accessibility Options
//	 */
//	public void configureAccessibility() {
//		// Need to add accessibility settings
//	}
//	
//	
//	/**
//	 * This function checks for all the end conditions
//	 * @return
//	 */
//	public boolean isGameOver() {
//		boolean allTasksCompleted = board.allObjectivesCompleted();
//				
//		return allTasksCompleted ;
//		//return allTasksCompleted || runOutOfResources || playerQuits
//	}
//	
//	
//	/**
//	 * 4. Quit
//	 */
//	public void endGame() {
//		System.out.println("Game Over!");
//        System.out.println("Final Player Statistics:");
//        for (Player player : players) {
//            System.out.println(player.getName() + " - Tasks Completed: " + player.getTasksCompleted());
//        }
//	}
//
//	/**
//	 * We require the currentTurn variable for moving the current players turn to the next one, Hence we have a seperate version of this code in Game.java class
//	 * @param players
//	 */
//	public void nextTurn(ArrayList<Player> players) {
//		  currentTurn = (currentTurn + 1) % players.size();  // using modular arithemtic to loop around the arraylist
//	}
//	
//	
//	
//	/**
//	 * Updates the Board after a player moves their turn
//	 */
//	public void updateGameBoard() {
//		board.updateBoard(); // board is updated [Reflects the position change of the player on the board] [!!] 
//	}
//	
//	
//	
//	/**
//	 * This gets the currentSqaureIndex that the currentPlayer has landed on
//	 * @return
//	 */
//	public Task getCurrentTask(Player player) {
//		int position = player.takeTurn(); // getting the current position of the player (after the player takes a turn)
//		return board.getObjective(position); // getting the
//		
//	}
//	
//	
//	
//	public void displayObjectives() {
//		System.out.println("Game Objectives:");
//        board.displayObjectives();
//	}
//	
//	
//	
//	/** Commenting this away bc player shouldnt need show resources
//	public void displayPlayers() {
//		System.out.println("Current Player Status:");
//        for (Player player : players) {
//            System.out.println(player.getName() + " - Resources: " + player.showResources());
//        }
//	}
//	*/
//
//	 public void displayBoard() {
//        System.out.println("Current Board State:");
//        board.printBoard();
//    }
//	
//	
//}
//
///**
// * Notes:
// * 
// * - Finish off the implementation of the Mini-Menu (according to the Take Turn Use Case Description)
// * 
// * - Need another mini-menu for players in alliance (see Allocate Resources Use Case)
// * 
// * - Code showResources() again
// * 
// * - If Option 3.) if claim task is selected, show task to player, ask again if they want to accept/not
// * 
// * - Update the isGameOver() method
// * 
// * - Checkout the remaining uncommented Game.java methods
// * 
// * - Implement landing on special square consequences (+ve / -ve)
// * 
// * - Talk 2 Ryan tmrw around 9pm (flow 5 of Take Turn use case)
// * - 
// * 
// * - Implementing Time sensitive tasks
// */
