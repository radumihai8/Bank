import Customer.*;
import Account.*;
import Transaction.Deposit;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BankService bankService = BankService.getInstance();
        boolean run = false;
        System.out.println("Use the help command to view informations about all the commands");
        while (!run){

            System.out.println("Insert command:");
            String command = in.nextLine();

            switch (command) {
                case "create_customer" -> bankService.createCustomer();
                case "create_account" -> bankService.createAccount();
                case "create_card" -> bankService.createCard();
                case "deposit" -> bankService.deposit();
                case "withdraw" -> bankService.withdraw();
                case "transfer" -> bankService.transfer();
                case "view_customers" -> bankService.viewCustomers();
                case "view_customer_accounts" -> bankService.viewCustomerAccounts();
                case "view_account_info" -> bankService.getCustomerAccountInfo();
                case "view_customer_statements" -> bankService.getCustomerStatement();
                case "help" -> bankService.help();
                case "exit" -> run = true;
            }
        }

        System.out.println("End");
    }
}
