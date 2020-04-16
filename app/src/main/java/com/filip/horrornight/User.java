package com.filip.horrornight;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "user")
public class User {
    @PrimaryKey(autoGenerate = true)
    private int userId;
    @NonNull
    @ColumnInfo(name = "name")
    private String name;
    @NonNull
    @ColumnInfo(name = "friendsName")
    private String friendsName;
    @ColumnInfo(name = "ends")
    private int ends;

    @Ignore
    public User(String name, String friendsName){
        this.name = name;
        this.friendsName = friendsName;
    }
    public User(int userId, String name, String friendsName, int ends){
        this.userId = userId;
        this.name = name;
        this.friendsName = friendsName;
        this.ends = ends;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFriendsName() {
        return friendsName;
    }

    public void setFriendsName(String friendsName) {
        this.friendsName = friendsName;
    }

    public int getEnds() {
        return ends;
    }

    public void setEnds(int ends) {
        this.ends = ends;
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
