package com.example.teamas.androidanimations;

import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Activity3 extends AppCompatActivity {

    Button shared_transition;
    ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        shared_transition = findViewById(R.id.btn_transition);
        imgView = findViewById(R.id.img_view);


        shared_transition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity3.this, Activity4.class);
                ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(Activity3.this,
                        imgView, ViewCompat.getTransitionName(imgView));
                startActivity(intent, optionsCompat.toBundle());
            }
        });
    }


}
