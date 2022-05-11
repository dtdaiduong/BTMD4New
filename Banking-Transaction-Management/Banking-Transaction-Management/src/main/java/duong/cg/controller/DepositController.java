package duong.cg.controller;

import duong.cg.model.Customer;
import duong.cg.model.Deposit;
import duong.cg.service.customer.ICustomerService;
import duong.cg.service.deposit.IDepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/deposit")
public class DepositController {

    @Autowired
    private IDepositService depositService;
    @Autowired
    private ICustomerService customerService;

    @GetMapping("save/{id}")
    private ModelAndView showFormDeposit(@PathVariable("id") Long id){
        ModelAndView modelAndView = new ModelAndView("/deposit/deposit");
        Optional<Customer> customer = customerService.findById(id);
        Customer fakeCustomer = customer.get();
        Deposit deposit = new Deposit();
        deposit.setCreate_at(Date.valueOf(java.time.LocalDate.now()));
        deposit.getTransaction_amount(0L);
        deposit.getCustomerDeposit(fakeCustomer);
        depositService.save(deposit);
    }


//    @GetMapping("/deposits/{id}")
//    private ModelAndView viewDeposits(@PathVariable Long id){
//        ModelAndView modelAndView = new ModelAndView("/transaction/deposits");
//        Optional<Customer> customer = customerService.findById(id);
//        modelAndView.addObject("deposits",new Deposit());
//        modelAndView.addObject("customer",customer);
//        return modelAndView ;
//    }
//    @PostMapping("/deposits")
//    private ModelAndView saveDeposits(@Validated @ModelAttribute("deposits") Deposit deposits,
//                                      BindingResult bindingResult){
//
//        Customer customer = customerService.findById(deposits.getIdOwner());
//        long money_deposits = deposits.getAmount();
//        boolean isMoney = false;
//        if (money_deposits > 1000 && money_deposits <= 1000000000) {
//            isMoney = true;
//        }
//        ModelAndView modelAndView = new ModelAndView("/transaction/deposits");
//        String error = null;
//        if (bindingResult.hasFieldErrors()) {
//            List<ObjectError> errorList = bindingResult.getAllErrors();
//            error = "Deposit error \n";
//            for (int i = 0; i < errorList.size(); i++) {
//                error += "***" + errorList.get(i).getDefaultMessage() + "\n";
//            }
//            modelAndView.addObject("error", error);
//        }
//        try {
//            if(isMoney){
//                depositService.save(deposits);
//                customer.setBalance(customer.getBalance()+ deposits.getAmount());
//                customerService.save(customer);
//                modelAndView.addObject("message", "Deposits successfully");
//            }else {
//                modelAndView.addObject("error",error);
//            }
//            modelAndView.addObject("deposits", new Deposit(deposits.getIdOwner()));
//            modelAndView.addObject("customer",customer);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            modelAndView.addObject("error", error);
//        }
//        return modelAndView ;
//    }
}
