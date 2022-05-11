package duong.cg.service.customer;

import duong.cg.model.Customer;
import duong.cg.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService{
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
        customerRepository.deleteById(id);
    }

    public List<Customer> findAllCustomerWithoutId(Long id){
        List<Customer> customers = findAll();
        List<Customer> customerList = new ArrayList<>();
        for (Customer customer: customers){
            if (customer.getId() == id)
                continue;
            else customerList.addAll(customers);
        }
        return customerList;
    }
}
