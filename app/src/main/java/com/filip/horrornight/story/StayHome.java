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

public class StayHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        ImageView image = findViewById(R.id.imageS);
        TextView stroyText = findViewById(R.id.story);
        Button left = findViewById(R.id.leftb);
        Button right = findViewById(R.id.rightb);
        image.setImageResource(R.drawable.kitchen);
        stroyText.setText("Ipak ostajes sta ces sad da uradis, jesi li se uplasio ili ne?");
        left.setText("Proverices kuhinju");
        right.setText("Bezis ispod kreveta");
    }
    public void odabir(View view) {
        String kraj;
        Boolean uspeh = false;
        switch (view.getId()) {
            case R.id.leftb:
                kraj= "Je l stvarno mislis da je pametno otici direktno ka ludaku?";
                Intent intentl = new Intent(this, End.class);
                intentl.putExtra("kraj",kraj);
                intentl.putExtra("uspeh",uspeh);
                intentl.putExtra("slika",R.drawable.h);
                startActivity(intentl);
                break;
            case R.id.rightb:
                kraj = "Sta mislis gde ce prvo da pogleda?";
                Intent intentr = new Intent(this, End.class);
                intentr.putExtra("kraj",kraj);
                intentr.putExtra("uspeh",uspeh);
                intentr.putExtra("slika",R.drawable.underbed);
                startActivity(intentr);
                break;
        }
    }
}
