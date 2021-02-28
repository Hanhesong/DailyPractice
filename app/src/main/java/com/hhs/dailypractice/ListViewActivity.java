package com.hhs.dailypractice;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListViewActivity extends AppCompatActivity {

    @BindView(R.id.listView)
    ListView listView;
    private List<Hero> heroList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        ButterKnife.bind(this);
        innitData();

        HeroAdapter adapter = new HeroAdapter(this, R.layout.list_item_part2, heroList);
        listView.setAdapter(adapter);
    }

    private void innitData() {
        heroList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Hero hero1 = new Hero("wuqi");
            Hero hero2 = new Hero("manwang");
            heroList.add(hero1);
            heroList.add(hero2);
        }
    }
}
