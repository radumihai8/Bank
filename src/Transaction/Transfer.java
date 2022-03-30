package Transaction;


import Account.Account;

public class Transfer extends Transaction{
    double sum;
    Account receiver;

    public Transfer(Account sender, Account receiver, double sum){
        super(sender);
        this.sum = sum;
        this.receiver = receiver;

        if(sender.getBalance() >= sum){
            sender.setBalance(sender.getBalance()-sum);
            receiver.setBalance(receiver.getBalance()+sum);
        }

    }

    public void getDetails(){
        System.out.println(date  + " " +sum);
    }
}
