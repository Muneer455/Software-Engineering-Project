package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BoardGameGUI {
    public static void main(String[] args) {
    	
    	// Creating the board object instance:
    	ArrayList<Player> players = new ArrayList<>();
    	Board board = new Board(26); // 26 => squares
    	
        // Creating the main frame:
        JFrame mainFrame = new JFrame("EcoJozi");
        
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // basically, on pressing 'x' on the window, it will terminate the program
        mainFrame.setSize(1200, 800); // setting the size for the mainFrame
        mainFrame.setLayout(new CardLayout()); // we're going with a cardLayout for switching screens/frames

        // Creating panels for each screen: (welcome -> setting up players -> game board screen)
        JPanel welcomeScreen = createWelcomeScreen(mainFrame);
        PlayerSetupPanel playerSetupScreen = new PlayerSetupPanel(players, board, mainFrame); // setting up the players screen
        JPanel gameBoardScreen = createGameBoardScreen();
        
        

        // Add screens to the main frame: (basically each frame has a screen, i.e a screen is a subset of the mainFrame)
        mainFrame.add(welcomeScreen, "WelcomeScreen");
        mainFrame.add(playerSetupScreen, "PlayerSetupScreen");
        mainFrame.add(gameBoardScreen, "GameBoardScreen");

        // Show the frame
        mainFrame.setVisible(true); // always keep this on cuh
    }

    
    
    // Welcome screen:
    private static JPanel createWelcomeScreen(JFrame mainFrame) {
        JPanel panel = new JPanel(); // creating a panel for the welcome screen
        panel.setLayout(null); // positioning for custom placement

        // setting up the content for this screen
        JLabel welcomeLabel = new JLabel("Welcome to EcoJozi!");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 36));
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeLabel.setBounds(350, 200, 500, 50); // Centering the text
        panel.add(welcomeLabel);

        // Start game button
        JButton startButton = new JButton("Start Game");
        startButton.setBounds(500, 400, 200, 50); // Centering the button
        startButton.setFont(new Font("Arial", Font.PLAIN, 20));
        startButton.addActionListener(e -> { // Using action listeners (for startButton)
        	
        	// using cardlayout to switch from the main screen to playerSetup screen
            CardLayout layout = (CardLayout) mainFrame.getContentPane().getLayout();
            layout.show(mainFrame.getContentPane(), "PlayerSetupScreen");
            
        });
        panel.add(startButton); // adding the start button to the welcome panel

        return panel; // basically this gives the whole panel back to the mainFrame
    }

    
    
    
    // Player setup screen: PlayerSetupPanel.java (we've already taken care of calling this in the main)
    
    
    
    // Game board screen
    private static JPanel createGameBoardScreen() {
        JPanel mainPanel = new JPanel(new BorderLayout());

        // LEFT PANEL: Players Section
        JPanel playersPanel = new JPanel();
        playersPanel.setLayout(new BoxLayout(playersPanel, BoxLayout.Y_AXIS));
        playersPanel.setBorder(BorderFactory.createTitledBorder("Players"));
        playersPanel.setPreferredSize(new Dimension(200, 0));
        playersPanel.setBackground(Color.WHITE);

        // Add sample players
        addPlayerInfo(playersPanel, "Ryan", 1500, "⭐");
        addPlayerInfo(playersPanel, "Clive", 1500, "");
        addPlayerInfo(playersPanel, "Adan", 1500, "");
        addPlayerInfo(playersPanel, "Leon", 1500, "");

        // TOP PANEL: Objectives Section
        JPanel objectivesPanel = new JPanel(new GridLayout(1, 5));
        objectivesPanel.setBorder(BorderFactory.createTitledBorder("Objectives"));
        objectivesPanel.setBackground(Color.WHITE);

        // Add objectives
        addObjectiveColumn(objectivesPanel, "Planning");
        addObjectiveColumn(objectivesPanel, "Design");
        addObjectiveColumn(objectivesPanel, "Development");
        addObjectiveColumn(objectivesPanel, "Testing");
        addObjectiveColumn(objectivesPanel, "Deployment");

        // CENTER PANEL: Board
        JPanel boardPanel = new JPanel(new GridLayout(5, 5));
        boardPanel.setBackground(Color.WHITE);

        // Add sample tiles (you can customize this as needed)
        for (int i = 0; i < 25; i++) {
            JButton tile = new JButton();
            tile.setBackground(new Color(240, 240, 240)); // Light gray tiles
            boardPanel.add(tile);
        }

        // RIGHT PANEL: Game Log and Menu
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BorderLayout());
        rightPanel.setPreferredSize(new Dimension(250, 0));
        rightPanel.setBackground(Color.WHITE);

        // Game Log
        JPanel gameLogPanel = new JPanel();
        gameLogPanel.setLayout(new BoxLayout(gameLogPanel, BoxLayout.Y_AXIS));
        gameLogPanel.setBorder(BorderFactory.createTitledBorder("Game Log"));
        gameLogPanel.setBackground(Color.WHITE);

        JLabel logLabel = new JLabel("<html>Round 1<br>Ryan, it is your turn!</html>");
        gameLogPanel.add(logLabel);

        rightPanel.add(gameLogPanel, BorderLayout.NORTH);

        // Add panels to the frame
        mainPanel.add(playersPanel, BorderLayout.WEST);
        mainPanel.add(objectivesPanel, BorderLayout.NORTH);
        mainPanel.add(boardPanel, BorderLayout.CENTER);
        mainPanel.add(rightPanel, BorderLayout.EAST);

        return mainPanel; // basically this gives the whole panel back to the mainFrame
    }

    // Helper methods
    private static void addPlayerInfo(JPanel panel, String name, int resources, String icon) {
        JLabel playerLabel = new JLabel(
                "<html><b>" + name + icon + "</b><br>Resources: " + resources + " ZAR<br>Tasks: None</html>");
        playerLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.add(playerLabel);
        panel.add(Box.createVerticalStrut(20));
    }
    
    

    private static void addObjectiveColumn(JPanel panel, String objectiveTitle) {
        JPanel objectivePanel = new JPanel();
        objectivePanel.setLayout(new BoxLayout(objectivePanel, BoxLayout.Y_AXIS));
        objectivePanel.setBackground(Color.WHITE);
        objectivePanel.setBorder(BorderFactory.createTitledBorder(objectiveTitle));

        for (int i = 1; i <= 5; i++) {
            JLabel taskLabel = new JLabel("Sample Task " + i);
            taskLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            objectivePanel.add(taskLabel);
        }

        panel.add(objectivePanel);
    }
}