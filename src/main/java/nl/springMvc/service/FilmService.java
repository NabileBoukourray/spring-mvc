package nl.springMvc.service;

import nl.springMvc.entity.Film;
import nl.springMvc.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class FilmService {

    private FilmRepository filmRepository;

    @Autowired
    public FilmService(FilmRepository filmRepository){
        this.filmRepository = filmRepository;
    }

    @Transactional
    public List<Film> findAll(){
        return filmRepository.findAll();
    }

    @Transactional
    public List<Film> find(int start, int maxRows){
        return filmRepository.find(start, maxRows);
    }

    @Transactional
    public int count(){
        return filmRepository.count();
    }
}
