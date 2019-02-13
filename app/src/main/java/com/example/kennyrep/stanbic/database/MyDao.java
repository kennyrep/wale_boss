package com.example.kennyrep.stanbic.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import static com.example.kennyrep.stanbic.Register.firstName;
import static com.example.kennyrep.stanbic.Register.lastName;


//Todo Nice work here
@Dao
public interface MyDao {

    @Insert
    public void addUser(User user);

    //Returning the number of user in the database via a Toast message
    @Query("SELECT * FROM User")
    //public User[] load();
    List<User> getAllUsers();

    // Login page
    @Query("SELECT * FROM User WHERE Email=:email AND Password=:password")
    public User loadone(String email, String password);

    @Query("SELECT * FROM User WHERE Email=:email")
    public User loadonewithmail(String email);

    @Query("SELECT * FROM User WHERE id=:id")
    public User getAUser(int id);

    @Query("DELETE FROM User WHERE id=:id")
    public int deleteAUser(int id);

    @Update
    public int update(User user);


}








