package main;
import java.util.*;
public class EndGame {
	private boolean endCondition;

    public EndGame() {
        this.endCondition = false;
    }

    public void checkGameStatus(Game game) {
        this.endCondition = false; 
    }

    public void updateGameStatus(boolean status) {
        this.endCondition = status;
    }
    
    /** 
    public void endGameSequence(List<Player> players) {
        System.out.println("Game Over!");
        displayStatistics(players);
    }
    
    
    Commenting this away because player doesnt need showResources
    
    
    public void displayStatistics(List<Player> players) {
        System.out.println("Final Player Statistics:");
        for (Player player : players) {
            System.out.println("Player: " + player.getName());
            System.out.println("Tasks Completed: " + player.getTasksCompleted());
            System.out.println("Resources Remaining: " + player.showResources());
            System.out.println("-----------------------------");
        }
    }
    */

    public boolean isEndConditionMet() {
        return endCondition;
    }

}
