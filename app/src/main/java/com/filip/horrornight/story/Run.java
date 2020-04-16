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

public class Run extends AppCompatActivity {
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
        image.setImageResource(R.drawable.run);
        stroyText.setText("Gde hocete da bezite? Suma je kraci put da se stigne do grada. A ako odete putem ka gradu duze je ali je sve osvetljeno.");
        left.setText("Suma");
        right.setText("Gradski put");
        String packageName = getPackageName();
        sharedPreferences = getSharedPreferences(packageName, MODE_PRIVATE);
        editor = sharedPreferences.edit();
        int id = sharedPreferences.getInt("id", 1);
        userRepository = new UserRepository(getApplication());
        user = userRepository.find(id);
    }
    public void odabir(View view) {
        switch (view.getId()) {
            case R.id.leftb:
                Intent intentl = new Intent(this, Forest.class);
                startActivity(intentl);
                break;
            case R.id.rightb:
                boolean isRun =  getSharedPreferences("end", MODE_PRIVATE).getBoolean("isRun", true);
                if(isRun){
                    getSharedPreferences("end", MODE_PRIVATE).edit()
                            .putBoolean("isRun", false).apply();
                    int ends = user.getEnds();
                    ends+=1;
                    user.setEnds(ends);
                    userRepository.update(user);
                }
                String kraj = "Izabrali ste bezbedan put. Imate srece susrece vas komsija.";
                Intent intentr = new Intent(this, End.class);
                intentr.putExtra("kraj",kraj);
                intentr.putExtra("uspeh", true);
                intentr.putExtra("slika", R.drawable.komsa);
                startActivity(intentr);
                break;
        }
    }
    @Override
    public void onBackPressed(){
        NavUtils.navigateUpFromSameTask(this);
    }
}
