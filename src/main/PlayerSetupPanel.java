package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PlayerSetupPanel extends JPanel {
    private ArrayList<Player> players;
    private Board board;
    private JFrame mainFrame;

    public PlayerSetupPanel(ArrayList<Player> players, Board board, JFrame mainFrame) {
        this.players = players;
        this.board = board;
        this.mainFrame = mainFrame;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.WHITE);

        // Setting up the player input section
        JLabel questionLabel = new JLabel("How many players?");
        questionLabel.setFont(new Font("Arial", Font.BOLD, 24));
        questionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(Box.createVerticalStrut(100));
        add(questionLabel);

        JTextField playerInput = new JTextField(10);
        playerInput.setMaximumSize(new Dimension(200, 30));
        playerInput.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(Box.createVerticalStrut(20));
        add(playerInput);

        JButton submitButton = new JButton("Submit");
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        submitButton.setFont(new Font("Arial", Font.PLAIN, 20));
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = playerInput.getText();
                try {
                    int numPlayers = Integer.parseInt(input);
                    if (numPlayers < 2 || numPlayers > 4) {
                        JOptionPane.showMessageDialog(mainFrame, "Please enter a number between 2 and 4 (inclusive).");
                    } else {
                        // Dynamically create JTextFields for player names based on the number of players
                        removeAll();
                        add(questionLabel);
                        add(Box.createVerticalStrut(20));
                        ArrayList<JTextField> nameFields = new ArrayList<>();
                        for (int i = 0; i < numPlayers; i++) {
                            JLabel nameLabel = new JLabel("Enter name for Player " + (i + 1) + ":");
                            nameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
                            JTextField nameField = new JTextField(10);
                            nameFields.add(nameField);
                            add(nameLabel);
                            add(nameField);
                        }
                        add(Box.createVerticalStrut(20));
                        JButton nameSubmitButton = new JButton("Submit Names");
                        nameSubmitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
                        nameSubmitButton.setFont(new Font("Arial", Font.PLAIN, 20));
                        nameSubmitButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                ArrayList<String> playerNames = new ArrayList<>();
                                for (JTextField nameField : nameFields) {
                                    String playerName = nameField.getText().trim();
                                    if (!playerName.isEmpty()) {
                                        playerNames.add(playerName);
                                    }
                                }

                                // Create player objects and add them to the players list
                                for (String name : playerNames) {
                                    Player newPlayer = new Player(name);
                                    players.add(newPlayer);
                                }

                                // Transition to the game board screen
                                CardLayout layout = (CardLayout) mainFrame.getContentPane().getLayout();
                                layout.show(mainFrame.getContentPane(), "GameBoardScreen");
                            }
                        });
                        add(nameSubmitButton);
                        revalidate();
                        repaint();
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(mainFrame, "Invalid input. Please enter a valid number.");
                }
            }
        });
        add(submitButton);
    }
}