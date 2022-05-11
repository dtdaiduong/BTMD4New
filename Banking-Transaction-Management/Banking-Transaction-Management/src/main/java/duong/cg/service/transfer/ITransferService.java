package duong.cg.service.transfer;

import duong.cg.model.Transfer;
import duong.cg.service.IGeneralService;

import java.util.List;

public interface ITransferService extends IGeneralService<Transfer> {
    List<Transfer> findAllTransferWithoutId(Long id);
}
