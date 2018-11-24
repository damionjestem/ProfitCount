/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profitCount;

import java.util.Scanner;

/**
 * @author Damion
 */
public class ProfitCount {

    public static void main(String[] args) {

        System.out.println("Podaj kwotę bazową");
        Scanner sc = new Scanner(System.in);
        int baseAmount = Integer.parseInt(sc.nextLine());

        System.out.println("Podaj ile procent w skali roku");
        sc = new Scanner(System.in);
        int percent = Integer.parseInt(sc.nextLine());

        System.out.println("Podaj ile miesięcy");
        sc = new Scanner(System.in);
        int months = Integer.parseInt(sc.nextLine());

        for (int i = 0; i <= months; i++) {
            baseAmount += (baseAmount * percent/100) / 12;
        }

        System.out.println(baseAmount);
    }

}
