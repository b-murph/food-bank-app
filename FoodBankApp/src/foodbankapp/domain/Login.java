/*
 * Version 1.0
 * CS 444
 * 9/15/18
 */
package foodbankapp.domain;

/**
 * this implements the login class for the food bank app project
 * @author Brian
 */
public class Login {
    
    private String username = "";
    private String password = "";
    
    public String getUsername(){
        return username;
    }
    
    public void setUsername(String username){
        this.username = username;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public boolean validate(){
        if (username == null||username.equals("")) return false;
        if (password == null||password.equals("")) return false;
        return true;
    }
    
    @Override
    public boolean equals(Object obj){
        if (obj == null) return false;
        if (!(obj instanceof Login)) return false;
        Login login = (Login)obj;
        if (!this.username.equals(login.getUsername())) return false;
        if (!this.password.equals(login.getPassword())) return false;
        return true;
    }
}
