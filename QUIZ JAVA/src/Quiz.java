
// ---------------------------- Quiz ----------------------------
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;

public class Quiz implements ActionListener {
	// Niveau 1
	String[] questions = { "JAVA est un langage?", "Toutes les classes héritent de la classe?",
			"Par convention une classe?", "Est-ce que on peut avoir plusieurs constructeurs pour la même classe?",
			"Dans la ligne \"public class A implements B\", B est", "",
			"Après la compilation, un programme écrit en JAVA, il se transforme en programme en bytecode Quelle est l’extension du programme en bytecode?",
			"Class Test{\r\n" + "Public Test () {\r\n" + "System.out.println(”Bonjour”);}\r\n"
					+ "public Test (int i) {\r\n" + "this();\r\n"
					+ "System.out.println(”Nous sommes en ”+i+ ” !”);};\r\n" + "}\r\n"
					+ "qu’affichera l’instruction suivante?\r\n" + "Test t1=new Test (2018);\r\n" + "",
			"Voici un constructeur de la classe Employee, y-at'il un problème ?\r\n"
					+ "Public void Employe(String n){\r\n" + "Nom=n;}\r\n" + "",
			"Pour spécifier que la variable ne pourra plus être modifiée et doit être initialisée dès sa déclaration, on la déclare comme une constante avec le mot réservé",
			"Dans une classe, on accède à ses variables grâce au mot clé", "",
			"calculerSalaire(int)\r\n" + "calculerSalaire(int, double)\r\n" + "La méthode calculerSalaire est :\r\n"
					+ "",
			"Une classe qui contient au moins une méthode abstraite doit être déclarée abstraite.",
			"Est-ce qu’une classe peut implémenter plusieurs interfaces ?",
			"La déclaration d'une méthode suivante : public void traitement() throws IOException précise que la méthode propage une exception contrôlée",
			"class Test{\r\n" + "public static void main (String[] args) {\r\n" + "try {\r\n" + "int a =10;\r\n"
					+ "System.out.println (\"a = \" + a );\r\n" + "int b = 0 / a;\r\n"
					+ "System.out.println (\"b = \" + b);\r\n" + "}\r\n" + "catch(ArithmeticException e)\r\n"
					+ "{System.out.println (\"diviser par 0!\"); }\r\n" + "finally\r\n"
					+ "{System.out.println (\"je suis à l’intérieur de\r\n" + "finally\");}}}\r\n" };
	String[][] options = { { "Compilé", "Interprété", "Compilé et interpreté" }, { "Main", "Object", "AWT" },
			{ "est en minuscule", "commence par une majuscule", "est en majuscules" }, { "oui ", "non" },
			{ "Interfacce", "Classe parent", "Package" }, {}, { "aucun des choix", ".java", ".Class" },
			{ "aucun des choix", "Bonjour Nous sommes en 2018!", "Nous sommes en 2018!" }, { "vrai", "faux" },
			{ "aucun des choix", "final", "const" }, { "aucun des choix", "this", "super" }, {},
			{ "aucun des choix", "surchargée", "redéfinie" }, { "vrais", "faux" }, { "vrais", "faux" },
			{ "vrais", "faux" }, { "Interfacce", "a = 10 , b = 0 Je suis à l’intérieur de finally",
					"a = 10 b = 0 diviser par 0! je suis à l’intérieur de finally" } };
	char[] answers = { 'A', 'C', 'B', 'A', 'A', ' ', 'B', 'B', 'A', 'B', 'A', ' ', 'C', 'A', 'A', 'A', 'C' };

	char guess;
	char answer;
	int index;
	int correct_guesses = 0;
	int total_questions = 5;
	int result;
	int seconds = 0;
	int minutes = 0;
	int elapsedTime = 0;
	String seconds_string = String.format("%02d", seconds);
	String minutes_string = String.format("%02d", minutes);

	JFrame frame = new JFrame();
	
