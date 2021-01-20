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
    public WalletModel addWallet(WalletModel walletModel) {
        return walletRepository.save(walletModel);
    }

    public List<WalletModel> getWallets() {
        return walletRepository.findAll();
    }
    public List<WalletModel> findbyPhone(Integer phone) {return walletRepository.findByPhone(phone);}
}
