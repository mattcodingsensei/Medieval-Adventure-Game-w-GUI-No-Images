import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Main {
  // 1 lowest one
JFrame window;
  // 2 create title
JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
  // 3 create label 
JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;
  // font-family, font-style, font-size
Font titleFont = new Font("Lucida Calligraphy", Font.PLAIN, 42);
Font normalFont = new Font("Lucida Calligraphy", Font.PLAIN, 17);
JButton startButton, choice1, choice2, choice3, choice4;
JTextArea mainTextArea;

int playerHP, monsterHP, silverRing;
String weapon, position;

TitleScreenHandler tsHandler = new TitleScreenHandler();
ChoiceHandler choiceHandler = new ChoiceHandler();

public static void main(String[] args) {
    //new Game();
    Main game;
    game = new Main();
}

public Main(){
    // initialize JFrame
    window = new JFrame();
    // set window size, width, height
    window.setSize(800, 600);
    // adds function to close the window
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.getContentPane().setBackground(Color.black);
    // create a custom layout
    window.setLayout(null);
    window.getContentPane();

    titleNamePanel = new JPanel();
    // x, y, width, height. Sets 'padding'
    titleNamePanel.setBounds(60, 80, 400, 150);
    titleNamePanel.setBackground(Color.black);
    titleNameLabel = new JLabel("ADVENTURE GAME");
    // text color
    titleNameLabel.setForeground(Color.white);
    titleNameLabel.setFont(titleFont);

    startButtonPanel = new JPanel();
    startButtonPanel.setBounds(175, 250, 200, 100);
    startButtonPanel.setBackground(Color.black);

    startButton = new JButton("START");
    // background is color of button
    startButton.setBackground(Color.black);
    // foreground is color of text
    startButton.setForeground(Color.black);
    startButton.setFont(normalFont);
    startButton.addActionListener(tsHandler);
    // removes annoying little box
    startButton.setFocusPainted(false);

    titleNamePanel.add(titleNameLabel);
    startButtonPanel.add(startButton);

    window.add(titleNamePanel);
    window.add(startButtonPanel);
    // need to make appear
    window.setVisible(true);
}

public void createGameScreen(){

    titleNamePanel.setVisible(false);
    startButtonPanel.setVisible(false);

    mainTextPanel = new JPanel();
    mainTextPanel.setBounds(60, 100, 400, 175);
    mainTextPanel.setBackground(Color.black);
    window.add(mainTextPanel);

    mainTextArea = new JTextArea();
    mainTextArea.setBounds(100, 100, 400, 175);
    mainTextArea.setBackground(Color.black);
    mainTextArea.setForeground(Color.white);
    mainTextArea.setFont(normalFont);
    // in case texts too long, 
    mainTextArea.setLineWrap(true);
    mainTextPanel.add(mainTextArea);

    choiceButtonPanel = new JPanel();
    choiceButtonPanel.setBounds(125, 275, 300, 100);
    choiceButtonPanel.setBackground(Color.black);
    // vertical 4, horizontal 1 button
    choiceButtonPanel.setLayout(new GridLayout(4, 1));
    window.add(choiceButtonPanel);

    choice1 = new JButton("Choice 1");
    choice1.setBackground(Color.black);
    choice1.setForeground(Color.black);
    choice1.setFont(normalFont);
    choice1.setFocusPainted(false);
    choice1.addActionListener(choiceHandler);
    choice1.setActionCommand("c1");
    choiceButtonPanel.add(choice1);

    choice2 = new JButton("Choice 2");
    choice2.setBackground(Color.black);
    choice2.setForeground(Color.black);
    choice2.setFont(normalFont);
    choice2.setFocusPainted(false);
    choice2.addActionListener(choiceHandler);
    choice2.setActionCommand("c2");
    choiceButtonPanel.add(choice2);

    choice3 = new JButton("Choice 3");
    choice3.setBackground(Color.black);
    choice3.setForeground(Color.black);
    choice3.setFont(normalFont);
    choice3.setFocusPainted(false);
    choice3.addActionListener(choiceHandler);
    choice3.setActionCommand("c3");
    choiceButtonPanel.add(choice3);

    choice4 = new JButton("Choice 4");
    choice4.setBackground(Color.black);
    choice4.setForeground(Color.black);
    choice4.setFont(normalFont);
    choice4.setFocusPainted(false);
    choice4.addActionListener(choiceHandler);
    choice4.setActionCommand("c4");
    choiceButtonPanel.add(choice4);

    playerPanel = new JPanel();
    playerPanel.setBounds(60, 15, 400, 50);
    playerPanel.setBackground(Color.black);
    playerPanel.setLayout(new GridLayout(1,4));
    window.add(playerPanel);

    hpLabel = new JLabel("HP:");
    hpLabel.setFont(normalFont);
    hpLabel.setForeground(Color.black);
    playerPanel.add(hpLabel);
    hpLabelNumber = new JLabel();
    hpLabelNumber.setFont(normalFont);
    hpLabelNumber.setForeground(Color.black);
    playerPanel.add(hpLabelNumber);
    weaponLabel = new JLabel("Weapon:");
    weaponLabel.setFont(normalFont);
    weaponLabel.setForeground(Color.black);
    playerPanel.add(weaponLabel);
    weaponLabelName = new JLabel();
    weaponLabelName.setFont(normalFont);
    weaponLabelName.setForeground(Color.black);
    playerPanel.add(weaponLabelName);

    playerSetup();

}

public void playerSetup(){
		playerHP = 15;
		monsterHP = 20;
		weapon = "Knife";
		weaponLabelName.setText(weapon);
		hpLabelNumber.setText("" + playerHP);
		
		townGate();
	}
	public void townGate(){
		position = "townGate";
		mainTextArea.setText("You are at the gate of the town. \nA guard is standing in front of you. \n\nWhat do you do?");		
		choice1.setText("Talk to the guard");
		choice2.setText("Attack the guard");
		choice3.setText("Leave");
		choice4.setText("");
	}
	public void talkGuard(){
		position = "talkGuard";
		mainTextArea.setText("Guard: Hello stranger. I have never seen your face. \nI'm sorry but we cannot let a stranger enter our town.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void attackGuard(){
		position = "attackGuard";
		mainTextArea.setText("Guard: Hey don't be stupid!\n\nThe guard fought back and hit you hard.\n(You receive 3 damage)");
		playerHP = playerHP -3;
		hpLabelNumber.setText(""+playerHP);
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void crossRoad(){
		position = "crossRoad";
		mainTextArea.setText("You are at a crossroad.\nIf you go south, you will go back to the town.");
		choice1.setText("Go north");
		choice2.setText("Go east");
		choice3.setText("Go south");
		choice4.setText("Go west");
	}
	public void north(){
		position = "north";
		mainTextArea.setText("There is a river. \nYou drink the water and rest at the riverside. \n\n(Your HP is recovered by 2)");
		playerHP = playerHP + 2;
		hpLabelNumber.setText(""+playerHP);
		choice1.setText("Go south");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");		
	}
	public void east(){
		position = "east";
		mainTextArea.setText("You walked into a forest and found a Long Sword!\n\n(You obtained a Long Sword)");
		weapon = "Long Sword";
		weaponLabelName.setText(weapon);
		choice1.setText("Go west");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		
	}
	public void west(){
		position = "west";
		mainTextArea.setText("You encounter a goblin!");
		choice1.setText("Fight");
		choice2.setText("Run");
		choice3.setText("");
		choice4.setText("");
	}
	public void fight(){
		position = "fight";
		mainTextArea.setText("Monter HP: " + monsterHP + "\n\nWhat do you do?");
		choice1.setText("Attack");
		choice2.setText("Run");
		choice3.setText("");
		choice4.setText("");
	}
	public void playerAttack(){
		position = "playerAttack";
		
		int playerDamage = 0;
		
		if(weapon.equals("Knife")){
			playerDamage = new java.util.Random().nextInt(3);
		}
		else if(weapon.equals("Long Sword")){
			playerDamage = new java.util.Random().nextInt(12); 
		}
		
		mainTextArea.setText("You attacked the monster and gave " + playerDamage + " damage!");
		
		monsterHP = monsterHP - playerDamage;
		
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");		
	}
	public void monsterAttack(){
		position = "monsterAttack";
		
		int monsterDamage = 0;
		
		monsterDamage = new java.util.Random().nextInt(6); 
		
		mainTextArea.setText("The monster attacked you and gave " + monsterDamage + " damage!");
		
		playerHP = playerHP - monsterDamage;
		hpLabelNumber.setText(""+playerHP);
		
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");	
	}
	public void win(){
		position = "win";
		
		mainTextArea.setText("You defeated the monster!\nThe monster dropped a ring!\n\n(You obtained a Silver Ring)");
		
		silverRing = 1;
		
		choice1.setText("Go east");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		
	}
	public void lose(){
		position = "lose";
		
		mainTextArea.setText("You are dead!\n\n");
		
		choice1.setText("");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		choice1.setVisible(false);
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	public void ending(){
		position = "ending";
		
		mainTextArea.setText("Guard: Oh you killed that goblin!?\nThank you so much. You are true hero!\nWelcome to our town!\n\n");
		
		choice1.setText("");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		choice1.setVisible(false);
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
	}



	
	
	
		
	
	
	
	public class TitleScreenHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			
			createGameScreen();
		}
	}
	public class ChoiceHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			
			String yourChoice = event.getActionCommand();
			
			switch(position){
			case "townGate":
				switch(yourChoice){
				case "c1": 
					if(silverRing==1){
						ending();
					}
					else{
						talkGuard();
					}
					break;
				case "c2": attackGuard();break;
				case "c3": crossRoad();break;
				}
				break;
			case "talkGuard":
				switch(yourChoice){
				case "c1": townGate(); break;
				}
				break;
			case "attackGuard":
				switch(yourChoice){
				case "c1": townGate(); break;
				}
				break;
			case "crossRoad":
				switch(yourChoice){
				case "c1": north(); break;
				case "c2": east();break;
				case "c3": townGate(); break;
				case "c4": west();break;
				}
				break;
			case "north":
				switch(yourChoice){
				case "c1": crossRoad(); break;
				}
				break;
			case "east":
				switch(yourChoice){
				case "c1": crossRoad(); break;
				}
				break;
			case "west":
				switch(yourChoice){
				case "c1": fight(); break;
				case "c2": crossRoad(); break;
				}
				break;
			case "fight":
				switch(yourChoice){
				case "c1": playerAttack();break;
				case "c2": crossRoad(); break;
				}
				break;
			case "playerAttack":
				switch(yourChoice){
				case "c1": 
					if(monsterHP<1){
						win();
					}
					else{
						monsterAttack();
					}
					break;
				}
				break;
			case "monsterAttack":
				switch(yourChoice){
				case "c1": 
					if(playerHP<1){
						lose();
					}
					else{
						fight();
					}
					break;
				}
				break;
			case "win":
				switch(yourChoice){
				case "c1": crossRoad();
				}
				break;
				
			}
			
			
		}
	}



}