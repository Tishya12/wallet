package com.paytm.walletapi.wallet.repository;

import com.paytm.walletapi.wallet.model.WalletModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WalletRepository extends JpaRepository<WalletModel,Integer> {
    List<WalletModel> findAll();
    public List<WalletModel> findByPhone(int phone);
}
