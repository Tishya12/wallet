package com.paytm.walletapi.wallet.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class WalletModel {

    @Id
    private Integer phone;
    private Integer balance;

    public WalletModel() {
    }

    public WalletModel(Integer phone, Integer balance) {
        this.phone = phone;
        this.balance = balance;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public void changeBalance(Integer amount) {
        this.balance += amount;
    }
}
