package com.knyzhenko.remindme.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.knyzhenko.remindme.R;
import com.knyzhenko.remindme.model.Termin;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.TerminHolder> {
    private ArrayList<Termin> termins;

    public RecyclerViewAdapter(ArrayList<Termin> termins) {
        this.termins = termins;
    }

    @NonNull
    @Override
    public TerminHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder, parent, false);
        return new TerminHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TerminHolder holder, int position) {
       // holder.img.setImageResource(termins.get(position).getImage());
        holder.title.setText(termins.get(position).getTitle());
        holder.descriptoion.setText(termins.get(position).getDesc());
    }

    @Override
    public int getItemCount() {
        return termins.size();
    }

    class TerminHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView title, descriptoion;

        public TerminHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imageViewHolder);
            title = itemView.findViewById(R.id.textViewTitleTermin);
            descriptoion = itemView.findViewById(R.id.textViewDescription);
        }
    }
}
