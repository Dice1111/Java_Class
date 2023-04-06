package Lesson2;
import java.util.*;

public class EWalletMain {

    private static ArrayList<EWallet> eWallets;
    public static void main(String[] args) {
        init();
    }

    public static void sortBybalance(){
        eWalletsSortBybalance =(ArrayList<EWallet)eWallets.clone();
    }

    private static void init(){
        EWallet ew1 = new EWallet("A123",10,1000);
        EWallet ew2 = new EWallet("A123",14,1000);
        EWallet ew3 = new EWallet("A123",17,1000);
        EWallet ew4 = new EWallet("A123",1,1000);
        EWallet ew5 = new EWallet("A123",2,1000);

        eWallets = new ArrayList<EWallet>();
        eWallets.add(ew1);
        eWallets.add(ew2);
        eWallets.add(ew3);
        eWallets.add(ew4);
        eWallets.add(ew5);

    }

    private static 
}
