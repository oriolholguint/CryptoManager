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
import java.util.logging.Level;
import java.util.logging.Logger;
import localdata.LocalData;
import apicontrol.ApiControl;
import apicontrol.ApiRequest;

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
        
        String query = "SELECT * FROM users WHERE userName = ?";
        PreparedStatement st = conn.prepareStatement(query);
        
        st.setString(1, usuario.getUsuario());
        
        ResultSet rs = st.executeQuery();
        while(rs.next())
        {
            username = rs.getString("userName");
            password = rs.getString("userPassword");
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
        
        String query = "SELECT * FROM users WHERE userName = ?";
        PreparedStatement st = conn.prepareStatement(query);
        
        st.setString(1, username);
        
        ResultSet rs = st.executeQuery();
        while(rs.next())
        {
            usernameAux = rs.getString("userName");
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
        String query = "INSERT INTO users VALUES(?, ?, ?)";
        
        PreparedStatement st = conn.prepareStatement(query);
        
        st.setString(1, usuario.getUsuario());
        st.setString(2, usuario.getPassword());
        st.setString(3, usuario.getEmail());
        
        if(st.executeUpdate() != 0)
        {
            System.out.println("Usuario registrado correctamente");
        }
        else
        {
            System.out.println("Usuario no registrado");
        }
    }
    
    //==============================RECOVER PASSWORD==============================
    
    /**
     * Se busca en la base de datos un usuario dado un email, en el caso que lo
     * encuentre devuelve un objeto de User sino el objeto sera null.
     * @param email a buscar en la base de datos.
     * @return objeto de User con los datos del usuario.
     * @throws SQLException 
     */
    public User checkUserExists(String email) throws SQLException
    {
        User user = null;
        String userName;
        String userPassword;
        String emailAux;
        
        String query = "SELECT * FROM users WHERE email = ?";
        
        PreparedStatement st = conn.prepareStatement(query);
        st.setString(1, email);
        
        ResultSet rs = st.executeQuery();
        while(rs.next())
        {
            userName = rs.getString("userName");
            userPassword = rs.getString("userPassword");
            emailAux = rs.getString("email");
            
            user = new User(userName, userPassword, emailAux);
        }
        
        return user;
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
        
        String query = "INSERT INTO transactions (transactionDate, currency, amount, price, userName) VALUES (?, ?, ?, ?, ?)";
        
        PreparedStatement st = conn.prepareStatement(query);
        st.setDate(1, transaction.getTransactionDate());
        st.setString(2, transaction.getCurrency());
        st.setFloat(3, transaction.getAmount());
        st.setFloat(4, transaction.getPrice());
        st.setString(5, transaction.getUser().getUsuario());
        
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
    public ArrayList<Transaction> getGlobalTransactionList() throws SQLException
    {
        ArrayList<Transaction> transactions = new ArrayList<>();
        Transaction transaction;
        int id;
        Date transactionDate;
        String currency;
        float amount;
        float price;
        
        String query = "SELECT * FROM transactions WHERE userName = ?";
        
        PreparedStatement st = conn.prepareStatement(query);
        
        st.setString(1, LocalData.user.getUserName());
        
        ResultSet rs = st.executeQuery();
        
        while(rs.next())
        {
            id = rs.getInt("id");
            transactionDate = rs.getDate("transactionDate");
            currency = rs.getString("currency");
            amount = rs.getFloat("amount");
            price = rs.getFloat("price");
            
            transaction = new Transaction(id, transactionDate, currency, price, amount, LocalData.user);
            
            transactions.add(transaction);
        }
        
        return transactions;
    }
    
    /**
     * Se obtiene la lista transacciones de la base de datos segun la moneda que
     * se envie por parametros y el usuario que este logueado en ese momento.
     * @param currency moneda de la cual se seleccionan las transacciones.
     * @return ArrayList con las transacciones y sus respectivos datos.
     * @throws SQLException 
     */
    public ArrayList<Transaction> getSpecificTransactionList(String currency) throws SQLException
    {
        ArrayList<Transaction> transactions = new ArrayList<>();
        Transaction transaction;
        int id;
        Date transactionDate;
        String currencyAux;
        float amount;
        float price;
        
        String query = "SELECT * FROM transactions WHERE currency = ? AND userName = ?";
        
        PreparedStatement st = conn.prepareStatement(query);
        st.setString(1, currency);
        st.setString(2, LocalData.user.getUserName());
        
        ResultSet rs = st.executeQuery();
        
        while(rs.next())
        {
            id = rs.getInt("id");
            transactionDate = rs.getDate("transactionDate");
            currencyAux = rs.getString("currency");
            amount = rs.getFloat("amount");
            price = rs.getFloat("price");
            
            transaction = new Transaction(id, transactionDate, currencyAux, price, amount, LocalData.user);
            
            transactions.add(transaction);
        }
        
        return transactions;
    }
    
    //===================Crypto==================
    /**
     * Inserta una criptomoneda a la base de datos en la que aparecen las criptomonedas
     * que el usuario tiene en su posesión. Es decir, de las que ha realizado transacciones.
     * @param coinName Nombre de la moneda.
     * @return TRUE si se ha insertado con éxito.
     * @throws SQLException 
     */
    public boolean insertCrypto(String coinName) throws SQLException
    {
        boolean done=false;
        String query = "Insert into crypto VALUES (?, ?, ?)";
        
        PreparedStatement ps = conn.prepareStatement(query);
        Crypto crypto = ApiControl.parseToObject(ApiRequest.cryptoInfo(coinName));
        ps.setString(1, crypto.getId());
        ps.setString(2, crypto.getSymbol());
        ps.setString(3, crypto.getName());
        int rowsChanged = ps.executeUpdate();
        
        if(rowsChanged!=0)
        {
            done=true;
        }
        
        return done;
    }
}