package com.colinbeuttler.dragonchronicles;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentContainerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.colinbeuttler.dragonchronicles.chapterselection.ChapterSelection;

public class MainActivity extends AppCompatActivity {

    CardView newGame;
    CardView chapterSelect;
    CardView options;

    TextView startLogin;

    LinearLayout startMenu;
    FragmentContainerView loginFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createCardViews();
        startNewGame();
        chapterSelectMenu();
        logIn();
    }

    private void createCardViews() {
        newGame = findViewById(R.id.new_game_card);
        chapterSelect = findViewById(R.id.chapter_selection_card);
        options = findViewById(R.id.options_card);
        startLogin = findViewById(R.id.start_login);
        startMenu = findViewById(R.id.start_menu);
        loginFragment = findViewById(R.id.log_in_fragment);

        startLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startLogin.setVisibility(View.INVISIBLE);
                startMenu.setVisibility(View.VISIBLE);

            }
        });
    }

   private void logIn(){
        getSupportFragmentManager().beginTransaction().add(R.id.log_in_fragment, LoginInFragment.class, null).commit();
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