public class Account{
    public String name;
    public Money amount;

    public Account(String name,Money amount){
        this.name = name;
        this.amount = amount;
    }
    public String getName(){
        return name;
    }
    public void setName( String newName){
        this.name = newName;
    }
    public Money getMoney(){
        return amount;
    }
    public void setAmount( Money newAmount){
        this.amount = newAmount;
    }
}