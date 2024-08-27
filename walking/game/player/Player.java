package walking.game.player;

import walking.game.util.Direction;

public class Player {
    public String name;
    private int score = 0;

    protected Direction direction = Direction.UP;

    public Direction getDirection() {
        return direction;
    }

    public int getScore() {
        return score;
    }

    public Player() {
        
    }

    public Player(String name) {
        this.name = name;
    }

    public void addToScore(int score) {
        this.score += score;
    }

    public void turn() {
        switch (direction) {
            case UP:
                direction = Direction.DOWN;
                break;
            case RIGHT:
                direction = Direction.UP;
                break;
            case DOWN:
                direction = Direction.LEFT;
                break;
            case LEFT:
                direction = Direction.RIGHT;
                break;
        }
    }
}
