package com.root.HaditsSimilarity.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.activeandroid.query.Select;
import com.root.HaditsSimilarity.R;
import com.root.HaditsSimilarity.adapter.HaditsAdapter;
import com.root.HaditsSimilarity.model.Hadits;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rv_hadits)
    RecyclerView mRecyclerView;

    private HaditsAdapter mAdapter;
    List<Hadits> listHadits = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        listHadits = new Select().from(Hadits.class).orderBy("id ASC").execute();

        mAdapter = new HaditsAdapter(MainActivity.this, listHadits);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @OnClick(R.id.btn_add)
    public void addHadits(){
        startActivity(new Intent(MainActivity.this,InputHadits.class));
    }
}
