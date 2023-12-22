package spark.learning.services;

import spark.learning.domain.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    public static List<User> getUsers() {
        ArrayList<User> list = new ArrayList<>();
        list.add(new User("Rohan Ghumman", "rohan.ghumman@gmail.com"));
        list.add(new User("Salman Ghumman", "salman.ghumman@gmail.com"));
        list.add(new User("Ahmed Ghumman", "ahmed.ghumman@gmail.com"));
        return list;
    }
}
