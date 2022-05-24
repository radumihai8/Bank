import Account.*;
import Customer.*;

import Transaction.Deposit;
import Transaction.DepositDatabase;

import java.io.IOException;
import java.sql.*;
import java.util.*;

public class BankService {

    private static BankService instance;

    private BankService(){}

    public static BankService getInstance(){
        if(instance==null)
            instance = new BankService();
        return instance;
    }




//    private AccountSingleton accountSingleton = AccountSingleton.getInstance();
//    private CustomerSingleton customerSingleton = CustomerSingleton.getInstance();
//    private CardSingleton cardSingleton = CardSingleton.getInstance();
//    private DepositSingleton depositSingleton = DepositSingleton.getInstance();

    private CustomerDatabase customerDatabase = CustomerDatabase.getInstance();
    private AccountDatabase accountDatabase = AccountDatabase.getInstance();
    private CardDatabase cardDatabase = CardDatabase.getInstance();
    private DepositDatabase depositDatabase = DepositDatabase.getInstance();

    private List<Customer> customers = new ArrayList<Customer>();;

    private HashMap<String, Account> accountsMap = new HashMap<String, Account>();

    public void saveData() throws IOException, SQLException {
        for(Customer x:customers)
        {
            //daca clientul nu exista deja in DB il inseram, altfel facem update
            if(!customerDatabase.exists(x)) {
                customerDatabase.create(x);
            }
            else {
                customerDatabase.update(x);

            }

            for(Account y:x.getAccountsList()){
                //Export cards
                for(Card z:y.getCardList()){
                    if(!cardDatabase.exists(z))
                        cardDatabase.create(y.getIban(),z);
                    else
                        cardDatabase.update(z);
                }
                //Export deposits
                for(Deposit d:y.getDepositList()){
                    if(!depositDatabase.exists(d))
                        depositDatabase.create(y.getIban(),d);

                }
                //Export account
                if(!accountDatabase.exists(y))
                    accountDatabase.create(x.getId(), y);
                else
                    accountDatabase.update(y);
            }
        }
    }

    public void readData(){
        //customers = customerSingleton.readFromCSV();
        customers.addAll(customerDatabase.read());
        accountsMap = accountDatabase.read(customers);
        cardDatabase.read(accountsMap);
        depositDatabase.read(accountsMap);
    }
    public void createCustomer(){
        Customer temp = new Customer(customers.size()+1);
        System.out.println(customers.size());
        customers.add(temp);
    }

    public void viewCustomers(){

        for(Customer x:customers){
            x.getInfo();
        }
    }

    public void viewCustomerAccounts(){
        Scanner in = new Scanner(System.in);
        System.out.println("Customer id:");
        int id = in.nextInt();

        for(Customer x:customers){
            if(x.getId()==id) {
                x.getAccountInfo();
            }
        }
    }

    //Get the account info by IBAN
    public void getAccountInfo(){
        Scanner in = new Scanner(System.in);
        System.out.println("IBAN:");
        String iban = in.nextLine();

        accountsMap.get(iban).getAccountInfo();
    }

    //Get the statement of a customer by Customer ID
    public void getCustomerStatement(){
        Scanner in = new Scanner(System.in);
        System.out.println("Customer id:");
        int id = in.nextInt();

        //Find the customer with the given id
        for(Customer x:customers)
            if (x.getId()==id) {
                customers.get(0).getStatement();
                break;
            }

    }

    //Create an account for a customer with a given id
    public void createAccount(){
        Scanner in = new Scanner(System.in);
        System.out.println("Customer id:");
        int id = in.nextInt();

        for(Customer x:customers)
            if (x.getId()==id) {
                Account temp = new Account();
                x.addAccount(temp);
                accountsMap.put(temp.getIban(),temp);
                break;
            }
    }

    //Add a card to a given account by IBAN
    public void createCard(){
        Scanner in = new Scanner(System.in);
        System.out.println("Account IBAN:");
        String iban = in.nextLine();

        accountsMap.get(iban).addCard();
    }

    //Deposit money into an account by IBAN
    public void deposit(){
        Scanner in = new Scanner(System.in);
        System.out.println("Account iban:");
        String iban = in.nextLine();
        System.out.println("Deposit location:");
        String location = in.nextLine();
        System.out.println("Sum:");
        double sum  = in.nextDouble();

        accountsMap.get(iban).Deposit(location, sum);
    }

    //Withdraw money from an account by iban
    public void withdraw(){
        Scanner in = new Scanner(System.in);
        System.out.println("Account iban:");
        String iban = in.nextLine();
        System.out.println("Withdraw location:");
        String location = in.nextLine();
        System.out.println("Sum:");
        double sum  = in.nextDouble();

        accountsMap.get(iban).Withdraw(location, sum);
    }

    //Transfer money between 2 accounts by IBAN
    public void transfer(){
        Scanner in = new Scanner(System.in);
        System.out.println("Sender iban:");
        String sender = in.nextLine();
        System.out.println("Receiver iban:");
        String receiver = in.nextLine();
        System.out.println("Sum:");
        double sum  = in.nextDouble();

        Account s = accountsMap.get(sender);
        Account r = accountsMap.get(receiver);
        s.Transfer(r,sum);
    }

    //Print all the commands with description
    public void help(){
        System.out.println("create_customer -> Create a customer");
        System.out.println("create_account -> Create an account");
        System.out.println("create_card -> Create a card");
        System.out.println("deposit -> Make a deposit to an account by IBAN");
        System.out.println("withdraw -> Make a withdraw from an account by IBAN");
        System.out.println("transfer -> Make a transfer between accounts by IBAN");
        System.out.println("view_customers -> View info of all customers");
        System.out.println("view_customer_accounts -> Get info for all the accounts of a customer by IBAN");
        System.out.println("view_account_info -> View info by customer ID");
        System.out.println("view_customer_statements -> View statements for a customer by ID");
    }


}
