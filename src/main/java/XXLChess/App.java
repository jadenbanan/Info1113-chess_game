package XXLChess;

//import org.reflections.Reflections;
//import org.reflections.scanners.Scanners;
import processing.core.PApplet;
import processing.core.PImage;
import processing.data.JSONObject;

import processing.event.MouseEvent;

import java.util.concurrent.TimeUnit;

import java.util.stream.Collectors;

import XXLChess.chessPieces.Amazon;
import XXLChess.chessPieces.ArchBishop;
import XXLChess.chessPieces.Bishop;
import XXLChess.chessPieces.Camel;
import XXLChess.chessPieces.Chancellor;
import XXLChess.chessPieces.King;
import XXLChess.chessPieces.Knight;
import XXLChess.chessPieces.KnightKing;
import XXLChess.chessPieces.Pawn;
import XXLChess.chessPieces.Piece;
import XXLChess.chessPieces.Queen;
import XXLChess.chessPieces.Rook;
import XXLChess.movementBehaviour.Position;

import java.io.*;

import java.util.*;

public class App extends PApplet {

    public static final int SPRITESIZE = 480;
    public static final int CELLSIZE = 48;
    public static final int SIDEBAR = 120;
    public static final int BOARD_WIDTH = 14;
    public static final float cellSize = 48;
    public static int WIDTH = CELLSIZE * BOARD_WIDTH + SIDEBAR;
    public static int HEIGHT = BOARD_WIDTH * CELLSIZE;

    int rows = 14;
    int cols = 14;
    public static final int FPS = 60;

    private static List<Piece> pieces = new ArrayList<Piece>();
    private List<Position> blue = new ArrayList<Position>();

    private List<Piece> clicked = new ArrayList<Piece>();

    private List<Position> green = new ArrayList<Position>();

    private List<Position> red = new ArrayList<Position>();

    List<Integer> timer = new ArrayList<Integer>();

    public List<Integer> movement = new ArrayList<Integer>();

    public List<String> layout = new ArrayList<String>();

    public List<Boolean> colour = new ArrayList<Boolean>();

    public List<JSONObject> jsonObj = new ArrayList<JSONObject>();

    int playerMovement = 0;

    boolean wAttackable = false;

    boolean bAttackable = false;

    int frameCounter = 0;

    int constantTimer;

    int constantTimerBot;

    int botTimer = 0;

    boolean wKingUnderAttack = false;

    boolean bKingUnderAttack = false;

    public boolean paused = false;

    public boolean test = false;

    // Timer

    // rows & column

    public String configPath;

    public App() {
        this.configPath = "config.json";
        System.out.println("$buildDir");
    }

    /**
     * Initialise the setting of the window siz e.
     */

    // reads the txt file
    public void readTxtfile() {
        // Load board layout from text file
        if (test == false) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(layout.get(0)));
                String line;

