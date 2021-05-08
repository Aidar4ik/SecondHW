package com.example.secondhw.data.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.secondhw.R;
import com.example.secondhw.data.models.Films;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder>{

    private List<Films> list = new ArrayList<>();
    private onItemClickLiesten onItemClickLiesten;

    public MainAdapter(MainAdapter.onItemClickLiesten onItemClickLiesten) {
        this.onItemClickLiesten = onItemClickLiesten;
    }

    public void addList(List<Films> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_recycler_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.ViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView title, release_date;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            release_date = itemView.findViewById(R.id.release_date);

            itemView.setOnClickListener(v->{
                onItemClickLiesten.clicker(getAdapterPosition());
            });
        }

        public void onBind(Films films) {
            title.setText(films.getTitle());
            release_date.setText(films.getRelease_date());
        }
    }

    public interface onItemClickLiesten {
        void clicker(int position);
    }
}
