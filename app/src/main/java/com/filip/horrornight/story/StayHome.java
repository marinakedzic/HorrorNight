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
        stroyText.setText("Ipak ostajes sta ces sad da uradis, jesi li se uplasio ili ne?");
        left.setText("Proverices kuhinju");
        right.setText("Bezis ispod kreveta");
        String packageName = getPackageName();
        sharedPreferences = getSharedPreferences(packageName, MODE_PRIVATE);
        int id = sharedPreferences.getInt("id", 1);
        userRepository = new UserRepository(getApplication());
        user = userRepository.find(id);
    }
    public void odabir(View view) {
        String kraj;
        Boolean uspeh = false;
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
                kraj= "Je l stvarno mislis da je pametno otici direktno ka ludaku?";
                Intent intentl = new Intent(this, End.class);
                intentl.putExtra("kraj",kraj);
                intentl.putExtra("uspeh",uspeh);
                intentl.putExtra("slika",R.drawable.h);
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
                kraj = "Sta mislis gde ce prvo da pogleda?";
                Intent intentr = new Intent(this, End.class);
                intentr.putExtra("kraj",kraj);
                intentr.putExtra("uspeh",uspeh);
                intentr.putExtra("slika",R.drawable.underbed);
                startActivity(intentr);
                break;
        }
    }
}
