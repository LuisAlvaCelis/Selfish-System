package net.selfish.mvc.view;

import javax.swing.UIManager;

public class ViewRegisterMySQL extends javax.swing.JFrame {

    public ViewRegisterMySQL() throws Exception{
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelImage1 = new org.edisoncor.gui.panel.PanelImage();
        jLabel1 = new javax.swing.JLabel();
        jtfIp = new javax.swing.JTextField();
        jtfPort = new javax.swing.JTextField();
        jtfDatabase = new javax.swing.JTextField();
        jtfUsername = new javax.swing.JTextField();
        jpfPassword = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jckbShowPassword = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaStatus = new javax.swing.JTextArea();
        jbtRegisterMySQL = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        panelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/selfish/images/fondo800x600.png"))); // NOI18N
        panelImage1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Registro de la base de datos");
        panelImage1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));
        panelImage1.add(jtfIp, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 180, -1));
        panelImage1.add(jtfPort, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 180, -1));
        panelImage1.add(jtfDatabase, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 180, -1));
        panelImage1.add(jtfUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 180, -1));
        panelImage1.add(jpfPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 180, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("IP:");
        panelImage1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Puerto:");
        panelImage1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Base de datos:");
        panelImage1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Usuario:");
        panelImage1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Contraseña:");
        panelImage1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, -1));

        jckbShowPassword.setForeground(new java.awt.Color(255, 255, 255));
        jckbShowPassword.setText("Mostrar contraseña");
        jckbShowPassword.setContentAreaFilled(false);
        panelImage1.add(jckbShowPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, -1, -1));

        jtaStatus.setEditable(false);
        jtaStatus.setColumns(20);
        jtaStatus.setRows(5);
        jScrollPane1.setViewportView(jtaStatus);

        panelImage1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 100, 270, 100));

        jbtRegisterMySQL.setText("Registrar");
        panelImage1.add(jbtRegisterMySQL, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 280, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, 652, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JButton jbtRegisterMySQL;
    public javax.swing.JCheckBox jckbShowPassword;
    public javax.swing.JPasswordField jpfPassword;
    public javax.swing.JTextArea jtaStatus;
    public javax.swing.JTextField jtfDatabase;
    public javax.swing.JTextField jtfIp;
    public javax.swing.JTextField jtfPort;
    public javax.swing.JTextField jtfUsername;
    private org.edisoncor.gui.panel.PanelImage panelImage1;
    // End of variables declaration//GEN-END:variables
}
