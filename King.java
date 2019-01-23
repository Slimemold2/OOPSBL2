package chess.piece;

public class King extends ChessPiece{
    public King(Color color){
        super(ChessPieceType.KING, color);
    }

    public String toString(){
        if(this.color==Color.WHITE){
            return "\u265a";
        }
        else{return "\u2654";}
    }
}