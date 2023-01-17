package web.service;

import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import java.util.List;

public interface UserService {

    @Transactional
    List<User> allUsers();

    @Transactional
    void add(User user);

    @Transactional
    void update(User user);

    @Transactional
    void delete(int id);

    @Transactional
    User get(int id);
}
