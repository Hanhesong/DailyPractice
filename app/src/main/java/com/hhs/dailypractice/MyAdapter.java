package com.hhs.dailypractice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;


public class MyAdapter extends RecyclerView.Adapter {
    private LayoutInflater inflater;
    private ArrayList<HashMap<String, Object>> itemList;
    private MyItemClickListener listener;

    public MyAdapter(Context context, ArrayList<HashMap<String, Object>> itemList) {
        inflater = LayoutInflater.from(context);
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.list_item, null));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.text.setText((String) itemList.get(position).get("ItemText"));
        viewHolder.title.setText((String) itemList.get(position).get("ItemTitle"));
        viewHolder.image.setImageResource((Integer) itemList.get(position).get("ItemImage"));

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title, text;
        private ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.ItemTitle);
            text = itemView.findViewById(R.id.ItemText);
            image = itemView.findViewById(R.id.ItemImage);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        listener.onItemClick(v, getPosition());
                    }
                }
            });
        }

        public TextView getTitle() {
            return title;
        }

        private TextView getText() {
            return text;
        }

        private ImageView getImage() {
            return image;
        }

    }

    interface MyItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(MyItemClickListener itemClickListener) {
        this.listener = itemClickListener;
    }

}
