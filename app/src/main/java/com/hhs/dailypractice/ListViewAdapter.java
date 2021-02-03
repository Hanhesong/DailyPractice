package com.hhs.dailypractice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListViewAdapter extends ArrayAdapter<Hero> {


    public ListViewAdapter(@NonNull Context context, int resource, ArrayList<Hero> list) {
        super(context, resource, list);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Hero hero = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(R.layout.list_item_part2, parent, false);
        TextView heroName = view.findViewById(R.id.heroName);
        ImageView heroImage = view.findViewById(R.id.heroImage);
        heroName.setText(hero.getName());
        heroImage.setImageResource(R.mipmap.ic_launcher);
        return view;
    }
}
