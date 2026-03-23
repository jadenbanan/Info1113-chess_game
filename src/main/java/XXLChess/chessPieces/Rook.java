package XXLChess.chessPieces;

import java.util.List;

import XXLChess.App;
import XXLChess.movementBehaviour.MovementStrategy;
import XXLChess.movementBehaviour.Position;
import XXLChess.movementBehaviour.RookMovement;
import processing.data.JSONObject;

public class Rook extends Piece {
    private MovementStrategy movement = new RookMovement();

    public Rook(int x, int y, boolean isWhite, JSONObject json) {
        super(x, y, isWhite, json);
        // TODO Auto-generated constructor stub
    }

    @Override
    public List<Position> movableWithBlock(App board) {
        return movement.moveableWithBlock(board, this);
    }
}
