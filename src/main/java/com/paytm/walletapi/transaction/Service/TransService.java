package com.paytm.walletapi.transaction.Service;

import com.paytm.walletapi.transaction.Model.TransModel;
import com.paytm.walletapi.transaction.Repository.TransRepository;
import com.paytm.walletapi.wallet.model.WalletModel;
import com.paytm.walletapi.wallet.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransService {
    @Autowired
    private TransRepository transRepository;
    public TransModel addtransaction(TransModel transModel) {

        return transRepository.save(transModel);
    }

    public List<TransModel> displayall() {
        return transRepository.findAll();
    }

    public TransModel displayTransaction(int transactionid) {
        Optional<TransModel> optionalUser = transRepository.findById(transactionid);
        return optionalUser.orElse(null);
    }

//    public List<WalletModel> findbyPhone(int phone) {return walletRepository.findByPhone(phone);}
}

