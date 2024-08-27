package walking.game;

import org.junit.jupiter.api.Test;

import walking.game.util.Direction;

public class WalkingBoardTest {
    @Test
    public void testSimpleInit() {
        WalkingBoard board = new WalkingBoard(3);
        int[][] tiles = board.getTiles();
        assert tiles.length == 3;
        assert tiles[0].length == 3;
    }

    @Test
    public void testCustomInit() {
        int[][] tiles = new int[][] {
            { 1, 2, 3 },
            { 4, 5, 6 },
            { 7, 8, 9 }
        };
        WalkingBoard board = new WalkingBoard(tiles);
        int[][] boardTiles = board.getTiles();
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[0].length; j++) {
                assert boardTiles[i][j] == Math.max(tiles[i][j], WalkingBoard.BASE_TILE_SCORE);
            }
        }
    }
    
    @Test
    public void testMoves() {
        WalkingBoard board = new WalkingBoard(3);
        board.moveAndSet(Direction.RIGHT, 1);  
        int[] position = board.getPosition();
        assert position[0] == 1;
        assert position[1] == 0;
        board.moveAndSet(Direction.UP, 1);
        position = board.getPosition();
        assert position[0] == 1;
        assert position[1] == 1;
        board.moveAndSet(Direction.UP, 2);
        position = board.getPosition();
        assert position[0] == 1;
        assert position[1] == 2;
        int outOfBounds = board.moveAndSet(Direction.UP, 3);
        position = board.getPosition();
        assert position[0] == 1;
        assert position[1] == 2;
        // Went out of bounds, thus 0
        assert outOfBounds == 0;

        
        

    }
}
