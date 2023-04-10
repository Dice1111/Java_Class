package Lesson2;
import java.util.*;

public class EWalletMain {

    private static ArrayList<EWallet> eWallets;
    private static ArrayList<EWallet> eWalletsSortByBalance;
    private static ArrayList<EWallet> eWalletsSortBySerialNumber;
    public static void main(String[] args) {
        init();
        displayAll();
        System.out.println("Sorting:");
        sortBybalance();
        displayHighestAndLowestBalance();
        System.out.println("Sorting Serial:");
        sortBySerialNumber();
        System.out.println("Search:");
        searchBySerialNumberLinearSearch();
    }

    private static void searchBySerialNumberLinearSearch() {
        String serialNumberToSearch = "D432";
        boolean found = false;
        for(EWallet eWallet: eWallets){
            if(eWallet.getSerialNumber().equals(serialNumberToSearch)){
                eWallet.display();
                found = true;
                break;
            }
        }
        if(!found){
            System.out.println("Serial Number not found");
        }
    }

    private static void sortBySerialNumber(){
        eWalletsSortBySerialNumber=(ArrayList<EWallet>)eWallets.clone();
        boolean swap = true;
        while(swap){
            swap = false;
            for(int i=1;i<eWalletsSortBySerialNumber.size();i++){
                EWallet ew1 = eWalletsSortBySerialNumber.get(i-1);
                EWallet ew2 = eWalletsSortBySerialNumber.get(i);
                String serialNum1 = ew1.getSerialNumber();
                String serialNum2 = ew2.getSerialNumber();
                int n = serialNum1.compareTo(serialNum2);

                if(n>0){
                    eWalletsSortBySerialNumber.set(i-1,ew2);
                    eWalletsSortBySerialNumber.set(i,ew1);
                    swap = true;
                }
            }
        }
        for(EWallet eWallet: eWalletsSortBySerialNumber){
            eWallet.display();
        }
    }

    private static void displayHighestAndLowestBalance(){
        sortBybalance();
        EWallet highestBalance = eWalletsSortByBalance.get(eWalletsSortByBalance.size()-1);
        EWallet lowestBalance = eWalletsSortByBalance.get(0);
        System.out.println("\nLowest:");
        lowestBalance.display();
        System.out.println("Highest:");
        highestBalance.display();
    }

    public static void sortBybalance(){
        eWalletsSortByBalance=(ArrayList<EWallet>)eWallets.clone();
        boolean swap = true;
        while(swap){
            swap = false;
            for(int i=1;i<eWalletsSortByBalance.size();i++){
                EWallet ew1 = eWalletsSortByBalance.get(i-1);
                EWallet ew2 = eWalletsSortByBalance.get(i);
                if(ew1.getBalance()>ew2.getBalance()){
                    eWalletsSortByBalance.set(i-1,ew2);
                    eWalletsSortByBalance.set(i,ew1);
                    swap = true;
                }
            }
        }
        for(EWallet eWallet: eWalletsSortByBalance){
            eWallet.display();
        }
    }

    private static void init(){
        EWallet ew1 = new EWallet("T456",10,1000);
        EWallet ew2 = new EWallet("A432",14,1000);
        EWallet ew3 = new EWallet("C432",17,1000);
        EWallet ew4 = new EWallet("D432",1,1000);
        EWallet ew5 = new EWallet("B422",2,1000);

        eWallets = new ArrayList<EWallet>();
        eWallets.add(ew1);
        eWallets.add(ew2);
        eWallets.add(ew3);
        eWallets.add(ew4);
        eWallets.add(ew5);
        

    }

    public static void displayAll(){
        for(EWallet eWallet: eWallets){
            eWallet.display();
        }
    }

    private static void searchBySerialnumberBinarySearch() {
        String serialNumberToSearch = "D432";
        int index = binarySearchIndex(serialNumberToSearch);
        if(index != -1){
            eWalletsSortBySerialNumber.get(index).display();
        }else{
            System.out.println("Serial number not found");
        }
    }

    private static int binarySearchIndex(String serialNumberToSearch){
        int first = 0;
        int last = eWalletsSortBySerialNumber.size()-1;
        int mid = 0;

        while(first<=last){
            mid = first+(last-first)/2;
            EWallet ew = eWalletsSortBySerialNumber.get(mid);
            String serialNumber = ew.getSerialNumber();
            if (serialNumber.equals(serialNumberToSearch)){
                return mid;
            }else if(serialNumberToSearch.compareTo(serialNumber)<0){
                last = mid -1;
            }else{
                first = mid+1;
            }

        }
        return -1;
    }

}
