package Model;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

import Controller.Connect4Controller;

public class Connect4Model {
			
	private Connect4Controller controller; 

	ImageIcon gameBoardImage = new ImageIcon ("Images/ConnectFour.png");
	ImageIcon yellowMarker = new ImageIcon("Images/Marker1.png");
	ImageIcon redMarker = new ImageIcon("Images/Marker2.png");
	ImageIcon winningMove = new ImageIcon("Images/WinnerMove.png");
	ImageIcon restartIcon = new ImageIcon("Images/RestartButton.png");
	//this.restartButton = new JButton (this.restartIcon);
	
			/**
			 * Represents the gameBoard in which discs are placed.
			 */
			private int gameBoard[][];
			
			/**
			 * Represents the disc which drops when the user clicks a column of the game board.
			 */
			private Disc droppingDisc;
			
			/**
			 * Represents the location where the user clicks.
			 */
			private Point clickPoint;
			
			/**
			 * Represents the location of the mouse cursor.
			 */
			private Point mousePoint;
			
			/**
			 * Represents the location of 4 discs which make up the Connect-Four.
			 */
			private Point connectFour[];
			
			/**
			 * Represents whether or not to begin drawing the win Sequence.
			 */
			private boolean winSequence;
			
			/**
			 * Represents timer for the dropping disc.
			 */
			private Timer timer;
			
			/**
			 * Represents the size of the disc.
			 */
			private final int DISC_SIZE = 75;
			
			/**
			 * Represents the size of the tile.
			 */
			private final int TILE_SIZE = 100;
			
			/**
			 * Represents the distance between the game board and the window.
			 */
			private final int MARGIN = 70;
			
			/**
			 * Represents the font size of the text drawn in the win sequence.
			 */
			private final int FONT_SIZE = 48;
			
			/**
			 * Represents the status of a tile in the game board. In this case: an empty tile.
			 */
			public final int EMPTY = 0;
			
			/**
			 * Represents the status of a tile in the game board. In this case: A red disc.
			 */
			public final int RED = 1;
			
			/**
			 * Represents the status of a tile in the game board. In this case: A yellow disc.
			 */
			public final int YELLOW = 2;
			
			/**
			 * Represents the # of rows in the game board.
			 */
			private final int ROWS = 6;
			
			/**
			 * Represents the # of columns in the game board.
			 */
			private final int COLS = 7;
			
			/**
			 * Represents the speed in which the timer fires for the dropping disc.
			 */
			private final int Y_DISC_VELOCITY = 5;
			
			/**
			 * Represents the color of the current turn.
			 */
			private int currentColor = YELLOW;
			
			/* 
			 *  Represents the board.
			 */
			//private ImageIcon gameBoardImage;
			
			/*
			 *  Restart button.
			 */
			
			private JButton restartButton;
			
			/*
			 *  Restart icon.
			 */
			
			//private ImageIcon restartIcon;
			
			/* 
			 *  Yellow marker. 
			 */
			
			//private ImageIcon yellowMarker;
			
			/*
			 *  Red marker.
			 */
			
			//private ImageIcon redMarker;
			
			/* 
			 *  Represents current marker, red or yellow.
			 */
			private ImageIcon currentMarker;
			
			/*
			 *  Represents the winning move.
			 */
			
			//private ImageIcon winningMove;
			
			/*
			 *  The font of the text that shows when someone wins.
			 */
			
			private Font font;
	
			
			/**
			 * Initializes a new instance of ConnectFourModel with default values.
			 */
			public Connect4Model() {
				this.gameBoard = new int[ROWS][COLS];
				for (int i = 0; i < ROWS; i++) {
					for (int j = 0; j < COLS; j++) {
						this.gameBoard[i][j] = EMPTY;
					}
				}
				
				this.connectFour = new Point[4];
				for (int i = 0; i < 4; i++) {
					this.connectFour[i]= new Point(0,0); 
				}
				
				this.droppingDisc = new Disc(0, 0, 0, Y_DISC_VELOCITY);
				this.winSequence = false;
				this.timer = new Timer(0, null);
				this.clickPoint = new Point(0,0);
				this.mousePoint = new Point(0,0);
			}
			
