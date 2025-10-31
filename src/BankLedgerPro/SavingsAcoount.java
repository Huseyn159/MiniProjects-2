package BankLedgerPro;

public class SavingsAcoount extends BankAccount{
    private final boolean fixedTerm;

    public SavingsAcoount(String id, String ownerName, double balance, String currency, boolean fixedTerm) {
        super(id, ownerName, balance, currency);
        this.fixedTerm = fixedTerm;
    }

    public boolean isFixedTerm() {
        return fixedTerm;
    }

    @Override
    public void withdraw(double amount) {
        try {
            if (!isFixedTerm()) {
                double balance = getBalance();
                if (balance > amount) {

                    balance -= amount;
                    String currency = getCurrency();
                    System.out.println("-" + amount + " " + " " + currency);
                    System.out.println("Current balance: " + balance);
                } else {
                    throw new InsufficientFundsException(" ");
                }
            }
            else {
                throw new OperationNotAllowedException(" ");
            }
        }catch (OperationNotAllowedException e){
            System.out.println("Opearation not allowed!");
        }
        catch(InsufficientFundsException e){
            System.out.println("Insufficient balance.Please Top up and try again");
        }
    }

}
