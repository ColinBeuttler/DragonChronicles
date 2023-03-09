package com.colinbeuttler.dragonchronicles;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

public class ChapterSelection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_selection);
        RecyclerView recyclerList = findViewById(R.id.recycler_view_chapters);

        Chapter[] chapters ={
                new Chapter("Chapter 2"),
                new Chapter("Chapter 3"),
                new Chapter("Chapter 4"),
                new Chapter("Chapter 5"),
                new Chapter("Chapter 6")
        };

        ChapterAdapter adapter;
        adapter = new ChapterAdapter(chapters);
        recyclerList.setAdapter(adapter);
    }

}