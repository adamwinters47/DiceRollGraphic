package com.example.graphicdiceroller.widgets.edittext;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;

import com.example.graphicdiceroller.DiceEnum;
import com.example.graphicdiceroller.R;

import static com.example.graphicdiceroller.DiceMap.Dice;

public class EditTextDiceNum extends AppCompatEditText {

    private DiceEnum dice;
    private Button btnAddDice;
    private Button btnRemoveDice;

    public EditTextDiceNum(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public EditTextDiceNum(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    public void setDice(DiceEnum dice){
        this.dice = dice;
    }

    public DiceEnum getDice(){
        return dice;
    }

    public void setBtnAddDice(Button btnAddDice){
        btnAddDice.setOnClickListener(v -> addDice());
        this.btnAddDice = btnAddDice;
    }

    public Button getBtnAddDice(){
        return btnAddDice;
    }

    public void setBtnRemoveDice(Button btnRemoveDice){
        btnRemoveDice.setOnClickListener(v -> removeDice());
        this.btnRemoveDice = btnRemoveDice;
    }

    public Button getBtnRemoveDice(){
        return btnRemoveDice;
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }

    private Integer updateEditText(){
        String changedText = getText().toString();
        Integer newVal = null;
        try{
            newVal = Integer.parseInt(changedText);
        } catch (Exception e){
            System.out.println("An error occurred parsing to an Integer: " + e.getMessage());
            newVal = 0;
        }
        Integer oldVal = Dice.get(getDice().getDiceType());
        if(oldVal != newVal){
            if (newVal != null && newVal >= 0) {
                Dice.put(dice.getDiceType(), newVal);
            } else {
                setText(Dice.get(dice.getDiceType()).toString());
            }
        }
        return Dice.get(dice.getDiceType());
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

    private Integer addDice(){
        Integer numDice = Dice.get(getDice().getDiceType());
        if(numDice == null){
            Dice.put(getDice().getDiceType(), 1);
        } else {
            Dice.put(getDice().getDiceType(), numDice + 1);
            numDice++;
        }
        setText(numDice.toString());
        return numDice;
    }

    private Integer removeDice(){
        Integer numDice = Dice.get(getDice().getDiceType());
        if(numDice == null || numDice <= 0){
            Dice.put(getDice().getDiceType(), 0);
        } else {
            Dice.put(getDice().getDiceType(), numDice - 1);
            numDice--;
        }
        setText(numDice.toString());
        return numDice;
    }



}
