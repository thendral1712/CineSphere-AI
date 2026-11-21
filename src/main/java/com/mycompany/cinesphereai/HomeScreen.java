/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.cinesphereai;

import javax.swing.*;
import java.awt.*;

public class HomeScreen extends JFrame {


    // Constructor
    public HomeScreen() {

        // Window settings
        setTitle("CineSphere AI");
        setSize(950, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // Main background
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(12, 14, 25));
        mainPanel.setLayout(new BorderLayout());

        // ================= HEADER =================

        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(12, 14, 25));
        headerPanel.setLayout(new BoxLayout(
                headerPanel, BoxLayout.Y_AXIS));

        JLabel logo = new JLabel("✦ CINESPHERE AI ✦");
        logo.setForeground(Color.WHITE);
        logo.setFont(new Font("Segoe UI", Font.BOLD, 38));
        logo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel tagline = new JLabel(
                "Discover the story behind every star.");
        tagline.setForeground(new Color(180, 185, 200));
        tagline.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        tagline.setAlignmentX(Component.CENTER_ALIGNMENT);

        headerPanel.add(Box.createVerticalStrut(45));
        headerPanel.add(logo);
        headerPanel.add(Box.createVerticalStrut(10));
        headerPanel.add(tagline);
        headerPanel.add(Box.createVerticalStrut(35));

        mainPanel.add(headerPanel, BorderLayout.NORTH);

        // ================= CENTER =================

        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(new Color(12, 14, 25));
        centerPanel.setLayout(new BoxLayout(
                centerPanel, BoxLayout.Y_AXIS));

        JLabel heading = new JLabel(
                "ACTOR CAREER ANALYZER");
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font(
                "Segoe UI", Font.BOLD, 25));
        heading.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel description = new JLabel(
                "Explore movies, ratings, genres, awards and career success.");
        description.setForeground(new Color(165, 170, 185));
        description.setFont(new Font(
                "Segoe UI", Font.PLAIN, 14));
        description.setAlignmentX(Component.CENTER_ALIGNMENT);

        centerPanel.add(heading);
        centerPanel.add(Box.createVerticalStrut(10));
        centerPanel.add(description);
        centerPanel.add(Box.createVerticalStrut(35));

        // ================= SEARCH CARD =================

        JPanel card = new JPanel();
        card.setBackground(new Color(25, 28, 43));
        card.setLayout(new BoxLayout(
                card, BoxLayout.Y_AXIS));

        card.setBorder(BorderFactory.createEmptyBorder(
                25, 40, 25, 40));

        JLabel actorLabel = new JLabel(
                "ENTER ACTOR NAME");
        actorLabel.setForeground(new Color(220, 225, 235));
        actorLabel.setFont(new Font(
                "Segoe UI", Font.BOLD, 13));
        actorLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField actorField = new JTextField();
        actorField.setMaximumSize(
                new Dimension(380, 42));
        actorField.setFont(new Font(
                "Segoe UI", Font.PLAIN, 16));
        actorField.setHorizontalAlignment(
                JTextField.CENTER);

        JButton analyzeButton = new JButton(
                "✦  ANALYZE CAREER  ✦");

        analyzeButton.setFont(new Font(
                "Segoe UI", Font.BOLD, 15));
        analyzeButton.setForeground(Color.WHITE);
        analyzeButton.setBackground(
                new Color(90, 60, 170));
        analyzeButton.setFocusPainted(false);
        analyzeButton.setBorder(BorderFactory.createEmptyBorder(
                12, 30, 12, 30));
        analyzeButton.setAlignmentX(
                Component.CENTER_ALIGNMENT);

        card.add(actorLabel);
        card.add(Box.createVerticalStrut(12));
        card.add(actorField);
        card.add(Box.createVerticalStrut(20));
        card.add(analyzeButton);
        analyzeButton.addActionListener(e -> {

    String actorName = actorField.getText().trim();

    if (actorName.isEmpty()) {

        JOptionPane.showMessageDialog(
                this,
                "Please enter an actor name.",
                "CineSphere AI",
                JOptionPane.WARNING_MESSAGE
        );

        return;
    }

    // Create the actor database
    ActorDatabase database = new ActorDatabase();

    // Search for the actor
    Actor actor = database.findActor(actorName);

    if (actor == null) {

        JOptionPane.showMessageDialog(
                this,
                "Actor not found.\n\n"
                + "Try:\n"
                + "Shah Rukh Khan\n"
                + "Deepika Padukone\n"
                + "Aamir Khan\n"
                + "Leonardo DiCaprio\n"
                + "Tom Hanks",
                "CineSphere AI",
                JOptionPane.INFORMATION_MESSAGE
        );

        return;
    }

    // Create the career analyzer
    CareerAnalyzer analyzer = new CareerAnalyzer();

    // Open the results dashboard
    ResultsScreen results =
            new ResultsScreen(actor, analyzer);

    results.setVisible(true);
});
        centerPanel.add(card);

        mainPanel.add(centerPanel, BorderLayout.CENTER);

        // ================= FOOTER =================

        JLabel footer = new JLabel(
                "Powered by Java • Data • AI Insights");

        footer.setForeground(new Color(100, 105, 120));
        footer.setFont(new Font(
                "Segoe UI", Font.PLAIN, 12));
        footer.setHorizontalAlignment(
                SwingConstants.CENTER);

        mainPanel.add(footer, BorderLayout.SOUTH);

        // Put main panel into window
        setContentPane(mainPanel);
    }

    // ================= MAIN METHOD =================

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            HomeScreen screen = new HomeScreen();
            screen.setVisible(true);
        });
    }
}
    

