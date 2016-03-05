public class Board {
	private int row;
	private int column;
	private char[] letterCoordinate = null;
//	private int[] numberCoordinate = null;
	private int[][] gameBoard = null;
	
	Board(){
		this(5,5);
	}
	
	Board(int row,int column){
		this.row = row;
		this.column = column;
		this.gameBoard = new int[this.row][this.column];
//		this.numberCoordinate = numberArrayCreator();
		this.letterCoordinate = letterArrayCreator();
	}
	
	private char[] letterArrayCreator() {
		int asciiValueForArray = 65;
		letterCoordinate = new char[getBoardColumnLength()];
		for (int letterIndex = 0; letterIndex<getBoardColumnLength(); letterIndex++) {
			letterCoordinate[letterIndex] = (char) asciiValueForArray;
			asciiValueForArray++;
		}
		return letterCoordinate;
	}

//	private int[] numberArrayCreator() {
//		int sideBoardValue = getBoardWidth();
//		numberCoordinate = new int[getBoardWidth()];
//		for (int numberIndex = 0; numberIndex < getBoardWidth(); numberIndex++) {
//			numberCoordinate[numberIndex] = sideBoardValue;
//			sideBoardValue--;
//		}
//		return numberCoordinate;
//	}
	
//	private int isSizeCorrect(int size){
//		if(size>3){
//			return size;
//		}
//		else{
//			return -1;
//		}
//	}
	
	public void startingBoard(){
		for(int i=0;i>getBoardRowLength();i++){
			for(int j=0;j>getBoardColumnLength();j++){
				gameBoard[i][j]=1;
			}
		}
	}
	
	public void printBoard(){
		int asciiValue = 65;
//		int sideBoardCoordinate = getBoardWidth();
		for(int rowIndex=getBoardRowLength()-1;rowIndex>=0;rowIndex--){
		for(int columnIndex=0;columnIndex<getBoardColumnLength();columnIndex++){
				System.out.print("["+getBoardPositionValue(rowIndex,columnIndex) + "]");
			}
			System.out.println();
		}
		for(int k=0;k<getBoardColumnLength();k++){
			System.out.print(" "+((char)asciiValue++)+" ");
		}
		System.out.println();
//		System.out.println("letter array is "+letterCoordinate.length);
//		for(char letter: letterCoordinate){
//			System.out.print("["+letter+"]");
//		}
//		System.out.println();
//		System.out.println("number array is "+numberCoordinate.length);
//		for(int number: numberCoordinate){
//			System.out.print("["+number+"]");
//		}
//		System.out.println();
	}
	
	public int getBoardRowLength(){
		return row;
	}
	
	public int getBoardColumnLength(){
		return column;
	}
	
	public int getBoardPositionValue(int rowIndex, int columnIndex){
		return gameBoard[rowIndex][columnIndex];
	}
	
	public int[][] getBoard(){
		return gameBoard;
	}
	
	public void setBoardPositionValue(int rowIndex, int columnIndex, int coordinateValue){
		gameBoard[rowIndex][columnIndex]=coordinateValue;
	}

	public int userInputConverter(String horizontalCoordinate) {
		for (int horizontalIndex = 0; horizontalIndex < letterCoordinate.length; horizontalIndex++) {
			if (String.valueOf(letterCoordinate[horizontalIndex]).equals(horizontalCoordinate)) {
				return horizontalIndex;
			}
		}
		return -1;
	}
	
	public int setCoinPermission(int columnIndex){
		for(int rowIndex=0; rowIndex<getBoardRowLength(); rowIndex++){
			if(getBoardPositionValue(rowIndex, columnIndex)==0){
				return rowIndex;
			}
		}
		return -1;
	}
	
	public boolean hasReached4thColumn(){
		for(int columnIndex=0; columnIndex<getBoardColumnLength(); columnIndex++){
			if(getBoardPositionValue(3, columnIndex)!=0){
				return true;
			}
		}
		return false;
	}
	
//	void createBoardInstance(){
//		gameBoard=new int[width][length];
//	}
	
//	void setBoardValue(){
//		String inputX = scanner.nextLine();
//	}
}
