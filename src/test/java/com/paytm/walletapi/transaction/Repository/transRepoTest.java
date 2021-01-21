package com.paytm.walletapi.transaction.Repository;

import com.paytm.walletapi.transaction.Model.TransModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class transRepoTest {


        @Autowired
        private TestEntityManager entityManager;

        @Autowired
        private TransRepository transRepository;



    @Test
        public void testSaveTransaction(){
            TransModel transModel = getTransaction();
            TransModel savedInDb = entityManager.persist(transModel);
            Optional<TransModel> getFromDb = transRepository.findById(savedInDb.getTransactionid());

            assertThat(getFromDb).isEqualTo(savedInDb);
        }

    private TransModel getTransaction() {
        TransModel transModel = new TransModel();
        transModel.setTransactionid(1);
        transModel.setPayeephone(75);
        transModel.setPayeephone(76);
        transModel.setAmount(500);
        return transModel;
    }


    }
