package Transaction;

import Account.Account;
import Customer.Customer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class DepositSingleton {
    private static DepositSingleton instance;

    FileWriter writer;

    private List<Deposit> DepositList = new ArrayList<Deposit>();
    private DepositSingleton(){}

    public static DepositSingleton getInstance(){
        if(instance==null)
            instance = new DepositSingleton();
        return instance;
    }

    private void initWriter(){
        try {
            this.writer = new FileWriter("csv/deposit.csv");
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }


    public void exportToCSV(String iban, Deposit deposit){
        try{
            writer.write(iban+","+deposit.toCSV());
            writer.write("\n");
            System.out.println("Deposit exported");
        }catch (IOException e){
            System.out.println(e.toString());
        }
    }

    public void readFromCSV(HashMap<String, Account> accounts){
        String line = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("csv/Deposit.csv"));
            while ((line = br.readLine()) != null)
            {
                String[] deposit = line.split(",");

                accounts.get(deposit[0]).Deposit(deposit[1],Double.parseDouble(deposit[2]));

            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        this.initWriter();
    }
}
