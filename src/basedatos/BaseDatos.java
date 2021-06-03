package basedatos;

import clases.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Oriol Holguin <oriolholguint@gmail.com>
 */
public class BaseDatos 
{
    private static Connection conn;
    
    public BaseDatos() throws SQLException 
    {
        String url = "jdbc:mysql://localhost:3306/cryptomanager";
        String usuario = "root";
        String password = "";
        conn = DriverManager.getConnection(url, usuario, password);
    }
    
    public void close() throws SQLException
    {
        conn.close();
    }
    
    public boolean comprobarLogin(Usuario usuario) throws SQLException
    {
        boolean loginCorrecto = false;
        String username;
        String password;
        
        String query = "SELECT * FROM usuario WHERE usuario = ?";
        PreparedStatement st = conn.prepareStatement(query);
        
        st.setString(1, usuario.getUsuario());
        
        ResultSet rs = st.executeQuery();
        while(rs.next())
        {
            username = rs.getString("usuario");
            password = rs.getString("password");
            if(password.equals(usuario.getPassword()))
            {
                loginCorrecto = true;
            }
        }
        
        return loginCorrecto;
    }
    
    public boolean checkUserRegister(String username) throws SQLException
    {
        boolean exists = false;
        String usernameAux;
        
        String query = "SELECT * FROM usuario WHERE usuario = ?";
        PreparedStatement st = conn.prepareStatement(query);
        
        st.setString(1, username);
        
        ResultSet rs = st.executeQuery();
        while(rs.next())
        {
            usernameAux = rs.getString("usuario");
            if(usernameAux.equals(username))
            {
                exists = true;
            }
        }
        
        return exists;
    }
}