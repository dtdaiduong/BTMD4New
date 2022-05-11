package duong.cg.service.withdraw;

import duong.cg.model.Withdraw;
import duong.cg.repository.IWithdrawRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class WithdrawService implements IWithdrawService{
    @Autowired
    private IWithdrawRepository withdrawRepository;

    @Override
    public List<Withdraw> findAll() {
        return withdrawRepository.findAll();
    }

    @Override
    public Optional<Withdraw> findById(Long id) {
        return withdrawRepository.findById(id);
    }
    @Override
    public Withdraw getById(Long id) {
        return null;
    }

    @Override
    public void save(Withdraw withdraw) {
        withdrawRepository.save(withdraw);
    }

    @Override
    public void remove(Long id) {
        withdrawRepository.deleteById(id);
    }
    @Override
    public boolean existById(Long id){
        return withdrawRepository.existsById(id);
    }
}
