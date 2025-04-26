//package main;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
///**
// * Player Class: Represents a player in the Game
// */
//public class Player {
//
//	// Instance variables:
//
//	// String name => to hold Player's Name
//	private String name;
//
//	// The game board is passed through we so have a shared board
//	private Board board;
//
//	// int playerID => unique Player ID for each player
//	private int playerID;
//
//	// Class variable: using this variable to have unique ID for each player
//	// instance
//	private static int nextPlayerID = 1;
//
//	// int resources => stores a players current resources (resources work as
//	// currency)
//	private int resources;
//
//	// int squareResources => stores the updated resources for a square:
//	private int allocatedSquareResources;
//
//	// int position => using a position variable to store the current position of
//	// the player
//	private int position;
//
//	// int taskCounter => used to see how many tasks a player currently holds
//	private int taskCounter;
//
//	private int specialDiceCount;
//	private int turnsCompleted;
//	private int tasksCompleted;
//
//	// Constructor:
//	public Player(String name) {
//		setName(name); // validating & assigning the player chosen name to the 'name' string
//		setID(); // assigning playerID
//
//		// Default values: (don't need to assign any of these from the player)
////		this.board = board;
//		this.resources = 0;
//		this.position = 0;
//		this.taskCounter = 0;
//		this.specialDiceCount = 0;
//		this.turnsCompleted = 0;
//		this.tasksCompleted = 0;
//	}
//
//	public Player() {
//
//	}
//
//	// Getter Methods:
//
//	// getName: to retrieve the name of the specified player instance
//	public String getName() {
//		return this.name;
//	}
//
//	// getPlayerID: To retrieve the ID of the specified player instance
//	public int getPlayerID() {
//		return this.playerID;
//	}
//
//	// getResources: To retrieve the resources of the specified player instance
//	public int getResources() {
//		return this.resources;
//	}
//
//	// getPosition: To retrieve the current position of the specified player
//	// instance
//	public int getPosition() {
//		return this.position;
//	}
//
//	// getTaskCounter: To retrieve the number of Tasks finished by the specified
//	// player instance
//	public int getTaskCounter() {
//		return this.taskCounter;
//	}
//
//	// getSpecialDiceCount: To idk
//	public int getSpecialDiceCount() {
//		return this.specialDiceCount;
//	}
//
//	// getTurnsCompleted: to retreive the number of turns taken by a specified
//	// player instance
//	public int getTurnsCompleted() {
//		return this.turnsCompleted;
//	}
//
//	// getTasksCompleted: to retrieve the number of tasks completed by a specified
//	// player instance
//	public int getTasksCompleted() {
//		return this.tasksCompleted;
//	}
//
//	// Setters:
//
//	/**
//	 * setID => Using this to set the player ID
//	 */
//	private void setID() {
//		this.playerID = nextPlayerID;
//		nextPlayerID++; // incrementing the class variable after assigning it to current player instance
//						// (for the next player)
//	}
//
//	/**
//	 * setName => Using this to validate player Name:
//	 * 
//	 * @param pName: the user chosen player name
//	 * 
//	 */
//	private void setName(String pName) {
//
//		if (pName != null) { // Checking if the name is null or not
//			if (!pName.isEmpty()) { // Checking if the name is an empty string or not
//				if (!pName.isBlank()) { // Checking if the name is a whitespace character/blank
//
//					this.name = pName; // if all conditions are satisfied, the name is assigned to the player instance
//
//				} else {
//					this.name = "N/A"; // default value for invalid input
//					throw new IllegalArgumentException("Player name can NOT be whitespace characters only"); // exception
//					// characters
//				}
//			} else {
//				this.name = "N/A"; // default value for invalid input
//				throw new IllegalArgumentException("Player name can NOT be empty"); // exception is thrown if player
//																					// name is empty string
//			}
//		} else {
//			this.name = "N/A"; // default value for invalid input
//			throw new IllegalArgumentException("Player name can NOT be null"); // exception is thrown if player name is
//																				// null
//		}
//
//	}
//
//	public List<Player> checkPlayersOnSameSquare(List<Player> allPlayers, Board board) {
//		List<Player> playersOnSameSquare = new ArrayList<>();
//		for (Player otherPlayer : allPlayers) {
//			// Check if the other player's position matches this player's position
//			if (otherPlayer != this && board.getSquare(otherPlayer.position).equals(board.getSquare(this.position))) {
//				playersOnSameSquare.add(otherPlayer);
//			}
//		}
//		return playersOnSameSquare;
//	}
//
//	// Object Methods: (Refer Use Case descriptions, wherever possible)
//
//	/**
//	 * !! Needs more understanding !!
//	 * 
//	 * - need a mini-menu to pop-up: this menu will contain: form alliance, allocate
//	 * resources, claim task, end turn
//	 * @param board 
//	 * 
//	 */
//	public Board takeTurn(Board board) {
//		System.out.println(this.name + " is taking their turn.");
//
//		// Roll dice to determine movement
//		int squaresToMove = rollDice();
//		int originalPosition = this.position;
//
//		// Update position and wrap around if necessary
//		this.position = (this.position + squaresToMove);
//
//		this.position = (this.position + squaresToMove) % 26;
//
//		if (this.position < originalPosition) {
//			this.giveResources(500);
//			System.out.println(this.name + " got 500 ZAR for completing a lap of the board!");
//		}
//
//		// if someone is already an owner of this square
//		// give them an option to gift resources
//		// Get the current square
//		// Square currentSquare = Board.getSquare(this.position);
//
//		// Check if someone owns the square
//		// Player squareOwner = currentSquare.getOwner();
//		// if (squareOwner != null && squareOwner != this) {
//		// System.out.println("This square is owned by " + squareOwner.getName() + "!");
//		// Handle interaction, e.g., pay resources, alliance options, etc.
//		// } else if (squareOwner == null) {
//		// System.out.println("This square is unowned. You can claim it!");
//		// } else {
//		// System.out.println("You already own this square.");
//		// }
//
//		// Add the player to the square's player list
//		// currentSquare.addPlayer(this);
//
//		/*
//		 * If landed on a special square
//		 */
//
//		this.turnsCompleted++;
//		return board;
//	}
//
//	// Setter for testing the dice roll to different positions on the board
//	public void setPositionToEnd() {
//		this.position = 25;
//	}
//
//	/**
//	 * !! Not working yet !!
//	 * 
//	 * - Special dice + specialDiceCount counter must be implemented with some
//	 * functionality [ !! Value-Added Feature !! ] - later
//	 * 
//	 * - How does the movement reflect on the board ? (maybe this should belong on
//	 * the Game.java / Board.java)
//	 * 
//	 */
//	public int rollDice() {
//
//		if (this.specialDiceCount > 0) {
////    		System.out.println("Use special dice?");
//			/*
//			 * SPECIAL DICE IMPLEMENTATION TO BE DECIDED (CAN ITS USE BE DELAYED?)
//			 */
//		}
//		int diceRoll = (int) (Math.random() * 6) + 1;
//		System.out.println(this.name + " rolled a " + diceRoll + ".");
//		return diceRoll;
//	}
//
//	/**
//	 * This functionality is used to Allocate Resources (for Board Square)
//	 * 
//	 * @param amount: desired amount inputted by the user
//	 */
//	public void allocatedSquareResources(int amount) {
//		if (amount > 0) {
//			this.resources += amount;
//		}
//	}
//
//	/**
//	 * This functionality is used to Allocate Resources (for player account)
//	 * 
//	 * @param player: current player instance
//	 * @param amount: desired amount of resources to allocate
//	 * @return
//	 */
//	public boolean allocateResourcesPlayer(Player player, int amount, Task task) {
//		// Checking if the player satisfies the minimal conditions for allocating
//		// resources:
//		if (player != null && amount > 0 && player.getResources() >= amount) {
//
//			player.resources -= amount; // deducting the resources from the players account
//			this.allocatedSquareResources += amount; // updating the resource amount for the square player is allocating
//														// resources to
//
//			// System.out.println(this.name + " received " + amount + " resources from " +
//			// player.getName());
//			System.out.println("Task: " + task.getDescription() + " has been claimed");
//			return true;
//		}
//
//		System.out.println("Resource request denied.");
//		return false;
//	}
//
//	public static void claimTask(Player player, Task task, Scanner input, Game game, AllianceManager alliances,
//			ArrayList<Player> players) {
//
//		boolean flag = task.getDeposit();
//		if (flag) {
//			int balance = player.getResources();
//			System.out.println("Your current balance is: " + balance);
//			System.out.print("Task: ");
//			System.out.println(task.getDescription());
//			System.out.print("Minimum amount to claim this task: " + task.getDeposit());
//			System.out.print("Are you sure you wish to claim this task(Y/N): ");
//			String choice = input.nextLine();
////			if (choice.equalsIgnoreCase("Y")) {
////
////				verifyMiniAmount(input, player, task);
////
////			} else if (choice.equalsIgnoreCase("N")) {
////				// miniMenuOperation(player,game,input,alliances,players, task);
////			}
//
//		} else if (player.getName().equals(task.getOwner().getName())) {
//			System.out.println("This task has already been claimed by you.");
//			// miniMenuOperation(player,game,input,alliances,players, task);
//
//		} else {
//			System.out.println("This Task is not available.");
//			// miniMenuOperation(player,game,input,alliances,players, task);
//
//		}
//
//	}
//
//	public void updateTaskCounter() {
//		this.taskCounter++;
//	}
//
//	/**
//	 * [ !! Value-Added Feature !! ] - later
//	 * 
//	 * @param otherPlayer
//	 * @param alliance
//	 */
//	public void formAlliance(Player otherPlayer, Alliance alliance) {
//		if (otherPlayer != null && alliance != null) {
//			alliance.addMember(this);
//			alliance.addMember(otherPlayer);
//			System.out.println(this.name + " formed an alliance with " + otherPlayer.getName());
//		} else {
//			System.out.println("Failed to form an alliance.");
//		}
//	}
//
//	/**
//	 * Literally just gives a custom amount of ZAR
//	 */
//	public void giveResources(int bonus) {
//		this.resources += bonus;
//	}
//	
//	/**
//	 * Removes a custom amount of ZAR
//	 */
//	public void deductResources(int amount) {
//		this.resources -= amount;
//	}
//	// This functionality does NOT exist in the Use Case descriptions
//	public void transferTask(Player recipient, Task task) {
//		if (task != null && task.getOwner() == this && recipient != null) {
//			task.claimTask(recipient);
//			this.taskCounter--;
//			recipient.taskCounter++;
//			System.out
//					.println(this.name + " transferred task: " + task.getDescription() + " to " + recipient.getName());
//		} else {
//			System.out.println("Task transfer failed.");
//		}
//	}
//
//	/**
//	 * !! Needs more understanding !!
//	 * 
//	 * 
//	 * If a player ends their turn, I believe the game ends?
//	 * 
//	 */
//	public void endTurn() {
//		System.out.println(this.name + " has ended their turn. Resources: " + this.resources + ", Tasks Completed: "
//				+ this.tasksCompleted);
//	}
//
//	/**
//	 * Extra Notes:
//	 * 
//	 * - I believe, in terms of core features: Player.java Task.java
//	 * Game.java/Board.java Square.java
//	 *
//	 * should be tackled in this order
//	 * 
//	 * 
//	 * - Setup Game Use Case implementation ?? - Random events? (see Use Case "Take
//	 * Turn" - In the development phase, how will each move (either moving on the
//	 * board, allocating resources, etc) reflect on a GUI that we dont have yet ? -
//	 * Do we require toStrings for checking: player instances & task instances ? -
//	 * See Use Case "End Game" - How will this go in play? Sequences?
//	 * 
//	 */
//
//}