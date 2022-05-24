import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import Connection.*;

public class AuditService {
    private static AuditService instance;

    Connection conn;

    public AuditService() {
        this.conn = ConnectionHandler.getInstance();
    }

    public static AuditService getInstance(){
        if(instance==null)
            instance = new AuditService();
        return instance;
    }



    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.ENGLISH);
    Date date = new Date();

//    public void log(String action) throws IOException {
//        writer.append(action);
//        writer.append(",");
//        writer.append(formatter.format(date));
//        writer.append("\n");
//        writer.flush();
//    }

    public void log(String action) throws SQLException {
        String query = "INSERT INTO audit (action, date) VALUES(?,?)";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, action);
        stmt.setString(2, formatter.format(date));

        stmt.execute();
        stmt.close();
    }



}