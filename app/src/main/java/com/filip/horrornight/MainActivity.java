package com.filip.horrornight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .getBoolean("isFirstRun", true);

        if (isFirstRun) {
            setContentView(R.layout.activity_main);
            getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                    .putBoolean("isFirstRun", false).apply();
            getSharedPreferences("end", MODE_PRIVATE).edit()
                    .putBoolean("isForest1", true).apply();
            getSharedPreferences("end", MODE_PRIVATE).edit()
                    .putBoolean("isForest2", true).apply();
            getSharedPreferences("end", MODE_PRIVATE).edit()
                    .putBoolean("isStay1", true).apply();
            getSharedPreferences("end", MODE_PRIVATE).edit()
                    .putBoolean("isStay2", true).apply();
            getSharedPreferences("end", MODE_PRIVATE).edit()
                    .putBoolean("isRun", true).apply();
            getSharedPreferences("end", MODE_PRIVATE).edit()
                    .putBoolean("isInside1", true).apply();
            getSharedPreferences("end", MODE_PRIVATE).edit()
                    .putBoolean("isInside2", true).apply();
        }
        else{
            startActivity(new Intent(MainActivity.this, PlayerScreen.class));
        }
    }
    public void playerInfo(View view) {
        Intent intent = new Intent(this, PlayerInfo.class);
        startActivity(intent);
    }
}
