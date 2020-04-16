package com.filip.horrornight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class EditProfile extends AppCompatActivity {
    int id;
    String name;
    String friendName;
    UserRepository userRepository;
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        userRepository = new UserRepository(getApplication());
        String packageName = getPackageName();
        SharedPreferences sharedPreferences = getSharedPreferences(packageName, MODE_PRIVATE);
        id = sharedPreferences.getInt("id", 0);
        user = userRepository.find(id);
        name = user.getName();
        friendName = user.getFriendsName();
        EditText editName = findViewById(R.id.editname);
        editName.setText(name);
        EditText editFriend = findViewById(R.id.editfriend);
        editFriend.setText(friendName);
    }

    public void onSave(View view) {
        EditText editName = findViewById(R.id.editname);
        name = editName.getText().toString();
        user.setName(name);
        EditText editFriend = findViewById(R.id.editfriend);
        friendName = editFriend.getText().toString();
        user.setFriendsName(friendName);
        userRepository.update(user);
        Intent intent = new Intent(this, ShowPlayer.class);
        startActivity(intent);
    }
}
