package com.example.a14049472.p05;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etTitle, etSong, etYear;
    RadioGroup rg;
    Button btnInsert, btnList;
    ArrayList<Song> al;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTitle = (EditText) findViewById(R.id.etTitle);
        etSong = (EditText) findViewById(R.id.etSingers);
        etYear = (EditText) findViewById(R.id.etYear);
        rg = (RadioGroup) findViewById(R.id.rg);
        btnInsert = (Button) findViewById(R.id.btnInsert);
        btnList = (Button) findViewById(R.id.btnList);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = etTitle.getText().toString();
                String song = etSong.getText().toString();
                int year = Integer.parseInt(etYear.getText().toString());
                int selectedButtonId = rg.getCheckedRadioButtonId();
                RadioButton rb = (RadioButton) findViewById(selectedButtonId);
               int rb1 = Integer.parseInt(rb.getText().toString());


                DBHelper dbh = new DBHelper(MainActivity.this);
                long row_affected = dbh.insertSong(title,song,year,rb1);
                dbh.close();
                if (row_affected != -1) {
                    Toast.makeText(MainActivity.this, "Insert successful",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,SecondActivity.class);
                DBHelper dbh=new DBHelper(MainActivity.this);
                al.clear();
                al.addAll(dbh.getAllSongs());
                dbh.close();

            }
        });


    }
}
