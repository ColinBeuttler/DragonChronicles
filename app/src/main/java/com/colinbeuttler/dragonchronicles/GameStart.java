package com.colinbeuttler.dragonchronicles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class GameStart extends AppCompatActivity {

    TextView dialogue;

    TextView nextDialogue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_start);

        dialogue = findViewById(R.id.text_view_dialogue);
        nextDialogue = findViewById(R.id.text_view_next);


    }
}