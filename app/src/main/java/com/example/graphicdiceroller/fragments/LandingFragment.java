package com.example.graphicdiceroller.fragments;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.graphicdiceroller.R;

public class LandingFragment extends Fragment {

    public LandingFragment() {
        super(R.layout.landing_fragment);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button btnDiceFragment = view.findViewById(R.id.btnOpenDiceRoller);

        btnDiceFragment.setOnClickListener(v -> {
            if(savedInstanceState == null){
                getParentFragmentManager().beginTransaction()
                        .setReorderingAllowed(true)
                        .add(R.id.fragment_container_view, DiceFragment.class, null)
                        .commit();
            }
        });
    }
}
