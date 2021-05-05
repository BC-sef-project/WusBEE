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
    private String fullName;

    @ColumnInfo(name = "username") @NonNull
    private String userName;

    @ColumnInfo(name = "password") @NonNull
    private String passWord;

    @ColumnInfo(name = "email") @NonNull
    private String eMail;

    @ColumnInfo(name = "phone_number") @NonNull
    private String phoneNumber;

    public CustomerModel( @NonNull String fullName, @NonNull String userName, @NonNull String passWord, @NonNull String eMail, @NonNull String phoneNumber) {
        this.fullName = fullName;
        this.userName = userName;
        this.passWord = passWord;
        this.eMail = eMail;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "CustomerModel{" +
                "uid=" + uid +
                ", fullName='" + fullName + '\'' +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", eMail='" + eMail + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @NonNull
    public String getFullName() {
        return fullName;
    }

    public void setFullName(@NonNull String fullName) {
        this.fullName = fullName;
    }

    @NonNull
    public String getUserName() {
        return userName;
    }

    public void setUserName(@NonNull String userName) {
        this.userName = userName;
    }

    @NonNull
    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(@NonNull String passWord) {
        this.passWord = passWord;
    }

    @NonNull
    public String getEMail() {
        return eMail;
    }

    public void setEMail(@NonNull String eMail) {
        this.eMail = eMail;
    }

    @NonNull
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(@NonNull String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
