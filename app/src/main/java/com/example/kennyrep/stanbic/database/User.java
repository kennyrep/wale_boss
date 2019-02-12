package com.example.kennyrep.stanbic.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;


//Todo Nice work here too.
//Todo I refactored everything relating to database into a folder(otherwise called package) called database
@Entity
public class User implements Parcelable {
    public User(String firstName, String lastName, String jobTitle, String email, String password, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.jobTitle = jobTitle;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public User() {
    }

    //Todo There is a principle of atomicity in database design
    //Todo Separate this into first name and last name and the same on the registration screen appropriately


    protected User(Parcel in) {
        firstName = in.readString();
        lastName = in.readString();
        jobTitle = in.readString();
        email = in.readString();
        password = in.readString();
        phoneNumber = in.readString();
    }

    public static Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel parcel) {
            return new User(parcel);
        }

        @Override
        public User[] newArray(int i) {
            return new User[i];
        }
    };

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "First_Name")
    private String firstName;

    @ColumnInfo(name = "Last_Name")
    private String lastName;

    @ColumnInfo(name = "Email")
    private String email;

    @ColumnInfo(name = "Job Title")
    private String jobTitle;

    @ColumnInfo(name = "Password")
    private String password;

    @ColumnInfo(name = "Phone Number")
    private String phoneNumber;

    @NonNull
    public int getId() {
        return id;
    }

    public void setId(@NonNull int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(firstName);
        parcel.writeString(lastName);
        parcel.writeString(password);
        parcel.writeString(jobTitle);
        parcel.writeString(email);
        parcel.writeString(phoneNumber);
    }
}
