package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> allUsers();

    void add(User user);

    void update(User user);

    void delete(int id);

    User get(int id);
}
