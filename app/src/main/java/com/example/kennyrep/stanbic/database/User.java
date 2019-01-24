package com.example.kennyrep.stanbic.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.widget.EditText;


//Todo Nice work here too.
//Todo I refactored everything relating to database into a folder(otherwise called package) called database
@Entity
public class User {

    @PrimaryKey(autoGenerate = true)
    private int id;

    //Todo There is a principle of atomicity in database design
    //Todo Separate this into first name and last name and the same on the registration screen appropriately
    @ColumnInfo(name = "Full Name")
    private String fullName;

    @ColumnInfo(name = "Email")
    private String email;

    @ColumnInfo(name = "Password")
    private String password;

    @ColumnInfo(name = "Phone Number")
    private String phoneNumber;


    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getFullName()
    {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }
}
