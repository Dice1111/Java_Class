package Lesson3;

public class Student extends Person {
    private String program;
    private int year;
    private double fees;

    public Student(String name, String address,String program, int year, double fees) { 
        super(name,address);
        this.program =program;
        this.year = year;
        this.fees = fees;
    }
    public String getProgram() {
        return this.program;
    }
    public void setProgram(String program) {
        this.program= program;
    }
    public int getYear() {
        return this.year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public double getFees() {
        return this.fees;
    }
    public void setFees(double fees) {
        this.fees = fees;
    }
    public String toString(){
        String s = "Student["+ super.toString()+",program="+this.program+",";
        s+="year="+this.year+",fees ="+this.fees+"]";
        return s;
    }
    public static void main(String[] args) {
        
        Student student = new Student("john", "BT","CS",1,30000);
        System.out.println(student);
    }
}
