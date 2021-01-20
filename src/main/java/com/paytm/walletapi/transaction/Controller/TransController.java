package com.paytm.walletapi.transaction.Controller;

import com.paytm.walletapi.transaction.Model.TransModel;
import com.paytm.walletapi.transaction.Service.TransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TransController {
    @Autowired
    TransService transService;

    @GetMapping(value = "/transaction/all")
    public List<TransModel> displayAll(){
        return transService.displayall();
    }

    @PostMapping(value = "/transaction")           // post mapping
    public String addtransaction(@RequestBody TransModel transModel) {
        transService.addtransaction(transModel);
        return "transaction successful";
    }
}
