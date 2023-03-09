package com.colinbeuttler.dragonchronicles;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ChapterAdapter extends RecyclerView.Adapter<ChapterAdapter.ChapterViewHolder> {

    private Chapter[] chapters;

    public ChapterAdapter(Chapter[] chapters){this.chapters = chapters;}

    @Override
    public int getItemCount() {
        return chapters.length;
    }

    @NonNull
    @Override
    public ChapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chapter_options, parent, false);
//        view.setOnClickListener();
        return new ChapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChapterViewHolder holder, int position) {
        holder.bind(chapters[position]);

    }

    static class ChapterViewHolder extends RecyclerView.ViewHolder{
        private TextView chapterTitle;

        public ChapterViewHolder(@NonNull View itemView) {
            super(itemView);
            this.chapterTitle = itemView.findViewById(R.id.text_view_chapter_title);
        }

        public void bind(Chapter chapter){
            chapterTitle.setText(chapter.title);
        }
    }

}
