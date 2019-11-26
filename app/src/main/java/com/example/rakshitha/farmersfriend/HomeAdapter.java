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

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.FarmerViewholder> {

    Context context;
    List<Farmers> my_items;
    Button rent;

    public HomeAdapter(Context context, List<Farmers> my_items) {
        this.context = context;
        this.my_items = my_items;
    }

    @NonNull
    @Override
    public FarmerViewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.card_layout,null);
        //rent = (Button) view.findViewById(R.id.rent);
        return new FarmerViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FarmerViewholder farmerViewholder, int i) {
        final Farmers items = my_items.get(i);

        farmerViewholder.title.setText(items.getName());
        farmerViewholder.desc.setText(items.getDesc());
        farmerViewholder.date.setText(items.getDate());

        //Picasso.get().load(items.getUrl()).into(farmerViewholder.imageView);

        farmerViewholder.register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,RegisterEvent.class);
                intent.putExtra("name",items.getName());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return my_items.size();
    }


    class FarmerViewholder extends RecyclerView.ViewHolder {

        //ImageView imageView;
        TextView title, desc , date;
        Button register;

        public FarmerViewholder(@NonNull View itemView) {
            super(itemView);
            //imageView = itemView.findViewById(R.id.imageView);
            title = itemView.findViewById(R.id.textViewTitle);
            desc = itemView.findViewById(R.id.textViewShortDesc);
            date = itemView.findViewById(R.id.textDate);
            register = itemView.findViewById(R.id.register);


            //price = itemView.findViewById(R.id.textViewPrice);
        }
    }
}