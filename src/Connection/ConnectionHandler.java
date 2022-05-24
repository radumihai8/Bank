package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHandler {
    private static ConnectionHandler instance;
    private static Connection conn = null;

    public static Connection getInstance(){
        if(instance==null)
            instance = new ConnectionHandler();
        return conn;
    }

    public ConnectionHandler() {
        try{
            String url = "jdbc:mysql://localhost:3306/pao";
            String user = "root";
            String password = "1234";

            conn = DriverManager.getConnection(url, user, password);
        }catch (SQLException e){
            System.out.println(e.toString());
        }
    }
}
