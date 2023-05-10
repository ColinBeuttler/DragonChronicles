package com.colinbeuttler.dragonchronicles;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


public class DialogFragment extends androidx.fragment.app.DialogFragment {

    TextView dialogShadow;
    LinearLayout dialogLayout;

    int i = 0;

    String[][] dialogLines = {
            {"Welcome to Dragon Flight"},
            {"Chapter 1: An Egg and a Stranger....."},
            {"'Good Morning'"},
            {"'Finally awake I see....'"},
            {"'Now where were we?'"},
            {"'...Oh yes that's right!!!'"},
            {"'You were about to pick a dragon egg..."},
            {"Did you make a decision yet?'", "Yes", "No"}
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
        dialogLayout = (LinearLayout) view.findViewById(R.id.dialog_linear_layout);
        dialogShadow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogShadow.setText(getLine());
                if (dialogLines[i].length < 2) {
                    i++;
                }
            }
        });

    }

    public String getLine() {
        int dialogLength = dialogLines[i].length;
        switch (dialogLength) {
            case 1:
                return dialogLines[i][0];
            case 3:
                addDialogOptions();
                return dialogLines[i][0];
            case 5:
                addMultiAns();
                return dialogLines[i][0];
            default:
                return null;
        }
    }

    private void addMultiAns() {
    }

    private void addDialogOptions() {

        for (int j = 1; j < dialogLines[i].length; j++) {
            TextView option = new TextView(this.getContext());
            option.setText(dialogLines[i][j]);
            option.setId(j);
            option.setLayoutParams(new ViewGroup.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));
            dialogLayout.addView(option);
        }
    }

}
