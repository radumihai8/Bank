import Customer.*;
import Account.*;
import Transaction.Deposit;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        BankService bankService = BankService.getInstance();
        AuditService auditService = AuditService.getInstance();
        bankService.readData();
        boolean run = true;
        System.out.println("Use the help command to view informations about all the commands");
        while (run){

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
                case "view_account_info" -> bankService.getAccountInfo();
                case "view_customer_statements" -> bankService.getCustomerStatement();
                case "help" -> bankService.help();
                case "exit" -> run = false;
            }
            auditService.log(command);

        }

        bankService.saveData();
        System.out.println("End");
    }
}
