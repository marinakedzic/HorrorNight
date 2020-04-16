package com.filip.horrornight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class PlayerScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_screen);
    }

    public void gameStarts(View view) {
        Intent intent = new Intent(this,Start.class);
        startActivity(intent);
    }

    public void showProfile(View view) {
        Intent intent = new Intent(this,ShowPlayer.class);
        startActivity(intent);
    }
}
