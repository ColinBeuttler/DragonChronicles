package com.colinbeuttler.dragonchronicles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_activity_background);
        loadDialog();

    }



    private void loadDialog() {
        getSupportFragmentManager().beginTransaction().add(R.id.dialog_fragment, DialogFragment.class, null).commit();
    }


}