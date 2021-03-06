package com.example.root.reitium.splashsecreens;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.root.reitium.R;

public class SplashOne extends AppCompatActivity {

    public static int splashTimeOut=2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent=new Intent(SplashOne.this,SplashSecond.class);
                startActivity(intent);

            }
        },splashTimeOut);
    }

    }

