import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class CPS implements ActionListener {

    int clicksCount = 0;
    int elapsedTime = 0;
    float result = 0;
    JButton startButton = new JButton();
    JButton stopButton = new JButton();
    JButton resetButton = new JButton();
    JFrame frame = new JFrame();
    JLabel timeLabel = new JLabel();
    JLabel resultlabel = new JLabel();
    JLabel iconLabel = new JLabel();
    JPanel topPanel = new JPanel();
    JPanel topPanel2 = new JPanel();


    CPS() {

        timeLabel.setText("Time: 0");
        timeLabel.setFont(new Font("Calibri", Font.PLAIN, 40));
        timeLabel.setVerticalAlignment(JLabel.BOTTOM);
        timeLabel.setHorizontalAlignment(JLabel.CENTER);

        resultlabel.setVisible(false);
        resultlabel.setFont(new Font("Calibri", Font.PLAIN, 40));
        resultlabel.setVerticalAlignment(JLabel.BOTTOM);
        resultlabel.setHorizontalAlignment(JLabel.CENTER);

        topPanel.setBounds(0,0,1000,75);
        topPanel.setLayout(new BorderLayout());
        
        topPanel2.setBounds(0,75,1000,75);
        topPanel2.setLayout(new BorderLayout());
        
        iconLabel.setBounds(450,610,80,80);

        startButton.addActionListener(this);
        startButton.setBounds(190, 200, 600, 400);
        startButton.setText("Clicks: 0");
        startButton.setFont(new Font("Calibri", Font.PLAIN, 60));
        startButton.setFocusable(false);

        stopButton.addActionListener(this);
        stopButton.setBounds(640,610,150,80);
        stopButton.setText("Stop");
        stopButton.setFont(new Font("Calibri", Font.PLAIN, 20));
        stopButton.setFocusable(false);

        resetButton.addActionListener(this);
        resetButton.setBounds(190,610,150,80);
        resetButton.setText("Reset");
        resetButton.setFont(new Font("Calibri", Font.PLAIN, 20));
        resetButton.setFocusable(false);

        ImageIcon icon = new ImageIcon("Images/Emojis/click.png");

        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,800);
        frame.setVisible(true);        
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setTitle("Clicks Per Second");
        frame.setIconImage(icon.getImage());
        frame.add(startButton);
        frame.add(topPanel);
        frame.add(topPanel2);
        frame.add(stopButton);
        frame.add(resetButton);
        frame.add(iconLabel);
        topPanel.add(timeLabel);
        topPanel2.add(resultlabel);

    }

    Timer timer = new Timer(1000, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            elapsedTime += 1000;
            updateTimeLabel();
        }
    });

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==startButton) {
            start();           
        } else if(e.getSource()==resetButton) {
            restart();
        } else if(e.getSource()==stopButton) {
            stop();
        }
    }

    public void updateTimeLabel() {
        String Stringseconds = String.valueOf((elapsedTime / 1000) % 60);
        timeLabel.setText("Time: " + Stringseconds);
        check();
    }

    public void start() {
        timer.start();
        clicksCount++;            
        startButton.setText("Clicks: " + clicksCount); 
    }

    public void stop() {
        timer.stop();
        startButton.setEnabled(false);
    }

    public void restart() {
        if (timer.isRunning()) {
            timer.stop();
            clicksCount = 0;
            elapsedTime = 0;
            startButton.setText("Clicks: " + clicksCount);
            resultlabel.setVisible(false);
            iconLabel.setVisible(false);
            updateTimeLabel();
        } else {
            clicksCount = 0;
            elapsedTime = 0;
            startButton.setEnabled(true);
            startButton.setText("Clicks: " + clicksCount);
            resultlabel.setVisible(false);
            iconLabel.setVisible(false);
            updateTimeLabel();
        }        
    }

    public void check() {
        if(elapsedTime == 5000) {
            stop();
            result = (float)clicksCount / 5F;
            resultlabel.setText(("CPS: ") + String.valueOf(result));
            if(result < 5) {
                ImageIcon sleepy = new ImageIcon("Images/Emojis/Sleeping_Emoji.png"); // load the image to a imageIcon
                Image image = sleepy.getImage(); // transform it 
                Image newimg = image.getScaledInstance(80, 80,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
                sleepy = new ImageIcon(newimg);  // transform it back
                iconLabel.setIcon(sleepy);
                iconLabel.setVisible(true);
            } else if(result >= 5 && result < 8 ) {
                ImageIcon serious = new ImageIcon("Images/Emojis/Serious_Emoji.png"); // load the image to a imageIcon
                Image image = serious.getImage(); // transform it 
                Image newimg = image.getScaledInstance(80, 80,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
                serious = new ImageIcon(newimg);  // transform it back
                iconLabel.setIcon(serious);
                iconLabel.setVisible(true);
            } else if(result >= 8 && result < 12) {
                ImageIcon surprised = new ImageIcon("Images/Emojis/Surprised_Emoji.png"); // load the image to a imageIcon
                Image image = surprised.getImage(); // transform it 
                Image newimg = image.getScaledInstance(80, 80,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
                surprised = new ImageIcon(newimg);  // transform it back
                iconLabel.setIcon(surprised);
                iconLabel.setVisible(true);
            } else if(result >= 12 &&  result < 16) {
                ImageIcon shocked = new ImageIcon("Images/Emojis/Shocked_Emoji.png"); // load the image to a imageIcon
                Image image = shocked.getImage(); // transform it 
                Image newimg = image.getScaledInstance(80, 80,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
                shocked = new ImageIcon(newimg);  // transform it back
                iconLabel.setIcon(shocked);
                iconLabel.setVisible(true);
            } else if(result >= 16 && result < 20) {
                ImageIcon monocle = new ImageIcon("Images/Emojis/Monocle_Emoji.png"); // load the image to a imageIcon
                Image image = monocle.getImage(); // transform it 
                Image newimg = image.getScaledInstance(80, 80,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
                monocle = new ImageIcon(newimg);  // transform it back
                iconLabel.setIcon(monocle);
                iconLabel.setVisible(true);
            } else {
                ImageIcon cursed = new ImageIcon("Images/Emojis/Cursed_Emoji.png"); // load the image to a imageIcon
                Image image = cursed.getImage(); // transform it 
                Image newimg = image.getScaledInstance(80, 80,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
                cursed = new ImageIcon(newimg);  // transform it back
                iconLabel.setIcon(cursed);
                iconLabel.setVisible(true);
            }
            resultlabel.setVisible(true);
        }            
    }
}