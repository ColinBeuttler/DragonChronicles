package com.colinbeuttler.dragonchronicles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class GameStart extends AppCompatActivity {

    TextView dialogue;
    TextView nextDialogue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter_1_activity_background);
        setDialogue();
        continueDialogue();
    }

    private void setDialogue() {
        dialogue = findViewById(R.id.text_view_dialogue);
        nextDialogue = findViewById(R.id.text_view_next);
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