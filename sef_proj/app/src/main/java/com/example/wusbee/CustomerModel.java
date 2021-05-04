package com.example.wusbee;

public class CustomerModel {

    private String FullName;
    private String Username;
    private String Password;
    private String Email;
    private int PhoneNumber;

    public CustomerModel(String fullName, String username, String password, String email, int phoneNumber)  {
        FullName = fullName;
        Username = username;
        Password = password;
        Email = email;
        PhoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "CustomerModel{" +
                "FullName='" + FullName +
                ", Username='" + Username +
                ", Password='" + Password +
                ", Email='" + Email +
                ", PhoneNumber=" + PhoneNumber +
                '}';
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) { PhoneNumber = phoneNumber; }
}
