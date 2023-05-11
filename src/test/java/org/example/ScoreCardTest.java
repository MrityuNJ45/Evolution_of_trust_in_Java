package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ScoreCardTest {

    @Test
    public void expectsToCreateAScorer() {
        assertDoesNotThrow(() -> new ScoreCard());
    }

    @Test
    public void expects1MeansFirstPlayerWillWinWhoseScoreIsMore() {
        Choice firstPlayerChoice = new CheatPlayer("Manish").playChoice();
        Choice secondPlayerChoice = new CooperatePlayer("Mamta").playChoice();
        List<Choice> choices = Arrays.asList(firstPlayerChoice, secondPlayerChoice);
        ScoreCard scoreCard = new ScoreCard();
        scoreCard.update(choices);
        Integer winner = scoreCard.winner();
        assertEquals(1, winner);
    }

    @Test
    public void expects0MeansDrawWhenBothHaveSameScore() {
        Choice firstPlayerChoice = new CooperatePlayer("Manish").playChoice();
        Choice secondPlayerChoice = new CooperatePlayer("Mamta").playChoice();
        List<Choice> choices = Arrays.asList(firstPlayerChoice, secondPlayerChoice);
        ScoreCard scoreCard = new ScoreCard();
        scoreCard.update(choices);
        Integer winner = scoreCard.winner();
        assertEquals(0, winner);
    }

    @Test
    public void expectsNegative1MeansSecondPlayerWillWinWhoseScoreIsMore() {
        Choice firstPlayerChoice = new CooperatePlayer("Manish").playChoice();
        Choice secondPlayerChoice = new CheatPlayer("Mamta").playChoice();
        List<Choice> choices = Arrays.asList(firstPlayerChoice, secondPlayerChoice);
        ScoreCard scoreCard = new ScoreCard();
        scoreCard.update(choices);
        Integer winner = scoreCard.winner();
        assertEquals(-1, winner);
    }


}