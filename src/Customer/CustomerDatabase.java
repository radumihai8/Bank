package Customer;

import Account.Card;
import Account.CardDatabase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Connection.*;

public class CustomerDatabase {
    private static CustomerDatabase instance;

    Connection conn;

    private List<Customer> customerList = new ArrayList<Customer>();


    public CustomerDatabase() {
        conn = ConnectionHandler.getInstance();
    }

    public static CustomerDatabase getInstance(){
        if(instance == null)
            instance = new CustomerDatabase();
        return instance;
    }

    public void create(Customer customer) throws SQLException {
        String query = "INSERT INTO customers (id, firstName, lastName, age, phone, city, street, streetNo, zipCode) VALUES(?,?,?,?,?,?,?,?,?)";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, customer.getId());
        stmt.setString(2,customer.getFirstName());
        stmt.setString(3,customer.getLastName());
        stmt.setInt(4,customer.getAge());
        stmt.setString(5, String.valueOf(customer.getPhone()));
        stmt.setString(6,customer.getAddress().getCity());
        stmt.setString(7,customer.getAddress().getStreet());
        stmt.setInt(8,customer.getAddress().getStreetNo());
        stmt.setInt(9,customer.getAddress().getZipCode());
        stmt.execute();
        stmt.close();
    }

    public void update(Customer customer) throws SQLException {
        String query = "UPDATE customers set firstName = ?, lastName= ?, age= ?, phone= ?, city= ?, street= ?, streetNo= ?, zipCode = ? WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1,customer.getFirstName());
        stmt.setString(2,customer.getLastName());
        stmt.setInt(3,customer.getAge());
        stmt.setString(4, String.valueOf(customer.getPhone()));
        stmt.setString(5,customer.getAddress().getCity());
        stmt.setString(6,customer.getAddress().getStreet());
        stmt.setInt(7,customer.getAddress().getStreetNo());
        stmt.setInt(8,customer.getAddress().getZipCode());
        stmt.setInt(9, customer.getId());
        stmt.execute();
        stmt.close();
    }

    public List<Customer> read(){

        try{
            Statement stmt = conn.createStatement();
            ResultSet r = stmt.executeQuery("SELECT * FROM customers");
            while(r.next()) {
                customerList.add(new Customer(r.getInt("id"), r.getString("firstName"),
                        r.getString("lastName"), r.getInt("age"),
                        Long.parseLong(r.getString("phone")), r.getString("city"), r.getString("street"),
                        r.getInt("streetNo"), r.getInt("zipCode")));


            }
            stmt.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }

        return customerList;

    }

    public void delete(Customer customer) throws SQLException {

        String query = "DELETE from customers WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, customer.getId());
        stmt.execute();
        stmt.close();
    }

    public boolean exists(Customer customer){
        return customerList.contains(customer);
    }



}
