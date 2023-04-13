package Assignment1_Example;
public class Example {
    public static void main(String[] args) {
        Example example = new Example();

        boolean ans = true;
        while(ans){
            System.out.println("banana");
            
            ans = example.run();
            if(ans == false){
                break;
            }

            System.out.println("mango");
        }   
    }

    public boolean run(){
        boolean a= false;
        return a;   
    }
}
