public class Board {
	private int width;
	private int length;
	private char[] letterCoordinate = null;
//	private int[] numberCoordinate = null;
	private int[][] gameBoard = null;
	
	Board(){
		this(5,5);
	}
	
	Board(int width,int length){
		this.width = width;
		this.length = length;
		this.gameBoard = new int[this.width][this.length];
//		this.numberCoordinate = numberArrayCreator();
		this.letterCoordinate = letterArrayCreator();
	}
	
	private char[] letterArrayCreator() {
		int asciiValueForArray = 65;
		letterCoordinate = new char[getBoardLength()];
		for (int letterIndex = 0; letterIndex<getBoardLength(); letterIndex++) {
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
		for(int i=0;i>getBoardWidth();i++){
			for(int j=0;j>getBoardLength();j++){
				gameBoard[i][j]=1;
			}
		}
	}
	
	public void printBoard(){
		int asciiValue = 65;
//		int sideBoardCoordinate = getBoardWidth();
		for(int i=0;i<getBoardWidth();i++){
			for(int j=0;j<getBoardLength();j++){
				System.out.print("["+getBoardPositionValue(i,j) + "]");
			}
			System.out.println();
		}
		for(int k=0;k<getBoardLength();k++){
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
	
	public int getBoardWidth(){
		return width;
	}
	
	public int getBoardLength(){
		return length;
	}
	
	public int getBoardPositionValue(int i, int j){
		return gameBoard[i][j];
	}
	
	public int[][] getBoard(){
		return gameBoard;
	}
	
	public void setBoardPositionValue(int horizontalIndex, int verticalIndex, int coordinateValue){
		gameBoard[horizontalIndex][verticalIndex]=coordinateValue;
	}
	
	public int userInputConverter(String horizontalCoordinate) {
		for (int horizontalIndex = 0; horizontalIndex < letterCoordinate.length; horizontalIndex++) {
			if (String.valueOf(letterCoordinate[horizontalIndex]) == horizontalCoordinate) {
				return horizontalIndex;
			}
		}
		return -1;
	}
	
	public int setCoinPermission(int horizontalIndex){
		for(int verticalIndex=0; verticalIndex<getBoardWidth(); verticalIndex++){
			if(getBoardPositionValue(horizontalIndex, verticalIndex)==0){
				return verticalIndex;
			}
		}
		return -1;
	}
	
//	void createBoardInstance(){
//		gameBoard=new int[width][length];
//	}
	
//	void setBoardValue(){
//		String inputX = scanner.nextLine();
//	}
}
