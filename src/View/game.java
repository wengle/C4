package View;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import Controller.Connect4Controller;
import Model.Disc;

import javax.swing.JLabel;
import javax.swing.JButton;

public class game extends JFrame {

	private JPanel contentPane;
	private Connect4Controller controller;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					game frame = new game();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public game() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 721, 638);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGameBoard = new JLabel();
		lblGameBoard.setVerticalAlignment(SwingConstants.BOTTOM);
		Image background = new ImageIcon (this.getClass().getResource("/4inARowBG.png")).getImage();
		lblGameBoard.setIcon(new ImageIcon (background));
		lblGameBoard.setBounds(111, 64, 490, 496);
		contentPane.add(lblGameBoard);
		
		
		JButton btnRestartGame = new JButton("Restart Game");
		btnRestartGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
						controller.restart();
					}	
			});	
		btnRestartGame.setBounds(307, 572, 117, 29);
		contentPane.add(btnRestartGame);
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
