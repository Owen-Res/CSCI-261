import java.util.Random;

public class RandomPlayer extends Player {

    RandomPlayer(int symbol, String name) {
        super(symbol, name);
    }

    @Override
    public void makeMove(Board theBoard) {
        if(theBoard.boardFilled())
            return;

        Random random = new Random();

        int r, c;
        r = random.nextInt(0, 3);
        c = random.nextInt(0, 3);

        while (!theBoard.isOpen(r, c)) {
            r = random.nextInt(0, 3);
            c = random.nextInt(0, 3);
        }

        theBoard.fillPosition(r, c, symbol);
    }
}