			public int getRows() {
				return this.ROWS;
			}
			
			public int getCols() {
				return this.COLS;
			}
			
			public int getMargin() {
				return this.MARGIN;
			}
			public int getDiscSize() {
				return this.DISC_SIZE;
			}
			
			public int getTileSize() {
				return this.TILE_SIZE;
			}
			
			public int getFontSize() {
				return this.FONT_SIZE;
			}
			
			public int getRed(){
				return this.RED;
			}
			
			public int getYellow(){
				return this.YELLOW;
			}
			
			public int getEmpty(){
				return this.EMPTY;
			}
			
			
			public int[][] getGameBoard() {
				return this.gameBoard;
			}
			
			public int getCurrentColor() {
				return this.currentColor;
			}
			
			public void setCurrentColor(int color) {
				this.currentColor = color;
			}
			
			public Disc getDroppingDisc() {
				return this.droppingDisc;
			}
			
			public Timer getTimer(){
				return this.timer;
			}
			
			public void setTimer(Timer timer) {
				this.timer = timer;
			}
			
			public Point getClickPoint() {
				return this.clickPoint;
			}
			
			public Point getMousePoint() {
				return this.mousePoint;
			}
			
			public boolean getWinSequence() {
				return this.winSequence;
			}
			
			public void setWinSequence(boolean winSequence) {
				this.winSequence = winSequence;
			}
			
			public Point[] getConnectFour() {
				return this.connectFour;
			}
			
			public void addRestartButtonListener(ActionListener l) {
				this.restartButton.addActionListener(l);
			}
			
			public void addPanel(java.awt.Panel p) {
				controller.addPanel(p);
			}

			public JButton getRestartButton() {
				return this.restartButton;
			}
			
			public ImageIcon getRestartIcon() {
				return this.restartIcon;
			}
			
			public ImageIcon getYellowMarker (){
				return this.yellowMarker;
			}
			
			public ImageIcon getRedMarker (){
				return this.redMarker;
			}
			
			public ImageIcon getWinningMove(){
				return this.winningMove;
			}
		
			public ImageIcon getCurrentMarker() {
				return this.currentMarker;
			}
			
			public ImageIcon getGameBoardImage(){
				return this.gameBoardImage;
			}
			
			public void setCurrentMarker(ImageIcon icon){
				this.currentMarker = icon;
			}
			
			public Font getFont(){
				return this.font;
			}
			
			public void setFont(Font font){
				this.font = font;
			}
			
			/**
			 * Responsible for preparing the dropping disc for dropping.
			 * Sets the location where it should be dropped and where it should stop dropping.
			 */
			
			public void setupDroppingDisc() {
				//Setup the timer.
				this.setTimer(new Timer(this.getDroppingDisc().getYVelocity(), (ActionListener) this)); //lagt till (actionlistener), vet inte om rätt?
				//Set the X-Coordinate of disc as the clicked column
				this.getDroppingDisc().setX(this.getClickPoint().x * this.getTileSize());
				//Set Y-Coordinate as top of screen.
				this.getDroppingDisc().setY(0);

				//Step through each row of the clicked column.
				//Find the first empty spot and set the location of the dropping disc to stop there.
				for (int i = this.getRows() - 1; i >= 0; i--) {
					if (this.getGameBoard()[i][this.getClickPoint().x] == this.EMPTY) {
						this.getDroppingDisc().setStopY(i * this.getTileSize());
						break;
					}
				}
			}
			
			/**
			 * Switches the current color or turn.
			 */
			public void switchColor() {
				if (this.getCurrentColor() == this.RED) {
					this.setCurrentColor(this.YELLOW);
				} else {
					this.setCurrentColor(this.RED);
				}
			}
			
