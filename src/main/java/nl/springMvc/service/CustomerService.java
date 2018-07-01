package nl.springMvc.service;

import nl.springMvc.entity.Customer;
import nl.springMvc.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Transactional
    public List<Customer>  findAll(){
        return customerRepository.findAll();
    }

    @Transactional
    public List<Customer> findcustomers(int start, int maxRows){
        return customerRepository.findcustomers(start, maxRows);
    }

    @Transactional
    public List<Customer> findcustomers2(int start, int maxRows, String iSortCol, String sSortDir, String whereClause){
        return customerRepository.findcustomers2(start, maxRows, iSortCol, sSortDir, whereClause);
    }

    @Transactional
    public int countCustomers(String whereClause){
        return  customerRepository.countCustomers(whereClause);
    }
}
