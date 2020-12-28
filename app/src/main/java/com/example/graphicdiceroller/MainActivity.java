package com.example.graphicdiceroller;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

import com.example.graphicdiceroller.widgets.ButtonResetDice;
import com.example.graphicdiceroller.widgets.ButtonRollDice;
import com.example.graphicdiceroller.widgets.EditTextDiceNum;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditTextDiceNum editD4Txt = findViewById(R.id.editD4Num);
        editD4Txt.setBtnAddDice(findViewById(R.id.btnD4Add));
        editD4Txt.setBtnRemoveDice(findViewById(R.id.btnD4Remove));

        EditTextDiceNum editD6Txt = findViewById(R.id.editD6Num);
        editD6Txt.setBtnAddDice(findViewById(R.id.btnD6Add));
        editD6Txt.setBtnRemoveDice(findViewById(R.id.btnD6Remove));

        EditTextDiceNum editD8Txt = findViewById(R.id.editD8Num);
        editD8Txt.setBtnAddDice(findViewById(R.id.btnD8Add));
        editD8Txt.setBtnRemoveDice(findViewById(R.id.btnD8Remove));

        EditTextDiceNum editD10Txt = findViewById(R.id.editD10Num);
        editD10Txt.setBtnAddDice(findViewById(R.id.btnD10Add));
        editD10Txt.setBtnRemoveDice(findViewById(R.id.btnD10Remove));

        EditTextDiceNum editD20Txt = findViewById(R.id.editD20Num);
        editD20Txt.setBtnAddDice(findViewById(R.id.btnD20Add));
        editD20Txt.setBtnRemoveDice(findViewById(R.id.btnD20Remove));

        EditTextDiceNum editD100Txt = findViewById(R.id.editD100Num);
        editD100Txt.setBtnAddDice(findViewById(R.id.btnD100Add));
        editD100Txt.setBtnRemoveDice(findViewById(R.id.btnD100Remove));

        ButtonRollDice btnRoll = findViewById(R.id.btnRoll);
        btnRoll.setTxtResult(findViewById(R.id.txtRollResult));

        ButtonResetDice btnResetDice = findViewById(R.id.btnResetDice);
        btnResetDice.setEditTextDiceNumList(Stream.of(editD4Txt, editD6Txt, editD8Txt, editD10Txt, editD20Txt, editD100Txt).collect(Collectors.toList()));
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
}