package Customer;

import Account.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Customer {
    private int id;
    private Address address;
    private String firstName;
    private String lastName;
    private int age;
    private long phone;

    private List<Account>  accountsList = new ArrayList<>();
    private List<SavingsAccount> savingsAccountList = new ArrayList<>();


    public void addAccount(Account account){
        this.accountsList.add(account);
    }

    public void getInfo(){
        System.out.println("Id: " + this.id + " Name: " + firstName + " " + lastName + " total balance: " + this.getTotalBalance());
    }

    public void getAccountInfo(){
        for(Account i:accountsList) {
            i.getAccountInfo();
            System.out.println("-----\n");
        }
    }

    public double getTotalBalance(){
        double totalBalance = 0;
        for(Account i:accountsList){
            totalBalance += i.getBalance();
        }
        return totalBalance;
    }

    public Customer(int id, String firstName, String lastName, int age, long phone, String city, String street, int streetNo, int zipCode) {
        this.id = id;
        this.address = new Address(city, street, streetNo, zipCode);
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phone = phone;
    }

    public Customer(int id) {
        this.id = id;
        Scanner in = new Scanner(System.in);

        this.address = new Address();
        System.out.println("First Name:");
        this.firstName = in.nextLine();
        System.out.println("Last Name:");
        this.lastName = in.nextLine();
        System.out.println("Age:");
        this.age = in.nextInt();
        System.out.println("Phone:");
        this.phone = in.nextLong();
    }

    public int getId() {
        return id;
    }

    public void getStatement(){
        for(Account x:accountsList){
            System.out.println("Statement for account "+x.getIban());
            x.getStatement();
        }
    }

    public String toCSV(){
        return id+","+address.getCity()+","+
                address.getStreet()+","+ address.getStreetNo()+
                ","+address.getZipCode()
                +","+firstName+","+lastName+","+age+","+phone;
    }

    public List<Account> getAccountsList(){
        return accountsList;
    }


}
