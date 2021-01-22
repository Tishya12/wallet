package com.paytm.walletapi.wallet;

import com.paytm.walletapi.wallet.model.WalletModel;
import com.paytm.walletapi.wallet.repository.WalletRepository;
import com.paytm.walletapi.wallet.service.WalletService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class WalletApplicationTests {

    @Test
    void contextLoads() {
    }
    @Autowired
    private WalletService walletService;
    @MockBean
    private WalletRepository walletRepository;
    @Test
    public void getWalletsTest() {
        when(walletRepository.findAll()).thenReturn(Stream
                .of(new WalletModel(75,500)).collect(Collectors.toList()));///when performed operation X then we are tured a Stram of data ad repository is mocked here.
        assertEquals(1, walletService.getWallets().size());/////(expected : Actual outPut)

    }


    //3:GET
    public void findbyPhoneTest() {
        int phone = 75;
        when(walletRepository.findByPhone(phone))
                .thenReturn(Stream.of(new WalletModel(75,500)).collect(Collectors.toList()));
        assertEquals(1, walletService.findbyPhone(phone).size());

    }

    //4:Post
    public void addWalletTest(){
        WalletModel user = new WalletModel(789,34);
        when(walletRepository.save(user)).thenReturn(user);
        assertEquals(user, walletService.addWallet(user));

    }



}
