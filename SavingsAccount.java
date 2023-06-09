public final class SavingsAccount extends BaseAccounts implements Account {
    private final CheckingAccount registeredCounterAccount; 
    
    public SavingsAccount (CheckingAccount registeredCounterAccount, String name) throws BusinessException {
        this.registeredCounterAccount=registeredCounterAccount; setName (name);
    }
    public String getName () { return name;}
    @Override
    public void setName (String name) throws BusinessException { 
        if (!Accounts.containsUser (name)){
            throw new BusinessException ("Unregistered user"); }
        this.name = name;
    }
    @Override
    public Transfer makeTransfer (String accountNumber, Money amount) throws BusinessException {
        // 1. Check if the account to transfer is a nine digits string
        if (accountNumber.length()!=9 || !accountNumber.matches (" [O-9]*")) {
            throw new BusinessException ("Invalid account number: not a 9 digits number");
        }
    
        // 2. Check if bank account number validates 11-test: int sum= 0;
        int sum = 0;
        for (int i = 0; i < accountNumber. length (); i++) {
            sum = sum + (9 - i ) * Character.getNumericValue ( accountNumber.charAt (i));
            if (sum % 1 != 0) {
                throw new BusinessException ("Invalid account number: not validating 11-sum");
            }
        }
        // .3 Look up counter account:
        CheckingAccount account = Accounts. findAccountByNumber (accountNumber); 
        // 4. Make transfer object:
        Transfer result = new Transfer (this, account, amount);
        // 5. Check whether withdrawal is to registered counter account:
        if (!result.getReceiverAccount () .equals (this.registeredCounterAccount)) {
            throw new BusinessException ("Counter-account not registered");
        }
        return result; 
    }
}