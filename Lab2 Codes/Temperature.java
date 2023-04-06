
public class Temperature {

	//declare your variables here
	private double degree;
	private char scale;

	public Temperature(double degree, char scale) {
		//fill in your codes
		this.degree = degree;
		this.scale = scale;
	}

	public Temperature(double degree) {
		//fill in your codes
		this.degree = degree;
	}

	public Temperature(char scale) {
		//fill in your codes
		this.scale = scale;
	}

	public Temperature() {
		//fill in your codes
		this.degree = 0;
		this.scale = 'C';
		
	}

	public double getCelsius() {
		//fill in your codes
		if(scale == 'F'){
			double celcius = roundOff((degree-32)*5/9);
			return celcius;
		}else if(scale == 'C'){
			return degree;
		}
		return 0;
	}

	public double getFahrenheit() {
		//fill in your codes
		if(scale == 'C'){
			double fahrenheit = roundOff((degree*9/5)+32);
			return fahrenheit;
		}else if(scale == 'F'){
			return degree;
		}
		return 0;
	}

	public void setScale(char scale) {
		//fill in your codes
		this.scale = scale;
	}

	public void setDegree(double degree) {
		//fill in your codes
		this.degree = degree;
	}

	public void setDegreeScale(double degree, char scale) {
		//fill in your codes
		this.degree = degree;
		this.scale = scale;
	}
	
	//use this method to roundoff to 2 dec places
	private double roundOff(double a) {
		return Math.round(a * 100.0) / 100.0;
	}

	
}
