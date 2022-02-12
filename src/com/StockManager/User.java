package com.StockManager;

public class User {
    private String userName, userEmail, userID, userType, password;

    public User() {}

    public User(String name, String email, String id, String type, String password) {
        this.userName = name;
        this.userEmail = email;
        this.userID = id;
        this.userType = type;
        this.password = password;
    }

    public User(String firstName, String lastName, String email, String id, String type, String password) {
        this.userName = firstName + " " + lastName;
        this.userEmail = email;
        this.userID = id;
        this.userType = type;
        this.password = password;
    }

    //Getters and Setters will be used to edit this Class
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserName(String firstName, String lastName) {
        this.userName = firstName + " " + lastName;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserID() {
        return userID;
    }

    public String getUserType() {
        return userType;
    }

    public String getPassword() {
        return password;
    }
}
