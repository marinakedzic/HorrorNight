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

public class GoInside extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        ImageView image = findViewById(R.id.imageS);
        TextView stroyText = findViewById(R.id.story);
        Button left = findViewById(R.id.leftb);
        Button right = findViewById(R.id.rightb);
        image.setImageResource(R.drawable.background);
        stroyText.setText("Odlucio si da ipak udjete. Drug predlaze da se odvojite i da trazite manijaka.");
        left.setText("Poslusaj ga");
        right.setText("Ipak idete zajedno");
    }
    public void odabir(View view) {
        String kraj;
        switch (view.getId()) {
            case R.id.leftb:
                kraj = "Od kad je pametno da se odvajate ma daj prvo i osnovno pravilo u filmovima.";
                Intent intentl = new Intent(this, End.class);
                intentl.putExtra("kraj", kraj);
                intentl.putExtra("uspeh",false);
                startActivity(intentl);
                break;
            case R.id.rightb:
                kraj = "Bravo bre uspeli ste da savladate manijaka!";
                Intent intentr = new Intent(this, End.class);
                intentr.putExtra("kraj", kraj);
                intentr.putExtra("uspeh",true);
                startActivity(intentr);
                break;
        }
    }
}
