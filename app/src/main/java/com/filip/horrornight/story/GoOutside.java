package com.filip.horrornight.story;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.filip.horrornight.R;

public class GoOutside extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        ImageView image = findViewById(R.id.imageS);
        TextView stroyText = findViewById(R.id.story);
        Button left = findViewById(R.id.leftb);
        Button right = findViewById(R.id.rightb);
        image.setImageResource(R.drawable.outside);
        stroyText.setText(R.string.goOutside);
        left.setText("Vrati se u kucu");
        right.setText("Bezite zajedno");
    }
    public void odabir(View view) {
        switch (view.getId()) {
            case R.id.leftb:
                Intent intentl = new Intent(this, GoInside.class);
                startActivity(intentl);
                break;
            case R.id.rightb:
                Intent intentr = new Intent(this, Run.class);
                startActivity(intentr);
                break;
        }
    }
}
