
/**
 * Write a description of class TicTacToeBoard here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TicTacToeBoard implements Board
{

    //I don't think there's any errors in here, but I could be very 
    //wrong.
    
    private char[][] board;
    private char winner;

    public TicTacToeBoard(int size){
        board = new char[size][size];
        for (int i = 0; i < size*size; i++){
            put(i, '-');
        }
    }

    public int size(){
        return board[0].length;
    }

    public void clear(){
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[0].length; x++) {
                board[y][x] = '-';
            }
        }
    }

    public boolean isValidSymbol(char symbol){
        if(symbol == 'x' || symbol == 'o' || symbol == '-'){
            return true;
        } else {
            return false;
        }
    }

    public boolean isValidPos(int position){
        if (0 <= position && position <= 8) {
            return true;
        } else {
            return false;
        }
    }

    public int put(int pos, char symbol){
        if (!isValidSymbol(symbol)){
            throw new IllegalArgumentException();
        }
        if (isValidPos(pos)){
            int x = posToCol(pos);
            int y = posToRow(pos);
            board[y][x] = symbol;
            return pos;
        }
        return -1;
    }

    public String toString(){
        String boardString = "";
        for (int y = 0; y < size(); y++){
            for (int x = 0; x < size(); x++){
                boardString = boardString + board[y][x] + " ";
            }
            boardString = boardString + "\n";
        }
        return boardString;
    }

    public boolean isEmpty(int position){
        for (int y = 0; y < size(); y++){
            for (int x = 0; x < size(); y++){
                if (!(board[y][x] == '-')) {
                    return false;
                }
            }
        }
        return true;
    }

    public Board copy(){
        TicTacToeBoard copy = new TicTacToeBoard(size());
        for (int y = 0; y < size(); y++){
            for (int x = 0; x < size(); y++){
                copy.put(rowColToPos(y,x),board[y][x]);
            }
        }
        return copy;
    }

    /*
     * This depends on toString's implementation - while
     * reasonable to compare strings that are use a 
     * overridden version of toString
     * generally equals would be written as
     * its own set of loops - just my opinion on
     * implementation of this method
     */
    @Override
    public boolean equals (Object other){
        other = (TicTacToeBoard)other;
        if (other.toString().equals(toString())) {
            return true;
        }
        return false;
    }

    private int posToRow (int pos)
    {
        int row = pos/board[0].length;

        return row;
    }

    private int posToCol (int pos)
    {
        int col = pos%board[0].length;

        return col;
    }

    private int rowColToPos (int row, int col)
    {
        int pos = row*board[0].length + col;
        return pos;
    }
    
    public char get(int position){
        return board[posToRow(position)][posToCol(position)];
    }

    public char getWinningTeam(){
        return winner;
    }
    
    public boolean checkForWin(){
        for (int y = 0; y < board.length; y++){
            char first = board[y][0];
            boolean line = true;
            if(!(first == '-')){
                for (int x = 0; x < board.length; x++){
                    if (!(board[y][x] == first)) {
                        line = false;
                    }
                    
                }
                if (line) {
                    winner = first;    
                    return true;
                }
            }
        }

        for (int x = 0; x < board.length; x++){
            char first = board[0][x];
            boolean line2 = true;
            if(!(first == '-')){
                for (int y = 0; y < board.length; y++){
                    if (!(board[y][x] == first)) {
                        line2 = false;
                    }
                }
                if (line2) {
                    return true;
                }
            }
        }

        char firstDiag = board[0][0];
        boolean line3 = true;
        if(!(firstDiag == '-')){
            for (int x = 0; x < board.length; x++){
                if (!(board[x][x] == firstDiag)){
                    line3 = false;
                }
            }
            if(line3){
                return true;
            }
        }
        
        char secondDiag = board[0][board.length];
        boolean line2 = true;
        if(!(secondDiag == '-')){
            for (int x = 0; x < board.length; x++){
                if (!(board[x][board.length-x] == secondDiag)){
                    line2 = false;
                }
            }
            if(line2){
                return true;
            }
        }
        return false;
    }
    
    /*
     * nice idea to have test code - 
     * the checkWin method is perhaps the most 
     * essential method - so testing this thoroughly
     * is important - I notice there are no tests
     * for it here -
     */
    public static void main (String[] args){
        TicTacToeBoard board = new TicTacToeBoard(3);
        board.put(8,'x');
        board.put(4,'o');
        TicTacToeBoard board2 = new TicTacToeBoard(3);
        board2.put(8,'x');
        board2.put(4,'o');
        if(board2.equals(board)){
            System.out.println("sko");
        }
        System.out.println(board.toString());
        System.out.println(board2.toString());
    }
}
