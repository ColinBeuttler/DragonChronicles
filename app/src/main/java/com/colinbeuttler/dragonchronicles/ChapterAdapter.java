package com.colinbeuttler.dragonchronicles;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class ChapterAdapter extends RecyclerView.Adapter<ChapterAdapter.ChapterViewHolder> {

    private Chapter[] chapters;

    public ChapterAdapter(Chapter[] chapters){this.chapters = chapters;}

    private ChapterSelectListener listener;

    public ChapterAdapter(Chapter[] chapters, ChapterSelectListener listener) {
        this.chapters = chapters;
        this.listener = listener;
    }

    @Override
    public int getItemCount() {
        return chapters.length;
    }

    @NonNull
    @Override
    public ChapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chapter_options, parent, false);
        return new ChapterViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ChapterViewHolder holder, int position) {
        holder.bind(chapters[position]);
    }

    static class ChapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView chapterTitle;
        ChapterSelectListener listener;
        public CardView cardView;

        public ChapterViewHolder(@NonNull View itemView, ChapterSelectListener listener) {
            super(itemView);
            this.chapterTitle = itemView.findViewById(R.id.text_view_chapter_title);
            this.cardView = itemView.findViewById(R.id.card_view_chapter);
            this.listener = listener;

            itemView.setOnClickListener(this);
        }

        public void bind(Chapter chapter){
            chapterTitle.setText(chapter.title);
        }

        @Override
        public void onClick(View view) {
            this.listener.onItemClicked(getAdapterPosition());
        }
    }

}
