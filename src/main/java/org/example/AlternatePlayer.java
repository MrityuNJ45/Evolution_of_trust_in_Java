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
        if(this.turn % 2 == 0){
            this.turn++;
            return Choice.COOPERATE;
        }
        this.turn++;
        return Choice.CHEAT;
    }
}
