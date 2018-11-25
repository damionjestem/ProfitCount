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
        int baseAmount = scannerIntInput();

        System.out.println("Podaj ile procent w skali roku");
        int percent = scannerIntInput();

        System.out.println("Podaj ile miesięcy");
        int months = scannerIntInput();

        for (int i = 0; i <= months; i++) {
            baseAmount += (baseAmount * percent / 100) / 12;
        }

        System.out.println(baseAmount);
    }

    private static int scannerIntInput() {
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

}
