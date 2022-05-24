package Transaction;

import Account.*;

import java.util.Date;

public class Deposit extends Transaction{
    private int id;
    private String location;
    private Double sum;

    public Deposit(Account account, String location, Double sum){
        super(account);
        this.id = 0;
        this.location = location;
        this.sum = sum;

    }

    public Deposit(Account account, String location, Double sum, int id){
        super(account);
        this.id = id;
        this.location = location;
        this.sum = sum;

    }

    public String toCSV(){
        return location+","+sum;
    }

    public void getDetails(){
        System.out.println(date + " " + location + " " +sum);
    }

    public String getLocation() {
        return location;
    }

    public Double getSum() {
        return sum;
    }

    public int getId(){
        return id;
    }
}
