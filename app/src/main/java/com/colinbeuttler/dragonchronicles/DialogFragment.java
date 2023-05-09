package com.colinbeuttler.dragonchronicles;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Arrays;

public class DialogFragment extends androidx.fragment.app.DialogFragment {

    TextView dialogShadow;

    int i = 0;

    String[][] dialogLines = {
            {"Welcome to Dragon Flight"},
            {"Chapter 1: An Egg and a Stranger....."},
            {"'Good Morning'"},
            {"'Finally awake I see....'"},
            {"'Now where were we?'"},
            {"'...Oh yes that's right!!!'"},
            {"'You were about to pick a dragon egg..."},
            {"Did you make a decision yet?'"}
    };


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_fragment, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dialogShadow = (TextView) view.findViewById(R.id.text_view_dialogue);
        dialogShadow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogShadow.setText(getLine());
                i++;
            }
        });

    }

    public String getLine() {
        if(dialogLines[i].length >2){
            return dialogLines[i][0];
        }
        else return null;
    }

}
