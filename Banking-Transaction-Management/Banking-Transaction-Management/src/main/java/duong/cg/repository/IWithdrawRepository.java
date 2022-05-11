package duong.cg.repository;

import duong.cg.model.Withdraw;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IWithdrawRepository extends PagingAndSortingRepository<Withdraw, Long> {

}
