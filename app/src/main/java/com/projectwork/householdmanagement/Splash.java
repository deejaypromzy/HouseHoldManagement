package com.projectwork.householdmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

import me.wangyuwei.particleview.ParticleView;


public class Splash extends AppCompatActivity {
     ParticleView mPv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mPv1 = findViewById(R.id.pv_1);
        mPv1.startAnim();
        mPv1.setOnParticleAnimListener(new ParticleView.ParticleAnimListener() {
            @Override
            public void onAnimationEnd() {
                Intent intent = new Intent(getApplication(), main.class);
                startActivity(intent);

            }
        });
/*
        mPv1.postDelayed(new Runnable() {
            @Override
            public void run() {
                mPv1.startAnim();
            }
        }, 2000);*/

    }
    //when splash activity pauses
    @Override
    protected void onPause() {
        super.onPause();
        this.finish();
    }
}
