package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import databases.Database;
import elements.Usuario;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
import utilities.WindowUtilities;

/**
 *
 * @author Oriol Holguin <oriolholguint@gmail.com>
 */
public class Login extends javax.swing.JFrame implements ActionListener
{
    //Creacion de temporizador de ActionListener.
    final static int DELAY = 1000;
    Timer timer;
        
    public Login() 
    {
        initComponents();
        //initTimer();
        initLabels();      
        WindowUtilities.initSimpleWindow(this, "CryptoManager");
    }
    
    /***
     * Se inician el estado de los labels de la interfaz.
     */
    private void initLabels()
    {
        lblInfoLogin.setVisible(false);
    }
    
    /*private void initTimer()
    {
        timer = new Timer(DELAY, this);
        timer.start();
    }*/
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        lblUser = new javax.swing.JLabel();
        txtTitleCryptoManager = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        btnEnter = new javax.swing.JButton();
        lblPassword = new javax.swing.JLabel();
        txtCopyright = new javax.swing.JLabel();
        lblInfoLogin = new javax.swing.JLabel();
        btnRegister = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblUser.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblUser.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblUser.setText("Username");

        txtTitleCryptoManager.setFont(new java.awt.Font("Arial Black", 0, 48)); // NOI18N
        txtTitleCryptoManager.setText("CryptoManager");

        btnEnter.setText("Entrar");
        btnEnter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEnterMouseClicked(evt);
            }
        });

        lblPassword.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblPassword.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPassword.setText("Password");

        txtCopyright.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtCopyright.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtCopyright.setText("Oriol Holguin - Alex Guirao - Francesc Bagué ©");

        lblInfoLogin.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblInfoLogin.setForeground(new java.awt.Color(255, 0, 51));
        lblInfoLogin.setText("lblInfoLogin");

        btnRegister.setText("Registrarse");
        btnRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegisterMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCopyright, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnEnter, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblPassword, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                            .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUser)
                            .addComponent(txtPassword)
                            .addComponent(btnRegister, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(272, 272, 272))
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(txtTitleCryptoManager))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(307, 307, 307)
                        .addComponent(lblInfoLogin)))
                .addContainerGap(203, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(txtTitleCryptoManager)
                .addGap(59, 59, 59)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEnter)
                    .addComponent(btnRegister))
                .addGap(65, 65, 65)
                .addComponent(lblInfoLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                .addComponent(txtCopyright)
                .addContainerGap())
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
     * Evento al clicar el boton Entrar, se conecta con la base de datos y comprueba
     * que el usuario exista y que la contraseña sea correcta.
     * @param evt 
     */
    private void btnEnterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnterMouseClicked
        Usuario usuario = new Usuario("", "");
        usuario.setUsuario(txtUser.getText());
        usuario.setPassword(txtPassword.getText());

        try 
        {
            Database bd = new Database();

            boolean loginCorrecto;

            loginCorrecto = bd.checkLogin(usuario);

            if(loginCorrecto)
            {
                lblInfoLogin.setText("Login correcto");
                lblInfoLogin.setVisible(true);
            }
            else
            {   
                lblInfoLogin.setText("Login incorrecto");
                lblInfoLogin.setVisible(true);
            }
            
            bd.close();
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEnterMouseClicked

    /**
     * Evento al clicar en el boton Registrar se abrira una ventana que bloqueara
     * el resto le pedira al usuario los datos.
     * @param evt 
     */
    private void btnRegisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegisterMouseClicked
        new Register(this, true);
    }//GEN-LAST:event_btnRegisterMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnter;
    private javax.swing.JButton btnRegister;
    private javax.swing.JLabel lblInfoLogin;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblUser;
    private javax.swing.JPanel panel;
    private javax.swing.JLabel txtCopyright;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JLabel txtTitleCryptoManager;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables

    /**
     * Este codigo se repeitira todo el rato.
     * @param ae 
     */
    @Override
    public void actionPerformed(ActionEvent ae) 
    {

    }

}