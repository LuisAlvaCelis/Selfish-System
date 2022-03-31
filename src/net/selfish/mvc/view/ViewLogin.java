package net.selfish.mvc.view;

import javax.swing.UIManager;

public class ViewLogin extends javax.swing.JFrame {
    
    public ViewLogin() throws Exception{
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        piBackground = new org.edisoncor.gui.panel.PanelImage();
        jLabel1 = new javax.swing.JLabel();
        jtfUsername = new javax.swing.JTextField();
        jpfPassword = new javax.swing.JPasswordField();
        jrbSeePassword = new javax.swing.JRadioButton();
        jbtJoin = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jrbRememberAccount = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        piBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/selfish/images/fondo800x600.png"))); // NOI18N
        piBackground.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Bienvenido sl sistema selfish");
        piBackground.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, -1, -1));
        piBackground.add(jtfUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 260, -1));
        piBackground.add(jpfPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 260, -1));

        jrbSeePassword.setForeground(new java.awt.Color(204, 204, 204));
        jrbSeePassword.setText("Mostrar contraseña");
        jrbSeePassword.setContentAreaFilled(false);
        jrbSeePassword.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        piBackground.add(jrbSeePassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, -1, -1));

        jbtJoin.setText("Ingresar");
        piBackground.add(jbtJoin, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 220, -1, -1));

        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Usuario");
        piBackground.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, -1, -1));

        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Contraseña");
        piBackground.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, -1, -1));

        jrbRememberAccount.setForeground(new java.awt.Color(204, 204, 204));
        jrbRememberAccount.setText("Recordar cuenta");
        jrbRememberAccount.setContentAreaFilled(false);
        jrbRememberAccount.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        piBackground.add(jrbRememberAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(piBackground, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(piBackground, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    public javax.swing.JButton jbtJoin;
    public javax.swing.JPasswordField jpfPassword;
    public javax.swing.JRadioButton jrbRememberAccount;
    public javax.swing.JRadioButton jrbSeePassword;
    public javax.swing.JTextField jtfUsername;
    private org.edisoncor.gui.panel.PanelImage piBackground;
    // End of variables declaration//GEN-END:variables
}
