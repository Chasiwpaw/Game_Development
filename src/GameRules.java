
public class GameRules {
	private int counter;
	private Board board;
	private Player coin;
	private int rightDiagonalCounter=0;
	private int leftDiagonalCounter=0;
	
	public boolean checkHorizontalWin(){
		for(int i=0; i<board.getBoardWidth(); i++){
			counter=0;
			for(int j=0; j<board.getBoardLength(); j++){
				if(board.getBoardPositionValue(i, j)==coin.getCoinNumber()){
					++counter;
				}
				if(board.getBoardPositionValue(i, j)==0){
					counter=0;
				}
			}
		}
		return (counter>=4);
	}
	
	public boolean checkVerticalWin(){
		for(int j=0; j<board.getBoardLength(); j++){
			counter=0;
			for(int i=0; i<board.getBoardWidth(); i++){
				if(board.getBoardPositionValue(i, j)==coin.getCoinNumber()){
					++counter;
				}
				if(board.getBoardPositionValue(i, j)==0){
					counter=0;
				}
			}
		}
		return (counter>=4);
	}
	
	public boolean checkDiagonalWin(){
		for(int i=0; i<board.getBoardWidth(); i++){
			counter=0;
			for(int j=0; j<board.getBoardLength(); j++){
				if(board.getBoardPositionValue(i,j)==coin.getCoinNumber()){
					leftDiagonalChecker(i, j);
					rightDiagonalChecker(i,j);
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
	
	public void leftDiagonalChecker(int i, int j){
		while(board.getBoardPositionValue(i, j)==board.getBoardPositionValue(i++, j++)){
			rightDiagonalCounter++;
			leftDiagonalChecker(i++,j++);
		}
	}
	
	public void rightDiagonalChecker(int i, int j){
		while(board.getBoardPositionValue(i, j)==board.getBoardPositionValue(i--, j++)){
			leftDiagonalCounter++;
			rightDiagonalChecker(i++,j++);
		}
	}
}
