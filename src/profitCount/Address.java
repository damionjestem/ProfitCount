/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profitCount;

/**
 *
 * @author Damion
 */
public class Address {

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
