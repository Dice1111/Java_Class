
package Lesson3;

public class Staff extends Person{

    private String school;
    private double pay;
    
    public Staff(String name, String address, String school, double pay) {
                super(name, address);
                this.school = school;
                this.pay = pay;
    }
    public String getSchool() {
        return this.school;
    }
    public void setSchool(String school) {
        this.school = school;
    }
    public double getPay() {
        return this.pay;
    }
    public void setPay(double pay) {
        this.pay = pay;
    }
    public String toString(){
        String s = "Staff["+super.toString()+",";
        s+="school="+this.school+",pay="+this.pay+"]";
        return s;
   }

   public static void main(String[] args) {
    Staff staff = new Staff("Peters", "BI","IT",5000);
    System.out.println(staff);
   }
}
