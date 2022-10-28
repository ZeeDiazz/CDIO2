package test.java;

import main.java.Account;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    void getBalance_balanceAtZero() {
        Account acct = new Account(0);
        assertEquals(0, acct.getBalance());
    }

    @Test
    void getBalance_balanceAtSmallPositive() {
        Account acct = new Account(1000);
        assertEquals(1000, acct.getBalance());
    }

    @Test
    void getBalance_balanceAtBigPositive() {
        Account acct = new Account(123456789);
        assertEquals(123456789, acct.getBalance());
    }

    @Test
    void getBalance_balanceAtSmallNegative() {
        Account acct = new Account(-2000);
        assertEquals(-2000, acct.getBalance());
    }

    @Test
    void getBalance_balanceAtBigNegative() {
        Account acct = new Account(-987654321);
        assertEquals(-987654321, acct.getBalance());
    }

    @Test
    void updateBalance_withZero() {
        Account acct = new Account(1000);
        acct.updateBalance(0);
        assertEquals(1000, acct.getBalance());
    }

    @Test
    void updateBalance_withSmallPositive() {
        Account acct = new Account(1000);
        acct.updateBalance(50);
        assertEquals(1050, acct.getBalance());
    }

    @Test
    void updateBalance_withBigPositive() {
        Account acct = new Account(1000);
        acct.updateBalance(1234567899);
        assertEquals(1234568899, acct.getBalance());
    }

    @Test
    void updateBalance_withSmallNegative() {
        Account acct = new Account(1000);
        acct.updateBalance(-100);
        assertEquals(900, acct.getBalance());
    }

    @Test
    void updateBalance_withBigNegative() {
        Account acct = new Account(12345678);
        acct.updateBalance(-1234567);
        assertEquals(11111111, acct.getBalance());
    }

    @Test
    void updateBalance_withNegativeOneBiggerThanInAccount() {
        Account acct = new Account(2301);
        acct.updateBalance(-2302);
        assertEquals(-1, acct.getBalance());
    }

    @Test
    void updateBalance_withNegativeALotMoreThanInAccount() {
        Account acct = new Account(4305);
        acct.updateBalance(-70000);
        assertEquals(-65695, acct.getBalance());
    }
}