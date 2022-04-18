package duong.cg.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.time.LocalDateTime;

@Entity
@Table(name = "transfers")
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idSender;

    private Long idRecipient;

    @Min(value = 1000, message = "transfer min 1000$")
    private long transferAmount;

    private long fees;

    //    @Min(value = 1000, message = "transfer min 1000$")
    private long transaction_amount;

    private boolean isDelete = false;

    private LocalDateTime dateTime = LocalDateTime.now();

    public Transfer() {}

    public Transfer(Long id, Long idSender, Long idRecipient, long transferAmount, long fees, long transaction_amount, boolean isDelete, LocalDateTime dateTime) {
        this.id = id;
        this.idSender = idSender;
        this.idRecipient = idRecipient;
        this.transferAmount = transferAmount;
        this.fees = fees;
        this.transaction_amount = transaction_amount;
        this.isDelete = isDelete;
        this.dateTime = dateTime;
    }

    public Transfer(Long idSender) {
        this.idSender = idSender;
        this.fees = 10;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdSender() {
        return idSender;
    }

    public void setIdSender(Long idSender) {
        this.idSender = idSender;
    }

    public Long getIdRecipient() {
        return idRecipient;
    }

    public void setIdRecipient(Long idRecipient) {
        this.idRecipient = idRecipient;
    }

    public long getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(long transferAmount) {
        this.transferAmount = transferAmount;
    }

    public long getFees() {
        return fees;
    }

    public void setFees(long fees) {
        this.fees = fees;
    }

    public long getTransaction_amount() {
        return transaction_amount;
    }

    public void setTransaction_amount(long transaction_amount) {
        this.transaction_amount = transaction_amount;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
