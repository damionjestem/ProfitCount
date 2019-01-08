package profitCount;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Damion
 */
class BankAccount {

    private String number;
    private String currency;

    public boolean isCurrencySupport(String currency) {
        return currency == this.currency;
    }

    public String getNumber() {
        return this.number;
    }

}

class ContactPerson {

    private String name;
    private String email;

    public String getEmailAddress() {
        return this.email;
    }
}

class Address {

    private String street;
    private String houseNumber;
    private String zip;
    private String city;
    private String country;

    public String getDataToInvoice() {
        return street + houseNumber + "\n"
                + zip + city + "\n"
                + country;
    }
}

class Contractor {

    private String nip;
    private String name;
    private ArrayList<BankAccount> bankAccounts;
    private ArrayList<ContactPerson> contactPeople;
    private Address address;

    public String getDataToInvoice() {
        return name + "\n" + address.getDataToInvoice() + "\n" + nip;
    }

    public void changeAddress(Address address) {
        this.address = address;
    }

    public String[] getEmailAddresses() {
        List<String> emailAddresses = new ArrayList<>();
        for (ContactPerson person : contactPeople) {
            emailAddresses.add(person.getEmailAddress());
        }
        return emailAddresses.toArray(new String[emailAddresses.size()]);
    }

    public String getBankAccountNumberForCurrency(String currency) {
        for (BankAccount bankAccount : bankAccounts) {
            if (bankAccount.isCurrencySupport(currency)) {
                return bankAccount.getNumber();
            }
        }
        throw new IllegalStateException(
        String.format("There is no bank account number for currency: '%s'", currency));
    }

    public void addBankAccount(BankAccount bankAccount) {
        this.bankAccounts.add(bankAccount);
    }

    public void removeBankAccountForSpecificCurrency(String currency) {
        for (int i = 0; i <= this.bankAccounts.size(); i++) {
            BankAccount bA = this.bankAccounts.get(i);
            if (bA.isCurrencySupport(currency)) {
                this.bankAccounts.remove(i);
                break;
            }
        }
        throw new IllegalStateException(
        String.format("There is no bank account number for currency: '%s'", currency));
    }

    Contractor(String nip, String name, Address address) {
        this.nip = nip;
        this.name = name;
        this.address = address;
    }

}

public class ProfitCount {

    public static void main(String[] args) {

        System.out.println("Podaj kwotę bazową");
        int baseAmount = scannerIntInput();

        System.out.println("Podaj ile procent w skali roku");
        int percent = scannerIntInput(0, 100);

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

    private static int scannerIntInput(int min, int max) {
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

}
