
public class GameTools {
	private int counter;
	private int rightDiagonalCounter=0;
	private int leftDiagonalCounter=0;
	
	public boolean checkColumnWin(Board board, Player player){
		for(int rowIndex=0; rowIndex<board.getBoardRowLength(); rowIndex++){
			counter=0;
			for(int columnIndex=0; columnIndex<board.getBoardColumnLength(); columnIndex++){
				if(board.getBoardPositionValue(rowIndex, columnIndex)==player.getCoinNumber()){
					++counter;
				}
				if(board.getBoardPositionValue(rowIndex, columnIndex)==0){
					counter=0;
				}
				if(counter>=4){
					return true;
				}
			}
			System.out.println("counter number is "+counter);
		}
		return false;
	}
	
//	public boolean checkVerticalWin(Board board, Player player){
//		for(int j=0; j<board.getBoardColumnLength(); j++){
//			counter=0;
//			for(int i=0; i<board.getBoardRowLength(); i++){
//				if(board.getBoardPositionValue(i, j)==player.getCoinNumber()){
//					++counter;
//				}
//				if(board.getBoardPositionValue(i, j)==0){
//					counter=0;
//				}
//			}
//		}
//		return (counter>=4);
//	}
	
	public boolean checkDiagonalWin(Board board, Player player){
		for(int i=0; i<board.getBoardRowLength(); i++){
			counter=0;
			for(int j=0; j<board.getBoardColumnLength(); j++){
				if(board.getBoardPositionValue(i,j)==player.getCoinNumber()){
					leftDiagonalChecker(i, j, board);
					rightDiagonalChecker(i, j, board);
					if(rightDiagonalCounter>3 || leftDiagonalCounter>3){
						return true;
					}
					else{
						continue;
					}
				}
			}
		}
		return false;
	}
	
	public void leftDiagonalChecker(int i, int j, Board board){
		while(board.getBoardPositionValue(i, j)==board.getBoardPositionValue(i++, j++)){
			rightDiagonalCounter++;
			leftDiagonalChecker(i++, j++, board);
		}
	}
	
	public void rightDiagonalChecker(int i, int j, Board board){
		while(board.getBoardPositionValue(i, j)==board.getBoardPositionValue(i--, j++)){
			leftDiagonalCounter++;
			rightDiagonalChecker(i++, j++, board);
		}
	}
	
//	public boolean isGameEnded(Board board, Player player){
//		return (checkVerticalWin(board, player) || checkColumnWin(board, player)
//				|| checkDiagonalWin(board, player));
//	}
}
