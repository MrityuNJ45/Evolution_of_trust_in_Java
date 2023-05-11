package org.example;

public class AlternatePlayer implements Player{

    private String name;

    private Integer turn;

    public AlternatePlayer(String name) {
        this.name = name;
        this.turn = 0;
    }

    @Override
    public Choice playerChoice() {
        this.turn++;
        if(this.turn % 2 == 0){
            return Choice.COOPERATE;
        }

        return Choice.CHEAT;
    }
}
