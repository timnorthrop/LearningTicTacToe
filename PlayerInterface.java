
/**
* interface PlayerInterface
* 
* 
*
* @author J. Smith
* @version May 2018, March 2020
*/
public interface PlayerInterface
{
   /*
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
   int takeTurn (int position);  
}