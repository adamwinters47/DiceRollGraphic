package com.example.graphicdiceroller.widgets.buttons;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;

import com.example.graphicdiceroller.DiceEnum;

import static com.example.graphicdiceroller.DiceMap.Dice;

public class ButtonRollDice extends AppCompatButton {

    private TextView txtResult;

    public ButtonRollDice(@NonNull Context context) {
        super(context);
        init();
    }

    public ButtonRollDice(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ButtonRollDice(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void setTxtResult(TextView txtResult) {
        this.txtResult = txtResult;
    }

    public TextView getTxtResult(){
        return txtResult;
    }

    private void init(){
        setOnClickListener(v -> {
            Integer diceResult = rollDice();
            txtResult.setText(diceResult.toString());
        });
    }

    private Integer rollDice(){
        Integer result = 0;
        for(DiceEnum dice : DiceEnum.values()){
            StringBuilder logStatement = new StringBuilder();
            logStatement.append(dice.getDiceType() + ": " + (Dice.get(dice.getDiceType()) == 0 ? "None" : ""));
            for(int i = 0; i < Dice.get(dice.getDiceType()); i++){
                if(i != 0){
                    logStatement.append(", ");
                }
                Integer rollResult = (int)(Math.random() * dice.getDiceNum()) + 1;
                result += rollResult;
                logStatement.append(rollResult);
            }
            System.out.println(logStatement);
        }
        return result;
    }
}
