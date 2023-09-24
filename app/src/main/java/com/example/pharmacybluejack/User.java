package com.example.pharmacybluejack;

public class User {
    static int id = 1;
    String username, email, password, numphone;


    public User(int id, String username, String email, String password, String numphone){
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.numphone = numphone;
    }

    public static  void Insert(User user){
        RegisterActivity.dataUser.add(user);
    }
}
