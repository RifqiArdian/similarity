package com.root.HaditsSimilarity.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.root.HaditsSimilarity.R;
import com.root.HaditsSimilarity.adapter.HaditsAdapter;
import com.root.HaditsSimilarity.model.Hadits;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class InputHadits extends AppCompatActivity {

    @BindView(R.id.et_deskripsi)
    TextView deskripsi;
    @BindView(R.id.et_hadits_satu)
    TextView hadissatu;
    @BindView(R.id.et_hadits_dua)
    TextView hadisdua;

    private HaditsAdapter mAdapter;
    List<Hadits> listHadits = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_hadits);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_simpan)
    public void simpan(){
        Hadits hadits = new Hadits();
        hadits.description = deskripsi.getText().toString();
        hadits.haditsSatu = hadissatu.getText().toString();
        hadits.haditsDua = hadisdua.getText().toString();
        hadits.save();
        recreate();

        listHadits.add(hadits);
        mAdapter.notifyDataSetChanged();

    }

    @OnClick(R.id.btn_cancel)
    public void cancel(){
        startActivity(new Intent(InputHadits.this,MainActivity.class));
    }
}
