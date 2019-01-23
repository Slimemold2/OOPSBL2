package chess.piece;

public class Bishop extends ChessPiece{
    public Bishop(Color color){
        super(ChessPieceType.BISHOP, color);
    }

    public String toString(){
        if(this.color==Color.WHITE){
            return "\u265d";
        }
        else{return "\u2657";}
    }
}