package com.colinbeuttler.dragonchronicles;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.colinbeuttler.dragonchronicles.chapterselection.ChapterSelection;

public class MainActivity extends AppCompatActivity {

    CardView newGame;
    CardView chapterSelect;
    CardView options;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createCardViews();
        startNewGame();
        chapterSelectMenu();
    }

    private void createCardViews() {
        newGame = findViewById(R.id.new_game_card);
        chapterSelect = findViewById(R.id.chapter_selection_card);
        options = findViewById(R.id.options_card);
    }

    private void startNewGame() {
        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newGameIntent = new Intent(MainActivity.this, GameActivity.class);
                startActivity(newGameIntent);
            }
        });
    }

    private void chapterSelectMenu() {
        chapterSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent chapterSelectionIntent = new Intent(MainActivity.this, ChapterSelection.class);
                startActivity(chapterSelectionIntent);
            }
        });
    }
}