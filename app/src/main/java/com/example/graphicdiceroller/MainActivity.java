package com.example.graphicdiceroller;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.example.graphicdiceroller.DiceEnum.*;

public class MainActivity extends AppCompatActivity {

    Map<String, Integer> diceMap = buildDiceMap();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtD4 = findViewById(R.id.txtD4);
        Button btnAddD4 = findViewById(R.id.btnD4Add);
        btnAddD4.setOnClickListener(v -> {
            addDice(D4.getDiceType());
            updateNumDiceText(D4.getDiceType(), txtD4);
        });

        Button btnRemoveD4 = findViewById(R.id.btnD4Remove);
        btnRemoveD4.setOnClickListener(v -> {
            removeDice(D4.getDiceType());
            updateNumDiceText(D4.getDiceType(), txtD4);
        });

        TextView txtD6 = findViewById(R.id.txtD6);
        Button btnAddD6 = findViewById(R.id.btnD6Add);
        btnAddD6.setOnClickListener(v -> {
            addDice(D6.getDiceType());
            updateNumDiceText(D6.getDiceType(), txtD6);
        });
        Button btnRemoveD6 = findViewById(R.id.btnD6Remove);
        btnRemoveD6.setOnClickListener(v -> {
            removeDice(D6.getDiceType());
            updateNumDiceText(D6.getDiceType(), txtD6);
        });

        TextView txtD8 = findViewById(R.id.txtD8);
        Button btnAddD8 = findViewById(R.id.btnD8Add);
        btnAddD8.setOnClickListener(v -> {
            addDice(D8.getDiceType());
            updateNumDiceText(D8.getDiceType(), txtD8);
        });
        Button btnRemoveD8 = findViewById(R.id.btnD8Remove);
        btnRemoveD8.setOnClickListener(v -> {
            removeDice(D8.getDiceType());
            updateNumDiceText(D8.getDiceType(), txtD8);
        });

        TextView txtD10 = findViewById(R.id.txtD10);
        Button btnAddD10 = findViewById(R.id.btnD10Add);
        btnAddD10.setOnClickListener(v -> {
            addDice(D10.getDiceType());
            updateNumDiceText(D10.getDiceType(), txtD10);
        });
        Button btnRemoveD10 = findViewById(R.id.btnD10Remove);
        btnRemoveD10.setOnClickListener(v -> {
            removeDice(D10.getDiceType());
            updateNumDiceText(D10.getDiceType(), txtD10);
        });

        TextView txtD20 = findViewById(R.id.txtD20);
        Button btnAddD20 = findViewById(R.id.btnD20Add);
        btnAddD20.setOnClickListener(v -> {
            addDice(D20.getDiceType());
            updateNumDiceText(D20.getDiceType(), txtD20);
        });
        Button btnRemoveD20 = findViewById(R.id.btnD20Remove);
        btnRemoveD20.setOnClickListener(v -> {
            removeDice(D20.getDiceType());
            updateNumDiceText(D20.getDiceType(), txtD20);
        });

        TextView txtD100 = findViewById(R.id.txtD100);
        Button btnAddD100 = findViewById(R.id.btnD100Add);
        btnAddD100.setOnClickListener(v -> {
            addDice(D100.getDiceType());
            updateNumDiceText(D100.getDiceType(), txtD100);
        });
        Button btnRemoveD100 = findViewById(R.id.btnD100Remove);
        btnRemoveD100.setOnClickListener(v -> {
            removeDice(D100.getDiceType());
            updateNumDiceText(D100.getDiceType(), txtD100);
        });

        TextView txtResult = findViewById(R.id.txtRollResult);
        Button btnRoll = findViewById(R.id.btnRoll);
        btnRoll.setOnClickListener(v -> {
            Integer diceResult = rollDice();
            txtResult.setText(diceResult.toString());
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private Map buildDiceMap(){
        return Stream.of(new Object[][] {
                {D4.getDiceType(), 0},
                {D6.getDiceType(), 0},
                {D8.getDiceType(), 0},
                {D10.getDiceType(), 0},
                {D20.getDiceType(), 0},
                {D100.getDiceType(), 0},
        }).collect(Collectors.toMap(data -> (String) data[0], data -> (Integer) data[1]));
    }

    private Integer addDice(String diceType){
        Integer numDice = diceMap.get(diceType);
        if(numDice == null){
            diceMap.put(diceType, 1);
        } else {
            diceMap.put(diceType, numDice + 1);
        }
        return numDice;
    }

    private Integer removeDice(String diceType){
        Integer numDice = diceMap.get(diceType);
        if(numDice == null || numDice <= 0){
            diceMap.put(diceType, 0);
        } else {
            diceMap.put(diceType, numDice - 1);
        }
        return numDice;
    }

    private void updateNumDiceText(String diceType, TextView view){
        Integer numDice = diceMap.get(diceType);
        String textResult;
        if(numDice <= 0){
            textResult = diceType;
        } else {
            textResult = diceMap.get(diceType) + " " + diceType;
        }
        view.setText(textResult);
    }

    private Integer rollDice(){
        Integer result = 0;
        for(DiceEnum dice : DiceEnum.values()){
            System.out.println("Number of " + dice.getDiceType() + " to roll - " + diceMap.get(dice.getDiceType()));
            for(int i = 0; i < diceMap.get(dice.getDiceType()); i++){
                Integer rollResult = (int)(Math.random() * dice.getDiceNum()) + 1;
                result += rollResult;
                System.out.println(dice.getDiceType() + " roll num " + (i + 1) + " result: " + rollResult);
            }
        }
        return result;
    }
}