package Controller;
import Model.Connect4Model;
import Model.Disc;
import Model.Player;
import View.Connect4JFrame;

import java.awt.Panel;
import java.awt.Point;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Connect4Controller {

	private Connect4Model model; 
	private Connect4JFrame view;
	private Player playerOne = new Player();
	private Player playerTwo = new Player();
	
	public int getCurrentColor() {
		return model.getCurrentColor();
	}
	
	public int getMargin() {
		return model.getMargin();
	}
	
	public Disc getDroppingDisc() {
		return model.getDroppingDisc();
	}
	
	public int getDiscSize() {
		return model.getDiscSize();
	}
	
	public int getTileSize() {
		return model.getTileSize();
	}
	
	public boolean getWinSequence() {
		return model.getWinSequence();
	}
	
	public void setWinSequence(boolean winSequence) {
		model.setWinSequence(winSequence);
	}
	
	public Point getClickPoint() {
		return model.getClickPoint();
	}
	
	public Point getMousePoint() {
		return model.getMousePoint();
	}
	
	public int getRows() {
		return model.getRows();
	}
	
	public int getCols() {
		return model.getCols();
	}
	
	public int getFontSize() {
		return model.getFontSize();
	}
	
	public int[][] getGameBoard() {
		return model.getGameBoard();
	}
	
	public Timer getTimer(){
		return model.getTimer();
	}
	
	public Point[] getConnectFour() {
		return model.getConnectFour();
	}
	
	
	public ImageIcon getGameBoardImage(){
		return model.getGameBoardImage();
	} 
	
	public JButton getRestartButton() {
		return model.getRestartButton();
	}
	 
	
	public ImageIcon getRestartIcon() {
		return model.getRestartIcon();
	}
	
	public ImageIcon getYellowMarker (){
		return model.getYellowMarker();
	}
	
	public ImageIcon getRedMarker (){
		return model.getRedMarker();
	}
	
	public ImageIcon getWinningMove(){
		return model.getWinningMove();
	}
	
	
	public void addRestartButtonListener(ActionListener l) {
		model.addRestartButtonListener(l);
	}
	
	public ImageIcon getCurrentMarker() {
		return model.getCurrentMarker();
	}
	
	public void setCurrentMarker(ImageIcon icon){
		model.setCurrentMarker(icon);
	}
	
	public int getRed(){
		return model.RED;
	}
	
	public int getYellow(){
		return model.YELLOW;
	}
	
	public int getEmpty(){
		return model.EMPTY;
	}
	
	public void setupDroppingDisc(){
		model.setupDroppingDisc();
	}
	
	public int checkWin(){
		return model.checkWin();
	}
	
	public void switchColor(){
		model.switchColor();
	}
	
	public void restart(){
		model.restart();
	}
	
	public void start(){
		model.start();
	}

	public void repaint(){
		view.repaint();
	}
	
	public void addPanel(Panel panel) {
		view.getContentPane().add(panel);
	}
	public void createGame(String p1, String p2){
		playerOne.setName(p1);
		playerOne.setWins(0);
		playerTwo.setName(p2);
		playerTwo.setWins(0);
	}
}
