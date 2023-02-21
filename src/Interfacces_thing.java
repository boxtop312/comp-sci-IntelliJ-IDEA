import java.util.ArrayList;
import java.util.Objects;

public class Interfacces_thing {
    public static void main(String[] args){

    }
}

class ChessPosition{
    ChessPosition(int x, int y){
        xPos=x;
        yPos=y;
    }
    ChessPosition(){}
    int xPos;
    int yPos;
    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public String toString() {
        return "("+xPos+", "+yPos+")";
    }
}
abstract class ChessPiece{
    ChessPosition currentPosition = new ChessPosition();
    String type;
    ChessPosition startPosition = new ChessPosition();

    ChessPiece(int x, int y, String t){
        startPosition.setxPos(x);
        startPosition.setyPos(y);
        type=t;
    }
    int getxPos(){return currentPosition.getxPos();}
    int getyPos(){return currentPosition.getyPos();}

    public String getType() {return type;}

    abstract boolean canMove(ChessPosition newPosition);

}

interface Threats{
    ChessPosition[][] boardPositions = {{new ChessPosition(0,0), new ChessPosition(1,0), new ChessPosition(2,0), new ChessPosition(3,0), new ChessPosition(4,0), new ChessPosition(5,0), new ChessPosition(6,0), new ChessPosition(7,0)}
                                    , {new ChessPosition(0,1), new ChessPosition(1,1), new ChessPosition(2,1), new ChessPosition(3,1), new ChessPosition(4,1), new ChessPosition(5,1), new ChessPosition(6,1), new ChessPosition(7,1)}
                                    , {new ChessPosition(0,2), new ChessPosition(1,2), new ChessPosition(2,2), new ChessPosition(3,2), new ChessPosition(4,2), new ChessPosition(5,2), new ChessPosition(6,2), new ChessPosition(7,2)}
                                    , {new ChessPosition(0,3), new ChessPosition(1,3), new ChessPosition(2,3), new ChessPosition(3,3), new ChessPosition(4,3), new ChessPosition(5,3), new ChessPosition(6,3), new ChessPosition(7,3)}
                                    , {new ChessPosition(0,4), new ChessPosition(1,4), new ChessPosition(2,4), new ChessPosition(3,4), new ChessPosition(4,4), new ChessPosition(5,4), new ChessPosition(6,4), new ChessPosition(7,4)}
                                    , {new ChessPosition(0,5), new ChessPosition(1,5), new ChessPosition(2,5), new ChessPosition(3,5), new ChessPosition(4,5), new ChessPosition(5,5), new ChessPosition(6,5), new ChessPosition(7,5)}
                                    , {new ChessPosition(0,6), new ChessPosition(1,6), new ChessPosition(2,6), new ChessPosition(3,6), new ChessPosition(4,6), new ChessPosition(5,6), new ChessPosition(6,6), new ChessPosition(7,6)}
                                    , {new ChessPosition(0,7), new ChessPosition(1,7), new ChessPosition(2,7), new ChessPosition(3,7), new ChessPosition(4,7), new ChessPosition(5,7), new ChessPosition(6,7), new ChessPosition(7,7)}};

    ChessPosition checkThreats();
}


class Blank extends ChessPiece{
    Blank(int x, int y) {
        super(x, y, "Blank");
    }
    Blank(){super(-1,-1,"Blank");}

    boolean canMove(ChessPosition newPosition) {
        return false;
    }
}

class Knight extends ChessPiece implements Threats{
    ArrayList<ArrayList<ChessPiece>> board;
    ChessPosition[][] positions = Threats.boardPositions;
    Knight(int x, int y, ArrayList<ArrayList<ChessPiece>> b) {
        super(x, y, "Knight");
        board = b;
        currentPosition=startPosition;
    }

    boolean canMove(ChessPosition newPosition) {
        if(currentPosition.getxPos() == newPosition.getxPos()+2){
            if(currentPosition.getyPos() == newPosition.getyPos()-1){
                return true;
            } else if (currentPosition.getyPos() == newPosition.getyPos()+1) {
                return true;
            } else{return false;}
        } else if (super.currentPosition.getxPos() == newPosition.getxPos()-2) {
            if(currentPosition.getyPos() == newPosition.getyPos()-1){
                return true;
            } else if (currentPosition.getyPos() == newPosition.getyPos()+1) {
                return true;
            } else{return false;}
        } else if (super.currentPosition.getyPos() == newPosition.getyPos()-2) {
            if(currentPosition.getxPos() == newPosition.getxPos()-1){
                return true;
            } else if (currentPosition.getxPos() == newPosition.getxPos()+1) {
                return true;
            } else{return false;}
        } else if (super.currentPosition.getyPos() == newPosition.getyPos()+2) {
            if (currentPosition.getxPos() == newPosition.getxPos() - 1) {
                return true;
            } else if (currentPosition.getxPos() == newPosition.getxPos() + 1) {
                return true;
            } else{return false;}
        }else{return false;}
    }

    public ChessPosition checkThreats() {
        for (ArrayList<ChessPiece> row: board){
            for (ChessPiece piece:row) {
                if (piece.canMove(super.currentPosition)) {
                    return piece.currentPosition;
                } else {
                    return null;
                }
            }
        }
        return null;
    }

    public String toString() {
        return "Knight{" + "Position=" + currentPosition + "}";
    }
}

class Pawn extends ChessPiece implements Threats{

    ArrayList<ArrayList<ChessPiece>> board;
    ChessPosition[][] positions = Threats.boardPositions;
    Pawn(char x, int y, ArrayList<ArrayList<ChessPiece>>b) {
        super(x, y, "Pawn");
        board = b;
        currentPosition=startPosition;
    }


    boolean canMove(ChessPosition newPosition) {
        if(currentPosition==startPosition){
            if(currentPosition.getyPos()-1==newPosition.getyPos()&&currentPosition.getxPos()==currentPosition.getyPos()||currentPosition.getyPos()-2== newPosition.getyPos()&&currentPosition.getxPos()==currentPosition.getyPos()){
                if(Objects.equals(board.get(newPosition.getyPos()).get(newPosition.getxPos()), new Blank(newPosition.getxPos(), newPosition.getyPos()))){
                    return true;
                }
            }else{return false;}
        } else if (currentPosition.getyPos()-1== newPosition.getyPos()&&currentPosition.getxPos()+1== newPosition.getxPos()||currentPosition.getyPos()+1== newPosition.getyPos()&&currentPosition.getxPos()-1== newPosition.getxPos()) {
            return true;
        }
        return false;
    }


    public ChessPosition checkThreats() {
        for (ArrayList<ChessPiece> row: board){
            for (ChessPiece piece:row) {
                if (piece.canMove(super.currentPosition)) {
                    return piece.currentPosition;
                } else {
                    return null;
                }
            }
        }
        return null;
    }
}
