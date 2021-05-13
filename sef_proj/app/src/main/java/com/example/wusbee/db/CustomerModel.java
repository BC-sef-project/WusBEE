package com.example.wusbee.db;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class CustomerModel {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "fullname") @NonNull
    private String fullname;

    @ColumnInfo(name = "username") @NonNull
    private String username;

    @ColumnInfo(name = "password") @NonNull
    private String password;

    @ColumnInfo(name = "email") @NonNull
    private String eMail;

    @ColumnInfo(name = "phone_number") @NonNull
    private String phone_number;

    public CustomerModel( @NonNull String fullname, @NonNull String username, @NonNull String password, @NonNull String eMail, @NonNull String phone_number) {
        this.fullname = fullname;
        this.username = username;
        this.password = password;
        this.eMail = eMail;
        this.phone_number = phone_number;
    }

    @Override
    public String toString() {
        return "CustomerModel{" +
                "uid=" + uid +
                ", fullName='" + fullname + '\'' +
                ", userName='" + username + '\'' +
                ", passWord='" + password + '\'' +
                ", eMail='" + eMail + '\'' +
                ", phoneNumber='" + phone_number + '\'' +
                '}';
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @NonNull
    public String getFullname() {
        return fullname;
    }

    public void setFullName(@NonNull String fullName) {
        this.fullname = fullName;
    }

    @NonNull
    public String getUsername() {
        return username;
    }

    public void setUserName(@NonNull String userName) {
        this.username = userName;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    public void setPassWord(@NonNull String passWord) {
        this.password = passWord;
    }

    @NonNull
    public String getEMail() {
        return eMail;
    }

    public void setEMail(@NonNull String eMail) {
        this.eMail = eMail;
    }

    @NonNull
    public String getPhone_number() {
        return phone_number;
    }

    public void setPhoneNumber(@NonNull String phoneNumber) {
        this.phone_number = phoneNumber;
    }
}
