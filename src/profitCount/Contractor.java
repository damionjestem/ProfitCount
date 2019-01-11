package profitCount;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Damion
 */


public class Contractor {

    private String nip;
    private String name;
    private ArrayList<BankAccount> bankAccounts;
    private ArrayList<ContactPerson> contactPeople;
    private Address address;

    public String getDataToInvoice() {
        return name + "\n" + address.getDataToInvoice() + "\n" + nip;
    }

    public void changeData(String nip, String name) {
        this.name = name;
        this.nip = nip;
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
