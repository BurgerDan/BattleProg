import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//Danny Young
//CSC 325 HW 8

public class BattleComponent
{
    private JFrame frame = new JFrame("Battle simulator");
    private JPanel panelOne = new JPanel();
    private JPanel panelTwo = new JPanel();
    private JPanel panelText = new JPanel();
    private JPanel panelCenter = new JPanel();
    private JTextArea area = new JTextArea();
    private JScrollPane scrollBar = new JScrollPane(area);
    private JLabel playOneName = new JLabel();
    private JLabel playTwoName = new JLabel();
    private JLabel playOneClass = new JLabel();
    private JLabel playTwoClass = new JLabel();
    private JLabel playOneRace = new JLabel();
    private JLabel playTwoRace = new JLabel();
    private JProgressBar playOneHealthBar;
    private JProgressBar playTwoHealthBar;
    private JButton fightButton = new JButton("Fight!");
    
    private GameRunnable run1 = new GameRunnable();
    private GameRunnable run2 = new GameRunnable();
    
    Characters playerOne = new Characters("Eragon", "Dragoon", "Human");
    Characters playerTwo = new Characters("Jaina", "Sorceror", "Half-Elf");
    
    public void setup()
    {
        
        playOneHealthBar = new JProgressBar(0, playerOne.getTotHealth());
        playTwoHealthBar = new JProgressBar(0, playerTwo.getTotHealth());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(1280,840);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());
        frame.setLayout(new BorderLayout());
        frame.setLayout(new BorderLayout());
        frame.add(panelOne, BorderLayout.WEST);
        frame.add(panelTwo, BorderLayout.EAST);
        frame.add(panelText, BorderLayout.SOUTH);
        frame.add(panelCenter, BorderLayout.CENTER);
        panelCenter.add(fightButton);
        panelOne.setLayout(new BoxLayout(panelOne, BoxLayout.Y_AXIS));
        panelTwo.setLayout(new BoxLayout(panelTwo, BoxLayout.Y_AXIS));
        //area.setPreferredSize(new Dimension(900, 300));
        playOneName.setText(playerOne.getName());
        playOneRace.setText(playerOne.getRace());
        playOneClass.setText(playerOne.getJob());
        playTwoName.setText(playerTwo.getName());
        playTwoRace.setText(playerTwo.getRace());
        playTwoClass.setText(playerTwo.getJob());
        panelOne.add(playOneName);
        panelOne.add(playOneRace);
        panelOne.add(playOneClass);
        panelOne.add(playOneHealthBar);
        panelTwo.add(playTwoName);
        panelTwo.add(playTwoRace);
        panelTwo.add(playTwoClass);
        panelTwo.add(playTwoHealthBar);
        playOneHealthBar.setBackground(Color.BLACK);
        playOneHealthBar.setForeground(Color.RED);
        playOneHealthBar.setValue(playerOne.getTotHealth());
        playTwoHealthBar.setBackground(Color.BLACK);
        playTwoHealthBar.setForeground(Color.RED);
        playTwoHealthBar.setValue(playerTwo.getTotHealth());
        scrollBar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollBar.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollBar.setVisible(true);
        scrollBar.setPreferredSize(new Dimension(600,300));
        panelText.add(scrollBar);
        
        fightButton.addActionListener(new FightButton());
    }
    public BattleComponent()
    {
        setup();
    }
    public static void main(String [] args)
    {
        BattleComponent game = new BattleComponent();
        
    }
    public void fight()
    {
        int healthNow1 = playerOne.getHealth() - run1.damageDone();
        int healthNow2 = playerTwo.getHealth() - run1.damageDone();
        
        playerOne.setHealth(healthNow1);
        playerTwo.setHealth(healthNow2);
        
        playOneHealthBar.setValue(healthNow1);
        playTwoHealthBar.setValue(healthNow2);
        victory();
    }
    public String playName(Characters d)
    {
        return d.getName();
    }
    public String status(Characters p)
    {
        return p.getName() + " has " + p.getHealth() + " left!";
    }
    public void victory()
    {
        if(playerTwo.getHealth() == 0)
        {
            area.append("\n " + playerOne.getName() + " WINS!");
            fightButton.setEnabled(false);
        }
        else if(playerOne.getHealth() == 0)
        {
            area.append("\n " + playerTwo.getName() + " WINS!");
            fightButton.setEnabled(false);
        }
        else
            area.append(" \n The battle continues!");
    }
    
    public class FightButton implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            run1.run();
            area.append("\n" + playName(playerOne) + " " + run1.combat() +  " " + status(playerTwo));
            
            run2.run();
            area.append("\n" + playName(playerTwo) + " " + run2.combat()+ " " + status(playerOne));
            fight();
        }
    }
}
