package web.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import web.model.User;

import java.util.List;

public interface UserService {

    public void addUser(User user);

    public List<User> getAll();

    public User getUser(long id);

    public void updateUser(User user);

    public void deleteUser(Long id);

    public User getUserByUsername(String username);

}
