package com.bidyut.messfinder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bidyut.messfinder.Models.MainModel;
import com.bumptech.glide.Glide;
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
        holder.type.setText(model.getType());
        holder.location.setText(model.getLocation());
        holder.amount.setText(model.getAmount());
        holder.about.setText(model.getAbout());
        holder.contact.setText(model.getRoll());


        Glide.with(holder.img.getContext())
                .load(model.getMimage())
                .placeholder(R.drawable.icon_home)
                .circleCrop()
                .error(com.firebase.ui.database.R.drawable.common_google_signin_btn_icon_dark_normal)
                .into(holder.img);

            holder.more.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AppCompatActivity activity = (AppCompatActivity)view.getContext();
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.container,
                            new Details(model.getName(),model.getType(),
                                    model.getLocation(),model.getMimage(),
                                    model.getAmount(),model.getAbout(),
                                    model.getRoll()))
                            .addToBackStack(null).commit();

                }
            });

    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_item,parent,false);
        return new myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder{

        CircleImageView img;
        TextView name,type,location, amount, more , about, contact;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            img = (CircleImageView)itemView.findViewById(R.id.img1);
            name = (TextView)itemView.findViewById(R.id.messName);
            type = (TextView)itemView.findViewById(R.id.type);
            location =  (TextView)itemView.findViewById(R.id.location);
            amount =  (TextView)itemView.findViewById(R.id.amount);
            more =  (TextView)itemView.findViewById(R.id.more);
            about =  (TextView)itemView.findViewById(R.id.about);
            contact =  (TextView)itemView.findViewById(R.id.contact);



        }
    }
}
