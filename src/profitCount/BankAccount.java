/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profitCount;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 *
 * @author Damion
 */
class MyBankAccount extends BankAccount{
    
    private static MyBankAccount instance;
    
    private BigDecimal balance;
    
    public BigDecimal getBalance() {
        return this.balance;
    }
    
    public void setBalance(BigDecimal balance){
        this.balance = balance;
    }

    public void countProfit() {

        BigDecimal balanceAfterInvestment = getBalance();

        System.out.println("Podaj ile procent w skali roku");
        int percent = scannerIntInput(0, 100);

        System.out.println("Podaj ile miesięcy");
        int months = scannerIntInput();

        if (months > 0) {
            for (int i = 0; i <= months; i++) {
                balanceAfterInvestment += getBalance().multiply(((percent / 100) / 12));
            }
        }

        System.out.println(balanceAfterInvestment);
    }
    
        //Bottleneck here: BigDecimal balance might be a problem later
    private int scannerIntInput() {
        Scanner sc = new Scanner(System.in);
        int result = 0;
        boolean isOk = false;
        while (!isOk) {
            try {
                result = Integer.parseInt(sc.nextLine());
                if (result > 0) {
                    isOk = true;
                } else {
                    System.out.println("Liczba musi być większa od 0, wprowadź jeszcze raz");
                }
            } catch (NumberFormatException e) {
                System.out.println("Niepoprawny format liczby, wprowadź jeszcze raz");
            }
        }
        return result;
    }

    private int scannerIntInput(int min, int max) {
        Scanner sc = new Scanner(System.in);
        int result = 0;
        boolean isOk = false;
        while (!isOk) {
            try {
                result = Integer.parseInt(sc.nextLine());
                if (min <= result && result <= max) {
                    isOk = true;
                } else {
                    System.out.println(new StringBuilder("Liczba musi zawierać się w przedziale ").append(min).append(" - ").append(max).append(", wprowadź jeszcze raz.").toString());
                }
            } catch (NumberFormatException e) {
                System.out.println("Niepoprawny format liczby, wprowadź jeszcze raz");
            }
        }
        return result;
    }
    
    //Singleton lazy init
    private MyBankAccount(){
        if (instance != null) {
            throw new IllegalStateException("Cannot create new instance, please use getInstance method instead.");
        }
    }
    public static MyBankAccount getInstance(){
        if (instance == null){
            instance = new MyBankAccount();
        }
        return instance;
    }
}


public class BankAccount {
    
    private String number;
    private String currency;

    public boolean isCurrencySupport(String currency) {
        return currency == this.currency;
    }

    public String getNumber() {
        return this.number;
    }

}
