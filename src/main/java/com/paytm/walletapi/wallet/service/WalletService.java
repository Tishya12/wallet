package com.paytm.walletapi.wallet.service;

import com.paytm.walletapi.wallet.model.WalletModel;
import com.paytm.walletapi.wallet.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalletService {
    @Autowired
    private WalletRepository walletRepository;

    //method for adding wallet in the database
    public WalletModel addWallet(WalletModel walletModel) {
        return walletRepository.save(walletModel);
    }

    //method for getting all the wallets from the database
    public List<WalletModel> getWallets() {
        return walletRepository.findAll();
    }

    //it will return object of walletmodel type if phone is present
    public List<WalletModel> findbyPhone(Integer phone) {return walletRepository.findByPhone(phone);}
}
