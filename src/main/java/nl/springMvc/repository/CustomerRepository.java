package nl.springMvc.repository;

import nl.springMvc.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.logging.Logger;

@Repository
public class CustomerRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public CustomerRepository(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public List<Customer> findAll(){
        Session session = sessionFactory.getCurrentSession();
        Query<Customer> query = session.createQuery("FROM Customer ", Customer.class);
        return query.getResultList();
    }

    public List<Customer> findcustomers(int start, int maxRows){
        Session session = sessionFactory.getCurrentSession();
        Query<Customer> query = session.createQuery("FROM Customer", Customer.class);
        query.setFirstResult(start);
        query.setMaxResults(maxRows);
        return query.getResultList();
    }

    public List<Customer> findcustomers2(int start, int maxRows, String iSortCol, String sSortDir, String whereClase){
        Session session = sessionFactory.getCurrentSession();
        String queryStr = String.join(" ", "FROM Customer "+whereClase+" ORDER BY", iSortCol, sSortDir );
        Query<Customer> query = session.createQuery(queryStr, Customer.class);
        query.setFirstResult(start);
        query.setMaxResults(maxRows);
        return query.getResultList();
    }

    public int countCustomers(String whereClause){
        Session session = sessionFactory.getCurrentSession();
        int count = ((Long) session.createQuery("SELECT COUNT(*) FROM Customer "+whereClause).uniqueResult()).intValue();
        return count;
    }

    public List<Customer> findByTag(String tagname){
        Session session = sessionFactory.getCurrentSession();
        Query<Customer> query = session.createQuery("FROM Customer WHERE first_name LIKE "+ tagname, Customer.class);
        return query.getResultList();
    }
}
