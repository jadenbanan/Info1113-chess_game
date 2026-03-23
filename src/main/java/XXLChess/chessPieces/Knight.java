package XXLChess.chessPieces;

import java.util.List;

import processing.data.JSONObject;
import XXLChess.App;
import XXLChess.movementBehaviour.KnightMovement;
import XXLChess.movementBehaviour.MovementStrategy;
import XXLChess.movementBehaviour.Position;

public class Knight extends Piece {

    private MovementStrategy movement = new KnightMovement();

    public Knight(int x, int y, boolean isWhite, JSONObject json) {
        super(x, y, isWhite, json);
    }

    @Override
    public List<Position> movableWithBlock(App board) {
        return movement.moveableWithBlock(board, this);
    }

}
