package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import web.dao.RoleDAO;
import web.dao.UserDAO;
import web.dao.UserDAOImpl;
import web.model.Role;
import web.model.User;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserDAO userDAOImpl;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    RoleDAO roleDAOimpl;


    @Transactional
    public void addUser(User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userDAOImpl.SaveUser(user);
    }
    @Transactional
    public List<User> getAll(){
        return userDAOImpl.getAll();
    }
    @Transactional
    public User getUser(long id){
        return userDAOImpl.getUser(id);
    }
    @Transactional
    public User getUserByUsername(String username){
        return userDAOImpl.getUserByUsername(username);
    }
    @Transactional
    public void updateUser(User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userDAOImpl.updateUser(user);
    }
    @Transactional
    public void deleteUser(Long id) {
        userDAOImpl.deleteUser(id);
    }
}
