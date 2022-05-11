package duong.cg.service.customer;

import duong.cg.model.Customer;
import duong.cg.service.IGeneralService;

import java.util.List;

public interface ICustomerService extends IGeneralService<Customer> {
    List<Customer> findAllCustomerWithoutId(Long id);



}
