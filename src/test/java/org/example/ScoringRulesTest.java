package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ScoringRulesTest {

    @Test
    public void expectsToCreateTransactionRulesObject() {
        assertDoesNotThrow(() -> new ScoringRules());
    }

    @Test
    public void expectsToGetAListOf2And2WhenBothHaveCooperated() {
        ScoringRules transactionRules = new ScoringRules();
        List<Choice> choices = new ArrayList<>();
        choices.add(Choice.COOPERATE);
        choices.add(Choice.COOPERATE);
        List<Integer> scores = transactionRules.getScores(choices);
        assertEquals(Arrays.asList(2, 2), scores);
    }


    @Test
    public void expectsToGetAListOfNegative1And3WhenFirstCooperatesAndOtherCheats() {
        ScoringRules transactionRules = new ScoringRules();
        List<Choice> choices = new ArrayList<>();
        choices.add(Choice.COOPERATE);
        choices.add(Choice.CHEAT);
        List<Integer> scores = transactionRules.getScores(choices);
        assertEquals(Arrays.asList(-1, 3), scores);
    }

    @Test
    public void expectsToGetAListOf3AndNegative1WhenFirstCheatsAndOtherCooperates() {
        ScoringRules transactionRules = new ScoringRules();
        List<Choice> choices = new ArrayList<>();
        choices.add(Choice.CHEAT);
        choices.add(Choice.COOPERATE);
        List<Integer> scores = transactionRules.getScores(choices);
        assertEquals(Arrays.asList(3, -1), scores);
    }


    @Test
    public void expectsToGetAListOf0And0WhenFirstBothCheats() {
        ScoringRules transactionRules = new ScoringRules();
        List<Choice> choices = new ArrayList<>();
        choices.add(Choice.CHEAT);
        choices.add(Choice.CHEAT);
        List<Integer> scores = transactionRules.getScores(choices);
        assertEquals(Arrays.asList(0, 0), scores);
    }


}