public class Money{
    public double balance;
    public String unit;

    public Money(double balance,String unit){
        this.balance = balance;
        this.unit = unit;
    }
    public double getBalance(){
        return balance;
    }
    public void setBalance( double newBalance){
        this.balance = newBalance;
    }
    public String getUnit(){
        return unit;
    }
    public void setUnit(String newUnit){
        this.unit = newUnit;
    }
}