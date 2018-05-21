package com.example.a14049472.p05;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    Button btnStars;
    ListView lv;
    ArrayAdapter aa;
    ArrayList<Song> al;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        lv=(ListView)findViewById(R.id.lv);
        al=new ArrayList<>();
        aa= new ArrayAdapter<Song>(this,R.layout.row,al);
        lv.setAdapter(aa);






        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DBHelper dbh= new DBHelper(SecondActivity.this);


            }
        });
    }
}
