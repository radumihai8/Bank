package Transaction;

import Account.Account;

import java.util.Date;

public class Transaction {
    Account account;
    Date date;

    public Transaction(Account account){
        this.account = account;
        date = new Date();
    }


}
