package com.example.kennyrep.stanbic.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;


//Todo Nice work here
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
