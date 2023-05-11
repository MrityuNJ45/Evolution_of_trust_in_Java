package org.example;

import java.util.Arrays;
import java.util.Random;

public class Transaction {

    private Player playerOne;

    private Player playerTwo;

    private ScoreCard scoreCard;

    private final Integer MIN_ROUND_LIMIT = 3;
    private final Integer MAX_ROUND_LIMIT = 7;

    public Transaction(Player playerOne, Player playerTwo) {

        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.scoreCard = new ScoreCard();

    }

    public void transactions() {

        Random random = new Random();
        Integer rounds = random.nextInt(MAX_ROUND_LIMIT - MIN_ROUND_LIMIT) + MIN_ROUND_LIMIT;
        for (int round = 1; round <= rounds; round++) {
            this.scoreCard.update(Arrays.asList(playerOne.playerChoice(), playerTwo.playerChoice()));
        }

    }

    public Player winner() {

        Integer winnerDeterminer = this.scoreCard.winner();
        if (winnerDeterminer == 0) {
            return null;
        }
        if (winnerDeterminer == 1) {
            return playerOne;
        }
        return playerTwo;

    }


}
