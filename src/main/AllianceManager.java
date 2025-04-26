package main;
import java.util.*;
public class AllianceManager {
	 private List<Alliance> alliances;  // List to store all alliances

    public AllianceManager() {
        alliances = new ArrayList<>();
    }

    public void createAlliance(List<Player> members, Task task) {
        Alliance alliance = new Alliance(members, task);
        alliances.add(alliance);
        System.out.println("New alliance created for task: " + task.getDescription());
    }

    public void addMemberToAlliance(Player player, Alliance alliance) {
        alliance.addMember(player);
    }

    public void removeMemberFromAlliance(Player player, Alliance alliance) {
        alliance.removeMember(player);
    }

    public List<Alliance> getAllAlliances() {
        return alliances;
    }

    public Alliance getAllianceByTask(Task task) {
        for (Alliance alliance : alliances) {
            if (alliance.getTask().equals(task)) {
                return alliance;
            }
        }
        return null;  
    }

}
