package com.example.graphicdiceroller;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.example.graphicdiceroller.DiceEnum.D10;
import static com.example.graphicdiceroller.DiceEnum.D100;
import static com.example.graphicdiceroller.DiceEnum.D20;
import static com.example.graphicdiceroller.DiceEnum.D4;
import static com.example.graphicdiceroller.DiceEnum.D6;
import static com.example.graphicdiceroller.DiceEnum.D8;

public class DiceMap {
    public static Map<String, Integer> Dice = buildDiceMap();

    public static Map buildDiceMap(){
        return Stream.of(new Object[][] {
                {D4.getDiceType(), 0},
                {D6.getDiceType(), 0},
                {D8.getDiceType(), 0},
                {D10.getDiceType(), 0},
                {D20.getDiceType(), 0},
                {D100.getDiceType(), 0},
        }).collect(Collectors.toMap(data -> (String) data[0], data -> (Integer) data[1]));
    }
}
