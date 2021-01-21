package com.paytm.walletapi.transaction.Service;

import com.paytm.walletapi.transaction.Model.TransModel;
import com.paytm.walletapi.transaction.Repository.TransRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransService {
    @Autowired
    private TransRepository transRepository;

    //saving transactions in the database
    public TransModel addtransaction(TransModel transModel) {
        return transRepository.save(transModel);
    }

    //method for displaying all the transaction in the database
//    public List<TransModel> displayall() {
//        return transRepository.findAll();
//    }

    //method for displaying particular transaction
    public TransModel displayTransaction(int transactionid) {
        Optional<TransModel> optionalUser = transRepository.findById(transactionid);
        return optionalUser.orElse(null);
    }

    //returning object of type transmodel if the given transaction id is present
    public List<TransModel> findByTransactionid(int transactionid) {
        return transRepository.findByTransactionid(transactionid);
    }

    //returning object of type transmodel if the given payerphone is present
    public List<TransModel> findbyPayerPhone(Integer payerphone) {
        return transRepository.findByPayerphone(payerphone);
    }

    //returning object of type transmodel if the given payeephone is present
    public List<TransModel> findbyPayeePhone(Integer payeephone) {
        return transRepository.findByPayeephone(payeephone);
    }

    public List<TransModel> getAllTransactions(Integer pageNo, Integer pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);

        Page<TransModel> pagedResult = transRepository.findAll(paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<TransModel>();
        }
    }
    }

//    public List<WalletModel> findbyPhone(int phone) {return walletRepository.findByPhone(phone);}


