package com.example.graphicdiceroller.fragments;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.graphicdiceroller.R;
import com.example.graphicdiceroller.widgets.buttons.ButtonResetDice;
import com.example.graphicdiceroller.widgets.buttons.ButtonRollDice;
import com.example.graphicdiceroller.widgets.edittext.EditTextDiceNum;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DiceFragment extends Fragment {
    public DiceFragment() {
        super(R.layout.dice_fragment);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditTextDiceNum editD4Txt = view.findViewById(R.id.editD4Num);
        editD4Txt.setBtnAddDice(view.findViewById(R.id.btnD4Add));
        editD4Txt.setBtnRemoveDice(view.findViewById(R.id.btnD4Remove));

        EditTextDiceNum editD6Txt = view.findViewById(R.id.editD6Num);
        editD6Txt.setBtnAddDice(view.findViewById(R.id.btnD6Add));
        editD6Txt.setBtnRemoveDice(view.findViewById(R.id.btnD6Remove));

        EditTextDiceNum editD8Txt = view.findViewById(R.id.editD8Num);
        editD8Txt.setBtnAddDice(view.findViewById(R.id.btnD8Add));
        editD8Txt.setBtnRemoveDice(view.findViewById(R.id.btnD8Remove));

        EditTextDiceNum editD10Txt = view.findViewById(R.id.editD10Num);
        editD10Txt.setBtnAddDice(view.findViewById(R.id.btnD10Add));
        editD10Txt.setBtnRemoveDice(view.findViewById(R.id.btnD10Remove));

        EditTextDiceNum editD20Txt = view.findViewById(R.id.editD20Num);
        editD20Txt.setBtnAddDice(view.findViewById(R.id.btnD20Add));
        editD20Txt.setBtnRemoveDice(view.findViewById(R.id.btnD20Remove));

        EditTextDiceNum editD100Txt = view.findViewById(R.id.editD100Num);
        editD100Txt.setBtnAddDice(view.findViewById(R.id.btnD100Add));
        editD100Txt.setBtnRemoveDice(view.findViewById(R.id.btnD100Remove));

        ButtonRollDice btnRoll = view.findViewById(R.id.btnRoll);
        btnRoll.setTxtResult(view.findViewById(R.id.txtRollResult));

        ButtonResetDice btnResetDice = view.findViewById(R.id.btnResetDice);
        btnResetDice.setEditTextDiceNumList(Stream.of(editD4Txt, editD6Txt, editD8Txt, editD10Txt, editD20Txt, editD100Txt).collect(Collectors.toList()));
    }
}
