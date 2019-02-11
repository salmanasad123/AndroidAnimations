package com.example.teamas.androidanimations;

import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.constraint.Placeholder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;

public class Constraint_Layout extends AppCompatActivity {

    Placeholder placeholder;
    ConstraintLayout mLayout;
    ConstraintSet constraintSetOld = new ConstraintSet();   // for old view
    ConstraintSet constraintSetNew = new ConstraintSet();   // for new view (alternate view)
    boolean alt_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint__layout);
        mLayout = findViewById(R.id.mLayout);

        constraintSetOld.clone(mLayout);
        constraintSetNew.clone(this, R.layout.activity_constraint_layout_alt);

    }

    public void swapView(View view) {
        TransitionManager.beginDelayedTransition(mLayout);
    }

    public void changeView(View view) {
        TransitionManager.beginDelayedTransition(mLayout);
        if (alt_layout == false) {
            constraintSetNew.applyTo(mLayout);
            alt_layout = true;

        } else {
            constraintSetOld.applyTo(mLayout);
            alt_layout = false;
        }
    }
}
