package XXLChess.chessPieces;

import java.util.LinkedList;
import java.util.List;

import XXLChess.App;
import XXLChess.movementBehaviour.KingMovement;
import XXLChess.movementBehaviour.MovementStrategy;
import XXLChess.movementBehaviour.Position;
import processing.core.PImage;
import processing.data.JSONObject;

public class King extends Piece {

    private MovementStrategy movement = new KingMovement();

    public King(int x, int y, boolean isWhite, JSONObject json) {
        super(x, y, isWhite, json);
        // TODO Auto-generated constructor stub
    }

    @Override
    public List<Position> movableWithBlock(App board) {
        return movement.moveableWithBlock(board, this);
    }

    public List<Position> movable(App board) {
        return ((KingMovement) movement).movable(board, this);
    }

    public boolean isKing() {
        return true;
    }

}
