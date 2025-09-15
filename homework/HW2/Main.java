public class Main {

	
	public static void main(String[] args) {
		Player p1 = new RandomPlayer(Board.X, "Bad Player");
		Player p2 = new O_R_Player(Board.O, "Owen");


		Tournament.playGame(p1, p2);
	}
}
