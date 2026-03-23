package XXLChess.chessPieces;

import java.util.List;

import XXLChess.App;
import XXLChess.movementBehaviour.ArchBishopMovement;
import XXLChess.movementBehaviour.MovementStrategy;
import XXLChess.movementBehaviour.Position;

import processing.core.PImage;
import processing.data.JSONObject;

public class ArchBishop extends Piece {
    private MovementStrategy movement = new ArchBishopMovement();

    public ArchBishop(int x, int y, boolean isWhite, JSONObject json) {
        super(x, y, isWhite, json);
        // TODO Auto-generated constructor stub
    }

    @Override
    public List<Position> movableWithBlock(App board) {
        return movement.moveableWithBlock(board, this);
    }

}
