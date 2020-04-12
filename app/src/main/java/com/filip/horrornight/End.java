package com.filip.horrornight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class End extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        ImageView image = findViewById(R.id.imageS);
        TextView stroyText = findViewById(R.id.story);
        Button again = findViewById(R.id.again);
        image.setImageResource(R.drawable.background);
        Intent intent = getIntent();
        String bravo = null;
        String kraj = null;
        boolean uspeh = false;

        if(intent != null)
        {
            kraj = intent.getStringExtra("kraj");
            uspeh = intent.getBooleanExtra("uspeh", false);
        }
            if(uspeh){
             bravo = "Bravo uspesno si ovo odradio";
             again.setText("Probaj da vidis sve krajeve");
        }
        else{
            bravo = "Zao mi je, niste uspeli";
            again.setText("Pokusaj ponovo");
        }
        String end = bravo + " " + kraj;
        stroyText.setText(end);




    }

    public void again(View view) {
        Intent intentl = new Intent(this, Start.class);
        startActivity(intentl);
    }
}
