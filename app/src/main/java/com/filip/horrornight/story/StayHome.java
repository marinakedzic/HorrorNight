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

public class StayHome extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    User user;
    UserRepository userRepository;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        ImageView image = findViewById(R.id.imageS);
        TextView stroyText = findViewById(R.id.story);
        Button left = findViewById(R.id.leftb);
        Button right = findViewById(R.id.rightb);
        image.setImageResource(R.drawable.kitchen);
        stroyText.setText(R.string.storyStayHome);
        left.setText(R.string.kitchen);
        right.setText(R.string.bed);
        String packageName = getPackageName();
        sharedPreferences = getSharedPreferences(packageName, MODE_PRIVATE);
        int id = sharedPreferences.getInt("id", 1);
        userRepository = new UserRepository(getApplication());
        user = userRepository.find(id);
    }
    public void odabir(View view) {
        String end;
        Boolean success = false;
        switch (view.getId()) {
            case R.id.leftb:
                boolean isStay1 =  getSharedPreferences("end", MODE_PRIVATE).getBoolean("isStay1", true);
                if(isStay1){
                    getSharedPreferences("end", MODE_PRIVATE).edit()
                            .putBoolean("isStay1", false).apply();
                    String packageName = getPackageName();
                    SharedPreferences sharedPreferences = getSharedPreferences(packageName, MODE_PRIVATE);
                    int id = sharedPreferences.getInt("id", 0);
                    user = userRepository.find(id);
                    int ends = user.getEnds();
                    ends+=1;
                    user.setEnds(ends);
                    userRepository.update(user);
                }
                end = getString(R.string.endMurderer);
                Intent intentl = new Intent(this, End.class);
                intentl.putExtra("end",end);
                intentl.putExtra("success",success);
                intentl.putExtra("image",R.drawable.murderer);
                startActivity(intentl);
                break;
            case R.id.rightb:
                boolean isStay2 =  getSharedPreferences("end", MODE_PRIVATE).getBoolean("isStay2", true);
                if(isStay2){
                    getSharedPreferences("end", MODE_PRIVATE).edit()
                            .putBoolean("isStay2", false).apply();
                    String packageName = getPackageName();
                    SharedPreferences sharedPreferences = getSharedPreferences(packageName, MODE_PRIVATE);
                    int id = sharedPreferences.getInt("id", 0);
                    user = userRepository.find(id);
                    int ends = user.getEnds();
                    ends+=1;
                    user.setEnds(ends);
                    userRepository.update(user);
                }
                end = getString(R.string.endBed);
                Intent intentr = new Intent(this, End.class);
                intentr.putExtra("end",end);
                intentr.putExtra("success",success);
                intentr.putExtra("image",R.drawable.underbed);
                startActivity(intentr);
                break;
        }
    }
    @Override
    public void onBackPressed(){
        NavUtils.navigateUpFromSameTask(this);
    }
}
