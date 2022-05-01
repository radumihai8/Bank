package Account;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Random;

import java.util.Date;

public class Card {
    private String number;
    private final int cvv;
    private final Date expire_date;

    public Card(){
        Random rand = new Random();
        number = "";
        for (int i = 0; i<4; i++) {
            int n = rand.nextInt(1000,9999);
            if(i==0)
                number = number +Integer.toString(n);
            else
                number = number + " " +Integer.toString(n);
        }
        cvv = rand.nextInt(100,999);

        expire_date = new Date();
    }

    public Card(String number, int cvv, String date) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
        this.number = number;
        this.cvv = cvv;
        this.expire_date = formatter.parse(date);
    }

    public void getCardInfo(){
        System.out.println("Card number: " + number + " CVV:" + cvv + " Exp. Date: " + expire_date);
    }

    public String toCSV(){
        return number+","+cvv+","+expire_date;
    }

    public Date getExpire_date(){
        return this.expire_date;
    }
}
