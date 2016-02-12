import java.util.Scanner;

public class Player {
	private String playerName;
	private int coinNumber;
	private Scanner playerMove = null;
	private String coinCoordinate;
	
	Player(String playerName, int coinNumber){
		this.playerName=playerName;
		this.coinNumber=coinNumber;
		this.playerMove = new Scanner(System.in);
	}
	
	public String getPlayerNumber(){
		return playerName;
	}
	
	public int getCoinNumber(){
		return coinNumber;
	}
	
	public String getPlayerMove(){
		return coinCoordinate;
	}
	
	public void setPlayerMove(){
		coinCoordinate = playerMove.nextLine();
	}	
}
