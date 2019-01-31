package chess.piece;
import chess.*;

public class Knight extends ChessPiece{
    public Knight(Color color){
        super(ChessPieceType.KNIGHT, color);
    }

    public String toString(){
        if(this.color==Color.WHITE){
            return "\u265e";
        }
        else{return "\u2658";}
    }
    public boolean canMove(Board board, int row, int col){
        int[] pos=board.getPosition(this);
        int currentrow=pos[0];
        int currentcol=pos[1];
        if((currentrow-row==2 || row-currentrow==2)&&(currentcol-col==1||col-currentcol==1)||(currentrow-row==1 || row-currentrow==1)&&(currentcol-col==2||col-currentcol==2)){
            //fuer jede Art verwendbar
            if(board.getBoard()[row][col]==null||board.getBoard()[row][col].getColor()!=this.getColor()){
                return true;
            }
            else{return false;}
        }
        else{return false;}
    }
}