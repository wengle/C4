package View;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;

import Controller.Connect4Controller;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class AppWindow {

	private JFrame frame;
	private JTextField textField;
	private Connect4Controller controller;
	private JTextField txtPlayerWrite;
	private JTextField txtPlayerWrite2;
	private String player1;
	private String player2;
	private JLabel lblError;
	private JLabel lblPlayerWrite;
	private JLabel lblPlayerWrite_1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppWindow window = new AppWindow();
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
	public AppWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Connect Four");
		frame.setBounds(100, 100, 654, 376);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtPlayerWrite = new JTextField();
		txtPlayerWrite.setText("");
		txtPlayerWrite.setBounds(225, 68, 204, 28);
		frame.getContentPane().add(txtPlayerWrite);
		txtPlayerWrite.setColumns(10);
		
		txtPlayerWrite2 = new JTextField();
		txtPlayerWrite2.setText("");
		txtPlayerWrite2.setBounds(225, 108, 204, 28);
		frame.getContentPane().add(txtPlayerWrite2);
		txtPlayerWrite2.setColumns(10);
		
		JButton btnStartGame = new JButton("Start Game");
		btnStartGame.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		btnStartGame.setVerticalAlignment(SwingConstants.BOTTOM);
		Image startGame = new ImageIcon (this.getClass().getResource("/StartGame.png")).getImage();
		btnStartGame.setIcon(new ImageIcon (startGame));
		btnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (txtPlayerWrite.getText() != null && txtPlayerWrite2.getText() != null && txtPlayerWrite.getText().length() > 0 && txtPlayerWrite2.getText().length() > 0){
					frame.dispose();
					game startGame = new game();
					startGame.setVisible(true);
					controller.createGame(txtPlayerWrite.getText().toString(), txtPlayerWrite2.getText().toString());
				}
				else{
					lblError.setText("Enter player name");
				}
							
				
			}
		});
		btnStartGame.setBounds(234, 179, 195, 76);
		frame.getContentPane().add(btnStartGame);
		
		lblError = new JLabel("");
		lblError.setBounds(463, 108, 157, 28);
		frame.getContentPane().add(lblError);
		
		lblPlayerWrite = new JLabel("Player 1, write name here");
		lblPlayerWrite.setBounds(45, 74, 157, 16);
		frame.getContentPane().add(lblPlayerWrite);
		
		lblPlayerWrite_1 = new JLabel("Player 2, write name here");
		lblPlayerWrite_1.setBounds(45, 114, 157, 16);
		frame.getContentPane().add(lblPlayerWrite_1);
		
		
		
	}
}
