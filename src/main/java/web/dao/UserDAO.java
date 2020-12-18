package web.dao;

import web.model.User;

import java.util.List;

public interface UserDAO {
    public List<User> getAll();
    public void SaveUser(User user);
    public User getUser(long id);
    public void deleteUser(long id);
    public void updateUser(User user);

}
