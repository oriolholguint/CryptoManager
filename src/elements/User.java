package elements;

/**
 *
 * @author Oriol Holguin <oriolholguint@gmail.com>
 */
public class User 
{
    private String usuario;
    private String password;
      
    public User(String usuario, String password)
    {
        this.usuario = usuario;
        this.password = password;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setPassword(String password) {
        this.password = password;
    }
   
}