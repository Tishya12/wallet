package com.paytm.walletapi.transaction.Controller;

import com.paytm.walletapi.transaction.Model.TransModel;
import com.paytm.walletapi.transaction.Service.TransService;
import com.paytm.walletapi.wallet.model.WalletModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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


//    public TransModel displayTransaction(@PathVariable("transactionid") int transactionid,@RequestBody TransModel transModel){
//        List<TransModel> trans_id = transService.findbyId(transModel.getTransactionid()); // check for same phone number
//
//        if (trans_id.isEmpty()) {
//            return "transaction Id does'nt exists";
//        }
//        else walletService.addWallet(walletModel);
//        return "Wallet created";
@GetMapping(value = "/transaction/{transactionid}")
        public TransModel  displayTransaction(@PathVariable("transactionid") int transactionid) {
            return transService.displayTransaction(transactionid);
        }


    @PostMapping(value = "/transaction")           // post mapping
    public String addtransaction(@RequestBody TransModel transModel) {
        transService.addtransaction(transModel);
        return "transaction successful";
    }
}
