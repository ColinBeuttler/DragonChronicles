package com.colinbeuttler.dragonchronicles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    TextView titleScreen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_activity_background);
        titleScreen = (TextView) this.findViewById(R.id.title_screen_background_view);
        DialogFragment fragment = (DialogFragment) getSupportFragmentManager().findFragmentById(R.id.dialog_fragment);
        titleScreen.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                titleScreen.setVisibility(View.INVISIBLE);
                loadDialog();
                assert fragment != null;
                fragment.setDialog();
            }
        });
    }


    private void loadDialog() {
        getSupportFragmentManager().beginTransaction().add(R.id.dialog_fragment, DialogFragment.class, null).commit();
    }


}