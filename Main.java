public class Main {
    public static void main(String[] args) {

       HDFCAccount nilesh=new HDFCAccount("Nilesh","nilesh@231098",2000000);
        //System.out.println(nilesh);

        // 1.fetching balance
        System.out.println(nilesh.fetchBalance("nilu@231098")); // wrong password
        System.out.println(nilesh.fetchBalance("nilesh@231098")); // correct password
        System.out.println();


//        // 2.adding money into account
        System.out.println(nilesh.addMoney(100000));
        System.out.println();
//
//        // 3.withDrawing money
        System.out.println(nilesh.withDrawMoney("niles@2310",100000)); // trying with wrong pass
        System.out.println(nilesh.withDrawMoney("nilesh@231098",3000000)); // correct pass bt more
//        // money trying to withdraw
        System.out.println(nilesh.withDrawMoney("nilesh@231098",1000000)); // correct pass with less
//        // money
        System.out.println();

        // 4. changing password
        System.out.println(nilesh.changePassword("niles@325","Nilesh@231098")); // try to update with wrong pass
        System.out.println(nilesh.changePassword("nilesh@231098","Nilesh@231098")); // try to update with correct pass
        System.out.println();

        // 5. rate of interest
        System.out.println(nilesh.reteOfInterest(8));
        System.out.println();
        // fetching balance using changed password
        System.out.println(nilesh.fetchBalance("Nilesh@231098"));
    }
}