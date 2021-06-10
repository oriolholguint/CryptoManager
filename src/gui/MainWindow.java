package gui;

import databases.Database;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import localdata.LocalData;
import javax.swing.table.DefaultTableModel;
import utilities.WindowUtilities;

/**
 * @author Alex Guirao López <aguiraol2021@cepnet.net>
 */
public class MainWindow extends javax.swing.JFrame 
{
    RowRenderer rr = new RowRenderer();
    
    public MainWindow() 
    {
        initComponents();
        tblCrypto.setDefaultRenderer(tblCrypto.getColumnClass(0), rr); 
        fillCryptoIconTable();
        fillGlobalTransactionTable();
        WindowUtilities.initSimpleWindow(this, "Crypto Manager");
    }
    
    /**
     * Rellena la tabla de criptomonedas con las imágenes correspondientes.
     */
    public void fillCryptoIconTable()
    {
        DefaultTableModel model = (DefaultTableModel)tblCrypto.getModel();
        Object rowData [] = new Object[1];
        for (int i = 0; i<LocalData.cryptoLogoPath.length;i++)
        {
            ImageIcon icon = new ImageIcon(LocalData.cryptoLogoPath[i]);
            rowData[0]= new JButton(icon);
            model.addRow(rowData);
        }
    }
    
    /**
     * Rellena la tabla con todas las transacciones.
     */
    public void fillGlobalTransactionTable()
    {
        try {
            Database db = new Database();
            DefaultTableModel model = (DefaultTableModel)tblTransactions.getModel();
            Object rowData [] = new Object[4];
            
            for (int i = 0; i<db.getTransactionList().length;i++)
            {
                rowData[0] = ;
                rowData[1] = ;
                rowData[2] = ;
                rowData[3] = ;
                model.addRow(rowData);
            }
        
        } catch (SQLException ex) {
            System.out.println("No se pudo acceder a la base de datos"+ex);
            ex.printStackTrace();
        }
    }
    
      /**
     * Rellena la tabla con las transacciones respectivas a una moneda en concreto.
     */
    public void fillSpecificTransactionTable()
    {
        try {
            Database db = new Database();
            DefaultTableModel model = (DefaultTableModel)tblTransactions.getModel();
            Object rowData [] = new Object[4];
            
            for (int i = 0; i<db.getSpecificTransactionList().length;i++)
            {
                rowData[0] = ;
                rowData[1] = ;
                rowData[2] = ;
                rowData[3] = ;
                model.addRow(rowData);
            }
        
            db.close();
        } catch (SQLException ex) {
            System.out.println("No se pudo acceder a la base de datos"+ex);
            ex.printStackTrace();
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCrypto = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTransactions = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        lblProfit = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblTotalProfit = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblTransactionAmount = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuAddTransaction = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        tblCrypto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Crypto", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCrypto.setRowHeight(50);
        jScrollPane1.setViewportView(tblCrypto);
        if (tblCrypto.getColumnModel().getColumnCount() > 0) {
            tblCrypto.getColumnModel().getColumn(0).setResizable(false);
            tblCrypto.getColumnModel().getColumn(1).setResizable(false);
        }

        tblTransactions.setBackground(new java.awt.Color(0, 0, 0));
        tblTransactions.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Date", "Currency", "Price", "Amount"
            }
        ));
        tblTransactions.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(tblTransactions);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Amount");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "EUR", "USD", "BTC" }));

        lblProfit.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        lblProfit.setForeground(new java.awt.Color(51, 255, 102));
        lblProfit.setText("80%");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Profit");

        lblTotalProfit.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        lblTotalProfit.setForeground(new java.awt.Color(51, 255, 102));
        lblTotalProfit.setText("210€");

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Transactions");

        lblTransactionAmount.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        lblTransactionAmount.setForeground(new java.awt.Color(51, 255, 102));
        lblTransactionAmount.setText("8");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(lblTransactionAmount))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(lblProfit))
                .addGap(91, 91, 91)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblTotalProfit)))
                .addGap(30, 30, 30)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProfit)
                    .addComponent(lblTotalProfit)
                    .addComponent(lblTransactionAmount))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel2.setText("<----- Select your crypto");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addComponent(jSeparator1)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenuBar1.setBackground(new java.awt.Color(209, 212, 229));

        mnuAddTransaction.setBackground(new java.awt.Color(209, 212, 229));
        mnuAddTransaction.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cross.png"))); // NOI18N
        mnuAddTransaction.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuAddTransactionMouseClicked(evt);
            }
        });
        jMenuBar1.add(mnuAddTransaction);

        jMenu4.setBackground(new java.awt.Color(209, 212, 229));
        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/minus.png"))); // NOI18N
        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuAddTransactionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuAddTransactionMouseClicked
        new AddTransaction(this, true);
    }//GEN-LAST:event_mnuAddTransactionMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JLabel lblProfit;
    private javax.swing.JLabel lblTotalProfit;
    private javax.swing.JLabel lblTransactionAmount;
    private javax.swing.JMenu mnuAddTransaction;
    private javax.swing.JTable tblCrypto;
    private javax.swing.JTable tblTransactions;
    // End of variables declaration//GEN-END:variables
}
