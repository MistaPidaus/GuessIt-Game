import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuessIt extends JFrame {
	private JTextField enterTxt;
	private JLabel itsOutput2;
	private JLabel itsOutput;
	private int thisNumber;		//This is number variable
	private int numberTries = 0;
	
	public void guessIt(){ //method to check the guess
		//get user guess
		String guessTxt = enterTxt.getText();
		String message = "";
		
		try {
			
			
			int guess = Integer.parseInt(guessTxt);
			numberTries++;
			//if its too high?
			if (guess > thisNumber)
			{
				message = guess + " is too high! Try again.";
				itsOutput.setText(message);
			}
			//if its too low?
			else if (guess < thisNumber )
			{
				message = guess + " is too low! Try again.";
				itsOutput.setText(message);
			}
			else
			{
				message = guess + " is correct! Congratulations! It tooks " + numberTries + " of tries!";
				itsOutput.setText(message);
				itsOutput2.setText("Let's play again!");
				newGuess();
			}
		}
		//Handle any error exception! (Important!)
		catch (Exception e){
			message = "Please enter a whole number 1 - 100! >;(";
			itsOutput.setText(message);
	}
		finally {
			//Select all function in textbox
			enterTxt.requestFocus();
			enterTxt.selectAll();
		}
	}
	
	public void newGuess(){ //New random number
		
		thisNumber = (int)(Math.random() * 100 + 1);
		
	}
	
	public GuessIt() {
		setTitle("GuessIt Game");
		getContentPane().setBackground(new Color(0, 204, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel titleGame = new JLabel("GuessIt Game ");
		titleGame.setBounds(0, 11, 434, 28);
		titleGame.setForeground(Color.BLACK);
		titleGame.setFont(new Font("Tahoma", Font.BOLD, 23));
		titleGame.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(titleGame);
		
		JLabel ccDev = new JLabel("Created by Mista Pidaus");
		ccDev.setBounds(0, 247, 434, 14);
		ccDev.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(ccDev);
		
		JLabel theGreets = new JLabel("Welcome to GuessIt Game!");
		theGreets.setHorizontalAlignment(SwingConstants.CENTER);
		theGreets.setFont(new Font("Tahoma", Font.PLAIN, 12));
		theGreets.setBounds(137, 65, 166, 28);
		getContentPane().add(theGreets);
		
		JLabel guessIt = new JLabel("Guess a number between 1 - 100 :");
		guessIt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		guessIt.setBounds(89, 117, 194, 14);
		getContentPane().add(guessIt);
		
		enterTxt = new JTextField();
		enterTxt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guessIt();
			}
		});
		enterTxt.setHorizontalAlignment(SwingConstants.CENTER);
		enterTxt.setBounds(293, 115, 47, 20);
		getContentPane().add(enterTxt);
		enterTxt.setColumns(10);
		
		JButton btnGuessit = new JButton("Guess It!");
		btnGuessit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guessIt();
			}
		});
		btnGuessit.setBounds(178, 157, 89, 23);
		getContentPane().add(btnGuessit);
		
		itsOutput = new JLabel("");
		itsOutput.setFont(new Font("Tahoma", Font.BOLD, 12));
		itsOutput.setHorizontalAlignment(SwingConstants.CENTER);
		itsOutput.setBounds(50, 191, 344, 20);
		getContentPane().add(itsOutput);
		
		itsOutput2 = new JLabel("");
		itsOutput2.setHorizontalAlignment(SwingConstants.CENTER);
		itsOutput2.setBounds(50, 222, 344, 14);
		getContentPane().add(itsOutput2);
	}

	public static void main(String[] args) {
		
		GuessIt guessGame = new GuessIt();
		guessGame.newGuess();
		guessGame.setSize(new Dimension(480, 320));
		guessGame.setVisible(true);
		
		



	}
}
