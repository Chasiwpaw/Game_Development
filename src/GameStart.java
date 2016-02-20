import java.util.Scanner;

public class GameStart {
	
	private static int width;
	private static int length;
	private static Board board;
	private static Scanner answer;
	private static Scanner boardSizeScanner;
	private static String firstPlayerName = null;
	private static String secondPlayerName = null;
	private static Player firstPlayer;
	private static Player secondPlayer;
	private static GameTools gameTools = new GameTools();

	public static void main(String[] args) {
		answer = new Scanner(System.in);
		boardSizeScanner = new Scanner(System.in);
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
		firstPlayerName = nameSetter(1);
		secondPlayerName = nameSetter(2);
		board.startingBoard();
		board.printBoard();
		firstPlayer = new Player(firstPlayerName, 1);
		secondPlayer = new Player(secondPlayerName, 2);
		
		System.out.println("Select a Letter shown on the Board");
		board.setBoardPositionValue(2, 0, 1);
		board.setBoardPositionValue(2, 2, 1);
		board.setBoardPositionValue(2, 3, 1);
		board.setBoardPositionValue(2, 4, 1);
		board.setBoardPositionValue(3, 0, 1);
		board.setBoardPositionValue(3, 1, 1);
		board.setBoardPositionValue(3, 2, 1);
		board.setBoardPositionValue(3, 3, 1);
		board.printBoard();
		if(gameTools.checkColumnWin(board, firstPlayer)){
			System.out.println(firstPlayer.getPlayerName()+" wins!");
		}
	}
	
	private static int boardSizeSetter(String sizeName) {
		System.out.println("Enter the size of the " + sizeName + "(must be a number from 4 to 10):");
		int size = boardSizeScanner.nextInt();
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
		int verticalIndex = board.setCoinPermission(horizontalIndex);
		if(verticalIndex == -1){
			System.out.println("The column you have chosen is full, please pick a new column to place your coin.");
			playerMoveSetter(player);
		}
		board.setBoardPositionValue(horizontalIndex, verticalIndex, player.getCoinNumber());
//		gameTools.isGameEnded(board, player);
	}
	
	private static String nameSetter(int playerId) {
		System.out.println("Please Enter a Name for Player " + playerId);
		Scanner nameScanner = new Scanner(System.in);
		String playerOrder = nameScanner.nextLine();
		if (playerOrder.equals("")) {
			return nameSetter(playerId);
		}
		if (firstPlayerName != null && firstPlayerName.equals(playerOrder)) {
			System.out.println("Invalid Name, cannot have the same name as First Player!");
			return nameSetter(playerId);
		}
		return playerOrder;
	}
}
