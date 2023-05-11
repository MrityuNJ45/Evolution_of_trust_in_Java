package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {

    @Test
    public void expectsToCreateATransactionObject() {
        Player playerOne = new CheatPlayer("Mohit");
        Player playerTwo = new CooperatePlayer("Manish");
        assertDoesNotThrow(() -> new Transaction(playerOne, playerTwo));
    }

    @Test
    public void expectsCheatPlayerToWinWhenPlayedWithCooperatePlayer() {
        Player playerOne = new CheatPlayer("Mohit");
        Player playerTwo = new CooperatePlayer("Manish");
        Transaction transaction = new Transaction(playerOne, playerTwo);
        transaction.transactions();
        Player winner = transaction.winner();
        assertEquals(playerOne, winner);
    }

    @Test
    public void expectsToGetNullMeansDrawWhenBothCooperatePlayerPlays() {
        Player playerOne = new CooperatePlayer("Mohit");
        Player playerTwo = new CooperatePlayer("Manish");
        Transaction transaction = new Transaction(playerOne, playerTwo);
        transaction.transactions();
        Player winner = transaction.winner();
        assertEquals(null, winner);
    }


}