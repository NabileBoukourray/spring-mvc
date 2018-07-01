package nl.springMvc.calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.logging.Logger;

@Controller
public class CalendarController {

    Logger logger = Logger.getLogger(getClass().getName());

    @GetMapping("/calendar")
    public String calendar(){
        return "calendar";
    }
}
