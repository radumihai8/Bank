package Transaction;


import Account.Account;
import Customer.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import Connection.*;



public class DepositDatabase {
    private static DepositDatabase instance;

    Connection conn;

    private List<Deposit> depositList = new ArrayList<Deposit>();


    public static DepositDatabase getInstance(){
        if(instance==null)
            instance = new DepositDatabase();
        return instance;
    }


    public DepositDatabase() {
        this.conn = ConnectionHandler.getInstance();
    }

    public void create(String iban, Deposit deposit) throws SQLException {
        String query = "INSERT IGNORE INTO deposits (iban, location, sum) VALUES(?,?,?)";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, iban);
        stmt.setString(2,deposit.getLocation());
        stmt.setDouble(3,deposit.getSum());
        stmt.execute();
        stmt.close();
    }

    public void update(Deposit deposit) throws SQLException {
        String query = "UPDATE deposits set location = ?, sum = ? where id = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1,deposit.getLocation());
        stmt.setDouble(2,deposit.getSum());
        stmt.setDouble(3,deposit.getId());
        stmt.execute();
        stmt.close();
    }

    public void read(HashMap<String, Account> accounts){
        try{
            Statement stmt = conn.createStatement();
            ResultSet r = stmt.executeQuery("SELECT * FROM deposits");
            while(r.next()) {
                Deposit temp = new Deposit(accounts.get(r.getString("iban")), r.getString("location"),r.getDouble("sum"), r.getInt("id"));
                accounts.get(r.getString("iban")).Deposit(temp);
                depositList.add(temp);
            }
            stmt.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }

    }

    public void delete(Deposit deposit) throws SQLException {
        String query = "DELETE from deposits where id = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setDouble(1,deposit.getId());
        stmt.execute();
        stmt.close();
    }


    public boolean exists(Deposit deposit){
        return depositList.contains(deposit);
    }



}
