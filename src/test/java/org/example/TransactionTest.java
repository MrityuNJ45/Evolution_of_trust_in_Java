package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {

    @Test
    public void expectsToCreateATransactionObject(){
        Player playerOne = new CheatPlayer("Mohit");
        Player playerTwo = new CooperatePlayer("Manish");
        assertDoesNotThrow(() -> new Transaction(playerOne, playerTwo));
    }

    @Test
    public void expectsToCreateATransactionObjectThrow2ndParameterizedConstructor(){
        Player playerOne = new CheatPlayer("Mohit");
        Player playerTwo = new CooperatePlayer("Manish");
        ScoreCard scorer = new ScoreCard(playerOne, playerTwo);
        assertDoesNotThrow(()->new Transaction(playerOne,playerTwo,scorer));
    }

    @Test
    public void expectsToBothPlayerToGetZeroScoreWhenBothCheated(){

        Player playerOne = new CheatPlayer("Mohit");
        Player playerTwo = new CheatPlayer("Manish");
        ScoreCard scorer = new ScoreCard(playerOne, playerTwo);
        Transaction transaction = new Transaction(playerOne, playerTwo, scorer);
        transaction.transactionOneRound();
        assertEquals(0,scorer.getPlayerScore(playerOne));
        assertEquals(0,scorer.getPlayerScore(playerTwo));

    }

    @Test
    public void expectsFirstPlayerScoreToBeNegative1AndOtherToBe3WhenFirstCooperatesAndOtherCheats(){
        Player playerOne = new CooperatePlayer("Mohit");
        Player playerTwo = new CheatPlayer("Harish");
        ScoreCard scorer = new ScoreCard(playerOne, playerTwo);
        Transaction transaction = new Transaction(playerOne, playerTwo, scorer);
        transaction.transactionOneRound();
        assertEquals(-1,scorer.getPlayerScore(playerOne));
        assertEquals(3,scorer.getPlayerScore(playerTwo));
    }

    @Test
    public void expectsFirstPlayerScoreToBe3AndOtherToBeNegative1WhenFirstCheatsAndOtherCooperates(){
        Player playerOne = new CheatPlayer("Mohit");
        Player playerTwo = new CooperatePlayer("Harish");
        ScoreCard scorer = new ScoreCard(playerOne, playerTwo);
        Transaction transaction = new Transaction(playerOne, playerTwo, scorer);
        transaction.transactionOneRound();
        assertEquals(3,scorer.getPlayerScore(playerOne));
        assertEquals(-1,scorer.getPlayerScore(playerTwo));
    }

    @Test
    public void expectsToBothPlayerToGet2ScoreWhenBothCooperated(){

        Player playerOne = new CooperatePlayer("Mohit");
        Player playerTwo = new CooperatePlayer("Manish");
        ScoreCard scorer = new ScoreCard(playerOne, playerTwo);
        Transaction transaction = new Transaction(playerOne, playerTwo, scorer);
        transaction.transactionOneRound();
        assertEquals(2,scorer.getPlayerScore(playerOne));
        assertEquals(2,scorer.getPlayerScore(playerTwo));

    }

    @Test
    public void expectsCheatedPlayerToWinWhenMatchedWithCooperatePlayer(){
        Player playerOne = new CheatPlayer("Mohit");
        Player playerTwo = new CooperatePlayer("Manish");
        ScoreCard scorer = new ScoreCard(playerOne, playerTwo);
        Transaction transaction = new Transaction(playerOne, playerTwo, scorer);
        transaction.transactionOneRound();
        assertEquals(playerOne,transaction.winner());
    }


    @Test
    public void expectsToThrowExceptionWhenMatchIsDrawnAndAskingForWinner(){

        Player playerOne = new CheatPlayer("Mohit");
        Player playerTwo = new CheatPlayer("Manish");
        ScoreCard scorer = new ScoreCard(playerOne, playerTwo);
        Transaction transaction = new Transaction(playerOne, playerTwo, scorer);
        transaction.transactionOneRound();
        IllegalStateException thrown = assertThrows(IllegalStateException.class, () -> {
            transaction.winner();
        });

        assertEquals("Match is drawn so no winner", thrown.getMessage());

    }

    @Test
    public void expectsCheatPlayerToAlwaysWinWhenPlayedWithCooperatePlayerForMoreRounds(){
        Player playerOne = new CheatPlayer("Mohit");
        Player playerTwo = new CooperatePlayer("Manish");
        ScoreCard scorer = new ScoreCard(playerOne, playerTwo);
        Transaction transaction = new Transaction(playerOne, playerTwo, scorer);
        transaction.transactionsForMoreRound();
        Player winner = transaction.winner();
        assertEquals(playerOne, winner);
    }

    @Test
    public void expectsToThrowExceptionWhenBothCooperatePlayersPlaysWithEachOtherForMoreRounds(){
        Player playerOne = new CooperatePlayer("Mohit");
        Player playerTwo = new CooperatePlayer("Manish");
        Transaction transaction = new Transaction(playerOne, playerTwo);
        transaction.transactionsForMoreRound();
        IllegalStateException thrown = assertThrows(IllegalStateException.class, () -> {
            transaction.winner();
        });
        assertEquals("Match is drawn so no winner", thrown.getMessage());

    }


    @Test
    public void expectsToThrowExceptionWhenBothCheatPlayersPlaysWithEachOtherForMoreRounds(){
        Player playerOne = new CheatPlayer("Mohit");
        Player playerTwo = new CheatPlayer("Manish");
        Transaction transaction = new Transaction(playerOne, playerTwo);
        transaction.transactionsForMoreRound();
        IllegalStateException thrown = assertThrows(IllegalStateException.class, () -> {
            transaction.winner();
        });
        assertEquals("Match is drawn so no winner", thrown.getMessage());

    }


}