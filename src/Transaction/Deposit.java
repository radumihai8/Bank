package Transaction;

import Account.*;

import java.util.Date;

public class Deposit extends Transaction{
    String location;
    Double sum;

    public Deposit(Account account, String location, Double sum){
        super(account);

        this.location = location;
        this.sum = sum;

        account.setBalance(account.getBalance()+sum);
    }

    public void getDetails(){
        System.out.println(date + " " + location + " " +sum);
    }

}
