package nl.springMvc;

import nl.springMvc.entity.Customer;
import nl.springMvc.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SwitchFormController {

    private final CustomerService customerService;

    public SwitchFormController(CustomerService customerService){
        this.customerService = customerService;
    }


    @GetMapping("/switchform")
    public String switchform(){
        return "switchform";
    }

    @GetMapping("/getSuggetions")
    @ResponseBody
    public List<Customer> getTags(@RequestParam("tagName") String tagName) {

        return simulateSearchResult(tagName);

    }

    private List<Customer> simulateSearchResult(String tagName) {
        List<Customer> customers = customerService.findByTag(tagName);
        return customers;
    }

}
