package com.hhs.dailypractice;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class HeroAdapter extends ArrayAdapter<Hero> {
    private int resourceId;

    public HeroAdapter(@NonNull Context context, int resource, List<Hero> object) {
        super(context, resource);
        resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Hero hero = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        TextView heroName = (TextView) view.findViewById(R.id.heroName);
        ImageView heroImage =(ImageView) view.findViewById(R.id.heroImage);
        heroName.setText(hero.getName());
        heroImage.setImageResource(hero.getImageId());
        Log.d("Songzzz","333");
        return view;
    }

}
