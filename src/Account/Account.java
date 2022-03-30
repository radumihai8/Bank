package Account;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import Transaction.*;
public class Account {
    protected String iban;
    protected double balance;
    protected List<Card> cardList = new ArrayList<>();
    protected List<Deposit> depositList= new ArrayList<>();
    protected List<Withdraw> withdrawList= new ArrayList<>();
    protected List<Transfer> transferList= new ArrayList<>();
    Scanner in = new Scanner(System.in);

    public Account(String iban, double balance) {
        this.iban = iban;
        this.balance = balance;
    }

    public Account() {
        System.out.println("Enter the IBAN:");

        this.iban = in.nextLine();

        this.balance = 0;

        //Add a card to the account
        cardList.add(new Card());
    }

    public void addCard(){
        cardList.add(new Card());
        if(cardList.size()>1)
            cardList.sort((f1, f2) -> {
                return f1.getExpire_date().compareTo(f2.getExpire_date());
            });
    }

    public void getAccountInfo(){
        System.out.println(this.iban);
        System.out.println(this.balance);
        for (Card x : cardList)
            x.getCardInfo();
    }

    public void Deposit(String location, double sum){
        depositList.add(new Deposit(this, location, sum));
    }

    public void Withdraw(String location, double sum){
        withdrawList.add(new Withdraw(this, location, sum));
    }

    public void Transfer(Account recipient, double sum){
        transferList.add(new Transfer(this, recipient, sum));
    }

    public void getStatement(){
        System.out.println("Deposits:");
        for(Deposit x:depositList)
            x.getDetails();
        System.out.println("Withdrawals:");
        for(Withdraw x:withdrawList)
            x.getDetails();
        System.out.println("Transfers:");
        for(Transfer x:transferList)
            x.getDetails();
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
