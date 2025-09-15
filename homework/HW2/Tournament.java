public class Tournament {
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

        //Has someone won yet?
        int winSentry = theBoard.getWinner();
        while (winSentry == -1 && !theBoard.boardFilled()) {
            
            if (isPlayerOne)
                p1.makeMove(theBoard);
            else
                p2.makeMove(theBoard);

            System.out.println(theBoard);

            isPlayerOne = !isPlayerOne;
            winSentry = theBoard.getWinner();
        }

        if (winSentry == -1) {
            System.out.println(p1.mourn());
            System.out.println(p2.mourn());
            return null;
        } else if (winSentry == Board.X) {
            System.out.println(p1.celebrate());
            System.out.println(p2.mourn());
            return p1;
        } else {
            System.out.println(p2.celebrate());
            System.out.println(p1.mourn());
            return p2;
        }
    }
}
