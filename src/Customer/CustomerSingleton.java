package Customer;

import Account.Account;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomerSingleton {
    private static CustomerSingleton instance;

    FileWriter writer;

    private List<Customer> customers = new ArrayList<Customer>();
    private CustomerSingleton(){};

    private void initWriter(){
        try {
            this.writer = new FileWriter("csv/customer.csv");
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    public static CustomerSingleton getInstance(){
        if(instance==null)
            instance = new CustomerSingleton();
        return instance;
    }

    public void exportToCSV(Customer customer){
        try{
            writer.append(customer.toCSV());
            writer.append("\n");
            writer.flush();
            System.out.println("Customer exported");
        }catch (IOException e){
            System.out.println(e.toString());
        }
    }

    public List<Customer> readFromCSV(){
        String line = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("csv/customer.csv"));
            while ((line = br.readLine()) != null)
            {
                String[] customer = line.split(",");
                customers.add(new Customer(Integer.parseInt(customer[0]),customer[5],customer[6],Integer.parseInt(customer[7]), Integer.parseInt(customer[8]),customer[1],customer[2], Integer.parseInt(customer[3]), Integer.parseInt(customer[4])));
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        //Dupa ce s-a citit initializam writer-ul, atunci se sterg datele din fisier
        this.initWriter();
        return customers;
    }
}
