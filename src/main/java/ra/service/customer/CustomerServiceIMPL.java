package ra.service.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ra.dao.ICustomerRepository;
import ra.model.Customer;

import java.util.Optional;
@Service
public class CustomerServiceIMPL implements ICustomerService{
    @Autowired
    private ICustomerRepository customerRepository;
    @Override
    public Page<Customer> findAll(Pageable pageable, Sort sort) {
pageable = PageRequest.of(pageable.getPageNumber(), 3,sort);
        return customerRepository.findAll(pageable);
    }

    @Override
    public Optional<Customer> findById(Long aLong) {
        return customerRepository.findById(aLong);
    }

    @Override
    public void save(Customer customer) {
customerRepository.save(customer);
    }

    @Override
    public void remove(Long aLong) {
customerRepository.deleteById(aLong);
    }
}
