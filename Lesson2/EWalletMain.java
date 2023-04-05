package Lesson2;

public class EWalletMain {
    public static void main(String[] args) {
        EWallet ew = new EWallet("A123",100,1000);
        ew.display();

        EWallet ew2 = new EWallet("B222",300);
        ew2.display();

        ew.topUp(-100);
        ew.topUp(100);
        ew.display();
        ew.topUp(10000);
        ew.deduct(10);
        ew.deduct(10000);

    }
}
