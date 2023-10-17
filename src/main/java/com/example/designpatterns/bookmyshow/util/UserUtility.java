package com.example.designpatterns.bookmyshow.util;

import com.example.designpatterns.bookmyshow.model.entity.User;

import java.util.List;
import java.util.Optional;

public class UserUtility {

    public static Optional<User> checkIfUserPresent(final List<User> userList, final User inputUser) {
        return userList.stream()
                .filter(user -> user.getId().equals(inputUser.getId()))
                .limit(1)
                .findFirst();
    }
}
