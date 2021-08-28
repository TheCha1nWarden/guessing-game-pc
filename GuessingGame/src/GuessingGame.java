import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuessingGame extends JFrame {
	private JTextField txtGuess;
	private JLabel lblOutput;
	private int theNumber;
	private JButton btnPlayAgain;
	public void checkGuess() {
		String guessText = txtGuess.getText();
		String message = "";
		try {
		int guess = Integer.parseInt(guessText);
		if (guess < theNumber)
			message = guess + " is too low. Try again.";
		else if (guess > theNumber) 
			message = guess + " is too high. Try again.";
		else {
			message = guess + " is correct. You win! do you want to play again?";
			btnPlayAgain.setVisible(true);
		}
		} catch (Exception e) {
			message = "Enter a whole number between 1 and 100";
		} finally {
		lblOutput.setText(message);
		txtGuess.requestFocus();
		txtGuess.selectAll();
		}
	}
	public void newGame() {
		theNumber = (int) (Math.random()*100 + 1);
	}
	public GuessingGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Play Hi-Lo Guessing Game");
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Play Hi-Lo Guessing Game");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 38, 414, 19);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Guess a number between 1 and 100:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(10, 95, 230, 14);
		getContentPane().add(lblNewLabel_1);
		
		txtGuess = new JTextField();
		txtGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				checkGuess();
			}
		});
		txtGuess.setBounds(250, 92, 86, 20);
		getContentPane().add(txtGuess);
		txtGuess.setColumns(10);
		
		JButton btnNewButton = new JButton("Guess");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				checkGuess();
			}
		});
		btnNewButton.setBounds(172, 147, 89, 23);
		getContentPane().add(btnNewButton);
		
		lblOutput = new JLabel("Enter a number above and click Guess!");
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setBounds(7, 189, 414, 14);
		getContentPane().add(lblOutput);
		
		btnPlayAgain = new JButton("Play again!");
		btnPlayAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnPlayAgain.setVisible(false);
				newGame();
				txtGuess.requestFocus();
				txtGuess.selectAll();
				lblOutput.setText("Enter a number above and click Guess!");
			}
		});
		btnPlayAgain.setBounds(155, 214, 118, 23);
		getContentPane().add(btnPlayAgain);
		btnPlayAgain.setVisible(false);
	}

	public static void main(String[] args) {
		GuessingGame theGame = new GuessingGame();
		theGame.newGame();
		theGame.setSize(new Dimension(450,300));
		theGame.setVisible(true);
	}
}
