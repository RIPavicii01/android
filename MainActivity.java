package com.example.week12_adapter_gridview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.helper.widget.Grid;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
GridView grid;
View dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        grid = findViewById(R.id.grid);
        GridAdapter adapter = new GridAdapter(MainActivity.this);
        grid.setAdapter(adapter);
    }
    class GridAdapter extends BaseAdapter{

        Context context;
        Integer[] postid = { // 이미지 리소스 ID 배열
                R.drawable.mov01, R.drawable.mov02, R.drawable.mov03, R.drawable.mov04,
                R.drawable.mov05, R.drawable.mov06, R.drawable.mov07, R.drawable.mov08,
                R.drawable.mov09, R.drawable.mov10, R.drawable.mov11, R.drawable.mov12,
                R.drawable.mov13, R.drawable.mov14, R.drawable.mov15, R.drawable.mov16,
                R.drawable.mov17, R.drawable.mov18, R.drawable.mov19, R.drawable.mov20,
                R.drawable.mov21, R.drawable.mov22, R.drawable.mov23, R.drawable.mov24
        };
        public GridAdapter(Context contex){
            this.context = contex;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ImageView img = new ImageView(context);
            img.setLayoutParams(new ViewGroup.LayoutParams(150,200));
            img.setPadding(5,5,5,5);
            img.setImageResource(postid[i]);
            final int pos = i;

            img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog = View.inflate(MainActivity.this,R.layout.dialog,null);
                    AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                    ImageView ivpost = dialog.findViewById(R.id.ivPost);
                    ivpost.setImageResource(postid[pos]);
                    dlg.setView(dialog);
                    dlg.setNegativeButton("close",null);
                    dlg.setPositiveButton("ok",null);
                    dlg.setIcon(R.drawable.movie_icon);
                    dlg.setTitle("big ima");


                    dlg.show();
                }
            });

            return img;
        }
        @Override
        public int getCount() {
            return postid.length;
        }
        @Override
        public Object getItem(int i) {
            return null;
        }
        @Override
        public long getItemId(int i) {
            return 0;
        }

    }
}