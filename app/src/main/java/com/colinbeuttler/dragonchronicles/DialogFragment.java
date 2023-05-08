package com.colinbeuttler.dragonchronicles;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DialogFragment extends androidx.fragment.app.DialogFragment {

    TextView dialogShadow;

    int i = 0;

    String[] dialogLines = {
            "\n\tWelcome to Dragon Flight",
            "\n\n\tChapter 1: An Egg and a Stranger.....\n\n",
            "\n\t'Good Morning'",
            "'Now where were we?'",
            "\n\t'...Oh yes that's right!!!'",
            "\n\t'You were about to pick a dragon egg...",
            "\n\tDid you make a decision yet?'",

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

public String getLine(){
    return dialogLines[i];
}

}
