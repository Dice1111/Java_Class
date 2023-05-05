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

    public void  setHashPassword(String loginPassword){
        this.hashLoginPassword=loginPassword;
    }


}