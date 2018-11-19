package com.example.szewy.shoppinglist;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    public List<Item> items;
    private Context context;


    public MyAdapter(List<Item> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_listitem, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(final MyViewHolder myViewHolder, final int i) {
        myViewHolder.title.setText(items.get(i).title);

        int id = context.getResources().getIdentifier(items.get(i).image, "drawable", context.getPackageName());

        myViewHolder.image.setImageResource(id);

        myViewHolder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ItemActivity.class);
                intent.putExtra("item", items.get(i));
                intent.putExtra("id", i);

                int id = context.getResources().getIdentifier(items.get(i).image, "drawable", context.getPackageName());

                myViewHolder.image.setImageResource(id);

                context.startActivity(intent);

                //items.remove(i);
                //notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        CircleImageView image;
        RelativeLayout parentLayout;

        public MyViewHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.item_text);
            image = (CircleImageView) itemView.findViewById(R.id.item_image);
            parentLayout = (RelativeLayout) itemView.findViewById(R.id.parent_layout);
        }
    }

}
