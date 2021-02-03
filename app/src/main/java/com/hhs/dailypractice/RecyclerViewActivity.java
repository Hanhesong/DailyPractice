package com.hhs.dailypractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewActivity extends AppCompatActivity implements MyAdapter.MyItemClickListener {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private ArrayList<HashMap<String, Object>> itemList;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        ButterKnife.bind(this);
        innitData();
        innitViews();
    }

    private void innitData() {
        itemList = new ArrayList<HashMap<String, Object>>();
        for (int i = 0; i < 50; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("ItemTitle", "第" + i + "行");
            map.put("ItemText", "这是第" + i + "行");
            map.put("ItemImage", R.mipmap.ic_launcher);
            itemList.add(map);
        }
    }

    private void innitViews() {
        adapter = new MyAdapter(this, itemList);
        adapter.setOnItemClickListener(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onItemClick(View view, int position) {
        startActivity(new Intent(this, ListViewActivity.class));
    }
}