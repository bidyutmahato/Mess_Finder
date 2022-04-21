package com.bidyut.messfinder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bidyut.messfinder.Models.MainModel;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainAdapter extends FirebaseRecyclerAdapter <MainModel,MainAdapter.myViewHolder> {

    public MainAdapter(@NonNull FirebaseRecyclerOptions<MainModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull MainModel model) {
        holder.name.setText(model.getName());
        holder.food.setText(model.getLocation());
        holder.type.setText(model.getType());
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_item,parent,false);
        return new myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder{

        ImageView img;
        TextView name, food , type;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            img = (ImageView)itemView.findViewById(R.id.imageView);
            name = (TextView)itemView.findViewById(R.id.messName);
            food =  (TextView)itemView.findViewById(R.id.location);
            type = (TextView)itemView.findViewById(R.id.type);


        }
    }
}
