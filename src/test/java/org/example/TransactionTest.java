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
        Scorer scorer = new Scorer(playerOne, playerTwo);
        assertDoesNotThrow(()->new Transaction(playerOne,playerTwo,scorer));
    }

    @Test
    public void expectsToBothPlayerToGetZeroScoreWhenBothCheated(){

        Player playerOne = new CheatPlayer("Mohit");
        Player playerTwo = new CheatPlayer("Manish");
        Scorer scorer = new Scorer(playerOne, playerTwo);
        Transaction transaction = new Transaction(playerOne, playerTwo, scorer);
        transaction.transactionOneRound();
        assertEquals(0,scorer.getPlayerScore(playerOne));
        assertEquals(0,scorer.getPlayerScore(playerTwo));

    }

    @Test
    public void expectsFirstPlayerScoreToBeNegative1AndOtherToBe3WhenFirstCooperatesAndOtherCheats(){
        Player playerOne = new CooperatePlayer("Mohit");
        Player playerTwo = new CheatPlayer("Harish");
        Scorer scorer = new Scorer(playerOne, playerTwo);
        Transaction transaction = new Transaction(playerOne, playerTwo, scorer);
        transaction.transactionOneRound();
        assertEquals(-1,scorer.getPlayerScore(playerOne));
        assertEquals(3,scorer.getPlayerScore(playerTwo));
    }

    @Test
    public void expectsFirstPlayerScoreToBe3AndOtherToBeNegative1WhenFirstCheatsAndOtherCooperates(){
        Player playerOne = new CheatPlayer("Mohit");
        Player playerTwo = new CooperatePlayer("Harish");
        Scorer scorer = new Scorer(playerOne, playerTwo);
        Transaction transaction = new Transaction(playerOne, playerTwo, scorer);
        transaction.transactionOneRound();
        assertEquals(-1,scorer.getPlayerScore(playerOne));
        assertEquals(3,scorer.getPlayerScore(playerTwo));
    }

    @Test
    public void expectsToBothPlayerToGet2ScoreWhenBothCooperated(){

        Player playerOne = new CooperatePlayer("Mohit");
        Player playerTwo = new CooperatePlayer("Manish");
        Scorer scorer = new Scorer(playerOne, playerTwo);
        Transaction transaction = new Transaction(playerOne, playerTwo, scorer);
        transaction.transactionOneRound();
        assertEquals(2,scorer.getPlayerScore(playerOne));
        assertEquals(2,scorer.getPlayerScore(playerTwo));

    }

    @Test
    public void expectsCheatedPlayerToWinWhenMatchedWithCooperatePlayer(){
        Player playerOne = new CheatPlayer("Mohit");
        Player playerTwo = new CooperatePlayer("Manish");
        Scorer scorer = new Scorer(playerOne, playerTwo);
        Transaction transaction = new Transaction(playerOne, playerTwo, scorer);
        transaction.transactionOneRound();
        assertEquals(playerOne,transaction.winner());
    }


    @Test
    public void expectsToThrowExceptionWhenMatchIsDrawnAndAskingForWinner(){

        Player playerOne = new CheatPlayer("Mohit");
        Player playerTwo = new CheatPlayer("Manish");
        Scorer scorer = new Scorer(playerOne, playerTwo);
        Transaction transaction = new Transaction(playerOne, playerTwo, scorer);
        transaction.transactionOneRound();
        IllegalStateException thrown = assertThrows(IllegalStateException.class, () -> {
            transaction.winner();
        });

        assertEquals("Match is drawn so no winner", thrown.getMessage());

    }


}