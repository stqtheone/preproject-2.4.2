package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Role;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class RoleDAOImpl implements RoleDAO{
    @PersistenceContext
    private EntityManager em;
    @Override
    public void saveRole(Role role){
        em.persist(role);
    }
    @Override
    public Role getRole(long id){
        Role role = em.find(Role.class,new Long(id));
        em.detach(role);
        return role;
    }
}
