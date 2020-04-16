package com.filip.horrornight;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;
import androidx.lifecycle.ViewModelProvider;

import android.app.Application;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

public class PlayerInfo extends AppCompatActivity {
    UserRepository userRepository;
    int userId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_info);
        userRepository = new UserRepository(getApplication());

    }

    public void gameStarts(View view) {
        EditText firstText = (EditText) findViewById(R.id.userName);
        String userName = firstText.getText().toString();
        EditText secondText = (EditText) findViewById(R.id.friendName);
        String friendName = secondText.getText().toString();
        User user = new User(1,userName,friendName,0);
        userRepository.insert(user);

        String packageName = getPackageName();
        SharedPreferences sharedPreferences = getSharedPreferences(packageName, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        userId = user.getUserId();
        editor.putInt("id", 1);
        editor.apply();

        Intent intent = new Intent(this,Start.class);
        intent.putExtra("ime", userName);
        intent.putExtra("drug", friendName);
        startActivity(intent);
    }
    @Override
    public void onBackPressed(){
        NavUtils.navigateUpFromSameTask(this);
    }
}
