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

import com.filip.horrornight.End;
import com.filip.horrornight.R;
import com.filip.horrornight.User;
import com.filip.horrornight.UserRepository;

public class GoInside extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    User user;
    UserRepository userRepository;
    String friendName;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        ImageView image = findViewById(R.id.imageS);
        TextView stroyText = findViewById(R.id.story);
        Button left = findViewById(R.id.leftb);
        Button right = findViewById(R.id.rightb);
        image.setImageResource(R.drawable.goagain);
        userRepository = new UserRepository(getApplication());
        String packageName = getPackageName();
        sharedPreferences = getSharedPreferences(packageName, MODE_PRIVATE);
        int id = sharedPreferences.getInt("id", 1);
        user = userRepository.find(id);
        friendName = user.getFriendsName();
        String text = String.format(getResources().getString(R.string.goInside), friendName);
        stroyText.setText(text);
        left.setText(R.string.agreeInside);
        right.setText(R.string.dontAgreeInside);
    }
    public void odabir(View view) {
        String end;
        switch (view.getId()) {
            case R.id.leftb:
                boolean isInside1 =  getSharedPreferences("end", MODE_PRIVATE).getBoolean("isInside1", true);
                if(isInside1){
                    getSharedPreferences("end", MODE_PRIVATE).edit()
                            .putBoolean("isInside1", false).apply();
                    int ends = user.getEnds();
                    ends+=1;
                    user.setEnds(ends);
                    userRepository.update(user);
                }
                name = user.getName();
                end = String.format(getResources().getString(R.string.endSplit), name);
                Intent intentl = new Intent(this, End.class);
                intentl.putExtra("end", end);
                intentl.putExtra("success",false);
                intentl.putExtra("image",R.drawable.split);
                startActivity(intentl);
                break;
            case R.id.rightb:
                boolean isInside2 =  getSharedPreferences("end", MODE_PRIVATE).getBoolean("isInside2", true);
                if(isInside2){
                    getSharedPreferences("end", MODE_PRIVATE).edit()
                            .putBoolean("isInside2", false).apply();
                    int ends = user.getEnds();
                    ends+=1;
                    user.setEnds(ends);
                    userRepository.update(user);
                }
                end = String.format(getResources().getString(R.string.endNoSplit), friendName);
                Intent intentr = new Intent(this, End.class);
                intentr.putExtra("end", end);
                intentr.putExtra("success",true);
                intentr.putExtra("image",R.drawable.nosplit);
                startActivity(intentr);
                break;
        }
    }
    @Override
    public void onBackPressed(){
        NavUtils.navigateUpFromSameTask(this);
    }
}
