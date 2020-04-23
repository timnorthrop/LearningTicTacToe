
/**
 * Write a description of class HumanPlayer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class HumanPlayer implements PlayerInterface
{
    private TicTacToeBoard board;
    /*
     * Add a field for the Board and other fields as needed
     */

    /*
     * Initialize the fields
     */
    public HumanPlayer(TicTacToeBoard gameboard){
        board = gameboard;
    }

    /*
     * Good question -- the provided interface does not have
     * move, but a turn method that looks like this.
     * I updated your PlayerInterface to reflect the interface
     * that I shared with class -- at some point you seemed to
     * have missed this piece of information.
     * 
     * 
     *   Here are some ideas for this method
     * @pre 0 <= position < board.size()*board.size()
     * makes a move 0..board.size()*board.size()
     * and returns the final selected position.
     * 
     * possible implementations
     * for human player the input position is what the
     * player input in the game or -1 if that is not a valid 
     * position
     * 
     * for the computer player the input position doesn't matter
     * and the player chooses a position based on its rules and returns
     * the position so the game knows where the computer player moved.
     */

    public int takeTurn (int position){
        //I'm really not sure what part of the move code goes here,
        //because the command is also processed in two different methods
        //in the Interface class.
        if(board.isValidPos(position)){
            board.put(position,'x');
        }

        return position;
    }

    
}
