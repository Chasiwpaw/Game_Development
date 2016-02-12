import java.util.Scanner;

public class GameStart {
	
	private static int width;
	private static int length;
	private static Board board;
	private static Scanner answer;
	private static Scanner boardSizeScanner;
	private static Scanner nameScanner;
	private static String firstPlayerName = null;
	private static String secondPlayerName = null;
	private static Player firstPlayer;
	private static Player secondPlayer;

	public static void main(String[] args) {
		answer = new Scanner(System.in);
		boardSizeScanner = new Scanner(System.in);
		nameScanner = new Scanner(System.in);
		System.out.println("Welcome to game Connect 4!");
		System.out.println();
		System.out.println("Would you like to set the size of the board? (yes/no)");
		
		if(answer.nextLine().equals("yes")){
			width = boardSizeSetter("width");
			length = boardSizeSetter("length");
			board = new Board(width, length);
		}
		else{
			System.out.println("The default board has a size of 5x5");
			board = new Board();
		}
		
		// Set player Name
		firstPlayerName = nameSetter(1);
		secondPlayerName = nameSetter(2);
		board.startingBoard();
		board.printBoard();
		firstPlayer = new Player(firstPlayerName, 1);
		secondPlayer = new Player(secondPlayerName, 2);
		
		
		System.out.println("Put a number");
		firstPlayer.setPlayerMove();
		System.out.println("Here is the coordinates");
		System.out.println(firstPlayer.getPlayerMove());
	}
	
	private static int boardSizeSetter(String sizeName) {
		System.out.println("Enter the size of the " + sizeName + "(must be a number from 4 to 10):");
		int size = boardSizeScanner.nextInt();
		if (!(size >= 4 && size <= 10)) {
			return boardSizeSetter(sizeName);
		}
		return size;
	}
	
	private static String nameSetter(int playerId){
			System.out.println("Please Enter a Name for Player "+playerId);
			String playerOrder = nameScanner.nextLine();
			if(playerOrder.equals("")){
				return nameSetter(playerId);
			}
			if(firstPlayerName==playerOrder){
				return nameSetter(playerId);
			}
			return playerOrder;
	}
}
