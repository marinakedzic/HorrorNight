package com.filip.horrornight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.filip.horrornight.story.GoOutside;
import com.filip.horrornight.story.StayHome;

public class Start extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        ImageView image = findViewById(R.id.imageS);
        TextView stroyText = findViewById(R.id.story);
        Button left = findViewById(R.id.leftb);
        Button right = findViewById(R.id.rightb);
        image.setImageResource(R.drawable.background);
        stroyText.setText(R.string.storystart);
        left.setText("Ostajes kuci da istrazis sta se desava");
        right.setText("Bezis napolje glavom bez obzira");

    }

    public void odabir(View view) {
        switch (view.getId()) {
            case R.id.leftb:
                Intent intentl = new Intent(this, StayHome.class);
                startActivity(intentl);
                break;
            case R.id.rightb:
                Intent intentr = new Intent(this, GoOutside.class);
                startActivity(intentr);
                break;
        }
    }
}
