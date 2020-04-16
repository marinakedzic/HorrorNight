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

public class Forest extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    UserRepository userRepository;
    User user;
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
        image.setImageResource(R.drawable.background);
        String packageName = getPackageName();
        sharedPreferences = getSharedPreferences(packageName, MODE_PRIVATE);
        int id = sharedPreferences.getInt("id", 1);
        userRepository = new UserRepository(getApplication());
        user = userRepository.find(id);
        friendName = user.getFriendsName();
        String text = String.format(getResources().getString(R.string.storyForest), friendName, friendName);
        stroyText.setText(text);
        left.setText(R.string.help);
        right.setText(R.string.noHelp);
    }
    public void odabir(View view) {
        String end;
        switch (view.getId()) {
            case R.id.leftb:
                boolean isForest1 =  getSharedPreferences("end", MODE_PRIVATE).getBoolean("isForest1", true);
                if(isForest1){
                    getSharedPreferences("end", MODE_PRIVATE).edit()
                            .putBoolean("isForest1", false).apply();
                    int ends = user.getEnds();
                    ends+=1;
                    user.setEnds(ends);
                    userRepository.update(user);
                }
                end= getString(R.string.endHelp);
                Intent intentl = new Intent(this, End.class);
                intentl.putExtra("end",end);
                intentl.putExtra("success",false);
                intentl.putExtra("image",R.drawable.help);
                startActivity(intentl);
                break;
            case R.id.rightb:
                boolean isForest2 =  getSharedPreferences("end", MODE_PRIVATE).getBoolean("isForest2", true);
                if(isForest2){
                    getSharedPreferences("end", MODE_PRIVATE).edit()
                            .putBoolean("isForest2", false).apply();
                    int ends = user.getEnds();
                    ends+=1;
                    user.setEnds(ends);
                    userRepository.update(user);
                }
                name = user.getName();
                end = String.format(getResources().getString(R.string.endNoHelp), name);
                Intent intentr = new Intent(this, End.class);
                intentr.putExtra("end",end);
                intentr.putExtra("success",false);
                intentr.putExtra("image",R.drawable.nohelp);
                startActivity(intentr);
                break;
        }
    }
    @Override
    public void onBackPressed(){
        NavUtils.navigateUpFromSameTask(this);
    }
}
