import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class QuizGameGUI extends JFrame {
    private int player1Score = 0;
    private int player2Score = 0;
    private JLabel questionLabel, timerLabel, player1ScoreLabel, player2ScoreLabel;
    private JButton[] player1Options, player2Options;
    private String correctAnswer;
    private Timer timer;
    private int timeRemaining = 60; // 60 seconds for the game

    private String[][] questions = {
            {"What is the capital of France?", "Paris", "Rome", "Berlin"},
            {"Who wrote 'Hamlet'?", "Shakespeare", "Hemingway", "Tolkien"},
            {"What is the largest planet?", "Jupiter", "Mars", "Earth"},
            {"What is the boiling point of water?", "100°C", "50°C", "200°C"},
            {"What color are bananas?", "Yellow", "Green", "Red"}
    };

    public QuizGameGUI() {
        setTitle("General Quiz Game");
        this.setBounds(650,200,600,700);
        this.getContentPane().setBackground(Color.decode("#D6F5FF"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new GridLayout(1, 3));
        player1ScoreLabel = new JLabel("Player 1 Score: 0", SwingConstants.CENTER);
        timerLabel = new JLabel("Time: 60", SwingConstants.CENTER);
        player2ScoreLabel = new JLabel("Player 2 Score: 0", SwingConstants.CENTER);
        topPanel.add(player1ScoreLabel);
        topPanel.add(timerLabel);
        topPanel.add(player2ScoreLabel);
        add(topPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        questionLabel = new JLabel("Question: ");
        questionLabel.setFont(new Font("Comic Sans", Font.BOLD, 24));
        centerPanel.add(questionLabel);
        add(centerPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new GridLayout(2, 3, 10, 10));

        player1Options = new JButton[3];
        for (int i = 0; i < 3; i++) {
            player1Options[i] = new JButton();
            player1Options[i].setFont(new Font("Comic Sans", Font.BOLD, 20));
            player1Options[i].addActionListener(new Player1AnswerListener());
            bottomPanel.add(player1Options[i]);
        }

        player2Options = new JButton[3];
        for (int i = 0; i < 3; i++) {
            player2Options[i] = new JButton();
            player2Options[i].setFont(new Font("Comic Sans", Font.BOLD, 20));
            player2Options[i].addActionListener(new Player2AnswerListener());
            bottomPanel.add(player2Options[i]);
        }

        add(bottomPanel, BorderLayout.SOUTH);

        // Add key bindings for Player 1
        addKeyBinding(player1Options[0], "A", new Player1AnswerListener(), 0);
        addKeyBinding(player1Options[1], "S", new Player1AnswerListener(), 1);
        addKeyBinding(player1Options[2], "D", new Player1AnswerListener(), 2);

        // Add key bindings for Player 2
        addKeyBinding(player2Options[0], "J", new Player2AnswerListener(), 0);
        addKeyBinding(player2Options[1], "K", new Player2AnswerListener(), 1);
        addKeyBinding(player2Options[2], "L", new Player2AnswerListener(), 2);


        generateNewQuestion();

        //TIMER
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeRemaining--;
                timerLabel.setText("Time: " + timeRemaining);
                if (timeRemaining <= 0) {
                    timer.stop();
                    JOptionPane.showMessageDialog(QuizGameGUI.this, "Time's up! Final Scores:\nPlayer 1: "
                            + player1Score + "\nPlayer 2: " + player2Score);
                    resetGame();
                }
            }
        });
        timer.start();
    }

    //KANI QUESTIONS
    private void generateNewQuestion() {
        int questionIndex = new Random().nextInt(questions.length);
        String[] selectedQuestion = questions[questionIndex];
        questionLabel.setText(selectedQuestion[0]);
        correctAnswer = selectedQuestion[1];

        String[] options = {selectedQuestion[1], selectedQuestion[2], selectedQuestion[3]};
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            int randomIndex = random.nextInt(3);
            String temp = options[i];
            options[i] = options[randomIndex];
            options[randomIndex] = temp;
        }

        for (int i = 0; i < 3; i++) {
            player1Options[i].setText(options[i]);
            player2Options[i].setText(options[i]);
        }
    }

    private void addKeyBinding(JButton button, String key, ActionListener action, int index) {
        InputMap im = button.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap am = button.getActionMap();

        im.put(KeyStroke.getKeyStroke(key), key);
        am.put(key, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action.actionPerformed(new ActionEvent(button, ActionEvent.ACTION_PERFORMED, null));
            }
        });
    }

    private class Player1AnswerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            String selectedAnswer = source.getText();
            if (selectedAnswer.equals(correctAnswer)) {
                player1Score++;
                player1ScoreLabel.setText("Player 1 Score: " + player1Score);
                generateNewQuestion();
            }
        }
    }

    private class Player2AnswerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            String selectedAnswer = source.getText();
            if (selectedAnswer.equals(correctAnswer)) {
                player2Score++;
                player2ScoreLabel.setText("Player 2 Score: " + player2Score);
                generateNewQuestion();
            }
        }
    }

    private void resetGame() {
        player1Score = 0;
        player2Score = 0;
        timeRemaining = 60;
        player1ScoreLabel.setText("Player 1 Score: 0");
        player2ScoreLabel.setText("Player 2 Score: 0");
        timerLabel.setText("Time: 60");
        timer.start();
        generateNewQuestion();
    }


}
