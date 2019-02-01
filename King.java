package chess.piece;
import chess.*;

//King subclass;
public class King extends ChessPiece{
    //constructor
    public King(Color color){
        super(ChessPieceType.KING, color);
    }
    //returns special character representing the figure
    public String toString(){
        if(this.color==Color.WHITE){
            return "\u265a";
        }
        else{return "\u2654";}
    }

    //Checks for one field if the chesspiece can move there according to the rules
    public boolean canMove(Board board, int row, int col){
        int[] pos=board.getPosition(this);
        int currentrow=pos[0];
        int currentcol=pos[1];

        //part specific for King; checks whether the field is next to the king
        if(((currentrow-row<=1 && -1<=currentrow-row)||(row-currentrow<=1 && -1<=row-currentrow))&&((currentcol-col<=1 && -1<=currentcol-col)||(col-currentcol<=1 && -1<=col-currentcol))&&!(currentrow-row==0&&currentcol-col==0)){
            //this part is used in every class
            //checks if already a chesspiece of the same color is on the selected field
            if(board.getBoard()[row][col]==null||board.getBoard()[row][col].getColor()!=this.getColor()){
                return true;
            }
            else{return false;}
        }
        else{return false;}
    }
}