package org.example;

import java.util.HashMap;

public class Scorer {

    private HashMap<Player, Integer> playersScores;
//    private HashMap<Player, Integer> playerTwoScore;

    public Scorer(Player playerOne, Player playerTwo) {

        playersScores = new HashMap<Player,Integer>();
        playersScores.put(playerOne,0);
        playersScores.put(playerTwo,0);

    }

    public void updatePlayerScore(Player player, Integer score){
        playersScores.put(player, playersScores.get(player) + score);
    }

    public Integer getPlayerScore(Player player){
        return playersScores.get(player);
    }


}
