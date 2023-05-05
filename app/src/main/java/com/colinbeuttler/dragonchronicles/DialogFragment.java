package com.colinbeuttler.dragonchronicles;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DialogFragment extends androidx.fragment.app.DialogFragment {

    TextView dialogCard;
    TextView nextDialogue;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_fragment, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dialogCard = (TextView) view.findViewById(R.id.text_view_dialogue);
        nextDialogue = (TextView) view.findViewById(R.id.text_view_next);
//        continueDialogue();
        dialogCard.setText("Hello there!!");
    }

//    private void continueDialogue() {
//        nextDialogue.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                dialogCard.setText("Hello there!!");
//            }
//        });
//    }
}
