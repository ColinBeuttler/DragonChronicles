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

import com.colinbeuttler.dragonchronicles.models.Dragon;
import com.colinbeuttler.dragonchronicles.models.DragonList;

import java.util.ArrayList;
import java.util.Arrays;


public class DialogFragment extends androidx.fragment.app.DialogFragment {

    TextView dialogShadow;
    LinearLayout dialogLayout;

    ListView dialogOptionsView;

    ArrayList<String> options;

    TextView titleScreen;

    DragonList dragons;


    int i = 0;

    String[][] dialogLines = {
            {"Good Morning"},
            {"Finally awake I see...."},
            {"Now where were we?"},
            {"...Oh yes that's right!!!"},
            {"You were about to pick a dragon egg..."},
            {"Did you make a decision yet?", "Yes", "No"},
            {"Need more time..."},
            {"or Should I pick for you?"},
            {"How's this egg?", "Green Egg", "Blue Egg", "Purple Egg"},
            {"You stare deep into the egg..."},
            {"***Egg Message***"},
            {"Choose this egg?", "Yes", "No"},
            {"You are handed the egg, you turn it over in your hands..."},
            {"What would you like to do with the Egg?", "Hold the egg close to the fire.", "Rub the egg.", "Do nothing with the egg"},
            {"I think it's hatching..."},
            {"It's a ***hatchling gender***"},
            {"Ohhh, that's rare..."},
            {"a ***dragon species***"},
            {"Have you heard of the dragon tribes?"},
            {"Anyways... every dragon species has a place of origin..."},
            {"the locals in these places of origin tame and ride the respective species.."},
            {"so they know it better than anyone else."},
            {"These locals are known as the dragon tribes."},
            {"If you want to learn how to ride your new friend, you will need to seek out one of these tribes."},
            {"The tribes you will want to seek out, is the ***dragon origin*** tribe."},
            {"Quite a wild bunch if I remember, although I'd say that about all the dragon tribes..."},
            {"there's a reason I just sell their eggs, I'm not crazy enough to actually get on one's back..."},
            {"This is when we part ways, are you ready to go?", "Yes", "Not yet"},
            {"...well you can't stay here with me, I have business to attend."},
            {"Ready to be on your way?", "Yes", "No"},
            {"A small carriage drops from above you, several adolescent wyverns are tethered to the top."},
            {"The door swings open, revealing a black barren interior with a single seat, it has no windows"},
            {"With your new Hatchling in toe, you get inside..."},
            {"Continue to next Chapter?"}
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
        dragons = new DragonList();


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
        options = new ArrayList<>();
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
