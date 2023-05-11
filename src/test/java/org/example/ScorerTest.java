package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScorerTest {

    @Test
    public void expectsToCreateAScorer(){

          assertDoesNotThrow(() -> new ScoreCard(new CheatPlayer("Manish"), new CheatPlayer("Mohit")));

    }

    @Test
    public void expectsToGetPlayerScore0AtInitial(){

        Player playerOne = new CheatPlayer("Manish");
        Player playerTwo = new CooperatePlayer("Mohit");
        ScoreCard scorer = new ScoreCard(playerOne, playerTwo);
        assertEquals(0, scorer.getPlayerScore(playerOne));
        assertEquals(0, scorer.getPlayerScore(playerTwo));

    }

    @Test
    public void expectsToGetUpdatedScoreAfterUpdating(){
        Player playerOne = new CheatPlayer("Manish");
        Player playerTwo = new CooperatePlayer("Mohit");
        ScoreCard scorer = new ScoreCard(playerOne, playerTwo);
        scorer.updatePlayerScore(playerOne,2);
        scorer.updatePlayerScore(playerTwo, 3);
        assertEquals(2, scorer.getPlayerScore(playerOne));
        assertEquals(3, scorer.getPlayerScore(playerTwo));
    }

}