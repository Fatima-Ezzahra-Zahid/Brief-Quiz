

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.UIManager;

public class Inter1 {

	private JFrame frmQuiz;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inter1 window = new Inter1();
					window.frmQuiz.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Inter1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmQuiz = new JFrame();
		frmQuiz.getContentPane().setBackground(SystemColor.activeCaption);
		frmQuiz.setTitle("Quiz");
		frmQuiz.setBounds(100, 100, 588, 496);
		frmQuiz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmQuiz.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Quiz");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(261, 31, 100, 14);
		frmQuiz.getContentPane().add(lblNewLabel);
		
		JTextPane txtpnLePremierNiveau = new JTextPane();
		txtpnLePremierNiveau.setForeground(new Color(0, 0, 0));
		txtpnLePremierNiveau.setBackground(new Color(153, 180, 209));
		txtpnLePremierNiveau.setText("Le premier niveau consiste à répondre à 5 questions à choix multiples\r\n"
				+ "\r\n"
				+ "Le score minimal pour réussir le premier niveau et passer au second niveau est de 40/100 !\r\n"
				+ "\r\n"
				+ "Une fois le premier niveau est validé, on a accès au second niveau\r\n"
				+ "\r\n"
				+ "Le deuxième niveau consiste à répondre à 5 questions à choix multiples\r\n"
				+ "\r\n"
				+ "Le score minimal nécessaire pour valider le deuxième niveau et passer au troisième niveau est de 60/100 !\r\n"
				+ "\r\n"
				+ "Une fois le second niveau est validé, on a accès au troisième niveau\r\n"
				+ "\r\n"
				+ "Le troisième niveau consiste à répondre à 5 questions à choix multiples Pour valider le troisième niveau et réussir le chalenge, il faudra réussir ce dernier niveau avec un score de 80%.");
		txtpnLePremierNiveau.setBounds(46, 87, 463, 260);
		frmQuiz.getContentPane().add(txtpnLePremierNiveau);
		
		JButton btnNewButton = new JButton("Commencer");
		btnNewButton.setBackground(UIManager.getColor("Button.background"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Quiz quiz=new Quiz();
				
			}
		});
		btnNewButton.setForeground(SystemColor.desktop);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(88, 385, 109, 38);
		frmQuiz.getContentPane().add(btnNewButton);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmQuiz.dispose();
			}
		});
		btnAnnuler.setForeground(Color.BLACK);
		btnAnnuler.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAnnuler.setBounds(400, 385, 109, 38);
		frmQuiz.getContentPane().add(btnAnnuler);
	}
}
