package chess;
import java.util.Arrays;
import chess.*;
import java.util.ArrayList;
import chess.piece.*;
import java.util.Scanner;
import java.io.*;

//Class game, mainly to get the user input to do turns or to save or load games
public class Game implements Serializable{
    ArrayList<String> moves;
    Board board;
    ChessPiece whiteKing;
    ChessPiece blackKing;
    public boolean end=false;
    int player=1;
    int round=0;
    Color currentColor=Color.WHITE;
    String winner;
    String command="";
    char[] coordinates;
    int row=0;
    int col=0;
    int rowDest=0;
    int colDest=0;
    boolean invalidInput=true;
    boolean invalidMove=true;
    boolean[][] possDest;
    public static Scanner input= new Scanner(System.in);
    transient FileWriter fw = null;

    //main function, contains the loop to allow the Players to do their turns
    public static void main(String args[]){
        //Different ways to start the game
        //Game game=loadGameByMoves(movesTest);
        //Game game=loadGame("gametest");
        //Game game=loadGameByMoves("test2");
        Game game=new Game();

        //Game starts:
        System.out.println("Instructions:");

        System.out.println("To select a field type two numbers between 0 and 7, i.e. 00 would be field a1, 10 a2...");
        System.out.println("First select a field with one of the Chess pieces of your color.");
        System.out.println("Next select the field where you want to move your figure.\n");

        System.out.println("White starts");
        //until a King gets destroyed:
        while(game.end==false){
            game.invalidInput=true;
            game.invalidMove=true;

            //determine whose turn it is
            game.player=game.player%2;
            if(game.player==1){
                game.currentColor=Color.WHITE;
                System.out.println("Whites turn");
                game.round=game.round+1;
            }
            else{
                game.currentColor=Color.BLACK;
                System.out.println("Blacks turn");
            }

            System.out.println("Turn "+game.round);

            //Show board to player
            System.out.print(game.board.toString());

            //**************
            //The actual turn the player does:
            //until he selects a field with a figure of his color
            while(game.invalidInput) {
                System.out.println("Select one of your figures");
                game.command = input.nextLine();
                game.coordinates = game.command.toCharArray();
                //catch invalid input
                if(game.coordinates.length!=2||translateColumn(game.coordinates[0])<0||translateColumn(game.coordinates[0])>7||Character.getNumericValue(game.coordinates[1])<1||Character.getNumericValue(game.coordinates[1])>8){
                    System.out.println("Type the field you want, eg. a4");
                }
                else {
                    game.row = Character.getNumericValue(game.coordinates[1]) - 1;
                    game.col = translateColumn(game.coordinates[0]);
                    if (!(0 <= game.row && game.row <= 7 && 0 <= game.col && game.col <= 7)) {
                        System.out.println("Select a field by typing the field you want, eg. a4, c2...");
                    } else if (game.board.getBoard()[game.row][game.col] == null) {
                        System.out.println("Select a field with a figure of your color.");
                    } else if (game.board.getBoard()[game.row][game.col].getColor() != game.currentColor) {
                        System.out.println("Select a field with a figure of your color.");
                    } else {
                        game.invalidInput = false;
                        System.out.println("You selected field " + translateColumn(game.col) + (game.row + 1));
                        //until he selects a field where his figure can actually move
                        while (game.invalidMove) {
                            System.out.println("Select where you want to go");
                            System.out.println("Type 'back' to select another figure");
                            game.command = input.nextLine();
                            if (game.command.equals("back")) {
                                game.invalidInput = true;
                                break;
                            }
                            game.coordinates = game.command.toCharArray();
                            //catch invalid input
                            if (game.coordinates.length != 2 || translateColumn(game.coordinates[0]) < 0 || translateColumn(game.coordinates[0]) > 7 || Character.getNumericValue(game.coordinates[1]) < 1 || Character.getNumericValue(game.coordinates[1]) > 8) {
                                System.out.println("Type the field you want, eg. a4");
                            } else {
                                game.rowDest = Character.getNumericValue(game.coordinates[1]) - 1;
                                game.colDest = translateColumn(game.coordinates[0]);
                                game.possDest = game.board.getBoard()[game.row][game.col].getPossibleDestinations(game.board);
                                if (!(game.possDest[game.rowDest][game.colDest])) {
                                    System.out.println("Can't move there. Select valid field.");
                                } else {
                                    game.invalidMove = false;
                                }
                            }
                        }
                    }
                }
            }


            //Do the move and store it
            if(game.board.getBoard()[game.rowDest][game.colDest]==null){
                game.moves.add(game.board.getBoard()[game.row][game.col].toString()+ translateColumn(game.col) + (game.row+1)  + "-" + translateColumn(game.colDest) + (game.rowDest+1));
            }
            else {
                game.moves.add(game.board.getBoard()[game.row][game.col].toString()+ translateColumn(game.col) + (game.row+1)  + "-" + translateColumn(game.colDest) + (game.rowDest+1) + game.board.getBoard()[game.rowDest][game.colDest].toString());
            }
            game.board.move(game.row,game.col,game.rowDest,game.colDest);
            game.player=game.player+1;

            //Check if the game ended
            if(game.board.getBoard()[game.rowDest][game.colDest].getClass().equals("class chess.piece.King")){
                game.end=true;
                //Check who won
                if(game.currentColor==Color.WHITE) {
                    game.winner = "White";
                }
                else {game.winner="Black";}
            }
        }


        System.out.println("The game is over");
        if(game.winner.equals("Black")){
            System.out.println("Black won");
        }
        else{System.out.println("White won");}
        input.close();
    }

