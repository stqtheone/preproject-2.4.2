package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import web.model.Role;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collections;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO, UserDetailsService{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> getAll(){
        List<User> list = em.createQuery("Select user from User user").getResultList();
        return list;
    }
    @Override
    public void SaveUser(User user){
        em.persist(user);
    }
    @Override
    public User getUser(long id){
        User user = em.find(User.class,new Long(id));
        em.detach(user);
        return user;
    }
    @Override
    public UserDetails loadUserByUsername(String name){
        User user = em.createQuery(
                "SELECT u from User u WHERE u.username = :username", User.class).
                setParameter("username", name).getSingleResult();
        return user;
    }
    @Override
    public User getUserByUsername(String name){
        List<User> user = em.createQuery(
                "SELECT u from User u WHERE u.username = :username", User.class).
                setParameter("username", name).getResultList();
        return user.isEmpty() ? null : user.get(0);
    }
    @Override
    public void deleteUser(long id){
        User user = em.find(User.class,new Long(id));
        System.out.println("ПОЛЬЗОВАТЕЛЬ " + user);
        em.remove(user);
    }
    @Override
    public void updateUser(User user){
        em.merge(user);
    }
}
