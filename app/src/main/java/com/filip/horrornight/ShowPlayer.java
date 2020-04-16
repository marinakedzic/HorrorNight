package com.filip.horrornight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ShowPlayer extends AppCompatActivity {
    int id;
    String name;
    String friendName;
    int ends;
    UserRepository userRepository;
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_player);
        String packageName = getPackageName();
        userRepository = new UserRepository(getApplication());
        SharedPreferences sharedPreferences = getSharedPreferences(packageName, MODE_PRIVATE);
        id = sharedPreferences.getInt("id", 0);
        user = userRepository.find(id);
        name = user.getName();
        friendName = user.getFriendsName();
        ends = user.getEnds();
        TextView nameText = findViewById(R.id.username);
        nameText.setText(name);
        TextView friendText = findViewById(R.id.friendname);
        friendText.setText(friendName);
        TextView endsText = findViewById(R.id.ends);
        endsText.setText(ends + "/7");

    }

    public void onDelete(View view) {
        String packageName = getPackageName();
        SharedPreferences sharedPreferences = getSharedPreferences(packageName, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear().apply();
        getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                .putBoolean("isFirstRun", true).apply();
        userRepository.delete(user);
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void onEdit(View view) {
        Intent intent = new Intent(this,EditProfile.class);
        intent.getIntExtra("id", id);
        startActivity(intent);
    }
}