			/**
			 * Checks for Connect-Fours. Accomplishes this by comparing every possible
			 * starting location for a Connect-Four with its succeeding discs.
			 * @return The color of the connect four or 0 if none was found.
			 */
			public int checkWin() {
				int start = 0;
				//Check horizontal win
				for (int row = this.getRows() - 1; row >= 0; row--) {
					for (int col = 0; col < this.getCols() - 3; col++) {
						start = this.getGameBoard()[row][col];
						if (start != this.EMPTY 
								&& start == this.getGameBoard()[row][col + 1]
								&& start == this.getGameBoard()[row][col + 2]
								&& start == this.getGameBoard()[row][col + 3]) {
							for (int i = 0; i < 4; i++) {
								this.getConnectFour()[i] = new Point(row, col + i);
							}
							return start;
						}
					}
				}
				
				//Check vertical win
				for (int row = this.getRows() - 1; row >= 3; row--) {
					for (int col = 0; col < this.getCols(); col++) {
						start = this.getGameBoard()[row][col];
						if (start != this.EMPTY 
								&& start == this.getGameBoard()[row - 1][col]
								&& start == this.getGameBoard()[row - 2][col]
								&& start == this.getGameBoard()[row - 3][col]) {
							for (int i = 0; i < 4; i++) {
								this.getConnectFour()[i] = new Point(row - i, col);
							}
							return start;
						}
					}
				}
				
				//Check diagonal win from bottom left to top right
				for (int row = this.getRows() - 1; row >= 3; row--) {
					for (int col = 0; col < this.getCols() - 3; col++) {
						start = this.getGameBoard()[row][col];
						if (start != this.EMPTY 
								&& start == this.getGameBoard()[row - 1][col + 1]
								&& start == this.getGameBoard()[row - 2][col + 2]
								&& start == this.getGameBoard()[row - 3][col + 3]) {
							for (int i = 0; i < 4; i++) {
								this.getConnectFour()[i] = new Point(row - i, col + i);
							}
							return start;
						}
					}
				}
				
				//Check diagonal win from bottom right to top left
				for (int row = this.getRows() - 1; row >= 3; row--) {
					for (int col = this.getCols() - 1; col >= 3; col--) {
						start = this.getGameBoard()[row][col];
						if (start != this.EMPTY 
								&& start == this.getGameBoard()[row-1][col-1]
								&& start == this.getGameBoard()[row-2][col-2]
								&& start == this.getGameBoard()[row-3][col-3]) {
							for (int i = 0; i < 4; i++) {
								this.getConnectFour()[i] = new Point(row - i, col - i);
							}
							return start;
						}
					}
				}
				
				return 0;
			}
			

			/**
			 * Restarts the game by setting all the tiles in the game board to empty and 
			 * sets the current turn to red by default.
			 */
			public void restart() {
				for (int i = 0; i < this.getRows(); i++) {
					for (int j = 0; j < this.getCols(); j++) {
						this.getGameBoard()[i][j] = this.EMPTY;
					}
				}
					
				this.setCurrentColor(this.RED);
				this.setWinSequence(false);
				controller.repaint();
			}
		

			public void start(){
				for (int i = 0; i < this.getRows(); i++) {
					for (int j = 0; j < this.getCols(); j++) {
						this.getGameBoard()[i][j] = this.EMPTY;
					}
				}
					
				this.setCurrentColor(this.RED);
				
				this.setWinSequence(false);
				controller.repaint();
			}
			
			//NYTT FRÅN VIEW

			class Panel extends JPanel {

				@Override
				/**
				 * Responsible for updating the view.
				 * Draws the dropping marker if a timer is running and then draws the game board
				 * to simulate the marker dropping inside the game board.
				 * Draws a marker which follows the user's cursor if no timer is running.
				 * Draws the win sequence when a Connect Four is found. 
				 */
				
