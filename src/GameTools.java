
public class GameTools {
	private int counter;
	private int rightDiagonalCounter=1;
	private int leftDiagonalCounter=1;
	
	public boolean checkColumnWin(Board board, Player player) {
		for (int rowIndex = 0; rowIndex < board.getBoardRowLength(); rowIndex++) {
			counter = 0;
			for (int columnIndex = 0; columnIndex < board
					.getBoardColumnLength(); columnIndex++) {
				if (board.getBoardPositionValue(rowIndex, columnIndex) == player
						.getCoinNumber()) {
					++counter;
				}
				if (board.getBoardPositionValue(rowIndex, columnIndex) == 0) {
					counter = 0;
				}
				if (counter >= 4) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean checkVerticalWin(Board board, Player player) {
		for (int columnIndex = 0; columnIndex < board.getBoardColumnLength(); columnIndex++) {
			counter = 0;
			for (int rowIndex = 0; rowIndex < board.getBoardRowLength(); rowIndex++) {
				if (board.getBoardPositionValue(rowIndex, columnIndex) == player
						.getCoinNumber()) {
					++counter;
				}
				if (board.getBoardPositionValue(rowIndex, columnIndex) == 0) {
					counter = 0;
				}
				if (counter >= 4) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean checkDiagonalWin(Board board, Player player){
		for(int rowIndex=0; rowIndex<board.getBoardRowLength(); rowIndex++){
			for(int columnIndex=0; columnIndex<board.getBoardColumnLength(); columnIndex++){
				if(board.getBoardPositionValue(rowIndex,columnIndex)==player.getCoinNumber()){
					if(rowIndex<board.getBoardRowLength()-2 && columnIndex>0){
						leftDiagonalChecker(rowIndex, columnIndex, board);
					}
					if(rowIndex<board.getBoardRowLength()-2 && columnIndex<board.getBoardColumnLength()-2){
						rightDiagonalChecker(rowIndex, columnIndex, board);
					}
					if(rightDiagonalCounter>3 || leftDiagonalCounter>3){
						return true;
					}
				}
				leftDiagonalCounter = 1;
				rightDiagonalCounter = 1;
			}
		}
		return false;
	}
	
	public int leftDiagonalChecker(int rowIndex, int columnIndex, Board board){
		if(board.getBoardPositionValue(rowIndex, columnIndex)==board.getBoardPositionValue(++rowIndex, --columnIndex)){
			++leftDiagonalCounter;
			if(rowIndex<board.getBoardRowLength()-1 && columnIndex>0){
				return leftDiagonalChecker(rowIndex, columnIndex, board);
			}
		}
		return leftDiagonalCounter;
	}
	
	public int rightDiagonalChecker(int rowIndex, int columnIndex, Board board){
		if(board.getBoardPositionValue(rowIndex, columnIndex)==board.getBoardPositionValue(++rowIndex, ++columnIndex)){
			++leftDiagonalCounter;
			if(rowIndex<board.getBoardRowLength()-1 && columnIndex<board.getBoardColumnLength()-1){
				return rightDiagonalChecker(rowIndex, columnIndex, board);
			}
		}
		return rightDiagonalCounter;
	}
	
	public boolean isGameEnded(Board board, Player player){
		if(board.hasReached4thColumn()){
			if(checkVerticalWin(board, player)/*|| checkDiagonalWin(board, player)*/){
				System.out.println("vertical");
				return true;
			}
			if(/*checkVerticalWin(board, player) ||*/ checkDiagonalWin(board, player)){
				System.out.println("diagonal");
				return true;
			}
		}
		return checkColumnWin(board, player);
	}
	
	
}
