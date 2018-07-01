package nl.springMvc.start;

import nl.springMvc.service.CustomerService;
import nl.springMvc.Utils;
import nl.springMvc.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@Controller
public class StartController {

    private Logger logger = Logger.getLogger(getClass().getName());

    private final CustomerService customerService;

    @Autowired
    public StartController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @InitBinder
    private void initBinder(WebDataBinder binder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        binder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/")
    public String start() {
        return "index";
    }
}
