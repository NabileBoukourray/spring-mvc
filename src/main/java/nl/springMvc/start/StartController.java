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


    @GetMapping("/customers")
    public String customers(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
                            @RequestParam(value = "size", required = false, defaultValue = "10") int pageSize,
                            Model model) {

        int totalRows = customerService.countCustomers("a");
        model.addAttribute("empty", totalRows == 0);
        double totalPages = (double) totalRows / (double) pageSize;
        logger.info("totalPages >>>>>>>>>>>>>>>>>" + Utils.roundDoubleToInt(totalPages));
        model.addAttribute("totalPages", Utils.roundDoubleToInt(totalPages));
        int start = (page - 1) * pageSize;
        model.addAttribute("customers", customerService.findcustomers(start, pageSize));
        return "customers";
    }


    @GetMapping("/api/customers")
    @ResponseBody
    public List<Customer> getCustomers(@RequestParam(value = "page", required = false, defaultValue = "1") int pageSize,
                                       @RequestParam(value = "size", required = false, defaultValue = "10") int size) {
        int start = (pageSize - 1) * size;
        return customerService.findcustomers(start, size);
    }

    @GetMapping("/api/customers/all")
    @ResponseBody
    public List<Customer> getAllCustomers() {
        List<Customer> customers = customerService.findAll();
        return customers;
    }











}
