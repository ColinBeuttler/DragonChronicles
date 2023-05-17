package com.colinbeuttler.dragonchronicles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.colinbeuttler.dragonchronicles.models.Dragon;
import com.colinbeuttler.dragonchronicles.models.DragonList;

import java.util.ArrayList;

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