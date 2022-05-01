import Transaction.Deposit;
import Transaction.DepositSingleton;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AuditService {
    private static AuditService instance;
    FileWriter writer;

    public AuditService() {
        try {
            this.writer = new FileWriter("csv/audit.csv",true);
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    public static AuditService getInstance(){
        if(instance==null)
            instance = new AuditService();
        return instance;
    }



    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    Date date = new Date();

    public void log(String action) throws IOException {
        writer.append(action);
        writer.append(",");
        writer.append(formatter.format(date));
        writer.append("\n");
        writer.flush();
    }



}