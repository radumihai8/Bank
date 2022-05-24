package Account;



import Customer.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import Connection.*;

public class AccountDatabase {
    private static AccountDatabase instance;

    Connection conn;

    private List<Account> accounts = new ArrayList<Account>();

    public static AccountDatabase getInstance(){
        if(instance == null)
            instance = new AccountDatabase();
        return instance;
    }


    public AccountDatabase() {
        this.conn = ConnectionHandler.getInstance();
    }

    public void create(Integer customer_id, Account account) throws SQLException {
        String query = "INSERT INTO accounts (customer_id, iban, balance) VALUES(?,?,?)";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, customer_id);
        stmt.setString(2,account.getIban());
        stmt.setDouble(3,account.getBalance());
        stmt.execute();
        stmt.close();
    }

    public void update(Account account) throws SQLException {
        String query = "UPDATE accounts set balance = ? where iban = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setDouble(1, account.getBalance());
        stmt.setString(2,account.getIban());
        stmt.execute();
        stmt.close();
    }

    public HashMap<String, Account> read(List<Customer> customers){
        HashMap<String, Account> accountsMap = new HashMap<String, Account>();
        try{
            Statement stmt = conn.createStatement();
            ResultSet r = stmt.executeQuery("SELECT * FROM accounts");
            while(r.next()) {
                for(Customer x:customers)
                    if (x.getId()==r.getInt("customer_id")){
                        Account temp = new Account(r.getString("iban"), r.getDouble("balance"));
                        x.addAccount(temp);
                        accounts.add(temp);
                        accountsMap.put(temp.getIban(), temp);
                        break;
                    }
            }
            stmt.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }

        return accountsMap;

    }

    public void delete(Account account) throws SQLException {
        String query = "DELETE FROM accounts WHERE iban = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1,account.getIban());
        stmt.execute();
        stmt.close();
    }

    public boolean exists(Account account){
        return accounts.contains(account);
    }
}
