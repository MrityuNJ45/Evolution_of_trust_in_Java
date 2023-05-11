package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ScoreCard {

    private Integer playerOneScore;

    private Integer playerTwoScore;

    private ScoringRules scoringRules = new ScoringRules();


    public ScoreCard() {

        this.playerOneScore = 0;
        this.playerTwoScore = 0;

    }

    public void update(List<Choice> choices) {

        List<Integer> scores = this.scoringRules.getScores(choices);
        playerOneScore += scores.get(0);
        playerTwoScore += scores.get(1);

    }

    public Integer winner() {
        if (this.playerOneScore > this.playerTwoScore) {
            return +1;
        }
        if (this.playerTwoScore > this.playerOneScore) {
            return -1;
        }
        return 0;
    }


}
