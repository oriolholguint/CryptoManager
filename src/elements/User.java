package elements;

/**
 *
 * @author Oriol Holguin <oriolholguint@gmail.com>
 */
public class User 
{
    private String userName;
    private String password;
    private String email;
    
    public User(String usuario, String password, String email)
    {
        this.userName = usuario;
        this.password = password;
        this.email = email;
    }

    public String getUsuario() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setUsuario(String usuario) {
        this.userName = usuario;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
   
    
}