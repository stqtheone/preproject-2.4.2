package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> getAll(){
        List list = em.createQuery("Select user from User user").getResultList();
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
    public void deleteUser(long id){
        User user = em.find(User.class, new Long(id));
        em.remove(user);
    }
    @Override
    public void updateUser(User user){
        em.merge(user);
    }
}
