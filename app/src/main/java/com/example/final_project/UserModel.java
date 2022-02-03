package com.example.final_project;

public class UserModel {
    class Message {
        String message;
        User sender;
        long createdAt;
    }

    class User {
        String nickname;
        String profileUrl;
    }
    String[] cheeses = {
            "Parmesan",
            "Ricotta",
            "Fontina",
            "Mozzarella",
            "Cheddar"
    };
}
