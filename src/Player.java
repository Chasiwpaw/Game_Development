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
	
	String getPlayerNumber(){
		return playerName;
	}
	
	int getCoinNumber(){
		return coinNumber;
	}
	
	String getPlayerMove(){
		return coinCoordinate;
	}
	
	void setPlayerMove(){
		coinCoordinate = playerMove.nextLine();
	}
}
