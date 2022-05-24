package Account;

import Account.Account;
import Account.Card;
import Customer.Customer;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import Connection.*;

public class CardDatabase {
    private static CardDatabase instance;

    Connection conn;


    private List<Card> cardList = new ArrayList<Card>();

    public static CardDatabase getInstance(){
        if(instance == null)
            instance = new CardDatabase();
        return instance;
    }


    public CardDatabase() {
        this.conn = ConnectionHandler.getInstance();
    }

    public void create(String iban, Card card) throws SQLException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.ENGLISH);
        String query = "INSERT INTO cards (iban, number, cvv, expire_date) VALUES(?,?,?,?)";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, iban);
        stmt.setString(2,card.getNumber());
        stmt.setDouble(3,card.getCvv());
        stmt.setString(4, formatter.format(card.getExpire_date()));
        stmt.execute();
        stmt.close();
    }

    public void update(Card card) throws SQLException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.ENGLISH);

        String query = "UPDATE cards set expire_date = ?, cvv = ? where number = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, formatter.format(card.getExpire_date()));
        stmt.setInt(2, card.getCvv());
        stmt.setString(3, card.getNumber());
        stmt.execute();
        stmt.close();
    }

    public void read(HashMap<String, Account> accounts){
        HashMap<String, Account> accountsMap = new HashMap<String, Account>();
        try{
            Statement stmt = conn.createStatement();
            ResultSet r = stmt.executeQuery("SELECT * FROM cards");
            while(r.next()) {
                Card temp =  new Card(r.getString("number"), r.getInt("cvv"), r.getString("expire_date"));
                accounts.get(r.getString("iban")).addCard(temp);
                cardList.add(temp);
            }
            stmt.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }


    }

    public void delete(Card card) throws SQLException {

        String query = "DELETE from cards WHERE number = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, card.getNumber());
        stmt.execute();
        stmt.close();
    }

    public boolean exists(Card card){
        return cardList.contains(card);
    }
}
