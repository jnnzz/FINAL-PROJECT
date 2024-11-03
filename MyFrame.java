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


    MyFrame(){

        displaySingleButton();
        displayMultiplayerButton();
        displayTutorialButton();
        displayTitleLable();


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setBounds(650,200,600,700);
        this.setResizable(false);
        this.setVisible(true);
        this.add(singleButton);
        this.add(MultiplayerButton);
        this.add(TutorialButton);
        this.add(TitleLabel);


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
                }
        );
        singleButton.setText("Single Player");
        singleButton.setFocusable(false);
        singleButton.setFont(new Font("Comic sans",Font.BOLD,25));
        singleButton.setForeground(new Color(128, 0, 128));
        singleButton.setBackground(Color.WHITE);
        singleButton.setBorder(BorderFactory.createEtchedBorder());
        singleButton.addMouseListener(new MouseAdapter() {
            // On mouse hover, change color and cursor
            @Override
            public void mouseEntered(MouseEvent e) {
                singleButton.setBackground(Color.LIGHT_GRAY);
                singleButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            // On mouse exit, revert to original color and cursor
            @Override
            public void mouseExited(MouseEvent e) {
                singleButton.setBackground(Color.WHITE);
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
                 }
        );
        MultiplayerButton.setText("2 Player");
        MultiplayerButton.setFocusable(false);
        MultiplayerButton.setFont(new Font("Comic sans",Font.BOLD,25));
        MultiplayerButton.setForeground(new Color(128, 0, 128));
        MultiplayerButton.setBackground(Color.WHITE);
        MultiplayerButton.setBorder(BorderFactory.createEtchedBorder());
        MultiplayerButton.addMouseListener(new MouseAdapter() {
            // On mouse hover, change color and cursor
            @Override
            public void mouseEntered(MouseEvent e) {
                MultiplayerButton.setBackground(Color.LIGHT_GRAY);
                MultiplayerButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            // On mouse exit, revert to original color and cursor
            @Override
            public void mouseExited(MouseEvent e) {
                MultiplayerButton.setBackground(Color.WHITE);
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
        TutorialButton.setForeground(new Color(128, 0, 128));
        TutorialButton.setBackground(Color.WHITE);
        TutorialButton.setBorder(BorderFactory.createEtchedBorder());
        TutorialButton.addMouseListener(new MouseAdapter() {
            // On mouse hover, change color and cursor
            @Override
            public void mouseEntered(MouseEvent e) {
                TutorialButton.setBackground(Color.LIGHT_GRAY);
                TutorialButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            // On mouse exit, revert to original color and cursor
            @Override
            public void mouseExited(MouseEvent e) {
                TutorialButton.setBackground(Color.WHITE);
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
        TitleLabel.setForeground(Color.magenta);
    }

    private void showTutorial() {
        JOptionPane.showMessageDialog(this, "Welcome to the Quiz Game Tutorial!\n" +
                "Select Single Player or 2 Player mode to start the game.\n" +
                "Answer questions within the time limit.\n" +
                "Good luck and have fun!");
    }


}
