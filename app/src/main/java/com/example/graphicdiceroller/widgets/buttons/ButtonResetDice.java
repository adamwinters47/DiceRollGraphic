package com.example.graphicdiceroller.widgets.buttons;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;

import com.example.graphicdiceroller.DiceMap;
import com.example.graphicdiceroller.widgets.edittext.EditTextDiceNum;

import java.util.List;

import static com.example.graphicdiceroller.DiceMap.Dice;


public class ButtonResetDice extends AppCompatButton {

    List<EditTextDiceNum> editTextDiceNumList;
    public ButtonResetDice(@NonNull Context context) {
        super(context);
        init();
    }

    public ButtonResetDice(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ButtonResetDice(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void setEditTextDiceNumList(List<EditTextDiceNum> editTextDiceNumList){
        this.editTextDiceNumList = editTextDiceNumList;
    }

    public List<EditTextDiceNum> getEditTextDiceNumList(){
        return editTextDiceNumList;
    }

    private void init(){
        setOnClickListener(v -> {
            Dice.putAll(DiceMap.buildDiceMap());
            for(EditTextDiceNum editText : editTextDiceNumList){
                editText.setText("0");
            }
        });
    }
}
