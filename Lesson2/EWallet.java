package Lesson2;

public class EWallet {
    private String serialNumber;
    private double balance;
    private double maxAmount;

    public EWallet(String serialNumber, double balance, double maxAmount){
        this.serialNumber = serialNumber;
        this.balance = balance;
        this.maxAmount = maxAmount;
    }
    public EWallet(String serialNumber,double maxAmount){
        this.serialNumber = serialNumber;
        this.maxAmount = maxAmount;
        this.balance =0;
    }

    private boolean canTopUp(double amount) {
        boolean canTopUp = false;
        
        if(amount+this.balance<=this.maxAmount){
            canTopUp = true;
        }
        return canTopUp;
    }

    public void topUp(double amount){
        if(amount<=0){
            System.out.println("Fall top up - amount must be >0");
        }
        else if(canTopUp(amount)){
            this.balance+=amount;
            System.out.println("Succes top up $"+amount);
        }else{
            System.out.println("Fail top up - exceed max amount");
        }
    }

    public void deduct(double amount){
        if (amount<=0){
            System.out.println("Fail deduct - amount must be> 0");
        }else if(this.balance>=amount){
            this.balance-=amount;
            System.out.println("Success deduct $"+amount);
            System.out.println("New balance $"+this.balance);
        }else{
            System.out.println("Fail deduct - insufficient amount");
        }
    }

    public boolean equals(EWallet ew){
        boolean equals = false;
        if(this.serialNumber.equals(ew.getSerialNumber())){
            if(this.balance==ew.getBalance()){
                equals = true;
            }
        }

        return equals;
    }

    public void display(){
        System.out.println("Serial Number: "+this.serialNumber);
        System.out.println("Balance:$"+this.balance);
        System.out.println("Max Amount:$"+this.maxAmount);
    }

    public boolean isEmpty(){
        boolean isEmpty = true;
        if(balance>0){
            isEmpty = false;
        }return isEmpty;
    }

    public double getBalance(){
        return this.balance;
    }

    public String getSerialNumber(){
        return this.serialNumber;
    }
}
