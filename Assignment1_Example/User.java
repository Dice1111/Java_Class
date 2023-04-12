package Assignment1_Example;
public class User {
    private String loginName;
    private String password; // plain password

    public User(String loginName, String password) {
        this.loginName = loginName;
        this.password = password;

    }

    public String getLoginName() {
        return loginName;
    }

    // should be done using HASH algo
    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }
}
