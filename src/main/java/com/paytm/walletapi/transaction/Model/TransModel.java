package com.paytm.walletapi.transaction.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TransModel {
    @Id                                   //primary key
    @GeneratedValue
    private Integer transactionid;
    private Integer payerphone;
    private Integer payeephone;
    private Integer amount;

    public TransModel() {
//        super();
    }

    public TransModel(Integer transactionid, Integer payerphone, Integer payeephone, Integer amount) {
//        super();
        this.transactionid = transactionid;
        this.payerphone = payerphone;
        this.payeephone = payeephone;
        this.amount = amount;
    }

    public Integer getTransactionid() {
        return transactionid;
    }

    public void setTransactionid(Integer transactionid) {
        this.transactionid = transactionid;
    }

    public Integer getPayerphone() {
        return payerphone;
    }

    public void setPayerphone(Integer payerphone) {
        this.payerphone = payerphone;
    }

    public Integer getPayeephone() {
        return payeephone;
    }

    public void setPayeephone(Integer payeephone) {
        this.payeephone = payeephone;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

//    public Object getTransaction() {
//    }
}
