package com.example.simplesystem;
import com.google.firebase.database.IgnoreExtraProperties;
public class user {
    private String user_id;
    private String user_name;
    private String user_email;
    private String user_password;
    public user(){
        //this constructor is required
    }

    public user(String user_id, String user_name, String user_email, String user_password) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_password =user_password;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getUser_email() {
        return user_email;
    }
    public String getUser_password() {
        return user_password;
    }
}

