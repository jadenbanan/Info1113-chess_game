package XXLChess;

import org.junit.Test;

import com.jogamp.newt.event.InputEvent;
import com.jogamp.newt.event.MouseListener;
import java.awt.Robot;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.awt.Point;

import XXLChess.chessPieces.Piece;
import XXLChess.chessPieces.Queen;
import XXLChess.chessPieces.Rook;
import XXLChess.chessPieces.Pawn;
import XXLChess.movementBehaviour.Position;
import processing.core.PApplet;
import processing.core.PImage;
import processing.data.JSONObject;
import processing.event.KeyEvent;
import processing.event.MouseEvent;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class SampleTest {
    // public static App app;

    // Test when the powerUp is active
    @Test
    public void testPowerUp1() {
        App app = new App();
        app.loop();
        PApplet.runSketch(new String[] { "App" }, app);
        app.setup();
        app.delay(5000);

        Piece pawn = app.getPiece(new Position(1, 1));
        assertEquals(Pawn.class, (pawn.getClass()));

        app.mousePressed(new MouseEvent(app, System.currentTimeMillis(), 1, 1, 0, 11 * 48, 1, 1));
        app.mousePressed(new MouseEvent(app, System.currentTimeMillis(), 1, 1, 0, 11 * 48, 1, 1));
        assertEquals(app.playerMovement, 0);
    }

    public static void testReadTxtFile() {
        App app = new App();
        assertEquals(28, App.getPieces().size());
    }

    public static void checkQueen() {
        App board = new App();
        Position pos = new Position(3, 4);
        boolean isWhite = true;

        // Add a queen to the board
        board.makeQueen(pos, isWhite);
        // Verify that the queen was added to the board

        assertEquals(1, App.getPieces().size());
        assertTrue(App.getPieces().get(0) instanceof Queen);
        assertEquals(pos.getX(), App.getPieces().get(0).getX());
        assertEquals(isWhite, App.getPieces().get(0).isWhite());

    }

    public static void testisKingUnderAttack() {
        App app = new App();
        assertEquals(false, app.isKingUnderAttack(false));

    }

    public static void testKeyPressed() {
        final App board = new App();
        PApplet.runSketch(new String[] { "Chess Board" }, board);

        // Create and dispatch a key event for the 'r' key
        Long k = new Long(10 % 200);
        char ch = 'r';
        KeyEvent event = new KeyEvent(board, 1, 1, 0, 'r', 69, false);

        board.keyPressed(event);

        // Verify that the game was restarted
        assertFalse(board.isPaused(false));

        // Create and dispatch a key event for the 'e' key
        KeyEvent eventz = new KeyEvent(board, 1, 1, 0, 'e', 101, false);
        board.keyPressed(eventz);

        // Verify that the game is paused and the "You resigned" message is displayed
        assertTrue(board.getPieces().isEmpty());
        assertTrue(board.isPaused(false));
    }

    public void testRestartGame() {
        List<Piece> piec = new ArrayList<Piece>();
        piec = App.getPieces();
        App app = new App();
        // Add some pieces to the board

        // Ensure that the board is not empty
        assertNotEquals(0, piec.size());

        // Restart the game
        app.restartGame();

        // Ensure that the board is empty
        assertEquals(0, piec.size());
        assertEquals(0, app.getRed().size());
        assertEquals(0, app.getGreen().size());
        assertEquals(0, app.getClicked().size());
        assertEquals(0, app.getblue().size());

        // Ensure that the player movement count is reset to zero
        assertEquals(0, app.getPlayerMovement());
    }

    public void testBotAi() {
        App board = new App();

        // Set the colour to black
        board.colour.set(0, true);
        assertEquals(board.getPlayerMovement(), 0);
        // Set the timer for black
        board.timer.set(3, 3);

        // Call the botAi() method
        board.botAi();

        assertEquals(4, (int) board.timer.get(3));

        assertEquals(true, board.getblue().isEmpty());

        board.colour.set(0, false);
        assertEquals(board.getPlayerMovement(), 1);
        board.timer.set(3, 3);
        assertEquals(4, (int) board.timer.get(3));
        assert ((board.getGreen().size()) != 0);

    }

    @Test
    public void kingInCheckOnlyShowsLegalEscapeSquares() throws IOException {
        App.getPieces().clear();

        Path tempDir = Files.createTempDirectory("xxlchess-check-test-");
        Path layoutPath = tempDir.resolve("layout-check.txt");
        Path configPath = tempDir.resolve("config-check.json");

        // 14x14 board. White king at (4,13), black rook at (4,0): king is in check.
        List<String> rows = Arrays.asList(
                "....R.........",
                "..............",
                "..............",
                "..............",
                "..............",
                "..............",
                "..............",
                "..............",
                "..............",
                "..............",
                "..............",
                "..............",
                "..............",
                "....k.........");
        Files.write(layoutPath, rows);

        String json = "{\n"
                + "  \"layout\": \"" + layoutPath.toAbsolutePath().toString().replace("\\", "\\\\") + "\",\n"
                + "  \"time_controls\": {\n"
                + "    \"player\": {\"seconds\": 180, \"increment\": 2},\n"
                + "    \"cpu\": {\"seconds\": 180, \"increment\": 2}\n"
                + "  },\n"
                + "  \"player_colour\": \"white\",\n"
                + "  \"piece_movement_speed\": 6.0,\n"
                + "  \"max_movement_time\": 1\n"
                + "}";
        Files.writeString(configPath, json);

        App app = new App();
        app.configPath = configPath.toAbsolutePath().toString();
        app.loop();
        PApplet.runSketch(new String[] { "App" }, app);
        app.setup();

        // Select the white king.
        app.mousePressed(new MouseEvent(app, System.currentTimeMillis(), 1, 1, 4 * 48 + 1, 13 * 48 + 1, 1, 1));

        Set<String> legalMoves = new HashSet<String>();
        app.getblue().forEach(pos -> legalMoves.add(pos.getX() + "," + pos.getY()));

        // King cannot move forward into same rook file while in check.
        assertFalse(legalMoves.contains("4,12"));

        // Side/diagonal escapes should be legal in this position.
        assertTrue(legalMoves.contains("3,13"));
        assertTrue(legalMoves.contains("5,13"));
        assertTrue(legalMoves.contains("3,12"));
        assertTrue(legalMoves.contains("5,12"));
    }
}
