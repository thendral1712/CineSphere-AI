package com.mycompany.cinesphereai;

import javax.swing.*;
import java.awt.*;

public class ResultsScreen extends JFrame {

    public ResultsScreen(Actor actor, CareerAnalyzer analyzer) {

        setTitle("CineSphere AI - Career Analysis");
        setSize(950, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        Color background = new Color(12, 14, 24);
        Color cardColor = new Color(25, 28, 43);
        Color purple = new Color(90, 60, 170);
        Color lightText = new Color(220, 225, 235);
        Color mutedText = new Color(165, 170, 185);

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(background);
        mainPanel.setLayout(new BorderLayout());

        // =========================
        // HEADER
        // =========================

        JPanel header = new JPanel();
        header.setBackground(background);
        header.setLayout(new BoxLayout(header, BoxLayout.Y_AXIS));

        JLabel logo = new JLabel("✦ CINESPHERE AI ✦");
        logo.setForeground(Color.WHITE);
        logo.setFont(new Font("Segoe UI", Font.BOLD, 30));
        logo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel actorName = new JLabel(
                actor.getActorName().toUpperCase()
        );
        actorName.setForeground(new Color(190, 170, 255));
        actorName.setFont(new Font("Segoe UI", Font.BOLD, 22));
        actorName.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitle = new JLabel("ACTOR CAREER ANALYSIS");
        subtitle.setForeground(mutedText);
        subtitle.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        header.add(Box.createVerticalStrut(20));
        header.add(logo);
        header.add(Box.createVerticalStrut(8));
        header.add(actorName);
        header.add(Box.createVerticalStrut(5));
        header.add(subtitle);
        header.add(Box.createVerticalStrut(20));

        mainPanel.add(header, BorderLayout.NORTH);

        // =========================
        // STATISTICS
        // =========================

        JPanel statsPanel = new JPanel();
        statsPanel.setBackground(background);
        statsPanel.setLayout(
                new GridLayout(1, 5, 12, 0)
        );

        int totalMovies = analyzer.getTotalMovies(actor);
        double averageRating = analyzer.getAverageRating(actor);
        int totalAwards = analyzer.getTotalAwards(actor);
        Movie topMovie = analyzer.getTopRatedMovie(actor);
        int careerScore = analyzer.getCareerScore(actor);
        String careerVerdict = analyzer.getCareerVerdict(actor);

        statsPanel.add(
                createStatCard(
                        "🎬",
                        String.valueOf(totalMovies),
                        "TOTAL MOVIES",
                        cardColor,
                        lightText,
                        mutedText,
                        purple
                )
        );

        statsPanel.add(
                createStatCard(
                        "⭐",
                        String.format("%.2f", averageRating),
                        "AVERAGE RATING",
                        cardColor,
                        lightText,
                        mutedText,
                        purple
                )
        );

        statsPanel.add(
                createStatCard(
                        "🏆",
                        String.valueOf(totalAwards),
                        "TOTAL AWARDS",
                        cardColor,
                        lightText,
                        mutedText,
                        purple
                )
        );

        statsPanel.add(
                createStatCard(
                        "🔥",
                        String.valueOf(topMovie.getRating()),
                        "TOP RATING",
                        cardColor,
                        lightText,
                        mutedText,
                        purple
                )
        );
        statsPanel.add(createStatCard(
        "💎", String.valueOf(careerScore) + " / 100", "CAREER SCORE",
        cardColor, lightText, mutedText, purple));

        JPanel center = new JPanel();
        center.setBackground(background);
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));

        center.add(statsPanel);
        center.add(Box.createVerticalStrut(15));

        // =========================
        // AI INSIGHT
        // =========================

        JPanel insightCard = new JPanel();
        insightCard.setBackground(cardColor);
        insightCard.setLayout(new BorderLayout());
        insightCard.setBorder(
                BorderFactory.createEmptyBorder(12, 20, 12, 20)
        );

        JLabel insightTitle = new JLabel(
                "🤖  AI CAREER INSIGHT"
        );
        insightTitle.setForeground(Color.WHITE);
        insightTitle.setFont(
                new Font("Segoe UI", Font.BOLD, 15)
        );

        JLabel insight = new JLabel(
                "<html>" + analyzer.getAIInsight(actor) + "</html>"
        );
        JLabel verdict = new JLabel(
        "Career Verdict: " + careerVerdict);
verdict.setForeground(new Color(190, 170, 255));
verdict.setFont(new Font("Segoe UI", Font.BOLD, 13));
        insight.setForeground(lightText);
        insight.setFont(
                new Font("Segoe UI", Font.PLAIN, 13)
        );

        insightCard.add(insightTitle, BorderLayout.NORTH);
        insightCard.add(insight, BorderLayout.CENTER);
        insightCard.add(verdict, BorderLayout.SOUTH);

        center.add(insightCard);
        center.add(Box.createVerticalStrut(15));

        // =========================
        // MOVIE PORTFOLIO
        // =========================

