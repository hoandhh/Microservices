package demo.hoandh.accountservice.controller;

import demo.hoandh.accountservice.client.NotificationService;
import demo.hoandh.accountservice.client.StatisticService;
import demo.hoandh.accountservice.model.AccountDTO;
import demo.hoandh.accountservice.model.MessageDTO;
import demo.hoandh.accountservice.model.StatisticDTO;
import demo.hoandh.accountservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private StatisticService statisticService;

    @Autowired
    private NotificationService notificationService;

    // add new
    @PostMapping("/account")
    public AccountDTO addAccount(@RequestBody AccountDTO accountDTO) {
        accountService.add(accountDTO);

        statisticService.add(new StatisticDTO("Account " + accountDTO.getUsername() + " is created", new Date()));

        //send notificaiton
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setFrom("21000517@vnu.edu.vn");
        messageDTO.setTo(accountDTO.getUsername());//username is email
        messageDTO.setToName(accountDTO.getName());
        messageDTO.setSubject("Welcome to Hoan Doan Soft");
        messageDTO.setContent("Đây là email được gửi tự đông.");

        notificationService.sendNotification(messageDTO);

        return accountDTO;
    }

    // get all
    @GetMapping("/accounts")
    public List<AccountDTO> getAll() {
        statisticService.add(new StatisticDTO("Get all accounts", new Date()));

        return accountService.getAll();
    }

    @GetMapping("/account/{id}")
    public ResponseEntity<AccountDTO> get(@PathVariable(name = "id") Long id) {
        return Optional.of(new ResponseEntity<AccountDTO>(accountService.getOne(id), HttpStatus.OK))
                .orElse(new ResponseEntity<AccountDTO>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/account/{id}")
    public void delete(@PathVariable(name = "id") Long id) {
        statisticService.add(new StatisticDTO("Delete account id " + id, new Date()));

        accountService.delete(id);
    }

    @PutMapping("/account")
    public void update(@RequestBody AccountDTO accountDTO) {
        statisticService.add(new StatisticDTO("Update account: " + accountDTO.getUsername(), new Date()));

        accountService.update(accountDTO);
    }
}
