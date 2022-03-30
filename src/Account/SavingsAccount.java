package Account;

public class SavingsAccount extends Account{
    public float interest;

    public SavingsAccount(String iban, double balance, float interest) {
        super(iban, balance);
        this.interest = interest;
    }

    public SavingsAccount(float interest) {
        super();
        this.interest = interest;
    }

    public SavingsAccount() {
        super();
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public void getAccountInfo(){
        System.out.println(this.iban);
        System.out.println(this.balance);
        for (Card x : cardList)
            x.getCardInfo();

    }
}
