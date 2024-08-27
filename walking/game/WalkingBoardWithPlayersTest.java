package walking.game;

import org.junit.jupiter.api.Test;

import walking.game.player.Player;
import walking.game.util.Direction;

public class WalkingBoardWithPlayersTest {
    
    @Test
    public void walk1() {
        WalkingBoardWithPlayers board = new WalkingBoardWithPlayers(3, 2);
        int[] score = board.walk(10);
        //print score
        for (int i = 0; i < score.length; i++) {
            System.out.println("Player " + i + " score: " + score[i]);
        }
        
    }
}
