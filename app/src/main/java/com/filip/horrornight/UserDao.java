package com.filip.horrornight;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(User user);
    @Delete
    void delete(User user);
    @Update(onConflict = OnConflictStrategy.REPLACE)
    void update(User user);
    @Query("SELECT * from user WHERE userId = :userId")
    User findById(int userId);
}
