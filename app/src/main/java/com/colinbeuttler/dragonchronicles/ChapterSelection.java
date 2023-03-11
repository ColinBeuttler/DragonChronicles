package com.colinbeuttler.dragonchronicles;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

public class ChapterSelection extends AppCompatActivity implements ChapterSelectListener{

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
        adapter = new ChapterAdapter(chapters, this);
        recyclerList.setAdapter(adapter);
    }

    @Override
    public void onItemClicked(int position) {
        Toast.makeText(this, "make toast", Toast.LENGTH_SHORT).show();
    }
}