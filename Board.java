package chess;
import chess.piece.*;
public class Board{
    //0 für leer, 1-6 für Klasse?
    //1,7 Pawn, 2,8 Rook, 3,9 Knight, 4,10 Bishop, 5,11 Queen, 6,12 King
    //1-6 White, 7-12 Black
    //oder von Typ ChessPiece? Sinnvoller wegen Color!
    ChessPiece[][] Board;
    //int[][] Board=new int[8][8];
    public Board(){
        this.Board=new ChessPiece[8][8];
        Board[0][0]=new Rook(Color.BLACK);
        Board[0][1]=new Knight(Color.BLACK);
        Board[0][2]=new Bishop(Color.BLACK);
        Board[0][3]=new Queen(Color.BLACK);
        Board[0][4]=new King(Color.BLACK);
        Board[0][5]=new Bishop(Color.BLACK);
        Board[0][6]=new Knight(Color.BLACK);
        Board[0][7]=new Rook(Color.BLACK);
        Board[7][0]=new Rook(Color.WHITE);
        Board[7][1]=new Knight(Color.WHITE);
        Board[7][2]=new Bishop(Color.WHITE);
        Board[7][3]=new Queen(Color.WHITE);
        Board[7][4]=new King(Color.WHITE);
        Board[7][5]=new Bishop(Color.WHITE);
        Board[7][6]=new Knight(Color.WHITE);
        Board[7][7]=new Rook(Color.WHITE);
        for(int i=0;i<8;i++){
            Board[1][i]=new Pawn(Color.BLACK);
        }
        for(int i=0;i<8;i++){
            Board[6][i]=new Pawn(Color.WHITE);
        }
    }


    //Namen ändern für Englisch...
    public ChessPiece[][] getBoard(){
        ChessPiece[][] momentaneAufstellung=new ChessPiece[8][8];
        for(int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                momentaneAufstellung[i][j]=this.Board[i][j];
            }
        }
        return momentaneAufstellung;
    }


    public int[] getPosition(ChessPiece piece){
        int[] pos=new int[2];
        for(int i=0;i<8;i++) {
            for (int j = 0; j < 8; j++) {
                if (piece.equals(this.Board[i][j])) {
                    pos[0]=i;
                    pos[1]=j;
                    return pos;
                }
            }
        }
        return pos;
    }

    public void move(int rowCur, int colCur, int rowDes, int colDes){}
    public String toString(){
        String Result="";
        ChessPiece[][] Board=getBoard();
        for(int i=0;i<8;i++) {
            for (int j = 0; j < 8; j++) {
                if(Board[i][j]==null){
                    Result+="\u26da";
                }
                else{Result+=Board[i][j].toString();}
            }
            Result+="\n";
        }
        return Result;
    }

}