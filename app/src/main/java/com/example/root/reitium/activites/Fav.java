package com.example.root.reitium.activites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.root.reitium.R;
import com.example.root.reitium.activites.adpaters.LandingAct;

public class Fav extends AppCompatActivity {

    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav);

        linearLayout=(LinearLayout)findViewById(R.id.linerLeft);

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Fav.this, LandingAct.class));
                overridePendingTransition(R.anim.animator_in,R.anim.animator_out);
            }
        });
    }
}
