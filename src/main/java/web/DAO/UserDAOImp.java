package web.DAO;


import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDAOImp implements UserDAO {

    @PersistenceContext
    private EntityManager em;

    @Transactional()
    public List<User> getAllUsers() {
        TypedQuery<User> AllUsers = em.createQuery("from User ", User.class);
        return  AllUsers.getResultList();
    }
}
