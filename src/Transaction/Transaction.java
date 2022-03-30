package Transaction;

import Account.Account;

import java.util.Date;

public class Transaction {
    protected Account account;
    protected Date date;

    public Transaction(Account account){
        this.account = account;
        date = new Date();
    }


}
