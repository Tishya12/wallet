package com.paytm.walletapi.transaction.Controller;

import com.paytm.walletapi.transaction.Model.TransModel;
import com.paytm.walletapi.transaction.Service.TransService;
import com.paytm.walletapi.wallet.model.WalletModel;
import com.paytm.walletapi.wallet.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TransController {
    @Autowired                         //dependency injection
    TransService transService;
    @Autowired                         //dependency injection
    WalletService walletService;

    //to display all transactions
    @GetMapping(value = "/transaction/all")
    public List<TransModel> displayAll() {
        return transService.displayall();
    }



    //for checking status of transaction
    @GetMapping(value = "/transaction/{transactionid}")
    public String displayTransaction(@PathVariable("transactionid") int transactionid) {
        List<TransModel> checkTransaction = transService.findByTransactionid(transactionid);
        if (checkTransaction.isEmpty())
            return "Transaction Status: failed";
        else return "Transaction Status: Successful";
    }


    //for checking transaction of particular phone number
//    @GetMapping(value = "/transaction/{payerphone}")
//    public List<TransModel> displayTransactions(@PathVariable("payerphone") int phoneNo) {
////            return transService.displayTransaction(transactionid);
//        List<TransModel> payer_phone = transService.findbyPayerPhone(phoneNo);
//        List<TransModel> payee_phone = transService.findbyPayeePhone(phoneNo);
//        List<TransModel> newList = null;
//        newList.addAll(payee_phone);
//        newList.addAll(payer_phone);
//        return payer_phone;
//    }

   //API to transfer money from one wallet to another wallet
    @PostMapping(value = "/transaction")           // post mapping
    public String addtransaction(@RequestBody TransModel transModel) {
//        transService.addtransaction(transModel);
//        return "transaction successful";
        List<WalletModel> payer_phone = walletService.findbyPhone(transModel.getPayerphone());
        List<WalletModel> payee_phone = walletService.findbyPhone(transModel.getPayeephone());
        if (!payee_phone.isEmpty()) {
            if (!payer_phone.isEmpty()) {
                if (payee_phone.get(0).getBalance() >= transModel.getAmount()) {
                    transService.addtransaction(transModel);
                    payee_phone.get(0).changeBalance(-transModel.getAmount());
                    payer_phone.get(0).changeBalance(transModel.getAmount());
                    return "transaction successful";
                } else return "Insufficient balance";
            } else return "phone number doesn't exist";
        } else return "phone number doesn't exist";
    }
}
