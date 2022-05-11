package duong.cg.service.transfer;

import duong.cg.model.Transfer;
import duong.cg.repository.ITransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransferService implements ITransferService{
    @Autowired
    private ITransferRepository transferRepository;

    @Override
    public List<Transfer> findAllTransferWithoutId(Long id){
        List<Transfer> transfers = new ArrayList<>();
        List<Transfer> allTransfers = findAll();
        for (Transfer transfer: transfers){
            if (transfer.getId() == id)
                continue;
            else transfers.add(transfer);
        }
        return transfers
    }

    @Override
    public List<Transfer> findAll() {
        return transferRepository.findAll();
    }

    @Override
    public Transfer findById(Long id) {
        return transferRepository.findById(id);
    }
//    @Override
//    public Transfer getById(Long id) {
//        return transferRepository.getById(id);
//    }

    @Override
    public void save(Transfer transfer) {
        transferRepository.save(transfer);
    }

    @Override
    public void remove(Long id) {
        transferRepository.deleteById(id);
    }

    @Override
    public boolean existById(Long id){
        return transferRepository.exists(id);
    }
}
