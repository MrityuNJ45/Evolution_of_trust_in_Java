package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CheatPlayerTest {

    @Test
    public void expectsToCreateACheatPlayer() {
        assertDoesNotThrow(() -> new CheatPlayer("Manish"));
    }

    @Test
    public void expectsToAlwaysGiveChoiceCheat() {
        Player player = new CheatPlayer("Manish");
        assertEquals(Choice.CHEAT, player.playerChoice());
    }


}
