package com.colinbeuttler.dragonchronicles;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DialogFragment extends androidx.fragment.app.DialogFragment {

    TextView dialogue;
    TextView nextDialogue;
    public DialogFragment(){
        super(R.layout.dialog_fragment);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private void setDialogue() {
        dialogue = dialogue.findViewById(R.id.text_view_dialogue);
        nextDialogue = dialogue.findViewById(R.id.text_view_next);
    }

    private void continueDialogue() {
        nextDialogue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogue.setText("Hello there!!");
            }
        });
    }
}
