package com.hhs.dailypractice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class HeroAdapter extends ArrayAdapter<Hero> {
    private int resourceId;

    public HeroAdapter(@NonNull Context context, int resource, List<Hero> heroList) {
        super(context, resource, heroList);
        this.resourceId = resource;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Toast.makeText(getContext(), "getView", Toast.LENGTH_SHORT).show();
        Hero hero = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        TextView heroName = (TextView) view.findViewById(R.id.heroName);
        heroName.setText(hero.getName());
        return view;
    }

}
