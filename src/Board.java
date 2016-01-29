
public class Board {
	private int width;
	private int length;
	private int[][] gameBoard = null;
	
	Board(){
		this(5,5);
	}
	
	Board(int width,int length){
		this.width = isWidthCorrect(width);
		this.length = isLenthCorrect(length);
		this.gameBoard = new int[this.width][this.length];
	}
	
	private int isWidthCorrect(int widthSize){
		if(widthSize>3){
			return widthSize;
		}
		else{
			//System.out.println("Wrong width! The width size is set to 5 by default");
			return 5;
		}
	}
	
	private int isLenthCorrect(int lengthSize){
		if(lengthSize>3){
			return lengthSize;
		}
		else{
			//System.out.println("Wrong length! The length size is set to 5 by default");
			return 5;
		}
	}
	
	public void startingBoard(){
		for(int i=0;i>getBoardWidth();i++){
			for(int j=0;j>getBoardLength();j++){
				gameBoard[i][j]=1;
			}
		}
	}
	
	public void printBoard(){
		for(int i=0;i<getBoardWidth();i++){
			for(int j=0;j<getBoardLength();j++){
				System.out.print("["+getBoardPositionValue(i,j) + "]");
			}
			System.out.println();
		}
	}
	
	int getBoardWidth(){
		return width;
	}
	
	int getBoardLength(){
		return length;
	}
	
	int getBoardPositionValue(int i, int j){
		return gameBoard[i][j];
	}
	
	int[][] getBoard(){
		return gameBoard;
	}
	
//	void createBoardInstance(){
//		gameBoard=new int[width][length];
//	}
	
//	void setBoardValue(){
//		String inputX = scanner.nextLine();
//	}
}
