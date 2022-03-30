package Customer;

import java.util.Scanner;

public class Address {
    private String city;
    private String street;
    private int streetNo;
    private int zipCode;

    public Address(String city, String street, int streetNo, int zipCode){
        this.city = city;
        this.street = street;
        this.streetNo = streetNo;
        this.zipCode = zipCode;
    }

    public Address(){
        Scanner in = new Scanner(System.in);
        System.out.println("City:");
        this.city = in.nextLine();
        System.out.println("Street:");
        this.street = in.nextLine();
        System.out.println("Street No.:");
        this.streetNo = in.nextInt();
        System.out.println("Zip code:");
        this.zipCode = in.nextInt();
    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getStreetNo() {
        return streetNo;
    }

    public void setStreetNo(int streetNo) {
        this.streetNo = streetNo;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }
}
