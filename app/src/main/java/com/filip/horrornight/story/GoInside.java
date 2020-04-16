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

public class GoInside extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
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
        image.setImageResource(R.drawable.goagain);
        stroyText.setText("Odlucio si da ipak udjete. Drug predlaze da se odvojite i da trazite manijaka.");
        left.setText("Poslusaj ga");
        right.setText("Ipak idete zajedno");
        String packageName = getPackageName();
        sharedPreferences = getSharedPreferences(packageName, MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putBoolean("inside1",true);
        editor.putBoolean("inside2",true);
        editor.apply();
        int id = sharedPreferences.getInt("id", 1);
        userRepository = new UserRepository(getApplication());
        user = userRepository.find(id);
    }
    public void odabir(View view) {
        String kraj;
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
                kraj = "Od kad je pametno da se odvajate ma daj prvo i osnovno pravilo u filmovima.";
                Intent intentl = new Intent(this, End.class);
                intentl.putExtra("kraj", kraj);
                intentl.putExtra("uspeh",false);
                intentl.putExtra("slika",R.drawable.split);
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
                kraj = "Bravo bre uspeli ste da savladate manijaka!";
                Intent intentr = new Intent(this, End.class);
                intentr.putExtra("kraj", kraj);
                intentr.putExtra("uspeh",true);
                intentr.putExtra("slika",R.drawable.nosplit);
                startActivity(intentr);
                break;
        }
    }
}
