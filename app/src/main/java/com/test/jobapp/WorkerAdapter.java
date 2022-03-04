package com.test.jobapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class WorkerAdapter extends FirebaseRecyclerAdapter<WorkerModel, WorkerAdapter.myViewHolder> {

    public WorkerAdapter(@NonNull FirebaseRecyclerOptions<WorkerModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull WorkerModel model) {
        holder.Username.setText(model.getUsername());
        holder.Prof.setText(model.getProf());
        holder.Num.setText(model.getUserNum());
        Glide.with(holder.img.getContext()).load(model.getQuestionImage()).into(holder.img);
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow, parent, false);
        return new myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView Username, Prof, Num;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            img = (ImageView)itemView.findViewById(R.id.img1);
            Username = (TextView)itemView.findViewById(R.id.nametext);
            Prof = (TextView)itemView.findViewById(R.id.proftext);
            Num = (TextView)itemView.findViewById(R.id.biotext);
        }
    }
}
