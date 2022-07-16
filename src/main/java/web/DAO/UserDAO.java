package web.DAO;

import org.springframework.stereotype.Component;
import web.model.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAO {

    private static Long User_Count;

    private List<User> users;

    {
        users = new ArrayList<>();

        users.add(new User(++User_Count, "Ivan", "Petrov", 35));
        users.add(new User(++User_Count, "Sveta", "Naumova", 24));
        users.add(new User(++User_Count, "Igor", "Ivanov", 31));
        users.add(new User(++User_Count, "Petr", "Sidorov", 28));
        users.add(new User(++User_Count, "Vasya", "Kulyakov", 18));
    }

    public List<User> allUsers() {
        return users;
    }

    public User show(int id) {
        return users.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }

}
