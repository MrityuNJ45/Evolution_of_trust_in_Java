package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CooperatePlayerTest {

    @Test
    public void expectsToCreateACooperatePlayer(){

        assertDoesNotThrow(() -> new CooperatePlayer("Horan"));

    }

    @Test
    public void expectsToAlwaysGiveChoiceCheat(){
        Player player = new CooperatePlayer("Manish");
        assertEquals(Choice.COOPERATE,player.playerChoice());
    }

}