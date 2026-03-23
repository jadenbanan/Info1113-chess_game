package XXLChess.chessPieces;

import java.util.List;

import XXLChess.App;
import XXLChess.movementBehaviour.BishopMovement;
import XXLChess.movementBehaviour.MovementStrategy;
import XXLChess.movementBehaviour.Position;
import XXLChess.movementBehaviour.RookMovement;

import processing.core.PImage;
import processing.data.JSONObject;

public class Bishop extends Piece {
    private MovementStrategy movement = new BishopMovement();

    public Bishop(int x, int y, boolean isWhite, JSONObject json) {
        super(x, y, isWhite, json);
        // TODO Auto-generated constructor stub
    }

    @Override
    public List<Position> movableWithBlock(App board) {
        return movement.moveableWithBlock(board, this);
    }

}
