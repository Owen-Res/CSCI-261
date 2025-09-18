/**
 * A class holding the static method playGame which will simulated a game
 * between two players and print data along the way.
 * 
 * @author Owen Resnikoff
 * @version 9/18/2025
 */
public class Tournament {

    /**
     * Play a full game between the provide players and return the winning player.
     * The board will be printed on each move as the gamee progresses.
     * 
     * @param p1 Player one (symbol X)
     * @param p2 Player two (symbol O)
     * @return A reference to the Player that one the game, or null in the case of a
     *         tie
     */
    public static Player playGame(Player p1, Player p2) {
        // ensure symbols are properly set
        p1.setSymbol(Board.X);
        p2.setSymbol(Board.O);

        Board theBoard = new Board();

        /**
         * keep track of whose turn it is, using a boolean makes switching back and
         * forth easy
         */
        boolean isPlayerOne = true;

        // Has someone won yet?
        int winSentry = theBoard.getWinner();
        while (winSentry == -1 && !theBoard.boardFilled()) {

            if (isPlayerOne)
                p1.makeMove(theBoard);
            else
                p2.makeMove(theBoard);

            System.out.println(theBoard);

            isPlayerOne = !isPlayerOne; // Switch the current player
            winSentry = theBoard.getWinner();
        }

        if (winSentry == -1) { // tie game, everyone mourns
            System.out.println(p1.mourn());
            System.out.println(p2.mourn());
            return null;
        } else if (winSentry == Board.X) { // player1 wins and celebrates, player2 mourns
            System.out.println(p1.celebrate());
            System.out.println(p2.mourn());
            return p1;
        } else {// player2 wins and celebrates, player1 mourns
            System.out.println(p2.celebrate());
            System.out.println(p1.mourn());
            return p2;
        }
    }
}
