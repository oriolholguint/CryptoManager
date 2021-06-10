package databases;

import elements.Crypto;
import elements.Transaction;
import elements.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import localdata.LocalData;
/**
 * @author Oriol Holguin <oriolholguint@gmail.com>
 */
public class Database 
{
    private static Connection conn;
    
    public Database() throws SQLException 
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
    
    //==============================REGISTER Y LOGIN==============================
    
    /**
     * Comprueba que el objeto usuario con los atributos username y password sean 
     * el mismo que algun registro de la base de datos para permitir el inicio de
     * sesion.
     * @param usuario objeto con los atributos a comprobar.
     * @return TRUE = si coincide el usuario con alguno de la base de datos.
     * @throws SQLException 
     */
    public boolean checkLogin(User usuario) throws SQLException
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
    public void createUser(User usuario) throws SQLException
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
    
    //================================MAIN WINDOW================================
    
    /**
     * Se inserta una transaccion en la base de datos enviado un objeto de Transaction.
     * @param transaction objeto de Transaccion con la informacion a insertar.
     * @return TRUE = si la insercion se ha podido realizar correctamente.
     * @throws SQLException 
     */
    public boolean insertTransaction(Transaction transaction) throws SQLException
    {
        boolean correctInsert = false;
        
        String query = "INSERT INTO transactions (transactionDate, currency, amount, userName) VALUES(?, ?, ?, ?)";
        
        PreparedStatement st = conn.prepareStatement(query);
        st.setDate(1, transaction.getTransactionDate());
        st.setString(2, transaction.getCurrency());
        st.setFloat(3, transaction.getAmount());
        st.setString(4, transaction.getUser().getUsuario());
        
        if(st.executeUpdate() != 0)
        {
            correctInsert = true;
            System.out.println("*Transaccion añadida correctamente*");
        }
        
        return correctInsert;
    }
    
    /**
     * Obtiene una lista de las transacciones segun el usuario que esta logeado.
     * @return ArrayList con objetos de Transaction cada una con su respectiva 
     * informacion.
     * @throws SQLException 
     */
    public ArrayList<Transaction> getTransactionsList() throws SQLException
    {
        ArrayList<Transaction> transactions = new ArrayList<>();
        Transaction transaction;
        int id;
        Date transactionDate;
        String currency;
        float amount; 
        
        String query = "SELECT * FROM transactions WHERE username = ?";
        
        PreparedStatement st = conn.prepareStatement(query);
        
        st.setString(1, LocalData.user.getUserName());
        
        ResultSet rs = st.executeQuery();
        
        while(rs.next())
        {
            id = rs.getInt("id");
            transactionDate = rs.getDate("transactionDate");
            currency = rs.getString("currency");
            amount = rs.getFloat("amount");
            
            transaction = new Transaction(id, transactionDate, currency, amount, LocalData.user);
            
            transactions.add(transaction);
        }
        
        return transactions;
    }
}