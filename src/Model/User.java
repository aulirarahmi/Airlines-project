package Model;

public class User {

    private String firstname;
    private String username;
    private String lasttname;
    private String email;
    private String password;
    private String role;
    
    
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getLasttname() {
        return lasttname;
    }
    public void setLasttname(String lasttname) {
        this.lasttname = lasttname;
    }
    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
   
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    
    public User(String firstname, String lasttname, String username, String email, String password, String role) {
        this.firstname = firstname;
        this.lasttname = lasttname;
        this.email = email;
        this.password = password;
        this.role = role;
        this.username = username;
        
    }
    
    
}

