package gui;

import databases.BaseDatos;
import elements.Usuario;
import java.sql.SQLException;
import utilities.Checker;
import utilities.WindowUtilities;

/**
 *
 * @author Uri
 */
public class Register extends javax.swing.JDialog 
{

    /**
     * Creates new form Register
     */
    public Register(java.awt.Frame parent, boolean modal) 
    {
        super(parent, modal);
        initComponents();
        initLabels();
        WindowUtilities.initSimpleWindow(this, "Register");
    }
    
    public void initLabels()
    {
        lblInfoRegister.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        lblUsername = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        lblConfirmPassword = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        txtConfirmPassword = new javax.swing.JPasswordField();
        btnRegister = new javax.swing.JButton();
        lblInfoRegister = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblUsername.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblUsername.setText("Username");

        lblPassword.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblPassword.setText("Password");

        lblConfirmPassword.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblConfirmPassword.setText("Confirm Password");

        lblEmail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblEmail.setText("Email");

        btnRegister.setText("Registrarse");
        btnRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegisterMouseClicked(evt);
            }
        });

        lblInfoRegister.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblInfoRegister.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInfoRegister.setText("jLabel1");

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblInfoRegister, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblEmail)
                                    .addComponent(lblConfirmPassword))
                                .addGap(0, 2, Short.MAX_VALUE)))
                        .addGap(26, 26, 26)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnRegister, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtUsername)
                            .addComponent(txtPassword)
                            .addComponent(txtEmail)
                            .addComponent(txtConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(43, 43, 43))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsername)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(lblConfirmPassword))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnRegister)
                .addGap(33, 33, 33)
                .addComponent(lblInfoRegister)
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Evento que sucedera cuando se clique al boton de Registrarse, en este caso
     * comprobara que todas las variables introducidas por el usuario sean correctas.
     * @param evt 
     */
    private void btnRegisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegisterMouseClicked
        
        boolean usernameExists = false;
        boolean samePasswords;
        boolean correctEmail;
        Usuario usuario;
        
        //Se comprueba que en la base de datos el username no exista.
        usernameExists = checkUsernameExists(txtUsername.getText());
        
        //Se comprueba que las dos contraseñas sean iguales
        char password [] = txtPassword.getPassword();
        char confirmPassword [] = txtConfirmPassword.getPassword();
        samePasswords = checkSamePasswords(password, confirmPassword);
        
        //Se comprueba que el email introducido sea correcto     
        correctEmail = Checker.checkEmail(txtEmail.getText());
        
        if(!usernameExists && samePasswords && correctEmail)
        {
            usuario = new Usuario(txtUsername.getText(), String.valueOf(password));
            createUser(usuario);
            lblInfoRegister.setText("Usuario registrado correctamente");
            lblInfoRegister.setVisible(true);
            this.dispose();
        }
        else
        {
            lblInfoRegister.setText("Error al registrar usuario");
            lblInfoRegister.setVisible(true);   
        }
    }//GEN-LAST:event_btnRegisterMouseClicked

    /**
     * Comprueba que dos contraseñas de JFieldPassword sean iguales.
     * @param password primera contraseña a comprobar.
     * @param confirmPassword segunda contraseña a comprobar.
     * @return TRUE = si las contraseñas son iguales.
     */
    private static boolean checkSamePasswords(char password [], char confirmPassword [])
    {
        boolean samePasswords = false;
        int i = 0;

        if(password.length == confirmPassword.length)
        {
            samePasswords = true;
            while(i < password.length && samePasswords)
            {
                if(password[i] != confirmPassword[i])
                {
                    samePasswords = false;
                }
                i++;
            }
        }
        
        return samePasswords;
    }
    
    /**
     * Comprueba que el username exista en la base de datos.
     * @param username nombre de usuario a buscar en la base de datos.
     * @return TRUE = si encuentra el nombre en la base de datos.
     */
    private static boolean checkUsernameExists(String username)
    {
        boolean usernameExists = false;
        
        try
        {
            BaseDatos bd = new BaseDatos();
            
            usernameExists = bd.checkUserRegister(username);
                        
            bd.close();
            
        }
        catch(SQLException ex)
        {
            System.out.println("No se ha podido acceder a la base de datos.");
        } 
        
        return usernameExists;
    }
    
    /**
     * Crea un usuario en la base de datos.
     * @param usuario objeto de usuario con los atributos a registrar.
     */
    private static void createUser(Usuario usuario)
    {
        try
        {
            BaseDatos bd = new BaseDatos();
            bd.createUser(usuario);
            bd.close();
        }
        catch(SQLException ex)
        {
            System.out.println("No se ha podido acceder a la base de datos.");
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegister;
    private javax.swing.JLabel lblConfirmPassword;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblInfoRegister;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JPanel panel;
    private javax.swing.JPasswordField txtConfirmPassword;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}