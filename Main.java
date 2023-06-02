public class Main {
    public static void main(String[] args) throws BusinessException{
        List<CheckingAccount> checkingAccounts = new ArrayList<>(); 
        List<SavingsAccount> savingsAccounts = new ArrayList<>();
        CheckingAccount checkingAccount = new CheckingAccount("Arnaud"); 
        checkingAccounts.add(checkingAccount);
        SavingsAccount savingsAccount = new SavingsAccount (checkingAccount, "Arnaud"); 
        savingsAccounts.add(savingsAccount);
        Accounts.addA11 (savingsAccounts);
        Accounts.addAl1 (checkingAccounts);
    }
}