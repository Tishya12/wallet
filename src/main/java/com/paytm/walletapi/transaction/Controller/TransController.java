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
    @Autowired
    TransService transService;
    @Autowired
    WalletService walletService;

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
        public String  displayTransaction(@PathVariable("transactionid") int transactionid) {
//            return transService.displayTransaction(transactionid);
    List<TransModel> checkTransaction = transService.findByTransactionid(transactionid);
    if(checkTransaction.isEmpty())
        return "Transaction Status: failed";
    else return "Transaction Status: Successful";
        }


    @PostMapping(value = "/transaction")           // post mapping
    public String addtransaction(@RequestBody TransModel transModel) {
//        transService.addtransaction(transModel);
//        return "transaction successful";
        List<WalletModel> payer_phone = walletService.findbyPhone(transModel.getPayerphone());
        List<WalletModel> payee_phone = walletService.findbyPhone(transModel.getPayeephone());
        if(!payer_phone.isEmpty() && !payee_phone.isEmpty()) {
            if(payee_phone.get(0).getBalance() >= transModel.getAmount()) {
                transService.addtransaction(transModel);
                payee_phone.get(0).changeBalance(-transModel.getAmount());
                payer_phone.get(0).changeBalance(transModel.getAmount());
                return "transaction successful";
            }
            else return "Insufficient balance";
        }
        else return "phone number doesn't exist";
    }
}
