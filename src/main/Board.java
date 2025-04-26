package main;
import java.util.*;

public class Board {
	
	private List<String> events;
	private List<Square> squares;
	private List<Task> objectives;
	private Task task;
	
	public Board(int numOfSquares) {
		this.squares = new ArrayList<>();
		 for (int i = 0; i < numOfSquares; i++) {
            squares.add(new Square("Square " + i, i, null, false,this));
            //name, squareID, task, isSpecial, board
        }
        this.events = new ArrayList<>();
        this.objectives = new ArrayList<>();
	}

	public Square getSquare(int position) {
		
        return this.squares.get(position);
    }
	
	/**
	 * Using this method for Game logger:
	 * 
	 * @param eventDescription: description of the event that just took place
	 */
	public void addEvent(String eventDescription) {
		events.add(eventDescription);
	}

	public void printEvents() {
	    System.out.println("Game Events:");
	    for (String event : events) {
	        System.out.println(event);
	    }
	}

	/**
	 * This method is used to update the square where a player lands on - for game logger
	 * 
	 * @param position: current position of the player
	 * @param player: current player instance
	 */
    public void updateSquare(int position) {
    	Square square = squares.get(position); 
    	square.triggerEvent();
    	addEvent("Square "+ position+" triggered an event.");
    }

    public void addObjective(Task task) {
    	objectives.add(task);
    }
 
    public void displayObjectives() {
    	System.out.println("Game Objectives: ");
    	 for (Task task : objectives) {
    	        System.out.println(task.getDescription());
    	    }
    }

    // -------
    public Task getObjective(int index) {
    	return this.objectives.get(index);
    }
  
    public boolean allObjectivesCompleted() {
    	for(Task task : objectives) {
    		if(!task.isComplete()) {
    			return false;
    		}
    	}
    	return true;
    }

    public void printBoard() {
    	for(Square square : squares) {
    		System.out.println(square.getName());
    	}
    } 
    
    /**
     * This method is used to update the board once a task has been completed.
     * 
     * @param player: current player instance
     */
    public void updateBoard() {
    	System.out.println("Updating board...");
    	for(Square square : squares) {
    		if(square.hasTask()) {
    			Task task = square.getTask();
    			if(task.isComplete()) {
    				System.out.println("Task on square "+ square.getSquareID()+" is complete.");
    				addEvent("Task on square "+square.getSquareID()+" completed."); 
    				
    			}
    		}
    	}
    	
    }
}
