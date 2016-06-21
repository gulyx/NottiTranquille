package it.ispw.efco.nottitranquille.model;

import it.ispw.efco.nottitranquille.view.LoginBean;
import it.ispw.efco.nottitranquille.view.RegistrationBean;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Federico on 02/05/2016.
 */
public class AccessDAO {

    public AccessDAO() {
    }

    public List<RegistrationBean> isRegistered(String username, String password) {
        EntityManager entityManager = JPAInitializer.getEntityManager();
        String querystring = "FROM registeredusersdata WHERE (username = :u OR email =:u) AND password = :p";
        TypedQuery<RegistrationBean> query = entityManager.createQuery(querystring,RegistrationBean.class);
        query.setParameter("u",username);
        query.setParameter("p",password);
        List<RegistrationBean> result = query.getResultList();
        return result;
    }

    public void saveLogin(LoginBean lb) {
        EntityManager entityManager = JPAInitializer.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(lb);
        entityManager.getTransaction().commit();
    }

    public void setExpired(String cookie) {
        EntityManager entityManager = JPAInitializer.getEntityManager();
        String querystring = "FROM loggedusers WHERE cookie = :c";
        TypedQuery<LoginBean> query = entityManager.createQuery(querystring,LoginBean.class);
        query.setParameter("c",cookie);
        List<LoginBean> result = query.getResultList();
        LoginBean lb = entityManager.find(LoginBean.class,result.get(0).getId());
        entityManager.getTransaction().begin();
        lb.setExpired(true);
        entityManager.getTransaction().commit();
    }

    public LoginBean getLoggedUser(String username, String password){
        EntityManager entityManager = JPAInitializer.getEntityManager();
        String querystring = "FROM loggedusers WHERE username = :u AND password = :p";
        TypedQuery<LoginBean> query = entityManager.createQuery(querystring,LoginBean.class);
        query.setParameter("u",username);
        query.setParameter("p",password);
        List<LoginBean> result = query.getResultList();
        if (result.size() == 0) {
            return null;
        }
        return result.get(0);
    }

    public void updateLogin(Long id, String cookie) {
        EntityManager entityManager = JPAInitializer.getEntityManager();
        LoginBean lb = entityManager.find(LoginBean.class,id);
        entityManager.getTransaction().begin();
        lb.setCookie(cookie);
        lb.setExpired(false);
        entityManager.getTransaction().commit();
    }

    public boolean removeLoggedUser(Long id){
        EntityManager entityManager = JPAInitializer.getEntityManager();
        LoginBean lb = entityManager.find(LoginBean.class,id);
        entityManager.getTransaction().begin();
        entityManager.remove(lb);
        entityManager.getTransaction().commit();
        return true;
    }

    public void register(RegistrationBean registrationBean) throws Exception {
        EntityManager entityManager = JPAInitializer.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(registrationBean);
        entityManager.getTransaction().commit();
    }

    public Long verifyPendingStatus(String hash) throws Exception {
        EntityManager entityManager = JPAInitializer.getEntityManager();
        String querystring = "FROM registeredusersdata WHERE hash = :h AND req_status = :rs";
        TypedQuery<RegistrationBean> query = entityManager.createQuery(querystring,RegistrationBean.class);
        query.setParameter("h",hash);
        query.setParameter("rs","pending");
        List<RegistrationBean> result = query.getResultList();
        return result.get(0).getId();
    }

    public void verify(Long id) throws Exception {
        EntityManager entityManager = JPAInitializer.getEntityManager();
        RegistrationBean rb = entityManager.find(RegistrationBean.class,id);
        entityManager.getTransaction().begin();
        rb.setReq_status("accepted");
        entityManager.getTransaction().commit();
    }
}