	JTextField textfield = new JTextField();
	JTextArea textarea = new JTextArea();
	JButton buttonA = new JButton();
	JButton buttonB = new JButton();
	JButton buttonC = new JButton();
	JButton next = new JButton();

	JLabel answer_labelA = new JLabel();
	JLabel answer_labelB = new JLabel();
	JLabel answer_labelC = new JLabel();

	JLabel time_label = new JLabel();
	JLabel seconds_left = new JLabel();
	JTextField number_right = new JTextField();
	JTextField percentage = new JTextField();

	public Quiz() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(650, 650);
		// frame.getContentPane().setBackground(new Color(50,50,50));
		frame.setLayout(null);
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setTitle("Quiz");
		//frame.setBounds(100, 100, 588, 496);
		// frame.setResizable(false);

		textfield.setBounds(0, 0, 650, 50);
//		textfield.setBackground(new Color(25,25,25));
		textfield.setForeground(SystemColor.desktop);
		textfield.setFont(new Font("Tahoma", Font.BOLD, 30));
		textfield.setBorder(BorderFactory.createBevelBorder(1));
		textfield.setHorizontalAlignment(JTextField.CENTER);
		textfield.setEditable(false);

		textarea.setBounds(0, 50, 650, 50);
		textarea.setLineWrap(true);
		textarea.setWrapStyleWord(true);
//		textarea.setBackground(new Color(25,25,25));
		textarea.setForeground(SystemColor.desktop);
		textarea.setFont(new Font("MV Boli", Font.BOLD, 25));
		textarea.setBorder(BorderFactory.createBevelBorder(1));
		textarea.setAlignmentX(JTextArea.CENTER_ALIGNMENT);
		textarea.setEditable(false);

		buttonA.setBounds(0, 100, 100, 100);
		buttonA.setFont(new Font("MV Boli", Font.BOLD, 35));
		buttonA.setFocusable(false);
		buttonA.addActionListener(this);
		buttonA.setText("A");

		buttonB.setBounds(0, 200, 100, 100);
		buttonB.setFont(new Font("MV Boli", Font.BOLD, 35));
		buttonB.setFocusable(false);
		buttonB.addActionListener(this);
		buttonB.setText("B");

		buttonC.setBounds(0, 300, 100, 100);
		buttonC.setFont(new Font("MV Boli", Font.BOLD, 35));
		buttonC.setFocusable(false);
		buttonC.addActionListener(this);
		buttonC.setText("C");

		answer_labelA.setBounds(125, 100, 500, 100);
		answer_labelA.setBackground(new Color(50, 50, 50));
		answer_labelA.setForeground(SystemColor.desktop);
		answer_labelA.setFont(new Font("MV Boli", Font.PLAIN, 35));

		answer_labelB.setBounds(125, 200, 500, 100);
		answer_labelB.setBackground(new Color(50, 50, 50));
		answer_labelB.setForeground(SystemColor.desktop);;
		answer_labelB.setFont(new Font("MV Boli", Font.PLAIN, 35));

		answer_labelC.setBounds(125, 300, 500, 100);
		answer_labelC.setBackground(new Color(50, 50, 50));
		answer_labelC.setForeground(SystemColor.desktop);
		answer_labelC.setFont(new Font("MV Boli", Font.PLAIN, 35));

		seconds_left.setBounds(535, 510, 100, 100);
		seconds_left.setBackground(new Color(25, 25, 25));
		seconds_left.setForeground(new Color(255, 0, 0));
		seconds_left.setFont(new Font("Ink Free", Font.BOLD, 30));
		seconds_left.setBorder(BorderFactory.createBevelBorder(1));
		seconds_left.setOpaque(true);
		seconds_left.setHorizontalAlignment(JTextField.CENTER);
		seconds_left.setText(minutes_string + ":" + seconds_string);

		time_label.setBounds(535, 475, 100, 25);
		time_label.setBackground(new Color(50, 50, 50));
		time_label.setForeground(SystemColor.desktop);
		time_label.setFont(new Font("Tahoma", Font.BOLD, 10));
		time_label.setHorizontalAlignment(JTextField.CENTER);
		time_label.setText("Vous avez 10 min");

