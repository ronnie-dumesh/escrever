import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Frame1 {
	private static String wordText = "Word";
	private static String defText = "Definition";
	private static String hintText = "Hint";

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame1 window = new Frame1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Frame1() {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1118, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//JLabel for the Card's word
		JLabel wordLabel = new JLabel(wordText);
		wordLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		wordLabel.setBounds(96, 105, 449, 125);
		frame.getContentPane().add(wordLabel);
		
		//HLabel for the Card's definition
		JLabel defLabel = new JLabel(defText);
		defLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		defLabel.setBounds(600, 105, 432, 125);
		frame.getContentPane().add(defLabel);
		
		//JLabel for the Card's hint
		JLabel hintLabel= new JLabel(hintText);
		hintLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		hintLabel.setBounds(600, 320, 418, 96);
		frame.getContentPane().add(hintLabel);
		
		//JButton to mark the current Card easy
		JButton btnEasy = new JButton("Easy (60 hours)");
		btnEasy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Base.nextCard(Delay.EASY);
					wordLabel.setText(Base.getCurrentCard().getWord());
					defLabel.setText(Base.getCurrentCard().getDef());
					defLabel.setVisible(false);
					hintLabel.setText(Base.getCurrentCard().getHint());
					hintLabel.setVisible(false);
				} catch (NullPointerException e) {}
			}
		});
		btnEasy.setBounds(885, 537, 147, 91);
		frame.getContentPane().add(btnEasy);
		
		//JButton to mark the current Card medium
		JButton btnMedium = new JButton("Medium (36 hours)");
		btnMedium.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Base.nextCard(Delay.MEDIUM);
					wordLabel.setText(Base.getCurrentCard().getWord());
					defLabel.setText(Base.getCurrentCard().getDef());
					defLabel.setVisible(false);
					hintLabel.setText(Base.getCurrentCard().getHint());
					hintLabel.setVisible(false);
				} catch (NullPointerException e) {}
			}
		});
		btnMedium.setBounds(606, 537, 189, 91);
		frame.getContentPane().add(btnMedium);
		
		//JButton to mark the current Card hard
		JButton btnHard = new JButton("Hard (12 hours)");
		btnHard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Base.nextCard(Delay.HARD);
					wordLabel.setText(Base.getCurrentCard().getWord());
					defLabel.setText(Base.getCurrentCard().getDef());
					defLabel.setVisible(false);
					hintLabel.setText(Base.getCurrentCard().getHint());
					hintLabel.setVisible(false);
				} catch (NullPointerException e) {}
			}
		});
		btnHard.setBounds(344, 537, 179, 91);
		frame.getContentPane().add(btnHard);
		
		//JButton to see the current card again soon 
		JButton btnAgain = new JButton("Again (10 min)");
		btnAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Base.nextCard(Delay.AGAIN);
					wordLabel.setText(Base.getCurrentCard().getWord());
					defLabel.setText(Base.getCurrentCard().getDef());
					defLabel.setVisible(false);
					hintLabel.setText(Base.getCurrentCard().getHint());
					hintLabel.setVisible(false);
				} catch (NullPointerException e) {}
			}
		});
		btnAgain.setBounds(96, 537, 147, 91);
		frame.getContentPane().add(btnAgain);
		
		//JButton to display the JLabel hintLabel
		JButton btnGiveHint = new JButton("Give Hint");
		btnGiveHint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				hintLabel.setVisible(true);
			}
		});
		btnGiveHint.setBounds(96, 319, 147, 106);
		frame.getContentPane().add(btnGiveHint);
		
		//JButton to display the JLabel defLabel
		JButton btnGiveDefinition = new JButton("Give Definition");
		btnGiveDefinition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				defLabel.setVisible(true);
			}
		});
		btnGiveDefinition.setBounds(300, 320, 137, 106);
		frame.getContentPane().add(btnGiveDefinition);
		
		//JButton to import a CSV into the program
		JButton btnImportCsv = new JButton("Import CSV");
		btnImportCsv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Base.importSet();
					wordLabel.setText(Base.getCurrentCard().getWord());
					defLabel.setText(Base.getCurrentCard().getDef());
					defLabel.setVisible(false);
					hintLabel.setText(Base.getCurrentCard().getHint());
					hintLabel.setVisible(false);
				} catch (NullPointerException e) {}
			}
		});
		btnImportCsv.setBounds(96, 16, 271, 61);
		frame.getContentPane().add(btnImportCsv);
		
		//JButton to save current progress
		JButton btnSaveProgress = new JButton("Save Progress");
		btnSaveProgress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				Base.saveProgress();
			} catch(NullPointerException e) {	
				System.out.println("Could not save progress");
				}
			}
		});
		btnSaveProgress.setBounds(753, 16, 279, 61);
		frame.getContentPane().add(btnSaveProgress);
	}
	
	/**setJLabels modifies the JFrame to display
	 * a Card's word, definiton, and hint. 
	 * 
	 * @param currentCard is the Card for which information
	 * should be displayed
	 */
	public void setJLabels(Card currentCard) {
		wordText = currentCard.getWord();
		defText = currentCard.getDef();
		hintText = currentCard.getHint();

	}
}
