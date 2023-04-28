public class Student_Coursework extends Student{

    private Unit_Coursework unit;
    
    public Student_Coursework(String firstName, String lastName, String id) {
        super(firstName, lastName, id,"C");
    }
    
    public String getFinalGrade(){
    	//TODO: return the student final grade
        String finalGrade;
        try{
            
            finalGrade = unit.getFinalGrade();
            
        }catch(NullPointerException e) {
            finalGrade = "No unit attempt";
        }
        return finalGrade;
    }

    public void setUnit(Unit unit) {
        this.unit = (Unit_Coursework)unit;
    }
    
    public String getCSVString() {
    	return this.getId()+","+this.getFinalGrade();
    }

}
