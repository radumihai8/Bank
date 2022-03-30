package Transaction;

import Account.Account;

public class Withdraw extends Transaction {
    private String location;
    private String status;
    private Double sum;

    public Withdraw(Account account, String location, Double sum){
        super(account);

        this.location = location;
        this.sum = sum;
        if(account.getBalance()>=sum) {
            account.setBalance(account.getBalance() - sum);
            System.out.println("Transaction succeeded");
            status = "Success";
        }
        else
        {
            System.out.println("Transaction failed - not enough funds");
            status = "Failed";
        }
    }

    public void getDetails(){
        System.out.println("Transaction date: " + date + " Location: " + location + " Sum:" +sum+ " Status:" + status);
    }

}
