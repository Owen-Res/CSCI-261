import java.util.Random;

/**
 * The RandomPlayer class which acts with the naive strategy of simply choosing
 * a random open position on the board and making a move there.
 * 
 * @author Owen Resnikoff
 * @version 9/18/2025
 */
public class RandomPlayer extends Player {

    /**
     * Instantiate the Player superclass and set the internal variables.
     * 
     * @param symbol This player's symbol
     * @param name   This player's name
     */
    RandomPlayer(int symbol, String name) {
        super(symbol, name);
    }

    @Override
    public void makeMove(Board theBoard) {
        // If the board is filled and we don't exit early this becomes an infinite loop
        if (theBoard.boardFilled())
            return;

        Random random = new Random(); // RNG object

        // try random positions on the board until one of them is empty
        int r, c;
        do { // do is here because the values of r and c need to be set to something
             // reasonable before they may be evaluated as open by the board
            r = random.nextInt(0, 3);
            c = random.nextInt(0, 3);
        } while (!theBoard.isOpen(r, c));

        theBoard.fillPosition(r, c, symbol);
    }
}