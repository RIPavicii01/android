package com.example.week12adapter_greidview2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {
    Gallery gallery;
    ImageView ivPoster;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ivPoster = findViewById(R.id.ivPoster);
        gallery = findViewById(R.id.gallery);
        GlleryAdapter adapter = new GlleryAdapter(MainActivity.this);
        gallery.setAdapter(adapter);
    }
    public class GlleryAdapter extends BaseAdapter{

        Context context;
        GlleryAdapter (Context c){
            context = c;
        }

        Integer[] postid = { // 이미지 리소스 ID 배열
                R.drawable.mov01, R.drawable.mov02, R.drawable.mov03, R.drawable.mov04,
                R.drawable.mov05, R.drawable.mov06, R.drawable.mov07, R.drawable.mov08,
                R.drawable.mov09, R.drawable.mov10, R.drawable.mov11, R.drawable.mov12,
                R.drawable.mov13, R.drawable.mov14, R.drawable.mov15, R.drawable.mov16,
                R.drawable.mov17, R.drawable.mov18, R.drawable.mov19, R.drawable.mov20,
                R.drawable.mov21, R.drawable.mov22, R.drawable.mov23, R.drawable.mov24
        };


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

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ImageView  img = new ImageView(MainActivity.this);
            img.setLayoutParams(new Gallery.LayoutParams(200,300));
            img.setScaleType(ImageView.ScaleType.CENTER);
            img.setPadding(5,5,5,5);
            img.setImageResource(postid[i]);
            img.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    ivPoster.setImageResource(postid[i]);
                    return false;
                }
            });
            return img;
        }
    }
}