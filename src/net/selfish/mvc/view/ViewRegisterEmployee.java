package net.selfish.mvc.view;

import javax.swing.UIManager;

public class ViewRegisterEmployee extends javax.swing.JFrame {

    public ViewRegisterEmployee() throws Exception{
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpiBackground = new org.edisoncor.gui.panel.PanelImage();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jcbRol = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtfLastnames = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtfNames = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtfDNI = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtfUsername = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jpfPassword = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        jpfRepeatPassword = new javax.swing.JPasswordField();
        jrbShowPassword = new javax.swing.JRadioButton();
        jbtRegisterEmployee = new javax.swing.JButton();
        jbtModify = new javax.swing.JButton();
        jbtCancel = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jtfTelCel = new javax.swing.JTextField();
        jbtReturn = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jtfSearch = new javax.swing.JTextField();
        jbtPrint = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jtfEmail = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jpiBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/selfish/images/fondo800x600.png"))); // NOI18N
        jpiBackground.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ROL", "DNI", "APELLIDOS", "NOMBRES", "TELÉFONO/CELULAR", "NOMBRE DE USUARIO", "CONTRASEÑA ", "CORREO ELECTRÓNICO", "MODIFICAR", "REMOVER"
            }
        ));
        jtTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtTable);

        jpiBackground.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 1030, 200));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SELECCIIONE ROL:");
        jpiBackground.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        jcbRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccione --", "1 -> Empleado" }));
        jpiBackground.add(jcbRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 200, 30));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("APELLIDOS");
        jpiBackground.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("REGISTRO DE EMPLEADOS");
        jpiBackground.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        jpiBackground.add(jtfLastnames, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 200, 20));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("NOMBRES");
        jpiBackground.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));
        jpiBackground.add(jtfNames, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 200, 20));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("DNI");
        jpiBackground.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));
        jpiBackground.add(jtfDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 200, 20));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("NOMBRE DE USUARIO");
        jpiBackground.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, -1, -1));
        jpiBackground.add(jtfUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 60, 200, 20));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("CONTRASEÑA");
        jpiBackground.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, -1, -1));
        jpiBackground.add(jpfPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 100, 200, -1));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("REPITA CONTRASEÑA");
        jpiBackground.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 140, -1, -1));
        jpiBackground.add(jpfRepeatPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 140, 200, -1));

        jrbShowPassword.setForeground(new java.awt.Color(255, 255, 255));
        jrbShowPassword.setText("Mostrar contraseña");
        jrbShowPassword.setContentAreaFilled(false);
        jrbShowPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpiBackground.add(jrbShowPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 170, -1, -1));

        jbtRegisterEmployee.setText("Registrar");
        jpiBackground.add(jbtRegisterEmployee, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 40, 100, -1));

        jbtModify.setText("Modificar");
        jbtModify.setEnabled(false);
        jpiBackground.add(jbtModify, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 80, 100, -1));

        jbtCancel.setText("Cancelar");
        jbtCancel.setEnabled(false);
        jpiBackground.add(jbtCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 120, 100, -1));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("TELÉFONO / CELULAR");
        jpiBackground.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));
        jpiBackground.add(jtfTelCel, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 200, -1));

        jbtReturn.setText("Regresar");
        jpiBackground.add(jbtReturn, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 160, 100, -1));

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("BUSCAR");
        jpiBackground.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, -1));
        jpiBackground.add(jtfSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 257, 200, -1));

        jbtPrint.setText("Imprimir");
        jpiBackground.add(jbtPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 260, -1, -1));

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("CORREO ELECTRÓNICO");
        jpiBackground.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 220, -1, -1));
        jpiBackground.add(jtfEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 220, 200, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpiBackground, javax.swing.GroupLayout.DEFAULT_SIZE, 1070, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpiBackground, javax.swing.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JButton jbtCancel;
    public javax.swing.JButton jbtModify;
    public javax.swing.JButton jbtPrint;
    public javax.swing.JButton jbtRegisterEmployee;
    public javax.swing.JButton jbtReturn;
    public javax.swing.JComboBox<String> jcbRol;
    public javax.swing.JPasswordField jpfPassword;
    public javax.swing.JPasswordField jpfRepeatPassword;
    public org.edisoncor.gui.panel.PanelImage jpiBackground;
    public javax.swing.JRadioButton jrbShowPassword;
    public javax.swing.JTable jtTable;
    public javax.swing.JTextField jtfDNI;
    public javax.swing.JTextField jtfEmail;
    public javax.swing.JTextField jtfLastnames;
    public javax.swing.JTextField jtfNames;
    public javax.swing.JTextField jtfSearch;
    public javax.swing.JTextField jtfTelCel;
    public javax.swing.JTextField jtfUsername;
    // End of variables declaration//GEN-END:variables
}
