package org.example;

import java.util.HashMap;
import java.util.List;

public class ScoreCard {

    private Player playerOne;

    private Player playerTwo;
    private Integer playerOneScore;

    private Integer playerTwoScore;

    private TransactionRules transactionRules = new TransactionRules();


    public ScoreCard(Player playerOne, Player playerTwo){
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
         this.playerOneScore = 0;
         this.playerTwoScore = 0;
    }

    public void updatePlayerScore(List<Choice> choices){

       List<Integer> scores = this.transactionRules.getScores(choices);
       playerOneScore += scores.get(0);
       playerTwoScore += scores.get(1);

    }

    public Player winner(){
        if(this.playerOneScore > this.playerTwoScore){
            return playerOne;
        }
        if(this.playerTwoScore > this.playerOneScore){
            return playerTwo;
        }
        return null;
    }



}