                int y = 0;
                while ((line = reader.readLine()) != null) {
                    int x = 0;
                    for (int i = 0; i < line.length(); i++) {
                        char pieceCode = line.charAt(i);
                        switch (pieceCode) {
                            case 'a':
                                printPiece("wa", x, y);
                                break;
                            case 'A':
                                printPiece("ba", x, y);
                                break;
                            case 'p':
                                printPiece("wP", x, y);
                                break;
                            case 'P':
                                printPiece("bP", x, y);
                                break;

                            case 'r':
                                printPiece("wR", x, y);
                                break;
                            case 'R':
                                printPiece("bR", x, y);
                                break;
                            case 'n':
                                printPiece("wN", x, y);
                                break;
                            case 'N':
                                printPiece("bN", x, y);
                                break;
                            case 'b':
                                printPiece("wB", x, y);
                                break;
                            case 'B':
                                printPiece("bB", x, y);
                                break;
                            case 'q':
                                printPiece("wQ", x, y);
                                break;
                            case 'Q':
                                printPiece("bQ", x, y);
                                break;
                            case 'k':
                                printPiece("wK", x, y);
                                break;
                            case 'K':
                                printPiece("bK", x, y);
                                break;
                            case 'h':
                                printPiece("wh", x, y);
                                break;
                            case 'H':
                                printPiece("bh", x, y);
                                break;
                            case 'c':
                                printPiece("wc", x, y);
                                break;
                            case 'C':
                                printPiece("bc", x, y);
                                break;
                            case 'g':
                                printPiece("wg", x, y);
                                break;
                            case 'G':
                                printPiece("bg", x, y);
                                break;
                            case 'e':
                                printPiece("we", x, y);
                                break;
                            case 'E':
                                printPiece("be", x, y);
                                break;

                        }
                        x++;
                    }
                    y++;
                }
                test = true;
                reader.close();
            } catch (IOException e) {
                println("Error reading board layout file: " + e.getMessage());
                return;
            }
        }
    }

    // gives the piece location to print
    public void printPiece(String name, int x, int y) {
        if (name == "wP") {
            pieces.add(new Pawn(x, y, true, jsonObj.get(0)));

        }
        if (name == "bP") {
            pieces.add(new Pawn(x, y, false, jsonObj.get(0)));

        }
        if (name == "wR") {
            pieces.add(new Rook(x, y, true, jsonObj.get(0)));

        }
        if (name == "bR") {
            pieces.add(new Rook(x, y, false, jsonObj.get(0)));

        }
        if (name == "wN") {
            pieces.add(new Knight(x, y, true, jsonObj.get(0)));

        }
        if (name == "bN") {
            pieces.add(new Knight(x, y, false, jsonObj.get(0)));
        }
        if (name == "wB") {
            pieces.add(new Bishop(x, y, true, jsonObj.get(0)));
        }
        if (name == "bB") {
            pieces.add(new Bishop(x, y, false, jsonObj.get(0)));
        }
        if (name == "wQ") {
            pieces.add(new Queen(x, y, true, jsonObj.get(0)));

        }
        if (name == "bQ") {
            pieces.add(new Queen(x, y, false, jsonObj.get(0)));
        }
        if (name == "wK") {
            pieces.add(new King(x, y, true, jsonObj.get(0)));
        }
        if (name == "bK") {
            pieces.add(new King(x, y, false, jsonObj.get(0)));

        }
        if (name == "wh") {
            pieces.add(new ArchBishop(x, y, true, jsonObj.get(0)));
        }
        if (name == "bh") {
            pieces.add(new ArchBishop(x, y, false, jsonObj.get(0)));
        }
        if (name == "wc") {
            pieces.add(new Camel(x, y, true, jsonObj.get(0)));
        }
        if (name == "bc") {
            pieces.add(new Camel(x, y, false, jsonObj.get(0)));
        }
        if (name == "wg") {
            pieces.add(new KnightKing(x, y, true, jsonObj.get(0)));
        }
        if (name == "bg") {
            pieces.add(new KnightKing(x, y, false, jsonObj.get(0)));
        }
        if (name == "we") {
            pieces.add(new Chancellor(x, y, true, jsonObj.get(0)));

        }
        if (name == "be") {
            pieces.add(new Chancellor(x, y, false, jsonObj.get(0)));

        }
        if (name == "wa") {
            pieces.add(new Amazon(x, y, true, jsonObj.get(0)));

        }
        if (name == "ba") {
            pieces.add(new Amazon(x, y, false, jsonObj.get(0)));
        }

    }

    public void settings() {
        size(WIDTH, HEIGHT);
    }

    /**
     * Load all resources such as images. Initialise the elements such as the
     * player, enemies and map elements.
     */

    public void setup() {
        JSONObject json = loadJSONObject(configPath);
        jsonObj.add(json);
        layout.add(json.getString("layout"));
        readTxtfile();

        if (json.getString("player_colour").equals("white")) {
            colour.add(true);

        }
        if (json.getString("player_colour").equals("black")) {
            colour.add(false);
        }
        JSONObject obj = json.getJSONObject("time_controls");

        JSONObject human = obj.getJSONObject("player");
        JSONObject computer = obj.getJSONObject("cpu");
        constantTimer = human.getInt("seconds");
        constantTimerBot = computer.getInt("seconds");
        timer.add(human.getInt("seconds"));
        timer.add(human.getInt("increment"));
        timer.add(computer.getInt("seconds"));
        timer.add(computer.getInt("increment"));

        frameRate(FPS);
        PImage bPawn = loadImage("src/main/resources/XXLChess/b-pawn.png");
        PImage wPawn = loadImage("src/main/resources/XXLChess/w-pawn.png");
        List<Pawn> pawns = getPieces(Pawn.class);
        pawns.forEach(pawn -> {
            if (pawn.isWhite()) {
                pawn.setImage(wPawn);
            } else {
                pawn.setImage(bPawn);
            }
        });
        PImage bRook = loadImage("src/main/resources/XXLChess/b-rook.png");
        PImage wRook = loadImage("src/main/resources/XXLChess/w-rook.png");
        List<Rook> rooks = getPieces(Rook.class);
        rooks.forEach(rook -> {
            if (rook.isWhite()) {
                rook.setImage(wRook);
            } else {
                rook.setImage(bRook);
            }
        });

        PImage bKnight = loadImage("src/main/resources/XXLChess/b-knight.png");
        PImage wKnight = loadImage("src/main/resources/XXLChess/w-knight.png");
        setImage(Knight.class, wKnight, bKnight);

        PImage bBishop = loadImage("src/main/resources/XXLChess/b-bishop.png");
        PImage wBishop = loadImage("src/main/resources/XXLChess/w-bishop.png");
        setImage(Bishop.class, wBishop, bBishop);

        PImage bArchBishop = loadImage("src/main/resources/XXLChess/b-archbishop.png");
        PImage wArchBishop = loadImage("src/main/resources/XXLChess/w-archbishop.png");
        setImage(ArchBishop.class, wArchBishop, bArchBishop);

        PImage bChancellor = loadImage("src/main/resources/XXLChess/b-chancellor.png");
        PImage wChancellor = loadImage("src/main/resources/XXLChess/w-chancellor.png");
        setImage(Chancellor.class, wChancellor, bChancellor);

        PImage bCamel = loadImage("src/main/resources/XXLChess/b-camel.png");
        PImage wCamel = loadImage("src/main/resources/XXLChess/w-camel.png");
        setImage(Camel.class, wCamel, bCamel);

        PImage bKnightKing = loadImage("src/main/resources/XXLChess/b-knight-king.png");
        PImage wKnightKing = loadImage("src/main/resources/XXLChess/w-knight-king.png");
        setImage(KnightKing.class, wKnightKing, bKnightKing);

        PImage wAmazon = loadImage("src/main/resources/XXLChess/w-amazon.png");
        PImage bAmazon = loadImage("src/main/resources/XXLChess/b-amazon.png");
        setImage(Amazon.class, wAmazon, bAmazon);

        PImage wKing = loadImage("src/main/resources/XXLChess/w-king.png");
        PImage bKing = loadImage("src/main/resources/XXLChess/b-king.png");
        setImage(King.class, wKing, bKing);

        background(192);
        stroke(240, 217, 181);
        chessBoard();
    }

    private <T extends Piece> void setImage(Class<T> type, PImage white, PImage black) {
        getPieces(type).forEach(piece -> {
            if (piece.isWhite()) {
                piece.setImage(white);
            } else {
                piece.setImage(black);
            }
        });

    }

    void makeQueen(Position pos, boolean isWhite) {
        pieces.add(new Queen(pos.getX(), pos.getY(), isWhite, jsonObj.get(0)));
        PImage wQueen = loadImage("src/main/resources/XXLChess/w-queen.png");
        PImage bQueen = loadImage("src/main/resources/XXLChess/b-queen.png");
        setImage(Queen.class, wQueen, bQueen);
    }

    public <T extends Piece> List<T> getPieces(Class<T> type) {
        return pieces.stream().filter(type::isInstance).map(type::cast).collect(Collectors.toList());
    }

    public static List<Piece> getPieces() {
        return pieces;
    }

    public Piece getPiece(Position pos) {
        for (Piece piece : pieces) {
            if (piece.getX() == pos.getX() && piece.getY() == pos.getY()) {
                return piece;
            }
        }
        return null;
    }

    private boolean isInsideBoard(Position position) {
        return position.getX() >= 0 && position.getX() < cols && position.getY() >= 0 && position.getY() < rows;
    }

    private Piece getKingPiece(boolean isWhite) {
        for (Piece piece : pieces) {
            if (piece.isKing() && piece.isWhite() == isWhite) {
                return piece;
            }
        }
        return null;
    }

    private boolean isPawnAttackingSquare(Piece pawn, Position target) {
        int forward = (pawn.isWhite() == playerColour()) ? -1 : 1;
        int attackY = pawn.getY() + forward;
        return target.getY() == attackY && (target.getX() == pawn.getX() - 1 || target.getX() == pawn.getX() + 1);
    }

    private boolean isSquareAttacked(Position target, boolean attackerIsWhite) {
        if (!isInsideBoard(target)) {
            return false;
        }

        for (Piece piece : pieces) {
            if (piece.isWhite() != attackerIsWhite) {
                continue;
            }

            if (piece instanceof Pawn) {
                if (isPawnAttackingSquare(piece, target)) {
                    return true;
                }
            } else if (piece.isKing()) {
                if (((King) piece).movable(this).contains(target)) {
                    return true;
                }
            } else if (piece.movableWithBlock(this).contains(target)) {
                return true;
            }
        }

        return false;
    }

    private boolean isMoveLegal(Piece piece, Position destination) {
        if (!isInsideBoard(destination)) {
            return false;
        }

        int originalX = piece.getX();
        int originalY = piece.getY();
        Piece captured = getPiece(destination);

        // A piece cannot move onto a square occupied by an allied piece.
        if (captured != null && captured.isWhite() == piece.isWhite()) {
            return false;
        }

        if (captured != null) {
            pieces.remove(captured);
        }

        piece.setX(destination.getX());
        piece.setY(destination.getY());

        Piece king = piece.isKing() ? piece : getKingPiece(piece.isWhite());
        boolean legal = king != null && checkPosIsSafe(new Position(king.getX(), king.getY()), piece.isWhite());

        piece.setX(originalX);
        piece.setY(originalY);

        if (captured != null) {
            pieces.add(captured);
        }

        return legal;
    }

    private List<Position> getLegalMoves(Piece piece) {
        List<Position> legalMoves = new ArrayList<Position>();
        List<Position> candidateMoves = piece.movableWithBlock(this);

        candidateMoves.forEach(pos -> {
            if (isMoveLegal(piece, pos)) {
                legalMoves.add(pos);
            }
        });

        return legalMoves;
    }

    public String getConfigPath() {
        return configPath;
    }

    public boolean playerColour() {
        return colour.get(0);
    }

    /**
     * return 0 if no piece
     * return 1 if ally
     * return -1 if enemie
     */
    public int isPosOccupied(Position position, Boolean isWhite) {
        for (Piece piece : pieces) {
            if (position.getX() == piece.getX() && position.getY() == piece.getY()) {
                if (isWhite == piece.isWhite()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        }
        return 0;
    }

    /**
     * Receive key pressed signal from the keyboard.
     */

    public boolean isPaused(boolean paused) {
        return paused;
    }

    public void keyPressed() {
        if (key == 'e') {

            paused = true;
            fill(255, 255, 255);
            textSize(15);
            text("You resigned", 675, height / 3);
            fill(255, 255, 255);
            paused();
        }
        if (key == 'r') {
            paused = false;
            restartGame();
        }

    }

    public void paused() {
        if (constantTimer == 0) {
            paused = true;
            fill(255, 255, 255);
            textSize(10);
            text("You lost on time", 675, height / 3);
        }
        if (constantTimerBot == 0) {
            paused = true;
            fill(255, 255, 255);
            textSize(10);
            text("You won on time", 675, height / 3);

        }
        fill(255, 255, 255);
        textSize(10);
        text("Pressed 'Y' to restart", 675, height / 2);
        text("the game", 675, height / 2 + 20);

    }

    public void restartGame() {

        blue.clear();
        clicked.clear();
        red.clear();
        pieces.clear();
        green.clear();
        setup();
        playerMovement = 0;
    }

    /**
     * Receive key released signal from the keyboard.
     */
    public void keyReleased() {

    }

    private void reset() {
        blue.clear();
        clicked.clear();
    }

    private void removePosOutsideBoard(List<Position> positions) {
        List<Position> positionToRemove = new ArrayList<Position>();

        positions.forEach(pos -> {
            if (pos.getX() >= cols || pos.getX() < 0
                    || pos.getY() >= rows || pos.getY() < 0) {
                positionToRemove.add(pos);
            }
        });

        positionToRemove.forEach(pos -> {
            positions.remove(pos);
        });
    }

    public int getBotTimer() {
        return botTimer;
    }

    public void botAi() {
        if (colour.get(0)) {
            // bot
            constantTimerBot += timer.get(3);
            botTimer += 1;
            List<Piece> blackPieces = new ArrayList<Piece>();
            pieces.forEach(piece -> {
                if (!piece.isWhite()) {
                    blackPieces.add(piece);
                }
            });
            Collections.shuffle(blackPieces);
            for (Piece piece : blackPieces) {
                List<Position> avaliablePos = getLegalMoves(piece);
                removePosOutsideBoard(avaliablePos);
                if (avaliablePos.isEmpty())
                    continue;
                Collections.shuffle(avaliablePos);
                Position pos = avaliablePos.get(0);
                playerMovement++;
                green.clear();
                removePieceAtPos(pos);
                green.add(new Position(piece.getX(), piece.getY()));
                piece.setAnimationX(piece.getX());
                piece.setAnimationY(piece.getY());
                piece.setX(pos.getX());
                piece.setY(pos.getY());
                piece.setMovementRateXY();
                green.add(new Position(piece.getX(), piece.getY()));
                blue.clear();
                break;
            }
        }
        if (!colour.get(0)) {
            List<Piece> whitePieces = new ArrayList<Piece>();
            pieces.forEach(piece -> {
                if (piece.isWhite()) {
                    whitePieces.add(piece);
                }
            });
            Collections.shuffle(whitePieces);
            for (Piece piece : whitePieces) {
                List<Position> avaliablePos = getLegalMoves(piece);
                removePosOutsideBoard(avaliablePos);
                if (avaliablePos.isEmpty())
                    continue;
                Collections.shuffle(avaliablePos);
                Position pos = avaliablePos.get(0);
                playerMovement++;
                green.clear();
                removePieceAtPos(pos);
                green.add(new Position(piece.getX(), piece.getY()));
                piece.setAnimationX(piece.getX());
                piece.setAnimationY(piece.getY());
                piece.setX(pos.getX());
                piece.setY(pos.getY());
                piece.setMovementRateXY();
                green.add(new Position(piece.getX(), piece.getY()));
                blue.clear();
                break;
            }
        }

    }

    @Override

    public void mousePressed(MouseEvent e) {

        int squareClickedX = e.getX() / 48;
        int squareClickedY = e.getY() / 48;
        if (blue.isEmpty()) {
            // not selected
        } else {
            blue.forEach(pos -> {
                Piece piece = clicked.get(0);
                if (pos.getX() == squareClickedX && pos.getY() == squareClickedY) {

                    green.clear();
                    removePieceAtPos(pos);
                    green.add(new Position(piece.getX(), piece.getY()));
                    piece.setAnimationX(piece.getX());
                    piece.setAnimationY(piece.getY());
                    piece.setX(squareClickedX);
                    piece.setY(squareClickedY);
                    piece.setMovementRateXY();
                    green.add(new Position(piece.getX(), piece.getY()));
                    constantTimer += 2;

                    playerMovement++;

                }
            });
        }

        reset();
        if (playerMovement % 2 == 0 && colour.get(0)) {
            for (Piece piece : new ArrayList<Piece>(pieces)) {
                if (piece.getX() == squareClickedX && piece.getY() == squareClickedY && piece.isWhite() == true) {

                    if (clicked.isEmpty()) {
                        clicked.add(piece);
                    }
                    clicked.set(0, piece);
                    getLegalMoves(piece).forEach(position -> {

                        blue.add(position);
                    });

                }
            }

        }
        if (playerMovement % 2 != 0 && colour.get(0)) {
            botAi();
        }

        if (!colour.get(0) && playerMovement != 0) {
            for (Piece piece : new ArrayList<Piece>(pieces)) {
                if (piece.getX() == squareClickedX && piece.getY() == squareClickedY && piece.isWhite() == false) {
                    if (clicked.isEmpty()) {
                        clicked.add(piece);
                    }
                    clicked.set(0, piece);
                    getLegalMoves(piece).forEach(position -> {
                        blue.add(position);
                    });
                }
            }

        }
        if (playerMovement % 2 == 0 && !colour.get(0)) {
            botAi();
        }

        // After click blue square
        // for each remaining pieces
        // update

        // Make queens
        List<Pawn> pawns = getPieces(Pawn.class);
        List<Piece> toRemove = new ArrayList<Piece>();
        pawns.forEach(pawn -> {
            if ((pawn.isWhite() && pawn.getY() == 0) || (!pawn.isWhite() && pawn.getY() == 13)) {
                toRemove.add(pawn);
                makeQueen(new Position(pawn.getX(), pawn.getY()), pawn.isWhite());
            }
        });
        pieces.removeAll(toRemove);

        removePosOutsideBoard(blue);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    public void removePieceAtPos(Position pos) {
        List<Piece> toRemove = new ArrayList<Piece>();
        pieces.forEach(piece -> {
            if (piece.getX() == pos.getX() && piece.getY() == pos.getY()) {
                if (piece.isKing() && piece.isWhite() == colour.get(0)) {
                    paused = true;
                    fill(255, 255, 255);
                    textSize(10);
                    text("You lost", 675, height / 3);

                }
                if (piece.isKing() && piece.isWhite() != colour.get(0)) {
                    paused = true;
                    fill(255, 255, 255);
                    textSize(10);
                    text("You won", 675, height / 3);
                }
                toRemove.add(piece);

            }
        });
        pieces.removeAll(toRemove);
    }

    // Check if the king is able to move to the location
    public boolean checkPosIsSafe(Position position, boolean isWhite) {
        return !isSquareAttacked(position, !isWhite);
    }

    public void chessBoard() {
        boolean isLightBrown = true; // Keep track if the square is light brown.

        // looping through the column and row
        for (float i = 0; i < rows; i++) {
            for (float j = 0; j < cols; j++) {

                if (isLightBrown == true) {
                    fill(181, 136, 99);
                }

                else {
                    fill(240, 217, 181);

                }

                rect(i * cellSize, j * cellSize, cellSize, cellSize);

                isLightBrown = !isLightBrown;

            }

            isLightBrown = !isLightBrown;
        }
        fill(192);
        rect(width - 10, 0, 10, height);
        colourYellow();
        colourBoxBlue();
        colourGreen();
        colourRed();

    }

    /**
     * Draw all elements in the game by current frame.
     */

    public void draw() {
        if (!paused) {
            drawTimerBot();
            chessBoard();
            pieces.forEach(p -> {

                p.draw(this);
            });
        }
    }

    private void drawTimerBot() {
        int fastBot = botTimer;
        int fastBotCounter = constantTimerBot;
        int q = fastBotCounter - fastBot;
        long minutes = TimeUnit.SECONDS.toMinutes(q);
        long seconds = q - TimeUnit.MINUTES.toSeconds(minutes);
        String secondsFormat = String.format("%02d", (seconds));
        String time = ((Long.toString(minutes) + ":" + secondsFormat));
        background(196);
        fill(255, 255, 255);
        textSize(40);
        text(time, 690, 30);
        long minutez = TimeUnit.SECONDS.toMinutes(constantTimer);
        long secondz = constantTimer - TimeUnit.MINUTES.toSeconds(minutez);
        String secondzFormat = String.format("%02d", (secondz));
        String timez = ((Long.toString(minutez) + ":" + secondzFormat));
        fill(255, 255, 255);
        textSize(40);
        text(timez, 690, height - 20);
        frameCounter++;
        if (playerMovement % 2 == 0) {
            if (frameCounter == FPS) {
                constantTimer--;
                frameCounter = 0;
            }
        }
    }

    public List<Position> getRed() {
        return red;

    }

    public List<Position> getblue() {
        return blue;

    }

    public List<Position> getGreen() {
        return green;

    }

    public List<Piece> getClicked() {
        return clicked;

    }

    public int getPlayerMovement() {
        return playerMovement;

    }

    public void colourRed() {
        red.clear();
        wAttackable = false;
        bAttackable = false;
        wKingUnderAttack = false;
        bKingUnderAttack = false;

        for (Piece p : pieces) {
            if (p.isKing() && p.isWhite() == true) {

                for (Piece d : pieces) {
                    if (d.isWhite() == false) {
                        d.movableWithBlock(this).forEach(movable -> {
                            if (movable.getX() == p.getX() && movable.getY() == p.getY()) {
                                wAttackable = true;
                                red.add(movable);
                                wKingUnderAttack = true;
                            }
                        });
                    }
                }

            }
            if (p.isKing() && p.isWhite() == false) {
                for (Piece d : pieces) {
                    if (d.isWhite() == true) {
                        d.movableWithBlock(this).forEach(movable -> {
                            if (movable.getX() == p.getX() && movable.getY() == p.getY()) {
                                bAttackable = true;
                                red.add(movable);
                                bKingUnderAttack = true;

                            }
                        });
                    }
                }

            }

        }
        if (bAttackable == false) {
            if (wAttackable == false) {
                red.clear();
            }
        }
        if (red.isEmpty()) {
        } else {
            red.forEach(box -> {
                int x = box.getX();
                int y = box.getY();

                if (x % 2 != 0) {
                    if (y % 2 != 0) {
                        fill(255, 0, 0);
                    } else {
                        fill(255, 164, 102);
                    }
                } else {
                    if (y % 2 == 0) {
                        fill(170, 162, 58);
                    } else {
                        fill(255, 0, 0);
                    }
                }
                rect(x * cellSize, y * cellSize, cellSize, cellSize);
            });

        }
    }

    public Boolean isKingUnderAttack(boolean isWhite) {
        if (isWhite) {
            return wKingUnderAttack;
        } else {
            return bKingUnderAttack;
        }
    }

    public Boolean LegalMove(Piece piece) {
        return true;

    }

    private void colourYellow() {
        green.forEach(box -> {
            int x = box.getX();
            int y = box.getY();

            if (x % 2 != 0) {
                if (y % 2 != 0) {
                    fill(170, 162, 58);
                } else {
                    fill(205, 210, 106);
                }
            } else {
                if (y % 2 == 0) {
                    fill(170, 162, 58);
                } else {
                    fill(205, 210, 106);
                }
            }
            rect(x * cellSize, y * cellSize, cellSize, cellSize);
        });
    }

    private void colourGreen() {
        if (clicked.isEmpty()) {

        } else {
            fill(105, 138, 76);
            rect(clicked.get(0).getX() * cellSize, clicked.get(0).getY() * cellSize, cellSize, cellSize);

        }
    }

    private void colourBoxBlue() {

        blue.forEach(box -> {
            int x = box.getX();
            int y = box.getY();

            if (box.isEat()) {
                // Colour orange
                fill(255, 164, 102);
            } else {
                // Colour blue
                if (x % 2 != 0) {
                    if (y % 2 != 0) {
                        fill(170, 210, 221);
                    } else {
                        fill(196, 224, 232);
                    }
                } else {
                    if (y % 2 == 0) {
                        fill(170, 210, 221);
                    } else {
                        fill(196, 224, 232);
                    }
                }
            }
            rect(x * cellSize, y * cellSize, cellSize, cellSize);
        });
    }

    // Add any additional methods or attributes you want. Please put classes in
    // different files.

    /*
     * @param args
     */
    public static void main(String[] args) {
        PApplet.main("XXLChess.App");
    }

}
