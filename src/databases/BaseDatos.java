package databases;

import elements.Usuario;
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
    
    /**
     * Comprueba que el objeto usuario con los atributos username y password sean 
     * el mismo que algun registro de la base de datos para permitir el inicio de
     * sesion.
     * @param usuario objeto con los atributos a comprobar.
     * @return TRUE = si coincide el usuario con alguno de la base de datos.
     * @throws SQLException 
     */
    public boolean checkLogin(Usuario usuario) throws SQLException
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
    
    /**
     * Comprueba que el username dado por parametros coincida con algun registro
     * de la base de datos.
     * @param username nombre de usuario a buscar en la base de datos.
     * @return TRUE = si el nombre de usuario coincide con alguno de la base de datos.
     * @throws SQLException 
     */
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
    
    /***
     * Crea un registro en la base de datos en la tabla usuario.
     * @param usuario objeto de usuario con los atributos del registro a añadir.
     * @throws SQLException 
     */
    public void createUser(Usuario usuario) throws SQLException
    {
        String query = "INSERT INTO usuario VALUES(?, ?)";
        
        PreparedStatement st = conn.prepareStatement(query);
        
        st.setString(1, usuario.getUsuario());
        st.setString(2, usuario.getPassword());
        
        if(st.executeUpdate() != 0)
        {
            System.out.println("Usuario registrado correctamente");
        }
        else
        {
            System.out.println("Usuario no registrado");
        }
    }
}