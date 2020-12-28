package com.example.graphicdiceroller;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.graphicdiceroller.widgets.ButtonResetDice;
import com.example.graphicdiceroller.widgets.EditTextDiceNum;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.example.graphicdiceroller.DiceEnum.*;

public class MainActivity extends AppCompatActivity {

    public static Map<String, Integer> diceMap = buildDiceMap();
    public static EditTextDiceNum editD4Txt;
    public static EditTextDiceNum editD6Txt;
    public static EditTextDiceNum editD8Txt;
    public static EditTextDiceNum editD10Txt;
    public static EditTextDiceNum editD20Txt;
    public static EditTextDiceNum editD100Txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editD4Txt = findViewById(R.id.editD4Num);
        Button btnAddD4 = findViewById(R.id.btnD4Add);
        btnAddD4.setOnClickListener(v -> {
            addDice(D4.getDiceType());
            editD4Txt.setText(diceMap.get(D4.getDiceType()).toString());
        });

        Button btnRemoveD4 = findViewById(R.id.btnD4Remove);
        btnRemoveD4.setOnClickListener(v -> {
            removeDice(D4.getDiceType());
            editD4Txt.setText(diceMap.get(D4.getDiceType()).toString());
        });

        editD6Txt = findViewById(R.id.editD6Num);
        Button btnAddD6 = findViewById(R.id.btnD6Add);
        btnAddD6.setOnClickListener(v -> {
            addDice(D6.getDiceType());
            editD6Txt.setText(diceMap.get(D6.getDiceType()).toString());
        });
        Button btnRemoveD6 = findViewById(R.id.btnD6Remove);
        btnRemoveD6.setOnClickListener(v -> {
            removeDice(D6.getDiceType());
            editD6Txt.setText(diceMap.get(D6.getDiceType()).toString());
        });

        editD8Txt = findViewById(R.id.editD8Num);

        Button btnAddD8 = findViewById(R.id.btnD8Add);
        btnAddD8.setOnClickListener(v -> {
            addDice(D8.getDiceType());
            editD8Txt.setText(diceMap.get(D8.getDiceType()).toString());
        });
        Button btnRemoveD8 = findViewById(R.id.btnD8Remove);
        btnRemoveD8.setOnClickListener(v -> {
            removeDice(D8.getDiceType());
            editD8Txt.setText(diceMap.get(D8.getDiceType()).toString());
        });

        editD10Txt = findViewById(R.id.editD10Num);

        Button btnAddD10 = findViewById(R.id.btnD10Add);
        btnAddD10.setOnClickListener(v -> {
            addDice(D10.getDiceType());
            editD10Txt.setText(diceMap.get(D10.getDiceType()).toString());
        });
        Button btnRemoveD10 = findViewById(R.id.btnD10Remove);
        btnRemoveD10.setOnClickListener(v -> {
            removeDice(D10.getDiceType());
            editD10Txt.setText(diceMap.get(D10.getDiceType()).toString());
        });

        editD20Txt = findViewById(R.id.editD20Num);
        Button btnAddD20 = findViewById(R.id.btnD20Add);
        btnAddD20.setOnClickListener(v -> {
            addDice(D20.getDiceType());
            editD20Txt.setText(diceMap.get(D20.getDiceType()).toString());
        });
        Button btnRemoveD20 = findViewById(R.id.btnD20Remove);
        btnRemoveD20.setOnClickListener(v -> {
            removeDice(D20.getDiceType());
            editD20Txt.setText(diceMap.get(D20.getDiceType()).toString());
        });

        editD100Txt = findViewById(R.id.editD100Num);
        Button btnAddD100 = findViewById(R.id.btnD100Add);
        btnAddD100.setOnClickListener(v -> {
            addDice(D100.getDiceType());
            editD100Txt.setText(diceMap.get(D100.getDiceType()).toString());
        });
        Button btnRemoveD100 = findViewById(R.id.btnD100Remove);
        btnRemoveD100.setOnClickListener(v -> {
            removeDice(D100.getDiceType());
            editD100Txt.setText(diceMap.get(D100.getDiceType()).toString());
        });

        TextView txtResult = findViewById(R.id.txtRollResult);
        Button btnRoll = findViewById(R.id.btnRoll);
        btnRoll.setOnClickListener(v -> {
            Integer diceResult = rollDice();
            txtResult.setText(diceResult.toString());
        });

        ButtonResetDice btnResetDice = findViewById(R.id.btnResetDice);
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

    public static void resetTextFields(){
        editD4Txt.setText("0");
        editD6Txt.setText("0");
        editD8Txt.setText("0");
        editD10Txt.setText("0");
        editD20Txt.setText("0");
        editD100Txt.setText("0");
    }

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