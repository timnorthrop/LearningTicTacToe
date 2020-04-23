
/**
 * class UserInterfaceGame is an example of a start that
 * uses the Parser, CommandWord, Commands structure
 * for a text based game.
 * 
 * Handout for APCS 2020
 * To be modified by students
 *
 * @author J. Smith
 * @version February 2020
 */
public class UserInterfaceGame
{
    
    //I tried to have my move code in this class instead of in the
    //player class, but I was having trouble actually "putting" that
    //move on the board, as my instance field for the board is in
    //this class.
    
    /*
     * jsmith:  yes, one strategy is to pass the players need 
     * the board as an input to the constructor
     * see changes I made to the HumanPlayerclass - and a big comment
     */
    
    private Parser parser;
    private TicTacToeBoard board1;
    private PlayerInterface human;
    private PlayerInterface com;

    /**
     * Constructor for objects of class TicTacToeGame
     */
    public UserInterfaceGame()
    {
        parser = new Parser();
        //human = new HumanPlayer();
        
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();
        board1 = new TicTacToeBoard(3);
        System.out.println(board1.toString());

        while (true) {
            Command command = parser.getCommand();

            boolean turnStatus = processCommand(command);
            if (!turnStatus) // bad info entered
            {
                printError();

            }
            else if (command.getCommandWord().equals("quit") && turnStatus)
                break;
            // j. smith removed an if block to eliminate double move bug
            else
            {

            }

        }
    }

    /**
     * Start a new game
     */
    private void freshStart ()
    {
        board1.clear();
        printWelcome();
    }

    private void gameOver()
    {
        System.out.println("Thank you for playing TicTacToe");

    }

    private void printError ()
    {
        System.out.println("Hmm... try again.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("You are playing TicTacToe");
        System.out.println("You should never win, but first");
        System.out.println("you must play LOTS of games against the computer");
        System.out.println("to train it to play well.");

    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {

        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }
        boolean turnState = false;
        String commandWord = command.getCommandWord();
        if (commandWord.equals("quit")) {
            turnState = quit(command);
        }
        else if (commandWord.equals("help")) {
            printHelp();
        }
        else if (commandWord.equals("move")) {
            turnState = move (command);
        }
        return turnState;
    }

    private void printHelp() 
    {
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()||command.hasThirdWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }

    /** 
     * "Move" was entered. 
     * make the move for the player
     * @return true if the player moved correctly, false if error
     *      */
    private boolean move(Command command) 
    {
        if((!command.hasSecondWord())) {
            System.out.println("Move command requires a position number 0..8");
            return false;
        }
        else {
            //if second word is in this array player.move
            // int[] nums = {0,1,2,3,4,5,6,7,8};
            // for (int i = 0; i < nums.length; i++){
                // if (nums[i] == Integer.parseInt(command.getSecondWord())){
                    // human.move(Integer.parseInt(command.getSecondWord()), 'x');
                // }
            // }
            /*
             * jsmith -- here is a starting algorithm for this point
             * 
             * call human player turn method with second word as input
             * print the board
             * check if the human won and do what you wish for that case
             * call the computer player turn method
             * print the board
             * check if the computer won and do what you want in that case
             * 
             */
            
            human.takeTurn(Integer.parseInt(command.getSecondWord()));
            System.out.println(board1.toString());
            if(board1.checkForWin()){
                gameOver();
                freshStart();
            }
            return false;
        }
    }
}
