package XXLChess.chessPieces;

import java.util.List;

import processing.core.PImage;
import processing.data.JSONObject;
import XXLChess.App;
import XXLChess.movementBehaviour.CamelMovement;
import XXLChess.movementBehaviour.MovementStrategy;
import XXLChess.movementBehaviour.Position;

public class Camel extends Piece {

    private MovementStrategy movement = new CamelMovement();

    public Camel(int x, int y, boolean isWhite, JSONObject json) {
        super(x, y, isWhite, json);
    }

    @Override
    public List<Position> movableWithBlock(App board) {
        return movement.moveableWithBlock(board, this);
    }
}
