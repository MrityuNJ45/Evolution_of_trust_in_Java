package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScorerTest {

    @Test
    public void expectsToCreateAScorer(){

          assertDoesNotThrow(() -> new Scorer(new CheatPlayer("Manish"), new CheatPlayer("Mohit")));

    }

}