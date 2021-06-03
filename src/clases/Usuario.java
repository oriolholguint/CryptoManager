package clases;

/**
 *
 * @author Oriol Holguin <oriolholguint@gmail.com>
 */
public class Usuario 
{
    private String usuario;
    private String password;
      
    public Usuario(String usuario, String password)
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