import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyFrame extends JFrame  {

    JButton singleButton = new JButton();
    JButton MultiplayerButton = new JButton();
    JButton TutorialButton = new JButton();
    JLabel TitleLabel = new JLabel();
    JButton StartButton = new JButton("Start");
    JButton BackButton = new JButton("Back");


    MyFrame(){

        displaySingleButton();
        displayMultiplayerButton();
        displayTutorialButton();
        displayTitleLable();
        startButton();
        backButton();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.decode("#D6F5FF"));
        this.setLayout(null);
        this.setBounds(650,200,600,700);
        this.setResizable(false);
        this.setVisible(true);
        this.add(singleButton);
        this.add(MultiplayerButton);
        this.add(TutorialButton);
        this.add(TitleLabel);
        this.add(StartButton);
        this.add(BackButton);
    }

//methods
    //single player button
    public void displaySingleButton(){
        singleButton.setBounds(170,200,250,100);
        singleButton.addActionListener(
                (e) -> {
                    System.out.println("Single Player selected");
                    singleButton.setVisible(false);
                    MultiplayerButton.setVisible(false);
                    TutorialButton.setVisible(false);
                    TitleLabel.setVisible(false);
                    StartButton.setVisible(true);
                    BackButton.setVisible(true);
                }
        );
        singleButton.setText("Single Player");
        singleButton.setFocusable(false);
        singleButton.setFont(new Font("Comic sans",Font.BOLD,25));
        singleButton.setForeground(Color.decode("#005C7A"));
        singleButton.setBackground(Color.decode("#ADEBFF"));
        singleButton.setBorder(BorderFactory.createEtchedBorder());
        singleButton.addMouseListener(new MouseAdapter() {
            // On mouse hover, change color and cursor
            @Override
            public void mouseEntered(MouseEvent e) {
                singleButton.setBackground(Color.decode("#85E0FF"));
                singleButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            // On mouse exit, revert to original color and cursor
            @Override
            public void mouseExited(MouseEvent e) {
                singleButton.setBackground(Color.decode("#ADEBFF"));
                singleButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

    }

    //2player button
    public void displayMultiplayerButton(){
        MultiplayerButton.setBounds(170,300,250,100);
        MultiplayerButton.addActionListener(
                (e) -> {
                        System.out.println("2 Player selected");
                        singleButton.setVisible(false);
                        MultiplayerButton.setVisible(false);
                        TutorialButton.setVisible(false);
                        TitleLabel.setVisible(false);
                        StartButton.setVisible(true);
                        BackButton.setVisible(true);
                 }
        );
        MultiplayerButton.setText("2 Player");
        MultiplayerButton.setFocusable(false);
        MultiplayerButton.setFont(new Font("Comic sans",Font.BOLD,25));
        MultiplayerButton.setForeground(Color.decode("#005C7A"));
        MultiplayerButton.setBackground(Color.decode("#ADEBFF"));
        MultiplayerButton.setBorder(BorderFactory.createEtchedBorder());
        MultiplayerButton.addMouseListener(new MouseAdapter() {
            // On mouse hover, change color and cursor
            @Override
            public void mouseEntered(MouseEvent e) {
                MultiplayerButton.setBackground(Color.decode("#85E0FF"));
                MultiplayerButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            // On mouse exit, revert to original color and cursor
            @Override
            public void mouseExited(MouseEvent e) {
                MultiplayerButton.setBackground(Color.decode("#ADEBFF"));
                MultiplayerButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

    }

    //tutorial button
    public void displayTutorialButton(){
        TutorialButton.setBounds(170,400,250,100);
        TutorialButton.addActionListener(
                (e) -> {
                    System.out.println("Tutorial selected");
                    showTutorial();

                }
        );
        TutorialButton.setText("Tutorial");
        TutorialButton.setFocusable(false);
        TutorialButton.setFont(new Font("Comic sans",Font.BOLD,25));
        TutorialButton.setForeground(Color.decode("#005C7A"));
        TutorialButton.setBackground(Color.decode("#ADEBFF"));
        TutorialButton.setBorder(BorderFactory.createEtchedBorder());
        TutorialButton.addMouseListener(new MouseAdapter() {
            // On mouse hover, change color and cursor
            @Override
            public void mouseEntered(MouseEvent e) {
                TutorialButton.setBackground(Color.decode("#85E0FF"));
                TutorialButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            // On mouse exit, revert to original color and cursor
            @Override
            public void mouseExited(MouseEvent e) {
                TutorialButton.setBackground(Color.decode("#ADEBFF"));
                TutorialButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

    }

    public void displayTitleLable(){
        TitleLabel.setText("General Quiz Game");
        TitleLabel.setBounds(20,70,550,100);
        TitleLabel.setBackground(Color.BLACK);
        TitleLabel.setOpaque(false);
        TitleLabel.setFont(new Font("MV Boli", Font.ITALIC,60));
        TitleLabel.setForeground(Color.decode("#0099CC"));
    }

    private void showTutorial() {
        JOptionPane.showMessageDialog(this, "Welcome to the Quiz Game Tutorial!\n" +
                "Select Single Player or 2 Player mode to start the game.\n" +
                "Answer questions within the time limit.\n" +
                "Good luck and have fun!");
    }
//START AND BACK BUTTON
    public void startButton(){
        StartButton.setVisible(false);
        StartButton.setBounds(170,200,250,100);
        StartButton.addActionListener(
                (e) -> {
                    System.out.printf("Start button selected");
                    StartButton.setVisible(false);
                    BackButton.setVisible(false);
                }
        );
        StartButton.setFocusable(false);
        StartButton.setFont(new Font("Comic sans",Font.BOLD,25));
        StartButton.setForeground(Color.decode("#005C7A"));
        StartButton.setBackground(Color.decode("#ADEBFF"));
        StartButton.setBorder(BorderFactory.createEtchedBorder());
        StartButton.addMouseListener(new MouseAdapter() {
            // On mouse hover, change color and cursor
            @Override
            public void mouseEntered(MouseEvent e) {
                StartButton.setBackground(Color.decode("#85E0FF"));
                StartButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            // On mouse exit, revert to original color and cursor
            @Override
            public void mouseExited(MouseEvent e) {
                StartButton.setBackground(Color.decode("#ADEBFF"));
                StartButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
    }

    public void backButton(){
        BackButton.setVisible(false);
        BackButton.setBounds(170,300,250,100);
        BackButton.addActionListener(
                (e) -> {
                    System.out.println("Back Button selected");
                    singleButton.setVisible(true);
                    MultiplayerButton.setVisible(true);
                    TutorialButton.setVisible(true);
                    TitleLabel.setVisible(true);
                    StartButton.setVisible(false);
                    BackButton.setVisible(false);
                }
        );
        BackButton.setFocusable(false);
        BackButton.setFont(new Font("Comic sans",Font.BOLD,25));
        BackButton.setForeground(Color.decode("#005C7A"));
        BackButton.setBackground(Color.decode("#ADEBFF"));
        BackButton.setBorder(BorderFactory.createEtchedBorder());
        BackButton.addMouseListener(new MouseAdapter() {
            // On mouse hover, change color and cursor
            @Override
            public void mouseEntered(MouseEvent e) {
                BackButton.setBackground(Color.decode("#85E0FF"));
                BackButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            // On mouse exit, revert to original color and cursor
            @Override
            public void mouseExited(MouseEvent e) {
                BackButton.setBackground(Color.decode("#ADEBFF"));
                BackButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
    }


}
