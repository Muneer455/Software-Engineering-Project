package main;

import main.Alliance;
import main.Board;

public class Player {
	
	private String name;
	private int resources;
	private int position;
	private int taskCounter;
	private int specialDiceCount;
	private int turnsCompleted;
	private int tasksCompleted;

	// Constructor:
	public Player(String name) {
		setName(name); // validating & assigning the player chosen name to the 'name' string
		this.resources = 1500;
		this.position = 0;
		this.taskCounter = 0;
		this.specialDiceCount = 0;
		this.turnsCompleted = 0;
		this.tasksCompleted = 0;
	}

	/*
	 * Allows the player to:
	 *  - Roll dice
	 *  - Claim tasks
	 *  - Form alliance
	 *  - Allocate resources
	 * 
	 * And then end their turn
	 */
	public Board takeTurn(Board board) {
		System.out.println(this.name + " is taking their turn.");

		// Roll dice to determine movement
		int squaresToMove = rollDice();
		int originalPosition = this.position;

		// Update position and wrap around if necessary
		this.position = (this.position + squaresToMove) % 26;
		if (this.position < originalPosition) {
			this.giveResources(500);
			System.out.println(this.name + " got 500 ZAR for completing a lap of the board!");
		}

//		 if someone is already an owner of this square
//		 give them an option to gift resources
//		 Square currentSquare = board.getSquare(this.position);


		this.turnsCompleted++;
		return board;
	}

	public int rollDice() {

		if (this.specialDiceCount > 0) {
    		System.out.println("Use special dice?");
			/*
			 * SPECIAL DICE IMPLEMENTATION TO BE DECIDED (CAN ITS USE BE DELAYED?)
			 */
		}
		int diceRoll = (int) (Math.random() * 6) + 1;
		System.out.println(this.name + " rolled a " + diceRoll + ".");
		return diceRoll;
	}

	/*
	 * Used to claim an unowned task on the board.
	 */
	public static void claimTask(Player player, Task task) {

		int balance = player.getResources();
		System.out.println("Your current balance is: " + balance);
		System.out.print("Task: ");
		System.out.println(task.getDescription());
		System.out.print("Minimum amount to claim this task: " + task.getDeposit());
		System.out.print("Are you sure you wish to claim this task(Y/N): ");

		System.out.println("This task has already been claimed by you.");

	}

	/*
	 * Used to allocate resources to owned tasks.
	 */
	public void allocateResourcesToSquare(int amount) {

		// if task is completed
		this.taskCounter++;
	}

	/*
	 * When landing on a task owned by another player, a popup may ask the user to
	 * donate to their task.
	 */
	public boolean donateResourcesToAPlayer(Player player, int amount, Task task) {
		// Checking if the player satisfies the minimal conditions for allocating
		// resources:
		if (player != null && amount > 0 && player.getResources() >= amount) {

			player.resources -= amount; // deducting the resources from the players account
//			this.allocatedSquareResources += amount; // updating the resource amount for the square player is allocating
			// resources to

			// System.out.println(this.name + " received " + amount + " resources from " +
			// player.getName());
			System.out.println("Task: " + task.getDescription() + " has been claimed");
			return true;
		}

		System.out.println("Resource request denied.");
		return false;
	}

	// Adds a ZAR amount to this players balance
	public void giveResources(int amount) {
		this.resources += amount;
	}

	// Removes a ZAR amount from this players balance
	public void deductResources(int amount) {
		this.resources -= amount;
	}

	/**
	 * Form Alliance with another player to share responsibility for the task you are
	 * sitting on on the board.
	 */
	public void formAlliance(Player otherPlayer, Alliance alliance) {
		if (otherPlayer != null && alliance != null) {
			alliance.addMember(this);
			alliance.addMember(otherPlayer);
			System.out.println(this.name + " formed an alliance with " + otherPlayer.getName());
		} else {
			System.out.println("Failed to form an alliance.");
		}
	}

	// This functionality does NOT exist in the Use Case descriptions
//		public void transferTask(Player recipient, Task task) {
//			if (task != null && task.getOwner() == this && recipient != null) {
//				task.claimTask(recipient);
//				this.taskCounter--;
//				recipient.taskCounter++;
//				System.out
//						.println(this.name + " transferred task: " + task.getDescription() + " to " + recipient.getName());
//			} else {
//				System.out.println("Task transfer failed.");
//			}
//		}

	//// GETTERS ////

	public String getName() {
		return this.name;
	}

	public int getResources() {
		return this.resources;
	}

	public int getPosition() {
		return this.position;
	}

	public int getTaskCounter() {
		return this.taskCounter;
	}

	public int getSpecialDiceCount() {
		return this.specialDiceCount;
	}

	public int getTurnsCompleted() {
		return this.turnsCompleted;
	}

	public int getTasksCompleted() {
		return this.tasksCompleted;
	}

	//// SETTERS ////

	/**
	 * setName => Using this to validate player Name:
	 * 
	 * @param pName: the user chosen player name
	 * 
	 */
	private void setName(String pName) {

		if (pName != null) { // Checking if the name is null or not
			if (!pName.isEmpty()) { // Checking if the name is an empty string or not
				if (!pName.isBlank()) { // Checking if the name is a whitespace character/blank

					this.name = pName; // if all conditions are satisfied, the name is assigned to the player instance

				} else {
					this.name = "N/A"; // default value for invalid input
					throw new IllegalArgumentException("Player name can NOT be whitespace characters only"); // exception
					// characters
				}
			} else {
				this.name = "N/A"; // default value for invalid input
				throw new IllegalArgumentException("Player name can NOT be empty"); // exception is thrown if player
																					// name is empty string
			}
		} else {
			this.name = "N/A"; // default value for invalid input
			throw new IllegalArgumentException("Player name can NOT be null"); // exception is thrown if player name is
																				// null
		}

	}
}