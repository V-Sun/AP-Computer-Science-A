import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class Main {
	
	private static String word = "";
	private static int count = 0;
	
	public static void main(String args[]) {
	
		File file = new File("./Words/words.txt");
		ArrayList<String> words = new ArrayList<String>();
		try {
			Scanner fileReader = new Scanner(file);
			while (fileReader.hasNextLine()) {
				words.add(fileReader.nextLine());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
		JFrame frame = new JFrame("Wordle");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel content = new JPanel();
		content.setPreferredSize(new Dimension(500, 700));

		content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
		frame.add(content);

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(6, 5));
		panel.setPreferredSize(new Dimension(500, 500));

		JLabel[][] grid = new JLabel[6][5];
		for (int row = 0; row < 6; row++) {
			for (int col = 0; col < 5; col++) {
				JLabel label = new JLabel("", SwingConstants.CENTER);
				panel.add(label);
				label.setBorder(border);
				label.setFont (label.getFont ().deriveFont (64.0f));
				label.setOpaque(true);
				grid[row][col] = label;
			}
		}

		content.add(panel);

		

		JTextField textField = new JTextField(5);
		Random rand = new Random();
		String randomWord = words.get(rand.nextInt(words.size()));
		System.out.println(randomWord);
		JLabel status = new JLabel();
		Action action = new AbstractAction() {
			
		    @Override
		    public void actionPerformed(ActionEvent e)
		    {	
		    	
		    	word = textField.getText();
		    	if(words.contains(word)) {
		    		Guess guess = new Guess(word, randomWord);
		    		
			    	char[] result = guess.checkChars();
			    	for(int i = 0; i < 5; i++) {
			    		grid[count][i].setText(Character.toString(word.charAt(i)));
			    		if(Character.isUpperCase(result[i])) {
			    			
			    			grid[count][i].setBackground(Color.GREEN);
			    			
			    		} else if(Character.isLowerCase(result[i])) {
			    			grid[count][i].setBackground(Color.yellow);
			    			
			    		}
			    		
			    	}
			    	status.setText("This is a valid word!");
			    	count++;
			    	if(guess.matches()) {
		    			status.setText("Correct!");
		    			
		    		}
			    	
		    	} else {
		    		status.setText("This is not a valid word!");
		    		
		    	}
				
		    	textField.setText("");
		    	if(count == 6) {
		    		System.exit(0);
		    	}
		    	
	    	}
		};
		textField.addActionListener( action );

		content.add(textField);

		

		content.add(status);
		

		frame.pack();
		frame.setVisible(true);

		Scanner keyboard = new Scanner(System.in);
		

		for (int i = 0; i < 6; i++) {
			String input = keyboard.nextLine();
			Guess guess = new Guess(input, randomWord);
			System.out.println(guess.checkChars());
			if (guess.matches()) {
				System.out.println("Correct!");
				System.exit(0);
			}
		}

		keyboard.close();
		// next we need to create a GUI
		// JFrame
		// - JPanel (content panel
		// - JPanel
		// - - - a grid of JLabels
		// - - JTextField
		// - -JLabel

	}

}
