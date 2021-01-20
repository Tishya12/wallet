package com.paytm.walletapi.wallet.controller;


import com.paytm.walletapi.wallet.model.WalletModel;
import com.paytm.walletapi.wallet.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class WalletController {
    @Autowired
    private WalletService walletService;

    //will create wallet for a user
    @PostMapping(value = "/wallet")
    public String addWallet(@RequestBody WalletModel walletModel) {
        List<WalletModel> phone_number = walletService.findbyPhone(walletModel.getPhone()); // check for same phone number

        if (!phone_number.isEmpty()) {
            return "Wallet already exists";
        } else walletService.addWallet(walletModel);
        return "Wallet created";

    }

    //for displaying all the wallets present in the database
    @GetMapping(value = "/wallet/all")
    public List<WalletModel> displayAll() {
        return walletService.getWallets();
    }
}
