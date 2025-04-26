package main;

import java.util.ArrayList;
import java.util.List;

public class Task {
    // Task attributes
    private String description;
    private int deposit;
    private int requiredTotalResources;
    private int resourceBalance; 
    private Player owner; 
    private boolean isTimeSensitive;
    private String objective; 
    private int getDeposit; 
    private boolean isInAlliance; 
    private int timeSensitivityInDays;
    private boolean isAvailableToClaim;

    // Constructor 
    public Task(String objective, int requiredResources, boolean isTimeSensitive, Player owner, int deposit, 
                int getDeposit, int timeSensitivityInDays, String description) {
        this.description = description;
        this.requiredTotalResources = requiredResources;
        this.isTimeSensitive = isTimeSensitive;
        this.owner = owner; // starts off as unclaimed
        this.resourceBalance = 1500;         this.deposit = deposit; 
        this.isInAlliance = false;
        this.getDeposit = getDeposit; 
        this.timeSensitivityInDays = timeSensitivityInDays;
        this.objective = objective; 
        this.isAvailableToClaim = true;
    }

    // Getter methods
    public String getDescription() {
        return this.description;
    }

    public int getRequiredTotalResources() {
        return requiredTotalResources;
    }

    public int getTimeSensitivityInDays() {
        return timeSensitivityInDays;
    }

    public String getObjective() {
        return objective;
    }

    public boolean isInAlliance() {
        return isInAlliance;
    }
    public boolean isAvailableToClaim() {
        return isAvailableToClaim;
    }
    public int checkResourceBalance() {
        return this.resourceBalance;
    }
    public int getDeposit() {
        return this.deposit;
        
        
    }  public void assignOwner(Player player) {
        if (this.owner == null) {
            this.owner = player;
            this.isAvailableToClaim = false;
            System.out.println(player.getName() + " is now the owner of the task.");
        } else {
            System.out.println("Task already has an owner.");
        }
    }

    public void setAllianceStatus(boolean isInAlliance) {
        this.isInAlliance = isInAlliance;
    }
    public void refundDeposit(Player player) {
        if (player != null) {
            player.giveResources(this.deposit);
            System.out.println("Deposit of " + this.deposit + " refunded to " + player.getName());
        }
    }
    public void updateResourceBalance(int resources) {
        this.resourceBalance += resources;
        System.out.println("Resource balance updated to: " + this.resourceBalance);
        
        
    } //placeholder pentalty based on what uy guys need
    public void applyPenalty(Player player) {
        if (player != null) {
            int penalty = 100; 
            player.deductResources(penalty);
            System.out.println(player.getName() + " has been penalised with " + penalty + " resources.");
        }
    }
    // Method to create the 20 tasks
    public List<Task> createTasks() {
        List<Task> tasks = new ArrayList<>();

        // Planning Tasks
        tasks.add(new Task("Planning", 2000, true, null, 500, 2000, 5, "plan for reducing waste in the city"));
        tasks.add(new Task("Planning", 2000, true, null, 500, 2000, 5, "identify areas for waste collection improvement."));
        tasks.add(new Task("Planning", 2000, true, null, 500, 2000, 5, "do a poll on current waste management systems."));
        tasks.add(new Task("Planning", 2000, true, null, 500, 2000, 5, "determine the environmental impact of waste in the city of Johannesburg."));

        // Design Tasks
        tasks.add(new Task("Design", 2000, true, null, 500, 2000, 5, "design a more efficient waste collection system."));
        tasks.add(new Task("Design", 2000, true, null, 500, 2000, 5, "design a system for recycling and waste sorting."));
        tasks.add(new Task("Design", 2000, true, null, 500, 2000, 5, "create public awareness initiative on waste reduction."));
        tasks.add(new Task("Design", 2000, true, null, 500, 2000, 5, "design waste management infrastructure for high-density areas."));

        // Development Tasks
        tasks.add(new Task("Development", 2000, true, null, 500, 2000, 5, "develop waste collection routes based on roads."));
        tasks.add(new Task("Development", 2000, true, null, 500, 2000, 5, "invite friends to city-wide program to reduce waste."));
        tasks.add(new Task("Development", 2000, true, null, 500, 2000, 5, "implement waste knowledge for reduction."));
        tasks.add(new Task("Development", 2000, true, null, 500, 2000, 5, "help gather donations for new waste sorting centers."));

        // Testing Tasks
        tasks.add(new Task("Testing", 2000, true, null, 500, 2000, 5, "test waste sorting techniques for efficiency."));
        tasks.add(new Task("Testing", 2000, true, null, 500, 2000, 5, "rate the impact of recycling programs."));
        tasks.add(new Task("Testing", 2000, true, null, 500, 2000, 5, "oversee public participation in waste reduction initiatives."));
        tasks.add(new Task("Testing", 2000, true, null, 500, 2000, 5, "measure the success of waste management on environmental impact."));

        // Deployment Tasks
        tasks.add(new Task("Deployment", 2000, true, null, 500, 2000, 5, "deploy the waste management services in your area."));
        tasks.add(new Task("Deployment", 2000, true, null, 500, 2000, 5, "ensure proper waste management facilities are being run right."));
        tasks.add(new Task("Deployment", 2000, true, null, 500, 2000, 5, "put up posters about waste management."));
        tasks.add(new Task("Deployment", 2000, true, null, 500, 2000, 5, "provide manual support to waste management facilities."));

        return tasks; 
    }

    
    	public boolean isComplete() {
        return this.resourceBalance >= this.requiredTotalResources;
    }

         public boolean claimTask(Player player, int deposit) {
        if (this.owner == null && deposit >= this.deposit) {
            this.owner = player;
            System.out.println(player.getName() + " has claimed the task.");
            return true; 
        }
        System.out.println("Task cannot be claimed sorry");
        return false; 
    }
    
         public Player getOwner() {
        return this.owner;
    }
}
