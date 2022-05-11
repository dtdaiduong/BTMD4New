package duong.cg.service.deposit;

import duong.cg.model.Deposit;
import duong.cg.service.IGeneralService;

import java.util.List;

public interface IDepositService extends IGeneralService<Deposit> {
    List<Customer> findAllCustomerWithoutId(Long id);
}
