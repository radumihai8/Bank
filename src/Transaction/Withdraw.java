package Transaction;

import Account.Account;

public class Withdraw extends Transaction {
    String location;
    String status;
    Double sum;

    public Withdraw(Account account, String location, Double sum){
        super(account);

        this.location = location;
        this.sum = sum;
        if(account.getBalance()>=sum) {
            account.setBalance(account.getBalance() - sum);
            status = "Success";
        }
        else
        {
            status = "Failed";
        }
    }

    public void getDetails(){
        System.out.println(date + " " + location + " " +sum+ " " + status);
    }

}
