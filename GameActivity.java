package com.example.administrator.activitytest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {
    Button restart=null;
    Button info=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        restart=(Button)findViewById(R.id.button5);
        info=(Button)findViewById(R.id.button4);
        Intent intent=getIntent();
        ArrayList<String> peizhi=intent.getStringArrayListExtra("peizhi");
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(GameActivity.this,CreateActivity.class);
                startActivity(intent);
            }
        });

    }
}
