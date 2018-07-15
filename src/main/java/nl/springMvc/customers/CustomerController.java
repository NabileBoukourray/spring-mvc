package nl.springMvc.customers;

import nl.springMvc.DatatableDTO;
import nl.springMvc.Utils;
import nl.springMvc.entity.Customer;
import nl.springMvc.service.CustomerService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

import java.util.List;
import java.util.logging.Logger;

@Controller
public class CustomerController {

    private Logger logger = Logger.getLogger(getClass().getName());
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        binder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/customers")
    public String datatables(@RequestParam(name = "customer_id", required = false) Integer customer_id,
                             @RequestParam(name = "email", required = false) String email,
                             @RequestParam(name = "first_name", required = false) String first_name,
                             @RequestParam(name = "last_name", required = false) String last_name,
                             HttpServletRequest httpServletRequest,
                             Model model) {

        CustomerDTO customerDTO = new CustomerDTO(customer_id, first_name, last_name, email);
        model.addAttribute("customerDTO", customerDTO);
        model.addAttribute("url", Utils.getUrl("/api/customers/page", httpServletRequest));
        return "customers";
    }

    @PostMapping("/customers")
    public String formProcessing(@ModelAttribute(name = "customerDTO") CustomerDTO customerDTO, RedirectAttributes redirectAttributes) {
        redirectAttributes.addAttribute("customer_id", customerDTO.getCustomer_id());
        redirectAttributes.addAttribute("email", customerDTO.getEmail());
        redirectAttributes.addAttribute("first_name", customerDTO.getFirst_name());
        redirectAttributes.addAttribute("last_name", customerDTO.getLast_name());
        return "redirect:/customers";
    }

    @GetMapping("/api/customers/all")
    public @ResponseBody List<Customer> getAllCustomers() {
        return customerService.findAll();
    }

    @GetMapping("/api/customers/page")
    @ResponseBody
    public DatatableDTO getAllCustomersChunky(@RequestParam(name = "sEcho", defaultValue = "1", required = false) Integer sEcho,
                                                      @RequestParam(name = "iDisplayStart", defaultValue = "0", required = false) Integer iDisplayStart,
                                                      @RequestParam(name = "iDisplayLength", defaultValue = "10", required = false) Integer iDisplayLength,
                                                      @RequestParam(name = "iSortCol_0", defaultValue = "1", required = false) Integer iSortCol,
                                                      @RequestParam(name = "sSortDir_0", defaultValue = "desc", required = false) String sSortDir,
                                                      @RequestParam(name = "customer_id", defaultValue = "0", required = false) Integer customer_id,
                                                      @RequestParam(name = "email", defaultValue = "", required = false) String email,
                                                      @RequestParam(name = "first_name", defaultValue = "", required = false) String first_name,
                                                      @RequestParam(name = "last_name", defaultValue = "", required = false) String last_name) {

        CustomerDTO customerDTO = new CustomerDTO(customer_id, first_name, last_name, email);

        int totalRows = customerService.countCustomers(queryBuilder(customerDTO));
        DatatableDTO<Customer> dt = new DatatableDTO<>(sEcho, totalRows, totalRows, iSortCol, sSortDir);
        dt.setAaData(customerService.findcustomers2(iDisplayStart, iDisplayLength, DTColumns.CUSTOMERSCOL.getById(iSortCol).getName(), sSortDir, queryBuilder(customerDTO)));

        return dt;
    }



   /* private String getUrlWithParams(String baseUrl, CustomerDTO customerDTO) {
        String urlStr = "";
        urlStr = addIntegerParamToUrl(urlStr, "customer_id", customerDTO.getCustomer_id());
        urlStr = addStringParamToUrl(urlStr, "first_name", customerDTO.getFirst_name());
        urlStr = addStringParamToUrl(urlStr, "last_name", customerDTO.getLast_name());
        urlStr = addStringParamToUrl(urlStr, "email", customerDTO.getEmail());
        return baseUrl + urlStr;
    }*/

    private String addStringToWhereClause(String whereClasue, String columnName, String columnValue) {
        if (StringUtils.isNotBlank(columnValue) && StringUtils.isNotEmpty(columnValue)) {
            if (StringUtils.isNotEmpty(whereClasue)) {
                return String.join(" ", whereClasue, "AND", columnName, "LIKE", "'%" + columnValue + "%'");
            } else if (StringUtils.isEmpty(whereClasue)) {
                return String.join(" ", whereClasue, "WHERE", columnName, "LIKE", "'%" + columnValue + "%'");
            }
        }
        return whereClasue;
    }

    private String addIntegerToWhereClause(String whereClasue, String columnName, Integer columnValue) {
        if (columnValue != null && columnValue != 0) {
            if (StringUtils.isNotEmpty(whereClasue)) {
                return String.join(" ", whereClasue, "AND", columnName, "=", String.valueOf(columnValue));
            } else if (StringUtils.isEmpty(whereClasue)) {
                return String.join(" ", whereClasue, "WHERE", columnName, "=", String.valueOf(columnValue));
            }
        }
        return whereClasue;
    }



   /* private String addIntegerToWhereClause(String whereClasue, String columnName, Integer columnValue){
        if(columnValue != null && columnValue != 0 ){
            if(StringUtils.isNotEmpty(whereClasue)){
                return String.join(" ",whereClasue,"AND",columnName,"=",String.valueOf(columnValue));
            }else if(StringUtils.isEmpty(whereClasue)){
                return String.join(" ",whereClasue,"WHERE",columnName,"=",String.valueOf(columnValue));
            }
        }
        return whereClasue;
    }*/

    private String queryBuilder(CustomerDTO customerDTO) {
        String whereClasue = "";
        whereClasue = addIntegerToWhereClause(whereClasue, "customer_id", customerDTO.getCustomer_id());
        whereClasue = addStringToWhereClause(whereClasue, "first_name", customerDTO.getFirst_name());
        whereClasue = addStringToWhereClause(whereClasue, "last_name", customerDTO.getLast_name());
        whereClasue = addStringToWhereClause(whereClasue, "email", customerDTO.getEmail());
        return whereClasue;
    }
}
