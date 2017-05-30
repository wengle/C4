package View;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.ActionEvent;	
import Controller.Connect4Controller;

public class Connect4JFrame extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Connect4Controller controller;
	private JTextField txtPlayerName1;
	private JTextField txtPlayerName2;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Connect4JFrame frame = new Connect4JFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Connect4JFrame() {
		
		txtPlayerName1 = new JTextField();
		txtPlayerName1.setText("Player 1, write name");
		txtPlayerName1.setBounds(159, 155, 147, 28);
		getContentPane().add(txtPlayerName1);
		txtPlayerName1.setColumns(10);
		
		txtPlayerName2 = new JTextField();
		txtPlayerName2.setText("Player 2, write name");
		txtPlayerName2.setBounds(384, 155, 147, 28);
		getContentPane().add(txtPlayerName2);
		txtPlayerName2.setColumns(10);
		
		JButton btnStartGame = new JButton("Start Game");
		btnStartGame.setBounds(277, 220, 135, 48);
		getContentPane().add(btnStartGame);
		
		/*int frameWidth = 2 * this.controller.getMargin() + this.controller.getCols() * this.controller.getTileSize();
		int frameHeight = 3 * this.controller.getMargin() + this.controller.getRows() * this.controller.getTileSize();
		
		//Setup Frame
		this.getContentPane().setPreferredSize(new Dimension(frameWidth, frameHeight));
		this.setTitle("Connect Four");
		this.pack();
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		int buttonWidth = 4 * this.controller.getMargin();
		int buttonHeight = this.controller.getMargin() / 1;
		
		//Setup Restart Button
		JPanel restartPanel = new JPanel();
		this.controller.getRestartButton().setPreferredSize(new Dimension(buttonWidth, buttonHeight));
		restartPanel.add(this.controller.getRestartButton(), BorderLayout.CENTER);
		this.add(restartPanel, BorderLayout.PAGE_END);
		
		///Setup Font
		this.setFont(new Font("Times New Roman", Font.BOLD, this.controller.getFontSize()));
		this.controller.addRestartButtonListener(new RestartButtonListener());
		this.addMouseListener(new PanelListener());
		this.addMouseMotionListener(new CursorListener());
		controller.addPanel(new Panel());
		this.setVisible(true);	
		*/ 
		getContentPane().setLayout(null);
	
		JButton btnRestart = new JButton("Restart");
		btnRestart.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
					controller.restart();
				}	
		});	
		btnRestart.setBounds(277, 523, 135, 29);
		getContentPane().add(btnRestart);
	
		JLabel lblPlayer = new JLabel(txtPlayerName1.getText());
		lblPlayer.setBounds(65, 30, 126, 16);
		getContentPane().add(lblPlayer);
		
		JLabel lblPlayer_1 = new JLabel(txtPlayerName2.getText());
		lblPlayer_1.setBounds(466, 30, 135, 16);
		getContentPane().add(lblPlayer_1);
	
		
	
	}
	
	
	class RestartButtonListener implements ActionListener {
		
		@Override
		/**
		 * Restarts the the game if the restart button is clicked.
		 */
		public void actionPerformed(ActionEvent e) {
			controller.restart();
		}
	}

	
	//new
	class HintTextField extends JTextField implements FocusListener {

		  /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private final String hint;
		  private boolean showingHint;

		  public HintTextField(final String hint) {
		    super(hint);
		    this.hint = hint;
		    this.showingHint = true;
		    super.addFocusListener(this);
		  }

		  @Override
		  public void focusGained(FocusEvent e) {
		    if(this.getText().isEmpty()) {
		      super.setText("");
		      showingHint = false;
		    }
		  }
		  @Override
		  public void focusLost(FocusEvent e) {
		    if(this.getText().isEmpty()) {
		      super.setText(hint);
		      showingHint = true;
		    }
		  }

		  @Override
		  public String getText() {
		    return showingHint ? "" : super.getText();
		  }
		}
	
	
	class PanelListener implements MouseListener {
		
		@Override
		/**
		 * Required to implement by MouseListener.
		 */
		public void mouseClicked(MouseEvent e) {}

		@Override
		/**
		 * Required to implement by MouseListener.
		 */
		public void mouseEntered(MouseEvent e) {}
		
		@Override
		/**
		 * Required to implement by MouseListener.
		 */
		public void mouseExited(MouseEvent e) {}

		@Override
		/**
		 * Responsible for updating the model.
		 * Retrieves and updates user clicks and starts the timer afterwards.
		 */
		
		public void mousePressed(MouseEvent e) {
			//If a disc is currently falling...return.
			if (controller.getTimer().isRunning()) return;
			
			//If the user clicks outside the game board...return.
			if (e.getX() < controller.getMargin() 
					|| e.getX() > controller.getMargin() + controller.getCols() * controller.getTileSize()) return;
			
			//If in the win sequence...return.
			if (controller.getWinSequence()) return;
			
			//Retrieves the location of where the user clicked.
			controller.getClickPoint().y = (int) Math.floor((e.getY() - controller.getMargin()) / controller.getTileSize());
			controller.getClickPoint().x = (int) Math.floor((e.getX() - controller.getMargin()) / controller.getTileSize());
			
			//If the user clicks a full column...return.
			if (controller.getGameBoard()[0][controller.getClickPoint().x] != controller.getEmpty()) return;
			
			controller.setupDroppingDisc();
			
			//Begin the timer.
			controller.getTimer().start();
		}

		@Override
		/**
		 * Required to implement by MouseListener.
		 */
		public void mouseReleased(MouseEvent e) {}	
	}
	
	class CursorListener implements MouseMotionListener {
		@Override
		/**
		 * Responsible for updating the model.
		 * Retrieves and updates the location of the user's mouse and
		 * tells the view to redraw.
		 */
		public void mouseMoved(MouseEvent e) {
			controller.getMousePoint().x = e.getX();
			repaint();
		}
		
		@Override
		/**
		 * Required to implement by MouseMotionListener.
		 */
		public void mouseDragged(MouseEvent e) {}
	}

	@Override
	/**
	 * Called every time the timer fires. Updates the location of the dropping
	 * disc and tells the view to redraw the screen. Stops the timer once
	 * it has reached it's stopping y-coordinate and checks for Connect-Fours
	 * otherwise it switches player turns.
	 */
	public void actionPerformed(ActionEvent e) {
		//Increment Y-coordinate of falling disc.
		this.controller.getDroppingDisc().setY(this.controller.getDroppingDisc().getY()+10);
		repaint();
		
		//Check if dropping disc has reached bottom of game board.
		if (this.controller.getDroppingDisc().getY() >= this.controller.getDroppingDisc().getStopY() + controller.getDiscSize()) {
			int row = this.controller.getDroppingDisc().getStopY() / this.controller.getTileSize();
			int col = this.controller.getClickPoint().x;
			//Place a disc where the falling disc landed.
			this.controller.getGameBoard()[row][col] = this.controller.getCurrentColor();
			//Stop the timer.
			this.controller.getTimer().stop();
			
			//Check if a Connect-Four is found. Else Switch turns.
			if (controller.checkWin() > 0)
				this.controller.setWinSequence(true);
			else
				controller.switchColor();
		}
		
	}
	
	
}
