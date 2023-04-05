package Lesson2;

public class EWalletMain {
    public static void main(String[] args) {
        EWallet ew1 = new EWallet("A123",100,1000);
        EWallet ew2 = new EWallet("A123",100,1000);
        System.out.println(ew1==ew2);
        System.out.println(ew1.equals(ew2));


    }
}
