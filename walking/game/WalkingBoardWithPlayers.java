package walking.game;

import walking.game.player.Player;

public class WalkingBoardWithPlayers extends WalkingBoard{
    private Player[] players;
    private int round;
    public static final int SCORE_EACH_STEP = 13;
    

    public WalkingBoardWithPlayers(int[][] board, int playerCount) {
        super(board);
        initPlayers(playerCount);
    }

    public WalkingBoardWithPlayers(int size, int playerCount) {
        super(size);
        initPlayers(playerCount);
    }

    private void initPlayers(int playerCount) {
        if (playerCount < 2) throw new IllegalArgumentException("Player count must be at least 2");
        this.players = new Player[playerCount];
        players[0] = new Player("MadlyRotatingBuccaneer");
        for (int i = 1; i < playerCount; i++) {
            players[i] = new Player("Player");
        }
    }

    public int[] walk(int... stepCounts) {
        int[] scores = new int[players.length];
        int totalSteps = 0;
        for (int i = 0; i < stepCounts.length; i++) {
            Player currentPlayer = players[i % players.length];
            if (currentPlayer.name.equals("MadlyRotatingBuccaneer")) {
                for (int j = 0; j < i; j++) {
                    currentPlayer.turn();
                }
            } else {
                currentPlayer.turn();
            }
            int steps = stepCounts[i];
            totalSteps += steps;
            for (int j = 0; j < steps; j++) {
                int score = moveAndSet(currentPlayer.getDirection(), Math.min(totalSteps, SCORE_EACH_STEP));
                scores[i % players.length] += score;
            }
        }
        return scores;
    }

    
}
