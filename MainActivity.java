package com.example.week12_adapterview_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list = findViewById(R.id.list);
        setContentView(R.layout.activity_main);
        String[] data ={"1","2","3","4","5"};
        ArrayAdapter<String> adapter=
                new ArrayAdapter<String>(MainActivity.this,
                        android.R.layout.simple_list_item_1,data);
        list.setAdapter(adapter);
    }
}