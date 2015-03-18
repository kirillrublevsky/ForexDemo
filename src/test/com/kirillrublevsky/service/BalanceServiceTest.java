package com.kirillrublevsky.service;

import com.kirillrublevsky.dao.BalanceDAO;
import com.kirillrublevsky.model.Balance;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static junit.framework.Assert.assertNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class BalanceServiceTest {

    @Mock
    private BalanceDAO mockBalanceDAO;

    @InjectMocks
    private BalanceService balanceService = new BalanceServiceImpl();

    @BeforeClass
    public static void beforeClassMessage(){
        System.out.println("Starting tests");
    }


    @Test
    public void testAddBalance(){
        Balance balance = new Balance();
        balanceService.addBalance(balance);

        verify(mockBalanceDAO, times(1)).addBalance(balance);
    }

    @Test
    public void testGetBalanceByIdIsNull(){
        assertNull(mockBalanceDAO.getBalanceById(1));

    }

    @AfterClass
    public static void afterClassMessage(){
        System.out.println("Tests are over.Have fun!");
    }

}
