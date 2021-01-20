package com.paytm.walletapi.transaction.Repository;

import com.paytm.walletapi.transaction.Model.TransModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransRepository extends JpaRepository<TransModel,Integer> {
}
