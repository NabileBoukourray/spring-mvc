package nl.springMvc.films;

import nl.springMvc.Utils;
import nl.springMvc.entity.Film;
import nl.springMvc.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
import java.util.logging.Logger;

@Controller
public class FilmController {

    private Logger logger = Logger.getLogger(getClass().getName());

    private FilmService filmService;

    @Autowired
    public FilmController(FilmService filmService){
        this.filmService = filmService;
    }

    @GetMapping("/films")
    public String films(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
                        @RequestParam(value = "size", required = false, defaultValue = "10") int pageSize,
                        Model model) {

        int totalRows = filmService.count();
        model.addAttribute("empty", totalRows == 0);
        double totalPages = (double) totalRows / (double) pageSize;
        model.addAttribute("totalPages", Utils.roundDoubleToInt(totalPages));
        int start = (page - 1) * pageSize;
        model.addAttribute("films", filmService.find(start, pageSize));
        return "films";
    }

    @GetMapping("/api/films")
    @ResponseBody
    public List<Film> getFilmsPage(@RequestParam(value = "page", required = false, defaultValue = "1") int pageSize,
                                   @RequestParam(value = "size", required = false, defaultValue = "10") int size) {
        int start = (pageSize - 1) * size;
        return filmService.find(start, size);
    }

    @GetMapping("/api/films/all")
    @ResponseBody
    public List<Film> getFilmsPage() {
        return filmService.findAll();
    }

}
