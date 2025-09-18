import java.util.ArrayList;

/**
 * The O_R_Player class which extends the base player class and implements the
 * minMax algorithm in order to find the "optimal move" in the game of
 * TicTacToe.
 * 
 * @author Owen Resnikoff
 * @version 9/18/2025
 */
public class O_R_Player extends Player {
    /**
     * Hold the symbol for the minimizing player(opponent) and the maximizng
     * player(= to symbol)
     */
    private final int MINIMIZER;
    private final int MAXIMIZER;

    /**
     * Perform a deep copy of a given board. Utility function used in the computing
     * the next move.
     * 
     * @param board The board to be copied
     * @return A copy of the provided board
     */
    private static Board copyBoard(Board board) {
        Board out = new Board();

        // this just looks through all the spaces in the provided board fills the output
        // board with the same values
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                int contentAt = board.getContents(c, r);
                if (contentAt != Board.BLANK)
                    out.fillPosition(c, r, contentAt);
            }
        }
        return out;
    }

    /**
     * Obtain an ArrayList<int[]> of all the available moves on a given board.
     * 
     * @param board The board to be inspected
     * @return An ArrayList containing integer arrays (int[2]) of the form:
     *         {row,column}
     */
    private static ArrayList<int[]> enumerateMoves(Board board) {
        ArrayList<int[]> out = new ArrayList<int[]>();

        // this is equivalent to looking through all cells in the board and returning
        // the pairs (in the form int[2] = {r, c}) representing blanks i.e all open
        // positions
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (board.getContents(c, r) == Board.BLANK) {
                    int[] pair = { r, c };
                    out.add(pair);
                }
            }
        }
        return out;
    }

    /**
     * Base function from which the MinMax algorithm is performed.
     * 
     * @param board The input board to find the best move for
     * @return int[2] of the form {row, column} containing the best move according
     *         to the computation
     */
    private int[] bestMove(Board board) {
        // get the possible moves for this board
        ArrayList<int[]> moves = enumerateMoves(board);
        int[] outMove = moves.get(0);

        int bestScore = Integer.MIN_VALUE;
        for (int[] move : moves) {
            // find a score for the move
            Board nextState = copyBoard(board);
            nextState.fillPosition(move[1], move[0], symbol);
            int score = evaluateMove(nextState, true); // minimizing = true because this class represents the maximizing
                                                       // player and the next move will be done by the minimizer

        
            if (score > bestScore) {
                bestScore = score;
                outMove = move;
            }
        }

        return outMove;
    }

    /**
     * A recursive function which will evaluate the value of a move by recursively
     * calling itself to find solutions.
     * 
     * Note:
     * A better explanation of the algorithm can be found below.
     * 
     * @param board      The board to be inspected
     * @param minimizing Whether the "player" is minimizing or not
     * @return One of the following values:
     *         0 if tie game
     *         1 if this player wins
     *         -1 if other player wins
     * 
     */
    private int evaluateMove(Board board, boolean minimizing) {
        /**
         * # A Description of The Min Max Algorithm
         * 
         * The algorithm that this class implements is called the Min Max algorithm and
         * it is a fairly famous (and simple) algorithm in writing game "AI". The way it
         * works is fairly simple. In a game with two players their is a minimizer and a
         * maximizer. Player1 (this player) is looking to mazimize their score while the
         * opponent is trying to minimize Player1's score. This algorithm simulates this
         * battle by playing a game between a minimizer and a maximizer in order to find
         * the move that has the best possible outcome (maximum score) for the
         * maximizer.
         * 
         * On each call to this method the player (as specified by the minimizing
         * parameter) will search through all the possible moves for the provided board
         * and return the best value (best meaning lowest or highest depending on the
         * minimizing parameter). Not all moves can be immediately evaluated to a score
         * (no of the possible moves on an empty board will win the game) so those that
         * can't immediatly be resolved to a value will retrieve said value by
         * recursively calling this function with minimizing = !minimizing in order to
         * simulate the adversary player.
         */

        // the best score is initialized to a large or small value based on minimizing
        int bestScore = (minimizing) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        // determine the symbol
        int playerSymbol = (minimizing) ? MINIMIZER : MAXIMIZER;

        int winningPlayer = board.getWinner();
        if (winningPlayer == -1) {
            if (board.boardFilled()) // tie game has a value of 0
                return 0;

            for (int[] move : enumerateMoves(board)) { // search through possible moves
                // copy the board and make the possible move on it
                Board nextState = copyBoard(board);
                nextState.fillPosition(move[1], move[0], playerSymbol);

                if (minimizing) {
                    bestScore = Math.min(bestScore, evaluateMove(nextState, false));
                } else {
                    bestScore = Math.max(bestScore, evaluateMove(nextState, true));
                }
            }

        } else if (winningPlayer == MAXIMIZER) {// return the corresponding score if the move results in a winner
            return 1;
        } else if (winningPlayer == MINIMIZER) {
            return -1;
        }

        return bestScore;
    }

    /**
     * Instantiate the Player superclass and set the internal variables.
     * 
     * @param symbol This player's symbol
     * @param name   This player's name
     */
    public O_R_Player(int symbol, String name) {
        super(symbol, name);

        // assign the MINIMIZER and MAXIMIZER constants based on this player's symbol
        MINIMIZER = symbol == Board.X ? Board.O : Board.X;
        MAXIMIZER = symbol;
    }

    /**
     * Make the "best possible move" according the the result of the MinMax
     * algorithm.
     * 
     * @param theBoard the board to make the move on
     */
    @Override
    public void makeMove(Board theBoard) {
        // make a copy of the board and find the best move
        Board boardCopy = copyBoard(theBoard);
        int[] move = bestMove(boardCopy);

        theBoard.fillPosition(move[1], move[0], symbol);
    }
}