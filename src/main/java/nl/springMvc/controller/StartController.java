package nl.springMvc.controller;

import nl.springMvc.Service.CustomerService;
import nl.springMvc.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import javax.persistence.NoResultException;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.Locale;
import java.util.logging.Logger;

@Controller
public class StartController {

    private Logger logger = Logger.getLogger(getClass().getName());

    private final CustomerService customerService;

    @Autowired
    public StartController(CustomerService customerService){
        this.customerService = customerService;
    }


    @InitBinder
    private void initBinder(WebDataBinder binder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        binder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/")
    public String start(){
        return "index";
    }


    @GetMapping("/customers")
    public String customers(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
                         @RequestParam(value = "size", required = false, defaultValue = "10") int pageSize,
                         Model model) {

        int totalRows = customerService.countCustomers();

        double totalPages = (double)totalRows/ (double)pageSize;

        if((totalPages % 1) != 0){
            int totalPages2 = (int)Math.round(totalPages);
            logger.info("totalPages2 >>>>>>>>>>>>>>>>>"+ totalPages2);
            model.addAttribute("totalPages", totalPages2);
        }
        if((totalPages % 1) == 0){
            logger.info("totalPages >>>>>>>>>>>>>>>>>"+ totalPages);
            model.addAttribute("totalPages", totalPages);
        }

        int start = (page-1)*pageSize;
        model.addAttribute("customers", customerService.findcustomers(start, pageSize));
        return "customers";
    }


    @GetMapping("/api/customers")
    @ResponseBody
    public List<Customer> getCustomers(@RequestParam(value = "page", required = false, defaultValue = "1") int pageSize,
                            @RequestParam(value = "size", required = false, defaultValue = "10") int size) {
        int start = (pageSize-1)*size;
        return customerService.findcustomers(start, size);
    }


}
