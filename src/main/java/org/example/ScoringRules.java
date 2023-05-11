package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ScoringRules {

    private HashMap<List<Choice>, List<Integer>> rules;

    public ScoringRules() {
        this.rules = new HashMap<>();
        rules.put(Arrays.asList(Choice.COOPERATE, Choice.COOPERATE), Arrays.asList(2, 2));
        rules.put(Arrays.asList(Choice.COOPERATE, Choice.CHEAT), Arrays.asList(-1, 3));
        rules.put(Arrays.asList(Choice.CHEAT, Choice.COOPERATE), Arrays.asList(3, -1));
        rules.put(Arrays.asList(Choice.CHEAT, Choice.CHEAT), Arrays.asList(0, 0));
    }

    public List<Integer> getScores(List<Choice> choices) {
        return rules.get(choices);
    }

}
