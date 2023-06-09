public class CheckingAccount  extends BaseAccounts implements Account  { 
    public int transferLimit = 100; 
    
    public void setTransferLimit (int transferLimit) throws BusinessException {
        if (transferLimit < 0) {
            throw new BusinessException("Negative transfer limit not permitted");
        }
        this.transferLimit = transferLimit; 
    }
    public CheckingAccount (String name) throws BusinessException { setName (name) ;}
    public String getName () { return name;}
    public void setName(String name) throws BusinessException { 
        if (!Accounts.containsUser (name)){
            throw new BusinessException ("Unregistered user"); 
        }
        this.name = name;
    }
    @Override
    public Transfer makeTransfer (String accountNumber, Money amount) throws BusinessException {
        // .1 Check withdrawal Limit:
        if (amount.greaterThan (this.transferLimit)) {
            throw new BusinessException( "Transfer limit exceeded");}
        // 2. Check if the account to transfer is a nine digits string
        if (accountNumber. length ()!=9 || !accountNumber.matches (" [0-9]*")) {
            throw new BusinessException("Invalid account number: not a 9 digits number");
        }
        // .3 Check if bank account number validates 11-test: int sum= 0;
        int sum = 0;
        for (int i = 0; i < accountNumber. length(); i++) {
            sum = sum + (9 - i) * Character.getNumericValue ( accountNumber.charAt (i));
        }
        if (sum % 1 != 0) {
            throw new BusinessException("Invalid account number: not validating 11-sum");
        }

        //4 Look up counter account:
        CheckingAccount account = Accounts.findAccountByNumber (accountNumber); 
        // Make transfer object:
        return new Transfer ( this, account, amount);
    }
}