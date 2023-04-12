
abstract class User {
    private String loginName;
    private String loginPassword;
    
    public User(String loginName, String loginPassword){
        this.loginName = loginName;
        this.loginPassword = loginPassword;
    }
   
    public String getLoginName(){
        return loginName;
    }

    public boolean checkName(String loginName){
        return this.loginName.equals(loginName);
    }

    public boolean checkPassword(String loginPassword){
        return this.loginPassword.equals(loginPassword);
    }

    public void userLoginName(Player player){
    
        String loginName = Keyboard.readString("Please Enter Your Name:");
        if(!checkName(loginName)){
            System.out.println("Wrong Name.Please enter your name again!\n");
            userLoginName(player);
        }else{
            userLoginPassword(player);
        }
    }

    public void userLoginPassword(Player player){
        
        System.out.println("Hello"+player.getLoginName());
        String loginpassword = Keyboard.readString("Please Enter Your Password:");
        if(!checkPassword(loginpassword)){
            System.out.println("Wrong password.Please enter your password again!\n");
            userLoginPassword(player);
        }else{
            System.out.println("Login successful.");
        }
    }
}