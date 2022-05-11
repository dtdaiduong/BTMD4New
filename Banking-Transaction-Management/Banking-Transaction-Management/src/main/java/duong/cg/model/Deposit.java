package duong.cg.model;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Optional;

@Entity
@Table( name = "deposits")
public class Deposit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date create_at;
    private String create_by;

//    @Min(value = 10001, message = "Deposit not min 10000")
//    @Max(value = 10000000000L, message = "Deposit not max 10000000000L")
    @ColumnDefault("0")
    private int deleted;
    private Date update_at;
    private String update_by;
    @ManyToOne
    @JoinColumn(name = "customer_Id")
    private Customer customerDeposit;
    //    @Pattern(regexp = "^$[0-9]{12}", message = "This field must be number")
    private Long transaction_amount;

    public Deposit() {
    }

    public Deposit(Date create_at, Customer customerDeposit) {
        this.create_at = create_at;
        this.customerDeposit = customerDeposit;
    }

    public Deposit(Date create_at, String create_by, int deleted,
                   Date update_at, String update_by, Customer customerDeposit, Long transaction_amount) {
        this.create_at = create_at;
        this.create_by = create_by;
        this.deleted = deleted;
        this.update_at = update_at;
        this.update_by = update_by;
        this.customerDeposit = customerDeposit;
        this.transaction_amount = transaction_amount;
    }

    public Deposit(Long id, Date create_at, String create_by, int deleted,
                   Date update_at, String update_by, Customer customerDeposit, Long transaction_amount) {
        this.id = id;
        this.create_at = create_at;
        this.create_by = create_by;
        this.deleted = deleted;
        this.update_at = update_at;
        this.update_by = update_by;
        this.customerDeposit = customerDeposit;
        this.transaction_amount = transaction_amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Date create_at) {
        this.create_at = create_at;
    }

    public String getCreate_by() {
        return create_by;
    }

    public void setCreate_by(String create_by) {
        this.create_by = create_by;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    public Date getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Date update_at) {
        this.update_at = update_at;
    }

    public String getUpdate_by() {
        return update_by;
    }

    public void setUpdate_by(String update_by) {
        this.update_by = update_by;
    }

    public Customer getCustomerDeposit() {
        return customerDeposit;
    }

    public void setCustomerDeposit(Customer customerDeposit) {
        this.customerDeposit = customerDeposit;
    }

    public Long getTransaction_amount() {
        return transaction_amount;
    }

    public void setTransaction_amount(Long transaction_amount) {
        this.transaction_amount = transaction_amount;
    }

    public void setCustomerDeposit(Optional<Customer> customer) {
        this.customerDeposit = customerDeposit;
    }
}
