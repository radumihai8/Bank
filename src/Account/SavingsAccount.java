package Account;

public class SavingsAccount extends Account{

    private float interest;

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
        System.out.println("Iban: " + this.iban);
        System.out.println("Balance: " + this.balance);
        System.out.println("Interest: " + this.interest);
        for (Card x : cardList)
            x.getCardInfo();

    }
}
