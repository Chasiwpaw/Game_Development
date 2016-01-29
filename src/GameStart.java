import java.util.Arrays;

public class GameStart {

	public static void main(String[] args) {
		Board test = new Board();
		test.startingBoard();
		test.printBoard();
		Player A = new Player("Andrew", 1);
		System.out.println("Put a number");
		A.setPlayerMove();
		System.out.println("Here is the coordinates");
		System.out.println(A.getPlayerMove());
	}

}
