package com.paytm.walletapi.transaction.Service;

import com.paytm.walletapi.transaction.Model.ElasticTransaction;
import com.paytm.walletapi.transaction.Repository.elasticrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
public class KafkaConsumer {
    @Autowired
    private elasticrepo elasticRepository;

    @KafkaListener(topics = "txn_by_id", groupId = "group_json",
            containerFactory = "concurrentKafkaListenerContainerFactory")
    public void consumeJson(ElasticTransaction transaction) {
        elasticRepository.save(transaction); /////////////////////////for saving in elastic repository//////
        System.out.println("Consumed JSON Message: " + transaction);
    }

    }

