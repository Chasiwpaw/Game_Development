package connect4game;
import java.util.Scanner;

public class GameStart {
	
	private static int width;
	private static int length;
	private static Board board;
	private static Scanner answer;
//	private static Scanner boardSizeScanner;
	private static String firstPlayerName = null;
	private static String secondPlayerName = null;
	private static Player firstPlayer;
	private static Player secondPlayer;
	private static GameTools gameTools = new GameTools();
	
	public static void main(String[] args) {
		answer = new Scanner(System.in);
//		boardSizeScanner = new Scanner(System.in);
		System.out.println("Welcome to game Connect 4!");
		System.out.println();
		System.out.println("Would you like to set the size of the board? (yes/no)");
		
		if(answer.nextLine().equals("yes")){
			width = boardSizeSetter("width");
			length = boardSizeSetter("length");
			board = new Board(width, length);
		}
		else{
			System.out.println("The default board of 5x5 has been selected");
			board = new Board();
		}
		
		// Set player Name
		firstPlayerName = nameSetter(1, answer);
		secondPlayerName = nameSetter(2, answer);
		firstPlayer = new Player(firstPlayerName, 1, answer);
		secondPlayer = new Player(secondPlayerName, 2, answer);
		board.startingBoard();
		board.printBoard();
		
		System.out.println("Select a Letter shown on the Board");
		while(true){
			playerMoveSetter(firstPlayer);
			if(gameTools.isGameEnded(board, firstPlayer)){
				System.out.println("Player \"" + firstPlayer.getPlayerName()
				+ "\" win!");
				break;
			}
			playerMoveSetter(secondPlayer);
			if(gameTools.isGameEnded(board, secondPlayer)){
				System.out.println("Player \"" + secondPlayer.getPlayerName()
				+ "\" win!");
				break;
			}
		}
	}
	
	private static int boardSizeSetter(String sizeName) {
		System.out.println("Enter the size of the " + sizeName + "(must be a number from 4 to 10):");
		int size = answer.nextInt();
		if (!(size >= 4 && size <= 10)) {
			return boardSizeSetter(sizeName);
		}
		return size;
	}
	
	private static void playerMoveSetter(Player player){
		System.out.println("Player \"" + player.getPlayerName()
				+ "\", please pick your move by entering your letter(column coordinate).");
		player.setPlayerMove();
		int horizontalIndex = board.userInputConverter(player.getPlayerMove());
		if(horizontalIndex == -1){
			System.out.println("Your input is invalid, please enter a valid coordinate.");
			playerMoveSetter(player);
		}
		System.out.println(horizontalIndex);
		int verticalIndex = board.setCoinPermission(horizontalIndex);
		if(verticalIndex == -1){
			System.out.println("The column you have chosen is full, please pick a new column to place your coin.");
			playerMoveSetter(player);
		}
		board.setBoardPositionValue(verticalIndex, horizontalIndex, player.getCoinNumber());
		board.printBoard();
	}
	
	private static String nameSetter(int playerId, Scanner nameScanner) {
		System.out.println("Please Enter a Name for Player " + playerId);
//		Scanner nameScanner = new Scanner(System.in);
		String playerOrder = nameScanner.nextLine();
		if (playerOrder.equals("")) {
			return nameSetter(playerId, nameScanner);
		}
		if (null != firstPlayerName && firstPlayerName.equals(playerOrder)) {
			System.out.println("Invalid Name, cannot have the same name as First Player!");
			return nameSetter(playerId, nameScanner);
		}
		return playerOrder;
	}
}
