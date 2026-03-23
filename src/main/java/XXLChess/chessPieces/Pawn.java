package XXLChess.chessPieces;

import java.util.List;

import processing.data.JSONObject;
import XXLChess.movementBehaviour.PawnMovement;
import XXLChess.App;
import XXLChess.movementBehaviour.MovementStrategy;
import XXLChess.movementBehaviour.Position;

public class Pawn extends Piece {

    private MovementStrategy movement = new PawnMovement();

    public Pawn(int x, int y, boolean isWhite, JSONObject json) {
        super(x, y, isWhite, json);
    }

    @Override
    public List<Position> movableWithBlock(App board) {
        return movement.moveableWithBlock(board, this);
    }
}
