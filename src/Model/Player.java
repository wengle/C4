package Model;

public class Player {

	public String name;
	
	private int wins;
	
	public Player(){
		
	}
	
	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}
    
     /* 
	 *  Get a player name.
	 */
	
	public String getName(){
		return this.name;
	}
	
	/* 
	 *  Set a name to a player.
	 */
	
	public void setName(String name){
		this.name = name;
	}
	
}
