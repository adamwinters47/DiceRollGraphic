package com.example.graphicdiceroller.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;

import com.example.graphicdiceroller.DiceEnum;
import com.example.graphicdiceroller.MainActivity;
import com.example.graphicdiceroller.R;

public class EditTextDiceNum extends AppCompatEditText {

    private DiceEnum dice;

    public EditTextDiceNum(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public EditTextDiceNum(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }
    //TODO: Delete this constructor if no issues
//    public EditTextDiceNum(Context context) {
//        super(context);
//        init();
//    }

    public void setDice(DiceEnum dice){
        this.dice = dice;
    }

    public DiceEnum getDice(){
        return dice;
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }

    private Integer updateEditText(){
        String changedText = this.getText().toString();
        Integer newVal = null;
        try{
            newVal = Integer.parseInt(changedText);
        } catch (Exception e){
            System.out.println("An error occurred parsing to an Integer: " + e.getMessage());
            newVal = 0;
        }
        if (newVal != null && newVal >= 0) {
            MainActivity.diceMap.put(dice.getDiceType(), newVal);
        } else {
            this.setText(MainActivity.diceMap.get(dice.getDiceType()).toString());
        }
        return MainActivity.diceMap.get(dice.getDiceType());
    }

    private void init(Context context, AttributeSet attrs){
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.EditTextDiceNum, 0, 0);
        try{
            String diceType = ta.getString(R.styleable.EditTextDiceNum_diceType);
            if(diceType.isEmpty() || diceType.equals(null)){
                throw new RuntimeException("EditTextDiceNum must have attr diceType set");
            }
            dice = DiceEnum.valueOf(diceType);
        } catch (Exception e) {
            System.out.println("An error occurred setting the Dice: " + e.getMessage());
        }
        addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //Do Nothing.
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                updateEditText();
            }

            @Override
            public void afterTextChanged(Editable s) {
                //Do Nothing.
            }
        });
    }



}