    //Constructor to create a board with the usual starting positions;
    public Game(){
        this.moves=new ArrayList<String>();
        this.board=new Board();
        this.whiteKing=this.board.getBoard()[0][4];
        this.blackKing=this.board.getBoard()[7][4];
        this.end=false;
        this.player=1;
        this.round=0;
        this.currentColor=Color.WHITE;
        this.command="";
        this.invalidInput=true;
        this.invalidMove=true;
    }

    //getter function
    public ArrayList<String> getMoves(){return this.moves;}

    //save the moves done so far in a new file with the name filename
    public void saveMoves(String filename) {
        File file=new File(filename);
        ArrayList<String> array=getMoves();
        try {
            fw = new FileWriter(file, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            for(int i=0;i<array.size();i++){
                fw.write(array.get(i));
                fw.write(System.lineSeparator());
                fw.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fw.close();
            } catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    //save the whole Game object in a new file with the name fileName
    public void saveGame(String fileName){
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(
                    new FileOutputStream(fileName));
            Game game = this;
            oos.writeObject(game);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (oos != null)
                try { oos.close(); }
                catch (IOException e) {}
        }
    }

    //load stored Game-object from file fileName
    public static Game loadGame(String fileName){
        Game game=null;
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(fileName));
            Object obj = ois.readObject(); // Objekt einlesen
            if (obj instanceof Game) { // Wenn richtiger Typ, Objekt casten
                game = (Game) obj;
                return game;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            if (ois != null)
                try { ois.close(); }
                catch (IOException e) {}
        }
        return game;
    }

    //load Game from moves stored in file fileName
    public static Game loadGameByMoves(String fileName){
        Game game=new Game();
        FileReader rd=null;
        ArrayList<String> moves=new ArrayList<String>();
        String move;
        try {
            rd = new FileReader(fileName);
            BufferedReader br=new BufferedReader(rd);
            do{
                move=br.readLine();
                if(move!=null) {
                    moves.add(move);
                }
            } while(move!=null);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (rd != null)
                try { rd.close(); }
                catch (IOException e) {}
        }
        game=loadGameByMoves(moves);
        return game;
    }

    //load Game by redoing the moves stored in moves
    public static Game loadGameByMoves(ArrayList<String> moves){
        Game game=new Game();
        for(int i=0; i<moves.size();i++){
            String move=moves.get(i);
            char[] array=move.toCharArray();
            int row=Character.getNumericValue(array[2])-1;
            int col=translateColumn(array[1]);
            int rowDest=Character.getNumericValue(array[5])-1;
            int colDest=translateColumn(array[4]);
            if(game.board.getBoard()[rowDest][colDest]==null){
                game.moves.add(game.board.getBoard()[row][col].toString()+ translateColumn(col) + (row+1)  + "-" + translateColumn(colDest) + (rowDest+1));
            }
            else {
                game.moves.add(game.board.getBoard()[row][col].toString()+ translateColumn(col) + (row+1)  + "-" + translateColumn(colDest) + (rowDest+1) + game.board.getBoard()[game.rowDest][game.colDest].toString());
            }
            game.board.move(row,col,rowDest,colDest);

            game.player=game.player+1;
            game.round+=1;
        }
        return game;
    }

    //translate the column from integer (0-7) used intern to a character (a-h) for the user
    public static char translateColumn(int position){
        if(position==0){return 'a';}
        if(position==1){return 'b';}
        if(position==2){return 'c';}
        if(position==3){return 'd';}
        if(position==4){return 'e';}
        if(position==5){return 'f';}
        if(position==6){return 'g';}
        else{return 'h';}
    }
    //reverses above function
    public static int translateColumn(char position){
        if(position=='a'){return 0;}
        if(position=='b'){return 1;}
        if(position=='c'){return 2;}
        if(position=='d'){return 3;}
        if(position=='e'){return 4;}
        if(position=='f'){return 5;}
        if(position=='g'){return 6;}
        else{return 7;}
    }

}