        JLabel movieTitle = new JLabel(
                "MOVIE PORTFOLIO"
        );
        movieTitle.setForeground(Color.WHITE);
        movieTitle.setFont(
                new Font("Segoe UI", Font.BOLD, 18)
        );
        movieTitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        center.add(movieTitle);
        center.add(Box.createVerticalStrut(10));

        JPanel moviePanel = new JPanel();
        moviePanel.setBackground(background);
        moviePanel.setLayout(
                new GridLayout(1, actor.getMovies().size(), 12, 0)
        );

        for (Movie movie : actor.getMovies()) {

            JPanel movieCard = new JPanel();
            movieCard.setBackground(cardColor);
            movieCard.setLayout(
                    new BoxLayout(movieCard, BoxLayout.Y_AXIS)
            );

            movieCard.setBorder(
                    BorderFactory.createEmptyBorder(
                            12, 12, 12, 12
                    )
            );

            JLabel name = new JLabel(
                    movie.getMovieName()
            );
            name.setForeground(Color.WHITE);
            name.setFont(
                    new Font("Segoe UI", Font.BOLD, 14)
            );
            name.setAlignmentX(Component.CENTER_ALIGNMENT);

            JLabel role = new JLabel(
                    "Role: " + movie.getRole()
            );
            role.setForeground(mutedText);
            role.setFont(
                    new Font("Segoe UI", Font.PLAIN, 11)
            );
            role.setAlignmentX(Component.CENTER_ALIGNMENT);

            JLabel rating = new JLabel(
                    "⭐ " + movie.getRating()
            );
            rating.setForeground(
                    new Color(255, 210, 100)
            );
            rating.setFont(
                    new Font("Segoe UI", Font.BOLD, 13)
            );
            rating.setAlignmentX(Component.CENTER_ALIGNMENT);

            JLabel year = new JLabel(
                    String.valueOf(movie.getReleaseYear())
            );
            year.setForeground(mutedText);
            year.setFont(
                    new Font("Segoe UI", Font.PLAIN, 11)
            );
            year.setAlignmentX(Component.CENTER_ALIGNMENT);

            movieCard.add(name);
            movieCard.add(Box.createVerticalStrut(8));
            movieCard.add(role);
            movieCard.add(Box.createVerticalStrut(8));
            movieCard.add(rating);
            movieCard.add(Box.createVerticalStrut(5));
            movieCard.add(year);

            moviePanel.add(movieCard);
        }

        center.add(moviePanel);
        center.add(moviePanel);

// BACK BUTTON
JButton backButton = new JButton("← ANALYZE ANOTHER ACTOR");

backButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
backButton.setForeground(Color.WHITE);
backButton.setBackground(new Color(90, 60, 170));
backButton.setFocusPainted(false);
backButton.setBorder(
        BorderFactory.createEmptyBorder(10, 20, 10, 20));
backButton.setAlignmentX(Component.CENTER_ALIGNMENT);

backButton.addActionListener(e -> {
    dispose();
});

center.add(Box.createVerticalStrut(10));
center.add(backButton);

mainPanel.add(center, BorderLayout.CENTER);

// FOOTER

        mainPanel.add(center, BorderLayout.CENTER);
        

        // =========================
        // FOOTER
        // =========================

        JLabel footer = new JLabel(
                "CineSphere AI  •  Actor Career Intelligence"
        );
        footer.setForeground(
                new Color(100, 105, 120)
        );
        footer.setFont(
                new Font("Segoe UI", Font.PLAIN, 11)
        );
        footer.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        mainPanel.add(footer, BorderLayout.SOUTH);

        setContentPane(mainPanel);
    }


    // =========================
    // STAT CARD METHOD
    // =========================

    private JPanel createStatCard(
            String icon,
            String value,
            String title,
            Color cardColor,
            Color lightText,
            Color mutedText,
            Color purple) {

        JPanel card = new JPanel();

        card.setBackground(cardColor);

        card.setLayout(
                new BoxLayout(card, BoxLayout.Y_AXIS)
        );

        card.setBorder(
                BorderFactory.createEmptyBorder(
                        10, 10, 10, 10
                )
        );

        JLabel iconLabel = new JLabel(icon);
        iconLabel.setFont(
                new Font("Segoe UI Emoji", Font.PLAIN, 20)
        );
        iconLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel valueLabel = new JLabel(value);
        valueLabel.setForeground(Color.WHITE);
        valueLabel.setFont(
                new Font("Segoe UI", Font.BOLD, 22)
        );
        valueLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel titleLabel = new JLabel(title);
        titleLabel.setForeground(mutedText);
        titleLabel.setFont(
                new Font("Segoe UI", Font.PLAIN, 10)
        );
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        card.add(iconLabel);
        card.add(Box.createVerticalStrut(3));
        card.add(valueLabel);
        card.add(Box.createVerticalStrut(3));
        card.add(titleLabel);

        return card;
    }
}
