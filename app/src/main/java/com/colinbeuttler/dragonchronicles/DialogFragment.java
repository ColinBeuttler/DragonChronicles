package com.colinbeuttler.dragonchronicles;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Arrays;


public class DialogFragment extends androidx.fragment.app.DialogFragment {

    TextView dialogShadow;
    LinearLayout dialogLayout;

    ListView dialogOptionsView;

    ArrayList<String> options;

    TextView titleScreen;


    int i = 0;

    String[][] dialogLines = {
            {"'Good Morning'"},
            {"'Finally awake I see....'"},
            {"'Now where were we?'"},
            {"'...Oh yes that's right!!!'"},
            {"'You were about to pick a dragon egg..."},
            {"Did you make a decision yet?'", "Yes", "No"}
    };


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_fragment, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        titleScreen = (TextView) view.findViewById(R.id.title_screen_background_view);
        dialogShadow = (TextView) view.findViewById(R.id.text_view_dialogue);
        dialogLayout = (LinearLayout) view.findViewById(R.id.dialog_linear_layout);
        dialogOptionsView = (ListView) requireView().findViewById(R.id.dialog_options_list_view);
        options = new ArrayList<String>();


        dialogShadow.setOnClickListener(v -> {
            dialogShadow.setText(getLine());
            if (dialogLines[i].length < 2) {
                i++;
            }
        });

        titleScreen.setOnClickListener(v -> {
            if (titleScreen.getVisibility() == View.VISIBLE) {
                titleScreen.setVisibility(View.GONE);
            }
        });

    }

    public String getLine() {
        if (dialogLines[i].length > 1) {
            addDialogOptions();
        }
        return dialogLines[i][0];
    }


    private void addDialogOptions() {
        options.clear();
        options.addAll(Arrays.asList(dialogLines[i]).subList(1, dialogLines[i].length));
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(), R.layout.list_view_answer_option_layout, options);
        dialogOptionsView.setAdapter(arrayAdapter);
        dialogOptionsView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value = arrayAdapter.getItem(position);
                Toast.makeText(getContext(), value, Toast.LENGTH_LONG).show();
            }
        });
    }

}
