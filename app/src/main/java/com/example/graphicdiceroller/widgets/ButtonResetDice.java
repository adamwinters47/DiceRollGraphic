package com.example.graphicdiceroller.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;

import com.example.graphicdiceroller.MainActivity;


public class ButtonResetDice extends AppCompatButton {
    public ButtonResetDice(@NonNull Context context) {
        super(context);
    }

    public ButtonResetDice(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public ButtonResetDice(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs){
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.diceMap.putAll(MainActivity.buildDiceMap());
                MainActivity.resetTextFields();
            }
        });
    }
}
