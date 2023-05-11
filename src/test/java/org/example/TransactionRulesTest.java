package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TransactionRulesTest {

    @Test
    public void expectsToCreateTransactionRulesObject(){
        assertDoesNotThrow(() -> new TransactionRules());
    }

    @Test
    public void expectsToGetAListOf2And2WhenBothHaveCooperated(){
        TransactionRules transactionRules = new TransactionRules();
        List<Choice> choices = new ArrayList<>();
        choices.add(Choice.COOPERATE);
        choices.add(Choice.COOPERATE);
        List<Integer> scores = transactionRules.getScores(choices);
        assertEquals(Arrays.asList(2,2), scores);
    }


    @Test
    public void expectsToGetAListOfNegative1And3WhenFirstCooperatesAndOtherCheats(){
        TransactionRules transactionRules = new TransactionRules();
        List<Choice> choices = new ArrayList<>();
        choices.add(Choice.COOPERATE);
        choices.add(Choice.CHEAT);
        List<Integer> scores = transactionRules.getScores(choices);
        assertEquals(Arrays.asList(-1,3), scores);
    }

    @Test
    public void expectsToGetAListOf3AndNegative1WhenFirstCheatsAndOtherCooperates(){
        TransactionRules transactionRules = new TransactionRules();
        List<Choice> choices = new ArrayList<>();
        choices.add(Choice.CHEAT);
        choices.add(Choice.COOPERATE);
        List<Integer> scores = transactionRules.getScores(choices);
        assertEquals(Arrays.asList(3,-1), scores);
    }


    @Test
    public void expectsToGetAListOf0And0WhenFirstBothCheats(){
        TransactionRules transactionRules = new TransactionRules();
        List<Choice> choices = new ArrayList<>();
        choices.add(Choice.CHEAT);
        choices.add(Choice.CHEAT);
        List<Integer> scores = transactionRules.getScores(choices);
        assertEquals(Arrays.asList(0,0), scores);
    }


}