				public void paintComponent(Graphics g) {
					super.paintComponent(g);
					//Set color of dropping marker to be the current players color
					if (controller.getCurrentColor() == controller.getRed()) {
						controller.setCurrentMarker(redMarker); 
					} else {
						controller.setCurrentMarker(yellowMarker);
					}
					
					if (controller.getTimer().isRunning()) {
						//Draw falling marker
						g.drawImage (controller.getCurrentMarker().getImage(), 
								controller.getMargin() + controller.getDroppingDisc().getX(),
								controller.getDroppingDisc().getY(), 
								controller.getTileSize(), 
								controller.getTileSize(), 
								null);
					} else {
						//Draw marker that follows mouse cursor at top
						if (!controller.getWinSequence())
							g.drawImage (controller.getCurrentMarker().getImage(), 
									controller.getMousePoint().x - (controller.getTileSize() / 2),
									0, 
									controller.getTileSize(), 
									controller.getTileSize(), 
									null);
					}
					
					for (int i = 0; i < controller.getRows(); i++) {
						for (int j = 0; j < controller.getCols(); j++) {
							if (controller.getGameBoard()[i][j]== controller.getRed()) {
								//Draw red markers
								g.drawImage (redMarker.getImage(), //NYTT, var controller.getRedMarker() innan
										controller.getMargin() + j * controller.getTileSize(),
										2 * controller.getMargin() + i * controller.getTileSize(), 
										controller.getTileSize(), 
										controller.getTileSize(), 
										null);
							} else if (controller.getGameBoard()[i][j]== controller.getYellow()) {
								//Draw yellow Markers
								g.drawImage (yellowMarker.getImage(), //NYTT, var controller.getYellowMarker() innan
										controller.getMargin() + j * controller.getTileSize(),
										2 * controller.getMargin() + i * controller.getTileSize(), 
										controller.getTileSize(), 
										controller.getTileSize(), 
										null);
							}
							//Draw the gameBoard
							g.drawImage (gameBoardImage.getImage(), //NYTT, var controller.getRedMarker() innan
									controller.getMargin() + (j * controller.getTileSize()),
									2 * controller.getMargin() + i * controller.getTileSize(), 
									controller.getTileSize(), 
									controller.getTileSize(), 
									null);
						}
					}
					
					if (controller.getWinSequence()) drawWinSequence(g);
				}
			}
			
			/**
			 * Highlights the Connect-four by drawing a transparent image over the discs
			 * and calls a method to draw the winning text.
			 * @param g
			 */
			public void drawWinSequence(Graphics g) {
				//Draw Connect Four
				for (int i = 0; i < this.controller.getConnectFour().length; i++) {
					g.drawImage (this.winningMove.getImage(), //NYTT, var controller.getWinningMove innan
							this.controller.getMargin() + (this.controller.getConnectFour()[i].y * this.controller.getTileSize()),
							2 * this.controller.getMargin() + this.controller.getConnectFour()[i].x * this.controller.getTileSize(), 
							this.controller.getTileSize(), 
							this.controller.getTileSize(), 
							null);
				}
				
				drawWinText(g);
			}
			
			/**
			 * Draws the winning text at the center of the top of the window.
			 * @param g
			 */
			public void drawWinText(Graphics g) {
				String str;
				g.setFont(this.getFont());
				
				if (this.controller.getGameBoard()[this.controller.getConnectFour()[0].x][this.controller.getConnectFour()[0].y] == controller.getRed()) {
					str = "Red Wins";
				} else {
					str = "Yellow Wins";
				}
				
				int strLength = g.getFontMetrics().stringWidth(str);
				int frameWidth = 2 * this.controller.getMargin() + this.controller.getCols() * this.controller.getTileSize();
				
				g.drawString(str, (frameWidth / 2) - (strLength / 2), this.controller.getMargin() + this.controller.getMargin() / 2);
			}
		
		
}

