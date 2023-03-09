package com.colinbeuttler.dragonchronicles;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    CardView newGame;

    CardView chapterSelect;

    CardView options;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newGame = findViewById(R.id.new_game_card);
        chapterSelect = findViewById(R.id.chapter_selection_card);
        options = findViewById(R.id.options_card);

        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newGameIntent = new Intent(MainActivity.this, GameStart.class);
                startActivity(newGameIntent);
            }
        });

        chapterSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent chapterSelectionIntent = new Intent(MainActivity.this, ChapterSelection.class);
                startActivity(chapterSelectionIntent);
            }
        });
    }
}