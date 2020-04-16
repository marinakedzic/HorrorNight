package com.filip.horrornight;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

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
        Intent intent = getIntent();
        String alive = null;
        String end = null;
        boolean success;
        int imageId;

        if(intent != null)
        {
            end = intent.getStringExtra("end");
            success = intent.getBooleanExtra("success", false);
            imageId = intent.getIntExtra("image",R.drawable.murderer);
            image.setImageResource(imageId);

            if(success){
                alive = getString(R.string.aliveTure);
                again.setText(R.string.tryMore);
            }
            else{
                alive = getString(R.string.aliveFalse);
                again.setText(R.string.tryAgain);
            }
        }
        String endAll = alive + " " + end;
        stroyText.setText(endAll);




    }

    public void again(View view) {
        Intent intentl = new Intent(this, Start.class);
        startActivity(intentl);
    }
    @Override
    public void onBackPressed(){
        NavUtils.navigateUpFromSameTask(this);
    }
}
