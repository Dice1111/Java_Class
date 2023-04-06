
public class Android {

	//declare your variables here
	private static int tag =1;
	private String name;

	public Android() {
		//fill in your codes
		
		this.name = "Bob"+String.valueOf(tag);
	}
	
	public String getName() {
		//fill in your codes
		changeTag();
		return name;
	}
	public int getTag(){
		return tag;
	}
	
	public static void changeTag() {
		//fill in your codes
		tag++;
		
		for(int i=2;i<tag;i++){
			if(i!=tag && tag%i==0){	
				changeTag();
			}else if(i == tag){
				continue;
			}
		}
	}


	
}
