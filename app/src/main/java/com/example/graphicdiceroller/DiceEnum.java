package com.example.graphicdiceroller;

public enum DiceEnum {

    D4("D4", 4),
    D6("D6", 6),
    D8("D8", 8),
    D10("D10", 10),
    D20("D20", 20),
    D100("D100", 100);

    private String diceType;
    private Integer diceNum;

    DiceEnum(String diceType, Integer diceNum){
        this.diceType = diceType;
        this.diceNum = diceNum;
    }

    public String getDiceType(){
        return diceType;
    }

    public Integer getDiceNum(){
        return diceNum;
    }
}
