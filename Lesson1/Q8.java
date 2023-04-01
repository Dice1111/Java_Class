package Lesson1;

public class Q8 {
    public static void main(String[] args) {
        int monthNum =3;
        String[] months ={"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};

        if (monthNum>=1 || monthNum<=12){
            System.out.println(months[monthNum-1]);
        }else{
            System.out.println("No month");
        }
    }
}
