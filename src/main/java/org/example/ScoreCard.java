package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ScoreCard {

    private Integer playerOneScore;

    private Integer playerTwoScore;

    private HashMap<List<Choice>, List<Integer>> scoringRules;


    public ScoreCard() {
        this.playerOneScore = 0;
        this.playerTwoScore = 0;
        this.scoringRules = new HashMap<>();
        scoringRules.put(Arrays.asList(Choice.COOPERATE, Choice.COOPERATE), Arrays.asList(2, 2));
        scoringRules.put(Arrays.asList(Choice.COOPERATE, Choice.CHEAT), Arrays.asList(-1, 3));
        scoringRules.put(Arrays.asList(Choice.CHEAT, Choice.COOPERATE), Arrays.asList(3, -1));
        scoringRules.put(Arrays.asList(Choice.CHEAT, Choice.CHEAT), Arrays.asList(0, 0));
    }

    public void update(List<Choice> choices) {
        List<Integer> scores = this.scoringRules.get(choices);
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
