abstract public class Student {
    
    private String firstName;
    private String lastName;
    private String id;
    private String enrolmentType;

    public Student(String firstName, String lastName, String id,String enrolmentType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.enrolmentType = enrolmentType;
    }

    // public void display(){
    //     System.out.println("student id: "+this.id);
    //     System.out.println("first name: "+this.firstName);
    //     System.out.println("last name: "+this.lastName);
    //     System.out.println("enrolement: "+this.enrolmentType);
    // }
   
    public String getEnrolmentType() {
        return this.enrolmentType;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getId() {
        return this.id;
    }
    
    public boolean equals(String id){
    	return this.id.equals(id);
    }

    public boolean equals(Student student){
    	return this.id.equals(student.getId());
    }
    
    public boolean studentIDMoreThan(Student student){
    	int n = this.id.compareTo(student.getId());
    	if(n>0) {
    		return true;
    	}else {
    		return false;
    	}
    }
    
    public String toString() {
    	return this.id;
    }
    
    abstract public String getFinalGrade();
    
    abstract public void setUnit(Unit unit);
    
    abstract public String getCSVString();

}
