package main;

import java.util.*;

public class Square {
	private String name; //The name of the square
	private int squareID; // A unique ID for the square
	private Task task; // Task assigned to a specific square
	private Player owner; //The
	private boolean isSpecial;
	private Board board;
	private List<Player> playersOnSquare;
	private Alliance allianceOnSquare;
	
	/*
	 * Constructor to initialize the object
	 */
	public Square(String name, int squareID, Task task, boolean isSpecial, Board board) {
		this.name = name;
		this.squareID = squareID;
		this.task = task;
		this.isSpecial = isSpecial;
		this.board = board;
		this.playersOnSquare = new ArrayList<>();
		this.allianceOnSquare = null; // no alliance at the start
	}
	/*
	 * Returns the name of the square
	 * @return
	 */
	public String getName() {
		return this.name;
	}
	
	/*
	 * Returns the unique ID of the square
	 * @return
	 */
	public int getSquareID() { // Gets the square's ID
		return this.squareID;
	}
	
	/*
	 * Returns the task assigned to the specific square
	 * @return
	 */
	public Task getTask() {
		return task;
	}
	
	/*
	 * Checks if square has a task assigned to it
	 * @return
	 */
	public boolean hasTask() {
		return task != null;
	}
	
	/*
	 * Checks if it is a special square or not.
	 * @return
	 */
	public boolean isSpecialSquare() {
		return isSpecial;
	}
	
	/*
	 * Returns the list of players that are on the square
	 * @return
	 */
	public List<Player> getPlayersOnSquare() {
		return playersOnSquare;
	}

	// OLD METHOD
	/*
	 * Ryan: I have changed this to be an ownership model below
	 */
//    public void addPlayer(Player player) {
//        if (!playersOnSquare.contains(player)) {
//            playersOnSquare.add(player);
//            System.out.println(player.getName() + " moved to square: " + this.name);
//        }
//    }

	/*
	 * Sets the owner of the task once it has been claimed for ZAR.
	 */
	public void setOwner(Player owner) {
		this.owner = owner;
	}
	
	/*
	 * Returns the player who owns the task assigned to the square
	 * @return
	 */
	public Player getOwner() {
		return owner;
	}
	
	/*OLD METHOD
	 * Ryan: I changed how this worked, before it just printed a message 
	 * saying X player left the square. Now it just removes them.
	 */
//    
//    public void removePlayer(Player player) {
//        if (playersOnSquare.remove(player)) {
//            System.out.println(player.getName() + " left square: " + this.name);
//        }
//    }
	
	
	public void removePlayer(Player player) {
		playersOnSquare.remove(player);
	}

	public void setAlliance(Alliance alliance) {
		this.allianceOnSquare = alliance;
		System.out.println("Alliance set for square: " + this.name);
	}
	
	/*
	 * 
	 */
	public boolean checkAlliance() {
		if (allianceOnSquare == null || playersOnSquare.size() < 2) {
			return false;
		}

		for (Player player : playersOnSquare) {
			if (!allianceOnSquare.isMember(player)) {
				return false;
			}
		}

		return true;
	}
	
	/*
	 * Triggers the event on the square
	 */
	public void triggerEvent() {

		System.out.println("Event triggered on square: " + this.name);
		// I don't know the events yet but this should be the method that triggers them.

	}

}
