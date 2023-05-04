import java.io.Serializable;
abstract class User implements Serializable {
    private String loginName;
    private String hashLoginPassword;
    
    public User(String loginName, String loginPassword){
        this.loginName = loginName;
        this.hashLoginPassword = Utility.getHash(loginPassword);
    }
   
    public String getLoginName(){
        return this.loginName;
    }

    public String getHashPassword(){
        return this.hashLoginPassword;
    }

    public boolean checkName(String loginName){
        return this.loginName.equals(loginName);
    }

    public boolean checkPassword(String loginPassword){
        return this.hashLoginPassword.equals(Utility.getHash(loginPassword));
    }

    public void userLoginName(Player player){
    
        String loginName = Keyboard.readString("Please Enter Your Name:");
        if(!checkName(loginName)){
            System.out.println("Player not found! Please enter your name again!\n");
            userLoginName(player);
        }else{
            System.out.println("Hello "+player.getLoginName()+"!");
            userLoginPassword(player);
        }
    }

    public void userLoginPassword(Player player){
        
        String loginpassword = Keyboard.readString("Please Enter Your Password:");
        if(!checkPassword(loginpassword)){
            System.out.println("Wrong password.Please enter your password again!\n");
            userLoginPassword(player);
        }else{
            System.out.println("Login successful.");
        }
    }
}