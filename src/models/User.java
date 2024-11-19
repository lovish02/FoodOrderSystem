package models;

import java.util.UUID;

public class User {
    String userId;
    String userName;
    String phoneNo;

    public User(String userName, String phoneNo) {
        this.userName = userName;
        this.phoneNo = phoneNo;
        this.userId = UUID.randomUUID().toString();
    }
}
