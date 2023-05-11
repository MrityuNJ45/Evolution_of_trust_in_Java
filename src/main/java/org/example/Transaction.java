package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Transaction {

    private Player playerOne;

    private Player playerTwo;

    private ScoreCard scoreCard;

    private final Integer MIN_ROUND_LIMIT = 3;
    private final Integer MAX_ROUND_LIMIT = 7;

    //private TransactionRules transactionRules = new TransactionRules();

    public Transaction(Player playerOne, Player playerTwo){

        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.scoreCard = new ScoreCard(playerOne, playerTwo);

    }

    public Transaction(Player playerOne, Player playerTwo, ScoreCard scorer){

        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.scoreCard = scorer;

    }

    public void transactionOneRound(){

        this.scoreCard.updatePlayerScore(Arrays.asList(playerOne.playerChoice(), playerTwo.playerChoice()));

    }

    public void transactionsForMoreRound(){

        Random random = new Random();
        Integer rounds = random.nextInt(MAX_ROUND_LIMIT - MIN_ROUND_LIMIT) + MIN_ROUND_LIMIT;
        for(int round = 1; round <= rounds; round++){
            this.transactionOneRound();
        }

    }

    public Player winner()  throws IllegalStateException{

        return this.scoreCard.winner();

    }



}
