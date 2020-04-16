package com.filip.horrornight.story;

import androidx.appcompat.app.AppCompatActivity;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        ImageView image = findViewById(R.id.imageS);
        TextView stroyText = findViewById(R.id.story);
        Button left = findViewById(R.id.leftb);
        Button right = findViewById(R.id.rightb);
        image.setImageResource(R.drawable.background);
        stroyText.setText("Klasika drug ti se sapleo jer msm sto da ne kad je svakako smotan.");
        left.setText("Pomocices mu");
        right.setText("Neces mu pomoci");
        String packageName = getPackageName();
        sharedPreferences = getSharedPreferences(packageName, MODE_PRIVATE);
        int id = sharedPreferences.getInt("id", 1);
        userRepository = new UserRepository(getApplication());
        user = userRepository.find(id);
    }
    public void odabir(View view) {
        String kraj;
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
                kraj= "Ko je ikada preziveo kad se sapleo u sumi.";
                Intent intentl = new Intent(this, End.class);
                intentl.putExtra("kraj",kraj);
                intentl.putExtra("uspeh",false);
                intentl.putExtra("slika",R.drawable.help);
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
                kraj = "Mislis li stvarno da izdajice prezivljavaju. Shame on you!";
                Intent intentr = new Intent(this, End.class);
                intentr.putExtra("kraj",kraj);
                intentr.putExtra("uspeh",false);
                intentr.putExtra("slika",R.drawable.nohelp);
                startActivity(intentr);
                break;
        }
    }
}
