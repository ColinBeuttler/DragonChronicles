package com.colinbeuttler.dragonchronicles;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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


    int i = 0;

    String[][] dialogLines = {
            {"Welcome to Dragon Flight"},
            {"Chapter 1: An Egg and a Stranger....."},
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
        dialogShadow = (TextView) view.findViewById(R.id.text_view_dialogue);
        dialogLayout = (LinearLayout) view.findViewById(R.id.dialog_linear_layout);
        dialogOptionsView = (ListView) requireView().findViewById(R.id.dialog_options_list_view);
        options = new ArrayList<String>();
        dialogShadow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogShadow.setText(getLine());
                if (dialogLines[i].length < 2) {
                    i++;
                }
            }
        });

    }

    public String getLine() {
        int dialogLength = dialogLines[i].length;
        switch (dialogLength) {
            case 1:
                return dialogLines[i][0];
            case 3:
                addDialogOptions();
                return dialogLines[i][0];
            case 5:
                addMultiAns();
                return dialogLines[i][0];
            default:
                return null;
        }
    }

    private void addMultiAns() {
    }

    private void addDialogOptions() {
        options.clear();
        for(int j = 1; j< dialogLines[i].length; j++){
            options.add(dialogLines[i][j]);
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(), R.layout.list_view_answer_option_layout, options);
        dialogOptionsView.setAdapter(arrayAdapter);
        Toast.makeText(getContext(), options.toString(), Toast.LENGTH_SHORT).show();
    }

}
