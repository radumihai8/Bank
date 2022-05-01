package Account;

import Customer.Customer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AccountSingleton {
    private static AccountSingleton instance;

    FileWriter writer;

    private List<Account> accountList = new ArrayList<Account>();
    private AccountSingleton(){

    }

    public void close() throws IOException {
        writer.close();
    }

    private void initWriter(){
        try {
            this.writer = new FileWriter("csv/account.csv");
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    public static AccountSingleton getInstance(){
        if(instance==null)
            instance = new AccountSingleton();
        return instance;
    }


    public void exportToCSV(int cid, Account account){
        try{
            writer.write(cid+","+account.toCSV());
            writer.write("\n");
            System.out.println("Account exported");
        }catch (IOException e){
            System.out.println(e.toString());
        }
    }

    public HashMap<String, Account> readFromCSV(List<Customer> customers){
        String line = "";
        HashMap<String, Account> accountsMap = new HashMap<String, Account>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("csv/account.csv"));
            while ((line = br.readLine()) != null)
            {
                String[] account = line.split(",");
                for(Customer x:customers)
                    if (x.getId()==Integer.parseInt(account[0])) {
                        Account temp = new Account(account[1], Double.parseDouble(account[2]));
                        x.addAccount(temp);
                        accountsMap.put(temp.getIban(), temp);
                        break;
                    }
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        this.initWriter();

        return accountsMap;
    }
}
