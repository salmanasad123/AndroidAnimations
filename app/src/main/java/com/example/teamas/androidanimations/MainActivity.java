package com.example.teamas.androidanimations;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button animateBtn;
    Button activity2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);
        animateBtn = findViewById(R.id.btn_animate);
        activity2 = findViewById(R.id.move_to_activity_2);

        animateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* YoYo.with(Techniques.Shake)
                        .duration(1000)
                        .repeat(1)
                        .playOn(textView);*/
                Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.slide_in_right);
                textView.startAnimation(animation);
            }
        });

        activity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // adding animations to Intents

                Intent intent = new Intent(MainActivity.this, Activity2.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
    }

}
