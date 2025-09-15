public class CornerPlayer extends RandomPlayer {
    private static final int[][] CORNERS = { { 0, 0 }, { 2, 2 }, { 0, 2 }, { 2, 0 } };

    public CornerPlayer(int symbol, String name) {
        super(symbol, name);
    }

    @Override
    public void makeMove(Board theBoard) {
        for (int corner = 0; corner < CORNERS.length; corner++) {
            int r = CORNERS[corner][0];
            int c = CORNERS[corner][1];

            if(theBoard.isOpen(c, r)){
                theBoard.fillPosition(c, r, symbol);
                return;
            }
        }

        // No open corners, default to random move
        super.makeMove(theBoard);
    }
}
