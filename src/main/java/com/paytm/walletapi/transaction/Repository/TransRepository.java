package com.paytm.walletapi.transaction.Repository;

import com.paytm.walletapi.transaction.Model.TransModel;
import com.paytm.walletapi.wallet.model.WalletModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//repository

@Repository
public interface TransRepository extends JpaRepository<TransModel,Integer> ,PagingAndSortingRepository<TransModel,Integer> {
    public List<TransModel> findByTransactionid(Integer transactionid);
    public List<TransModel> findByPayeephone(Integer payeephone);
    public List<TransModel> findByPayerphone(Integer payerphone);
}
