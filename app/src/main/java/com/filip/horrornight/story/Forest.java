package com.filip.horrornight.story;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.filip.horrornight.End;
import com.filip.horrornight.R;

public class Forest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        ImageView image = findViewById(R.id.imageS);
        TextView stroyText = findViewById(R.id.story);
        Button left = findViewById(R.id.leftb);
        Button right = findViewById(R.id.rightb);
        image.setImageResource(R.drawable.background);
        stroyText.setText("Klasika drug ti se sapleo jer msm sto da ne kad je svakako smotan.");
        left.setText("Pomocices mu");
        right.setText("Neces mu pomoci");
    }
    public void odabir(View view) {
        String kraj;
        switch (view.getId()) {
            case R.id.leftb:
                kraj= "Ko je ikada preziveo kad se sapleo u sumi.";
                Intent intentl = new Intent(this, End.class);
                intentl.putExtra("kraj",kraj);
                intentl.putExtra("uspeh",false);
                startActivity(intentl);
                break;
            case R.id.rightb:
                kraj = "Mislis li stvarno da izdajice prezivljavaju. Shame on you!";
                Intent intentr = new Intent(this, End.class);
                intentr.putExtra("kraj",kraj);
                intentr.putExtra("uspeh",false);
                startActivity(intentr);
                break;
        }
    }
}
