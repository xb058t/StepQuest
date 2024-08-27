package walking.game;

import walking.game.util.Direction;

public class WalkingBoard {
    private int[][] tiles;
    private int x;
    private int y;
    public static final int BASE_TILE_SCORE = 3;

    public WalkingBoard(int size) {
        this.tiles = new int[size][size];
    }

    public WalkingBoard(int[][] tiles) {
        this.tiles = new int[tiles.length][tiles[0].length];
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[0].length; j++) {
                this.tiles[i][j] = Math.max(tiles[i][j], BASE_TILE_SCORE);
            }
        }
    }

    public int[][] getTiles() {
        int[][] tilesC = new int[this.tiles.length][this.tiles[0].length];
        for (int i = 0; i < this.tiles.length; i++) {
            for (int j = 0; j < this.tiles[0].length; j++) {
                tilesC[i][j] = this.tiles[i][j];
            }
        }
        return tilesC;
    }

    public int[] getPosition() {
        return new int[] { x, y };
    }

    public boolean isValidPosition(int x, int y) {
        return x >= 0 && x < tiles.length && y >= 0 && y < tiles[0].length;
    }

    public static int getXStep(Direction direction) {
        switch (direction) {
            case LEFT:
                return -1;
            case RIGHT:
                return 1;
            default:
                return 0;
        }
    }

    public static int getYStep(Direction direction) {
        switch (direction) {
            case UP:
                return 1;
            case DOWN:
                return -1;
            default:
                return 0;
        }
    }

    public int getTile(int x, int y) {
        if (!isValidPosition(x, y)) {
            throw new IllegalArgumentException("Invalid position");
        }
        return tiles[x][y];
    }

    public int moveAndSet(Direction direction, int n) {
        int xStep = getXStep(direction);
        int yStep = getYStep(direction);
        if (isValidPosition(x + xStep, y + yStep)) {
            int oldVal = tiles[x + xStep][y + yStep];
            x += xStep;
            y += yStep;
            tiles[x][y] = n;
            return oldVal;
        } else {
            return 0;
        }
    }

}
