package nl.springMvc.repository;

import nl.springMvc.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Customer> findAll(){
        Session session = sessionFactory.getCurrentSession();
        Query<Customer> query = session.createQuery("FROM Customer ", Customer.class);
        return query.getResultList();
    }

    public List<Customer> findcustomers(int start, int maxRows){
        Session session = sessionFactory.getCurrentSession();
        Query<Customer> query = session.createQuery("FROM Customer ORDER BY customer_id", Customer.class);
        query.setFirstResult(start);
        query.setMaxResults(maxRows);
        return query.getResultList();
    }

    public int countCustomers(){
        Session session = sessionFactory.getCurrentSession();
        int count = ((Long) session.createQuery("SELECT COUNT(*) FROM Customer").uniqueResult()).intValue();

        return count;
    }
}
