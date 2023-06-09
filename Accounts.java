import java.util.ArrayList;
import java.util.List;

public class Accounts   {
    public static List <BaseAccounts>  list = new ArrayList<BaseAccounts>();
    public void addAll(List<CheckingAccount> account){
        for (CheckingAccount e: account){
            list.add(e);
        }
    }
    public void addAll(List<SavingsAccount> account){
        for (SavingsAccount e: account){
            list.add(e);
        }
    }
    public static CheckingAccount findAccountByNumber (String accountNumber){
        if (list == null){
            return null;
        }
        for ( BaseAccounts account : list ){
            if (accountNumber.equals(account.getName())){
                return (CheckingAccount)account;
            }
        }

        return null;

    }
    public static boolean containsUser (String name){
        if (list == null){
            return false;
        }
        for (BaseAccounts n : list){
            if (name.equals(n.getName())){
                return true;
            }
        }

        return false;

    }
    
}

