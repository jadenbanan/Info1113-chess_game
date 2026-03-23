package XXLChess.chessPieces;

import java.util.List;

import XXLChess.App;
import XXLChess.movementBehaviour.MovementStrategy;
import XXLChess.movementBehaviour.Position;
import XXLChess.movementBehaviour.QueenMovement;

import processing.data.JSONObject;

public class Queen extends Piece {
    private MovementStrategy movement = new QueenMovement();

    public Queen(int x, int y, boolean isWhite, JSONObject json) {
        super(x, y, isWhite, json);
    }

    @Override
    public List<Position> movableWithBlock(App board) {
        return movement.moveableWithBlock(board, this);
    }

}
