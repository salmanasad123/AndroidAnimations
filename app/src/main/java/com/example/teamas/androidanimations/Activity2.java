package com.example.teamas.androidanimations;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.CircularPropagation;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.Gravity;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    Button startActivity3;
    Button showTextView;
    TextView textView;
    LinearLayout transitionContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        startActivity3 = findViewById(R.id.move_to_activity_3);
        textView = findViewById(R.id.animate_text_view);
        showTextView = findViewById(R.id.btn_visible_textView);
        transitionContainer = findViewById(R.id.transition_container);

        startActivity3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity2.this, Activity3.class);
                startActivity(intent);
            }
        });

        showTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isVisible = true;

                Transition transition = new Slide(Gravity.RIGHT);
                transition.setDuration(1000);
                transition.setInterpolator(new FastOutSlowInInterpolator());

                Transition transition1 = new Fade();
                transition1.setDuration(1000);
                transition1.setInterpolator(new FastOutSlowInInterpolator());

                TransitionManager.beginDelayedTransition(transitionContainer, transition);
                if (isVisible) {
                    textView.setVisibility(View.VISIBLE);
                } else {
                    textView.setVisibility(View.GONE);
                }

            }
        });
    }


    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}
