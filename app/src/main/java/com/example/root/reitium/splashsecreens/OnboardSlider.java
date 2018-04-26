package com.example.root.reitium.splashsecreens;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.root.reitium.R;
import com.example.root.reitium.activites.adpaters.LandingAct;
import com.example.root.reitium.activites.adpaters.SliderAdapter;
import com.example.root.reitium.alltinderact.TinderActivity;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class OnboardSlider extends AppCompatActivity {

    private ViewPager mPager;
    private ImageView txtSkip;
    private static int currentPage = 0;
    private static final Integer[] XMEN= {R.drawable.firstonboard,R.drawable.secondonboard,R.drawable.thirdonboard};
    private ArrayList<Integer> XMENArray = new ArrayList<Integer>();
    private static int finalPage=XMEN.length;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reitium_anim);

        txtSkip=(ImageView) findViewById(R.id.txtSkip);
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        init();

        txtSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(OnboardSlider.this, LandingAct.class);
                startActivity(intent);
            }
        });
    }
    private void init() {
        for(int i=0;i<XMEN.length;i++)
            XMENArray.add(XMEN[i]);

        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(new SliderAdapter(OnboardSlider.this,XMENArray));
//        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
//        indicator.setViewPager(mPager);

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == XMEN.length) {
                    currentPage = 0;
                    return;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 2000, 2000);
    }


}
