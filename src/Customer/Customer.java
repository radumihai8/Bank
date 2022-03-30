package Customer;

import Account.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Customer {
    int id;
    protected Address address;
    String firstName;
    String lastName;
    int age;
    long phone;

    List<Account>  accountsList = new ArrayList<>();
    List<SavingsAccount> savingsAccountList = new ArrayList<>();


    public void addAccount(Account account){
        this.accountsList.add(account);
    }

    public void getInfo(){
        System.out.println("Id: " + this.id + " Name: " + firstName + " " + lastName);
    }

    public void getAccountInfo(){
        for(Account i:accountsList) {
            i.getAccountInfo();
            System.out.println("-----\n");
        }
    }

    public Customer(int id, String firstName, String lastName, int age, long phone) {
        this.id = id;
        this.address = new Address();
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


}