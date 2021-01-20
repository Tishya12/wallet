package com.paytm.walletapi.wallet.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class WalletModel {

    @Id

    private int phone;
    private int balance;

    public WalletModel() {
        super();
    }

    public WalletModel(int phone, int balance) {
        this.phone = phone;
        this.balance = balance;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
