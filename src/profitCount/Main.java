/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profitCount;

import java.math.BigDecimal;

/**
 *
 * @author Damion
 */
public class Main {
    public static void main(String[] args) {
        MyBankAccount mBA = MyBankAccount.getInstance();
        
        //test if it works
        mBA.setBalance(BigDecimal.valueOf(10000));
        System.out.println(new StringBuilder("Balance:").append(mBA.getBalance()));
    }
}
