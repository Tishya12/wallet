package com.paytm.walletapi.transaction.Repository;

import com.paytm.walletapi.transaction.Model.ElasticTransaction;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface elasticrepo extends ElasticsearchRepository<ElasticTransaction, String> {
    List<ElasticTransaction> findBySenderphone(Integer phone);

    List<ElasticTransaction> findByReceiverphone(Integer phone);
}
