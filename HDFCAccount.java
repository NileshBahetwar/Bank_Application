import java.util.UUID;

public class HDFCAccount implements BankAccountInterface{
    private String name;
    private String password;
    private double balance;
    private String accountNumber;  // unique
    final String IFSCCode="HDFC12345";
    final double rateOfInterest=7.1;

    public HDFCAccount() {
    }

    public HDFCAccount(String name, String password, double balance) {
        this.name = name;
        this.password = password;
        this.balance = balance;
        this.accountNumber= String.valueOf(UUID.randomUUID());  // universely unique identifier
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

    @Override
    public String fetchBalance(String Password) {
        if(this.password.equals(Password)){
            return "Your Current Balence is: "+this.balance;
        }
        return "Incorrect Password!!!";
    }

    @Override
    public String addMoney(double amount) {
        this.balance+=amount;
        return "You have added "+amount+"rs, now your updated balance is: "+this.balance;
    }

    @Override
    public String withDrawMoney(String password, double amount) {
        if(this.password.equals(password)){
            if(this.balance<amount){
                return "Insufficient balance";
            }
            this.balance-=amount;
            return "you have withdraw "+amount+"rs, now your remaining balance is: "+this.balance;
        }
        return "Incorrect password please enter correct password.";
    }

    @Override
    public String changePassword(String oldPassword, String newPassword) {
        if(this.password.equals(oldPassword)){
            this.password=newPassword;
            return "password updated successfully!!!! , Your updated password is: "+this.password;
        }
        return "you have entered wrong password";
    }

    @Override
    public double reteOfInterest(int year) {
        return (this.balance*year*rateOfInterest)/100.0;
    }

    @Override
    public String toString() {
        return "HDFCAccount{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", balence=" + balance +
                ", accountNumber='" + accountNumber + '\'' +
                ", IFSCCode='" + IFSCCode + '\'' +
                ", rateOfInterest=" + rateOfInterest +
                '}';
    }
}
