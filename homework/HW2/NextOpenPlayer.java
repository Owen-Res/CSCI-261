/**
 * The NextOpenPlayer class which extends the base class Player. This class
 * overrides the makeMove function. The behavior of this class is to make the
 * first open move starting with top left corner and moving down and to the
 * right.
 * 
 * @author Owen Resnikoff
 * @version 9/18/2025
 */
public class NextOpenPlayer extends Player {

    /**
     * Construct the NextOpenPlayer object
     * 
     * @param symbol The player's symbol (Board.X or Board.O)
     * @param name   The player's name
     */
    public NextOpenPlayer(int symbol, String name) {
        super(symbol, name);
    }

    /**
     * Scan the board from the top left and move down to the bottom right. The first
     * open space that is found via this method of search will be the move mad by
     * the player.
     * 
     * @param theBoard The board on which the move is made
     */
    @Override
    public void makeMove(Board theBoard) {
        // if the board is full, do nothing
        if (theBoard.boardFilled())
            return;

        for (int r = 2; r >= 0; r--) { // We have to do r-- here and iterate backwards over the rows because the top left corner is (r:2, c:0)
            for (int c = 0; c < 3; c++) {
                if (theBoard.isOpen(c, r)) {
                    theBoard.fillPosition(c, r, symbol);
                    return;
                }
            }
        }
    }
}
