import java.util.UUID;

public class SBIAccount implements BankAccountInterface{
    private String name;

    private String password;

    private double balance;

    private String accountNumber;

    final String IFSCCode="SBI-AC12213443";

    final double rateOfInterest=3.5;

    public SBIAccount() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getIFSCCode() {
        return IFSCCode;
    }

    public double getRateOfInterest() {
        return rateOfInterest;
    }

    public SBIAccount(String name, String password, double balance) {
        this.name = name;
        this.password = password;
        this.balance = balance;
        this.accountNumber= String.valueOf(UUID.randomUUID());
    }

    @Override
    public String fetchBalance(String password) {
        if(this.password.equals(password)){
            return "Your available balance is: "+this.balance;
        }
        return "Incorrect password";
    }

    @Override
    public String addMoney(double amount) {
        this.balance+=amount;
        return amount+"rs added , now your updated balance is: "+this.balance;
    }

    @Override
    public String withDrawMoney(String password, double amount) {
        if(this.password.equals(password)){
            if(this.balance<amount){
                return "Insufficient balance ...";
            }


            if(this.balance-amount<=100.0){
                this.balance+=amount;
                return "your balance cant be less than 100 rs..!!";
            }
            this.balance-=amount;
            return amount+"rs deducted from your account, now your remaining balance is: "+this.balance;
        }
        return "wrong password !!";
    }

    @Override
    public String changePassword(String oldPassword, String newPassword) {
        if(this.password.equals(oldPassword)){
            this.password=newPassword;
            return "Password updated successfully your updated password is: "+this.password;
        }
        return "wrong password..!!";
    }

    @Override
    public double reteOfInterest(int year) {
        return (this.balance*year*rateOfInterest)/100.0;
    }
}
