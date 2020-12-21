package web.dao;

import web.model.Role;

public interface RoleDAO {
    public void saveRole(Role role);

    public Role getRole(long id);
}
