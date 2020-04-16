package com.filip.horrornight.story;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.filip.horrornight.R;
import com.filip.horrornight.User;
import com.filip.horrornight.UserRepository;

public class GoOutside extends AppCompatActivity {
    UserRepository userRepository;
    int id;
    User user;
    String friendName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        ImageView image = findViewById(R.id.imageS);
        TextView stroyText = findViewById(R.id.story);
        Button left = findViewById(R.id.leftb);
        Button right = findViewById(R.id.rightb);
        image.setImageResource(R.drawable.outside);
        String packageName = getPackageName();
        userRepository = new UserRepository(getApplication());
        SharedPreferences sharedPreferences = getSharedPreferences(packageName, MODE_PRIVATE);
        id = sharedPreferences.getInt("id", 0);
        user = userRepository.find(id);
        friendName = user.getFriendsName();
        String text = String.format(getResources().getString(R.string.goOutside), friendName);
        stroyText.setText(text);
        left.setText(R.string.agreeOutside);
        right.setText(R.string.dontAgreeOutside);
    }
    public void odabir(View view) {
        switch (view.getId()) {
            case R.id.leftb:
                Intent intentl = new Intent(this, GoInside.class);
                startActivity(intentl);
                break;
            case R.id.rightb:
                Intent intentr = new Intent(this, Run.class);
                startActivity(intentr);
                break;
        }
    }
    @Override
    public void onBackPressed(){
        NavUtils.navigateUpFromSameTask(this);
    }
}
