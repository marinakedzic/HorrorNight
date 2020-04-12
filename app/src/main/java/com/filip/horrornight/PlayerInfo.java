package com.filip.horrornight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

public class PlayerInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_info);
    }

    public void gameStarts(View view) {
        EditText firstText = (EditText) findViewById(R.id.userName);
        String userName = String.valueOf(firstText.getText());
        EditText secondText = (EditText) findViewById(R.id.friendName);
        String friendName = String.valueOf(secondText.getText());
        User user = new User(userName, friendName);
        Intent intent = new Intent(this,Start.class);
        intent.putExtra("ime", userName);
        intent.putExtra("drug", friendName);
        startActivity(intent);
    }
}
