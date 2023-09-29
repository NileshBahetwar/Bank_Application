public interface BankAccountInterface {
   String fetchBalance(String Password);
    String addMoney(double amount);
    String withDrawMoney(String password,double amount);
    String changePassword(String oldPassword,String newPassword);
    double reteOfInterest(int year);
}
