package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlternatePlayerTest {

    @Test
    public void expectsToCreateAlternatePlayer() {
        assertDoesNotThrow(() -> new AlternatePlayer("Pradeep"));

    }

    @Test
    public void expectsToChooseCheatWhenTurnIsOdd() {

        Player alternatePlayer = new AlternatePlayer("Pradeep");
        Choice choice = alternatePlayer.playerChoice();
        assertEquals(choice, Choice.CHEAT);
    }

    @Test
    public void expectsToChooseCooperateWhenTurnIsOdd() {

        Player alternatePlayer = new AlternatePlayer("Pradeep");
        alternatePlayer.playerChoice(); // first turn
        Choice choice = alternatePlayer.playerChoice(); // second turn
        assertEquals(choice, Choice.COOPERATE);
    }


}