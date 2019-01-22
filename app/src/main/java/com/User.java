package com;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.widget.EditText;

@Entity
public class User {

    @PrimaryKey(autoGenerate = true)
    private int id;

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
