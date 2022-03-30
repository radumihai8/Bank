import Account.Account;
import Customer.Customer;
import Transaction.Transfer;

import java.util.*;

public class BankService {

    private static BankService instance;

    private BankService(){}

    public static BankService getInstance(){
        if(instance==null)
            instance = new BankService();
        return instance;
    }

    private List<Customer> customers = new ArrayList<>();
    private HashMap<String, Account> accountsMap = new HashMap<String, Account>();

    public void createCustomer(){
        customers.add(new Customer(customers.size()+1));
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
            if(x.getId()==id)
                x.getAccountInfo();
        }
    }

    public void getCustomerAccountInfo(){
        Scanner in = new Scanner(System.in);
        System.out.println("Account id:");
        int id = in.nextInt();

        for(Customer x:customers)
            if (x.getId()==id) {
                customers.get(id).getAccountInfo();
                break;
            }
    }

    public void getCustomerStatement(){
        Scanner in = new Scanner(System.in);
        System.out.println("Customer id:");
        int id = in.nextInt();

        for(Customer x:customers)
            if (x.getId()==id) {
                customers.get(0).getStatement();
                break;
            }

    }

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

    public void createCard(){
        Scanner in = new Scanner(System.in);
        System.out.println("Account id:");
        String iban = in.nextLine();

        accountsMap.get(iban).addCard();
    }

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

    public void help(){
        System.out.println("create_customer -> Create a customer");
        System.out.println("create_account -> Create an account");
        System.out.println("create_card -> Create a card");
        System.out.println("deposit -> Make a deposit to an account by IBAN");
        System.out.println("withdraw -> Make a withdraw from an account by IBAN");
        System.out.println("transfer -> Make a transfer between accounts by IBAN");
        System.out.println("view_customers -> View info of all customers");
        System.out.println("view_customer_accounts -> Get info for all the accounts of a customer by customer ID");
        System.out.println("view_account_info -> View info by customer ID");
        System.out.println("view_customer_statements -> View statements for a customer by ID");
    }


}
