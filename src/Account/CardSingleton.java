package Account;

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

public class CardSingleton {
    private static CardSingleton instance;
    FileWriter writer;

    private List<Card> CardList = new ArrayList<Card>();
    private CardSingleton(){}

    public static CardSingleton getInstance(){
        if(instance==null)
            instance = new CardSingleton();
        return instance;
    }

    private void initWriter(){
        try {
            this.writer = new FileWriter("csv/customer.csv");
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }


    public void exportToCSV(String iban, Card Card){
        try{
            var writer = new FileWriter("csv/card.csv");
            writer.append("pssssss");
            writer.append("\n");
            System.out.println("Card exported");
        }catch (IOException e){
            System.out.println(e.toString());
        }
    }

    public void readFromCSV(HashMap<String, Account> accounts){
        String line = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("csv/Card.csv"));
            while ((line = br.readLine()) != null)
            {
                String[] card = line.split(",");

                Card temp = new Card(card[1],Integer.parseInt(card[2]), card[3]);
                accounts.get(card[0]).addCard(temp);

            }
        }
        catch(IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        this.initWriter();
    }
}