		number_right.setBounds(225, 225, 200, 100);
		number_right.setBackground(new Color(25, 25, 25));
		number_right.setForeground(new Color(25, 255, 0));
		number_right.setFont(new Font("Ink Free", Font.BOLD, 50));
		number_right.setBorder(BorderFactory.createBevelBorder(1));
		number_right.setHorizontalAlignment(JTextField.CENTER);
		number_right.setEditable(false);

		percentage.setBounds(225, 325, 200, 100);
		percentage.setBackground(new Color(25, 25, 25));
		percentage.setForeground(new Color(25, 255, 0));
		percentage.setFont(new Font("Ink Free", Font.BOLD, 50));
		percentage.setBorder(BorderFactory.createBevelBorder(1));
		percentage.setHorizontalAlignment(JTextField.CENTER);
		percentage.setEditable(false);

		next.setBounds(225, 425, 200, 100);
		next.setFont(new Font("MV Boli", Font.BOLD, 20));
		next.setFocusable(false);
		next.addActionListener(this);
		next.setText("Next Niveau");

		frame.add(time_label);
		frame.add(seconds_left);
		frame.add(answer_labelA);
		frame.add(answer_labelB);
		frame.add(answer_labelC);

		frame.add(buttonA);
		frame.add(buttonB);
		frame.add(buttonC);

