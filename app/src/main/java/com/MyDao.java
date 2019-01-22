package com;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface MyDao {

    @Insert
    public void addUser(User user);

    //Returning the number of user in the database via a Toast message
    @Query("SELECT * FROM User")
    public User[] load();

    // Login page
    @Query("SELECT * FROM User WHERE Email=:email AND Password=:password")
    public User loadone(String email, String password);



}
