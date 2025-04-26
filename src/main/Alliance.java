package main;

import java.util.*;

public class Alliance {
    private List<Player> members; 
    private Task task; 
    private static List<Alliance> alliances = new ArrayList<>(); 

    // Constructor that initialises the members and task for the alliance
    public Alliance(List<Player> members, Task task) {
        this.members = new ArrayList<>(members);
        this.task = task;
        
        alliances.add(this);
        
        // Update task status
        updateTaskForAlliance();
    }

    public void addMember(Player player) {
        if (!members.contains(player)) {
            members.add(player);
            System.out.println(player.getName() + " joined the alliance.");
            updateTaskForAlliance();  
        }
    }

    public void removeMember(Player player) {
        if (members.remove(player)) {
            System.out.println(player.getName() + " left the alliance.");
            updateTaskForAlliance(); 
        }
    }

    public boolean isMember(Player player) {
        return members.contains(player);
    }

    private void updateTaskForAlliance() {
        if (!members.isEmpty()) {
            task.setAllianceStatus(true); 
            System.out.println("The task is now marked as an alliance task.");
        } else {
            task.setAllianceStatus(false); 
            System.out.println("The task is no longer an alliance task.");
        }
    }

    public boolean isTaskCompletedByAlliance() {
        return task.isComplete();
    }

    public Task getTask() {
        return this.task;
    }

    public List<Player> getAlliance() {
        return this.members;
    }

    public static List<Alliance> getAllAlliances() {
        return alliances;
    }

    public static Alliance getAllianceByTask(Task task) {
        for (Alliance alliance : alliances) {
            if (alliance.getTask().equals(task)) {
                return alliance;
            }
        }
        return null;  
    }
}
