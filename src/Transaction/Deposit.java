package Transaction;

import Account.*;

import java.util.Date;

public class Deposit extends Transaction{
    private String location;
    private Double sum;

    public Deposit(Account account, String location, Double sum){
        super(account);

        this.location = location;
        this.sum = sum;

        account.setBalance(account.getBalance()+sum);
    }

    public String toCSV(){
        return location+","+sum;
    }

    public void getDetails(){
        System.out.println(date + " " + location + " " +sum);
    }

}
