package chess;
import chess.piece.*;
import java.io.Serializable;

public class Board implements Serializable{
    //Board constists of 64 ChessPiece objects;
    //ChessPiece=null for empty fields;
    ChessPiece[][] Board;
    //constructor generating board with the starting positions
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


    //Gets the board at the moment, meaning the positions of every ChessPiece on the field
    public ChessPiece[][] getBoard(){
        ChessPiece[][] currentPositions=new ChessPiece[8][8];
        for(int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                currentPositions[i][j]=this.Board[i][j];
            }
        }
        return currentPositions;
    }

    //Function to receive the current position of a certain ChessPiece at the moment
    //First Integer tells row (0-7), second the column (0-7)
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

    public void move(int rowCur, int colCur, int rowDes, int colDes){
        ChessPiece[][] Board=getBoard();
        ChessPiece Piece=Board[rowCur][colCur];
        //if canmove==true...
        Board[rowCur][colCur]=null;
        Board[rowDes][colDes]=Piece;
        this.Board=Board;
    }


    //Get the current board and turn it into a String visualizing it
    public String toString(){
        String Result=" a.b.cd.e.fg.h\n";
        ChessPiece[][] Board=getBoard();
        for(int i=0;i<8;i++) {
            Result+=(i+1);
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