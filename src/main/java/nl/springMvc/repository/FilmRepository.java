package nl.springMvc.repository;

import nl.springMvc.entity.Film;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class FilmRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public FilmRepository(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public List<Film> findAll(){
        Session session = sessionFactory.getCurrentSession();
        Query<Film> query = session.createQuery("FROM Film ", Film.class);
        return query.getResultList();
    }

    public List<Film> find(int start, int maxRows){
        Session session = sessionFactory.getCurrentSession();
        Query<Film> query = session.createQuery("FROM Film", Film.class);
        query.setFirstResult(start);
        query.setMaxResults(maxRows);
        return query.getResultList();
    }


    public int count(){
        Session session = sessionFactory.getCurrentSession();
        int count = ((Long) session.createQuery("SELECT COUNT(*) FROM Film ").uniqueResult()).intValue();
        return count;
    }
}
