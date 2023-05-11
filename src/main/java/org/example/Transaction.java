package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Transaction {

    private Player playerOne;

    private Player playerTwo;

    private Scorer scorer;

    private TransactionRules transactionRules = new TransactionRules();

    public Transaction(Player playerOne, Player playerTwo){

        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.scorer = new Scorer(playerOne, playerTwo);

    }

    public Transaction(Player playerOne, Player playerTwo, Scorer scorer){

        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.scorer = scorer;

    }

    public void transactionOneRound(){

        List<Integer> scores = this.transactionRules.getScores(Arrays.asList(this.playerOne.playerChoice(), this.playerTwo.playerChoice()));
        this.scorer.updatePlayerScore(this.playerOne,scores.get(0));
        this.scorer.updatePlayerScore(this.playerTwo,scores.get(1));

    }

    public void transactionsForMoreRound(){

        Random random = new Random();
        Integer rounds = random.nextInt(Math.abs(3 - 7)) + 3;
        for(int round = 1; round <= rounds; round++){
            this.transactionOneRound();
        }

    }

    public Player winner()  throws IllegalStateException{

        Integer playerOneScore = this.scorer.getPlayerScore(this.playerOne);
        Integer playerTwoScore = this.scorer.getPlayerScore(this.playerTwo);

        if(playerOneScore > playerTwoScore){
            return this.playerOne;
        }
        if(playerOneScore < playerTwoScore){
            return this.playerTwo;
        }
        throw new IllegalStateException("Match is drawn so no winner");

    }



}
