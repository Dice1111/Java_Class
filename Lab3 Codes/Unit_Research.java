public class Unit_Research extends Unit{
    
    private double proposal;
    private double finalDissertation;

    public Unit_Research(String studentID, double proposal, double finalDissertation) {
        super(studentID,"R");
        this.proposal = proposal;
        this.finalDissertation = finalDissertation;
    }
    
    public double getOverallMarks(){
    	//TODO: calculate research overall marks;
        return 0;
    }
    
    public String getFinalGrade(){
    	return Helper.computeCWGrade(getOverallMarks());
    }
    
    public String getCSVString() {
    	//TODO: return a string in the following format
    	//studentID,proposal,finalDissertation
    	return "studentID,proposal,finalDissertation";
    }
   
}