		frame.add(textarea);
		frame.add(textfield);
		frame.setVisible(true);
		timer.start();
		nextQuestion();
	}

	Timer timer = new Timer(1000, new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			elapsedTime = elapsedTime + 1000;
			seconds = (elapsedTime / 1000) % 60;
			minutes = (elapsedTime / 60000) % 60;
			seconds_string = String.format("%02d", seconds);
			minutes_string = String.format("%02d", minutes);
			seconds_left.setText(minutes_string + ":" + seconds_string);

			if (minutes >= 10) {
				displayAnswer();
				System.out.println("GAME OVER");
			}
		}
	});

	public void nextQuestion() {

		if (index == 5 || index == 11 || index == 17) {
			results();
		} else {

			for (int i = 0; i < questions.length; i++) {
				if (options[index].length == 3) {

					textarea.setText(questions[index]);

					answer_labelA.setText(options[index][0]);
					answer_labelB.setText(options[index][1]);
					answer_labelC.setText(options[index][2]);
				} else {

					textarea.setText(questions[index]);

					answer_labelA.setText(options[index][0]);
					answer_labelB.setText(options[index][1]);
					buttonC.setVisible(false);
					answer_labelC.setVisible(false);

				}
			}
			if (index <= 5) {
				textfield.setText("Niveau 1");
			} else if (index <= 11) {
				textfield.setText("Niveau 2");
			} else if (index <= 17) {
				textfield.setText("Niveau 3");
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

//		buttonA.setEnabled(false);
//		buttonB.setEnabled(false);
//		buttonC.setEnabled(false);

		if (e.getSource() == buttonA) {
			answer = 'A';
			if (answer == answers[index]) {
				correct_guesses++;
			}
			displayAnswer();
		}
		if (e.getSource() == buttonB) {
			answer = 'B';
			if (answer == answers[index]) {
				correct_guesses++;
			}
			displayAnswer();
		}
		if (e.getSource() == buttonC) {
			answer = 'C';
			if (answer == answers[index]) {
				correct_guesses++;
			}
			displayAnswer();
		}

		if (e.getSource() == next) {

			buttonA.setVisible(true);
			buttonB.setVisible(true);
			buttonC.setVisible(true);
			answer_labelA.setVisible(true);
			answer_labelB.setVisible(true);
			answer_labelC.setVisible(true);
			number_right.setVisible(false);
			percentage.setVisible(false);
			next.setVisible(false);

			correct_guesses = 0;
			index++;
			nextQuestion();
		}

	}

	public void displayAnswer() {

		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);

		if (answers[index] != 'A')
			answer_labelA.setForeground(new Color(255, 0, 0));
		if (answers[index] != 'B')
			answer_labelB.setForeground(new Color(255, 0, 0));
		if (answers[index] != 'C')
			answer_labelC.setForeground(new Color(255, 0, 0));

		Timer pause = new Timer(2000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				answer_labelA.setForeground(SystemColor.desktop);;
				answer_labelB.setForeground(SystemColor.desktop);
				answer_labelC.setForeground(SystemColor.desktop);;

				answer = ' ';
				
				buttonA.setEnabled(true);
				buttonB.setEnabled(true);
				buttonC.setEnabled(true);

				index++;
				nextQuestion();
			}
		});
		pause.setRepeats(false);
		pause.start();
	}

	public void results() {
		if (minutes >= 10) {
			buttonA.setVisible(false);
			buttonB.setVisible(false);
			buttonC.setVisible(false);

			textarea.setText("You Lost. Time's up");
			answer_labelA.setVisible(false);
			answer_labelB.setVisible(false);
			answer_labelC.setVisible(false);
			timer.stop();
		} else if (index == 5 && correct_guesses < 2) {
			buttonA.setVisible(false);
			buttonB.setVisible(false);
			buttonC.setVisible(false);

			result = (int) ((correct_guesses / (double) total_questions) * 100);

			textfield.setText("RESULTS!");
			textarea.setText("You Lost");
			answer_labelA.setVisible(false);
			answer_labelB.setVisible(false);
			answer_labelC.setVisible(false);
			timer.stop();
			number_right.setText("(" + correct_guesses + "/" + total_questions + ")");
			percentage.setText(result + "%");

			frame.add(number_right);
			frame.add(percentage);
		} else if (index == 11 && correct_guesses < 3) {
			buttonA.setVisible(false);
			buttonB.setVisible(false);
			buttonC.setVisible(false);

			result = (int) ((correct_guesses / (double) total_questions) * 100);

			textfield.setText("RESULTS!");
			textarea.setText("You Lost");
			answer_labelA.setVisible(false);
			answer_labelB.setVisible(false);
			answer_labelC.setVisible(false);

			number_right.setText("(" + correct_guesses + "/" + total_questions + ")");
			percentage.setText(result + "%");

			percentage.setVisible(true);
			number_right.setVisible(true);
			timer.stop();
			frame.add(number_right);
			frame.add(percentage);
		} else if (index == 17 && correct_guesses < 4) {

			buttonA.setVisible(false);
			buttonB.setVisible(false);
			buttonC.setVisible(false);

			result = (int) ((correct_guesses / (double) total_questions) * 100);

			textfield.setText("RESULTS!");
			textarea.setText("You Lost");
			answer_labelA.setVisible(false);
			answer_labelB.setVisible(false);
			answer_labelC.setVisible(false);

			number_right.setText("(" + correct_guesses + "/" + total_questions + ")");
			percentage.setText(result + "%");

			percentage.setVisible(true);
			number_right.setVisible(true);
			timer.stop();
			frame.add(number_right);
			frame.add(percentage);
		} else if ((index == 5 && correct_guesses >= 2) || (index == 11 && correct_guesses >= 3)
				|| (index == 17 && correct_guesses >= 4)) {
			buttonA.setVisible(false);
			buttonB.setVisible(false);
			buttonC.setVisible(false);

			result = (int) ((correct_guesses / (double) total_questions) * 100);

			textfield.setText("RESULTS!");
			textarea.setText("You Win");
			answer_labelA.setVisible(false);
			answer_labelB.setVisible(false);
			answer_labelC.setVisible(false);
			next.setVisible(true);

			number_right.setText("(" + correct_guesses + "/" + total_questions + ")");
			percentage.setText(result + "%");

			percentage.setVisible(true);
			number_right.setVisible(true);

			frame.add(number_right);
			frame.add(percentage);
			frame.add(next);

		}
	}
}