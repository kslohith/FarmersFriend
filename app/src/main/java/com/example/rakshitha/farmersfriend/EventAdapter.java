package com.example.rakshitha.farmersfriend;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewholder> {

    Context context;
    List<Register> my_items;
    Button rent;

    public EventAdapter(Context context, List<Register> my_items) {
        this.context = context;
        this.my_items = my_items;
    }

    @NonNull
    @Override
    public EventViewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.card_layout2,null);
        //rent = (Button) view.findViewById(R.id.rent);
        return new EventViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewholder farmerViewholder, int i) {
        final Register items = my_items.get(i);

        farmerViewholder.name.setText(items.getName());
        farmerViewholder.usn.setText(items.getUsn());
        farmerViewholder.branch.setText(items.getBranch());
        farmerViewholder.event_name.setText(items.getEvent_name());

        //Picasso.get().load(items.getUrl()).into(farmerViewholder.imageView);



    }

    @Override
    public int getItemCount() {
        return my_items.size();
    }


    class EventViewholder extends RecyclerView.ViewHolder {


        TextView name , usn , branch , event_name;


        public EventViewholder(@NonNull View itemView) {
            super(itemView);
            //imageView = itemView.findViewById(R.id.imageView);
            name = itemView.findViewById(R.id.person_name);
            usn = itemView.findViewById(R.id.person_usn);
            branch = itemView.findViewById(R.id.person_branch);
            event_name = itemView.findViewById(R.id.event_name);


            //price = itemView.findViewById(R.id.textViewPrice);
        }
    }
}