/**
 * The CornerPlayer class which has the behavior of chosing the positions in the
 * corners of the board if they are open. Given they are not open, default to
 * the behavior of the parent class RandomPlayer.
 * 
 * @author Owen Resnikoff
 * @version 9/18/2025
 */
public class CornerPlayer extends RandomPlayer {

    /**
     * Instantiate the Player superclass and set the internal variables.
     * 
     * @param symbol This player's symbol
     * @param name   This player's name
     */
    public CornerPlayer(int symbol, String name) {
        super(symbol, name);
    }

    /**
     * Make a move by trying every corner, and if no corner is open make a random
     * move.
     * 
     * @param theBoard The board on which the move is made
     */
    @Override
    public void makeMove(Board theBoard) {
        /**
         * The corners on the board will be the positions
         * {{0, 0}, {0, 2}, {2, 0}, {2, 2}}
         */
        for (int r = 0; r <= 2; r += 2) {
            for (int c = 0; c <= 2; c += 2) {
                // make the move if the position is open
                if (theBoard.isOpen(c, r)) {
                    theBoard.fillPosition(c, r, symbol);
                    return;
                }
            }
        }

        // No open corners, default to random move
        super.makeMove(theBoard);
    }
}
