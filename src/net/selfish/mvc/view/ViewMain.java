package net.selfish.mvc.view;

import javax.swing.UIManager;

public class ViewMain extends javax.swing.JFrame {

    public ViewMain() throws Exception{
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jpiBackground = new org.edisoncor.gui.panel.PanelImage();
        jpButtons = new javax.swing.JPanel();
        jlAccount = new javax.swing.JLabel();
        jbtOrders = new javax.swing.JButton();
        jbtStatistics = new javax.swing.JButton();
        jbtBeverageWerehouse = new javax.swing.JButton();
        jbtMakeOrder = new javax.swing.JButton();
        jbtMenu = new javax.swing.JButton();
        jpContainer = new javax.swing.JPanel();
        jpMenu1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jlImageMenu = new javax.swing.JLabel();
        jbtExamineMenu = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jcbCategoryAllowedMenu = new javax.swing.JComboBox<>();
        jbtRegisterCategoryMenu = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jtfIDMenu = new javax.swing.JTextField();
        jtfNameMenu = new javax.swing.JTextField();
        jtfCostMenu = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jrbEnabledMenu = new javax.swing.JRadioButton();
        jrbDisabledMenu = new javax.swing.JRadioButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jtfSearchMenu = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtTableMenu = new javax.swing.JTable();
        jbtPrintTableMenu = new javax.swing.JButton();
        jbtRegisterMenu = new javax.swing.JButton();
        jbtModifyMenu = new javax.swing.JButton();
        jbtCancelMenu = new javax.swing.JButton();
        jbtNewMenu = new javax.swing.JButton();
        jpMenu2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtTableOrders = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        jtfSearchOrder = new javax.swing.JTextField();
        jbtUpdateListOrders = new javax.swing.JButton();
        jpMenu3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtTableListMenusOrder = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        jtTableListOrder = new javax.swing.JTable();
        jtfSearchMenuToOrder = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jtfCostTotalOrder = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jbtPerformOrder = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jtTableListDrinksOrder = new javax.swing.JTable();
        jLabel21 = new javax.swing.JLabel();
        jtfSearchDrinkToOrder = new javax.swing.JTextField();
        jpMenu4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jpMenu5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTableDrinks = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfSearchDrink = new javax.swing.JTextField();
        jcbCategoryAllowedDrink = new javax.swing.JComboBox<>();
        jbtRegisterCategoryDrink = new javax.swing.JButton();
        jtfIDDrink = new javax.swing.JTextField();
        jtfNameDrink = new javax.swing.JTextField();
        jsCantDrink = new javax.swing.JSpinner();
        jtfCostDrink = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jlImageDrink = new javax.swing.JLabel();
        jbtExamineDrink = new javax.swing.JButton();
        jbtRegisterDrink = new javax.swing.JButton();
        jbtModifyDrink = new javax.swing.JButton();
        jbtCancelDrink = new javax.swing.JButton();
        jbtNewDrink = new javax.swing.JButton();
        jbtPrintTableDrink = new javax.swing.JButton();
        jmbMenus = new javax.swing.JMenuBar();
        jmOptions = new javax.swing.JMenu();
        jmiRegisterEmployee = new javax.swing.JMenuItem();
        jmiRegisterMySQL = new javax.swing.JMenuItem();
        jmiLogout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jpiBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/selfish/images/fondo800x600.png"))); // NOI18N
        jpiBackground.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpButtons.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jpButtons.setOpaque(false);
        jpButtons.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlAccount.setForeground(new java.awt.Color(255, 255, 255));
        jlAccount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlAccount.setText("ACCOUNT");
        jpButtons.add(jlAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 170, -1));

        jbtOrders.setText("PEDIDOS");
        jbtOrders.setFocusPainted(false);
        jpButtons.add(jbtOrders, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 170, 40));

        jbtStatistics.setText("ESTADÍSTICAS");
        jbtStatistics.setFocusPainted(false);
        jpButtons.add(jbtStatistics, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 170, 40));

        jbtBeverageWerehouse.setText("ALMACÉN BEBIDAS");
        jbtBeverageWerehouse.setFocusPainted(false);
        jpButtons.add(jbtBeverageWerehouse, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 170, 40));

        jbtMakeOrder.setText("REALIZAR PEDIDO");
        jbtMakeOrder.setFocusPainted(false);
        jpButtons.add(jbtMakeOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 170, 40));

        jbtMenu.setText("MENÚ");
        jbtMenu.setFocusPainted(false);
        jpButtons.add(jbtMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 170, 40));

        jpiBackground.add(jpButtons, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 190, 550));

        jpContainer.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true));
        jpContainer.setOpaque(false);
        jpContainer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpMenu1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jpMenu1.setOpaque(false);
        jpMenu1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Menú");
        jpMenu1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jlImageMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlImageMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jpMenu1.add(jlImageMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 30, 260, 150));

        jbtExamineMenu.setText("Examinar");
        jbtExamineMenu.setFocusPainted(false);
        jpMenu1.add(jbtExamineMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 190, -1, -1));

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Categorías disponibles");
        jpMenu1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        jcbCategoryAllowedMenu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccione --" }));
        jcbCategoryAllowedMenu.setFocusable(false);
        jpMenu1.add(jcbCategoryAllowedMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 180, -1));

        jbtRegisterCategoryMenu.setText("Registrar categoría");
        jbtRegisterCategoryMenu.setFocusPainted(false);
        jpMenu1.add(jbtRegisterCategoryMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, -1, -1));

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("ID");
        jpMenu1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));
        jpMenu1.add(jtfIDMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 180, -1));
        jpMenu1.add(jtfNameMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 180, -1));
        jpMenu1.add(jtfCostMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 180, -1));

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Nombre");
        jpMenu1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Costo");
        jpMenu1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, -1));

        buttonGroup1.add(jrbEnabledMenu);
        jrbEnabledMenu.setForeground(new java.awt.Color(255, 255, 255));
        jrbEnabledMenu.setText("Disponible");
        jrbEnabledMenu.setContentAreaFilled(false);
        jrbEnabledMenu.setFocusPainted(false);
        jpMenu1.add(jrbEnabledMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, -1, -1));

        buttonGroup1.add(jrbDisabledMenu);
        jrbDisabledMenu.setForeground(new java.awt.Color(255, 255, 255));
        jrbDisabledMenu.setText("No disponible");
        jrbDisabledMenu.setContentAreaFilled(false);
        jrbDisabledMenu.setFocusPainted(false);
        jpMenu1.add(jrbDisabledMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, -1, -1));

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Disponibilidad");
        jpMenu1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));

        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Buscar");
        jpMenu1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));
        jpMenu1.add(jtfSearchMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 290, -1));

        jtTableMenu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Categoría", "ID", "Nombre", "Costo", "Imagen", "Disponibilidad", "Modificar", "Remover"
            }
        ));
        jtTableMenu.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jtTableMenu);

        jpMenu1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 870, 210));

        jbtPrintTableMenu.setText("Imprimir");
        jbtPrintTableMenu.setFocusPainted(false);
        jpMenu1.add(jbtPrintTableMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 240, -1, -1));

        jbtRegisterMenu.setText("Registrar");
        jbtRegisterMenu.setFocusPainted(false);
        jpMenu1.add(jbtRegisterMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 100, -1));

        jbtModifyMenu.setText("Modificar");
        jbtModifyMenu.setEnabled(false);
        jbtModifyMenu.setFocusPainted(false);
        jpMenu1.add(jbtModifyMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, 100, -1));

        jbtCancelMenu.setText("Cancelar");
        jbtCancelMenu.setEnabled(false);
        jbtCancelMenu.setFocusPainted(false);
        jpMenu1.add(jbtCancelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 100, -1));

        jbtNewMenu.setText("Nuevo");
        jbtNewMenu.setFocusPainted(false);
        jpMenu1.add(jbtNewMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, 100, -1));

        jpContainer.add(jpMenu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-930, 13, 920, 520));

        jpMenu2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jpMenu2.setOpaque(false);
        jpMenu2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Pedidos");
        jpMenu2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jtTableOrders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Pedido", "Pedido", "Cantidad", "Costo", "Remover"
            }
        ));
        jtTableOrders.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jtTableOrders);

        jpMenu2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 72, 880, 390));

        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Buscar");
        jpMenu2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));
        jpMenu2.add(jtfSearchOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 37, 280, -1));

        jbtUpdateListOrders.setText("Actualizar Lista");
        jpMenu2.add(jbtUpdateListOrders, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 30, -1, -1));

        jpContainer.add(jpMenu2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-930, 13, 920, 520));

        jpMenu3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jpMenu3.setOpaque(false);
        jpMenu3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Realizar pedido");
        jpMenu3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jtTableListMenusOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Menú", "Costo", "Seleccionar"
            }
        ));
        jtTableListMenusOrder.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(jtTableListMenusOrder);

        jpMenu3.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 440, 220));

        jtTableListOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Producto", "Cantidad", "Costo", "Remover"
            }
        ));
        jtTableListOrder.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(jtTableListOrder);

        jpMenu3.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 570, 200));
        jpMenu3.add(jtfSearchMenuToOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 160, -1));

        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Buscar");
        jpMenu3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        jtfCostTotalOrder.setEditable(false);
        jtfCostTotalOrder.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jpMenu3.add(jtfCostTotalOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 440, 240, -1));

        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("TOTAL: S/.");
        jpMenu3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 440, -1, -1));

        jbtPerformOrder.setText("Realizar pedido");
        jpMenu3.add(jbtPerformOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 470, -1, -1));

        jtTableListDrinksOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Bebida", "Categoría", "Costo", "Seleccionar"
            }
        ));
        jtTableListDrinksOrder.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(jtTableListDrinksOrder);

        jpMenu3.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 70, 440, 220));

        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Buscar");
        jpMenu3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 40, -1, -1));
        jpMenu3.add(jtfSearchDrinkToOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 40, 160, -1));

        jpContainer.add(jpMenu3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-930, 13, 920, 520));

        jpMenu4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jpMenu4.setOpaque(false);
        jpMenu4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Estadísticas");
        jpMenu4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jpContainer.add(jpMenu4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-930, 13, 920, 520));

        jpMenu5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jpMenu5.setOpaque(false);
        jpMenu5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtTableDrinks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Categoría", "ID", "Nombre", "Cantidad", "Costo", "Imagen", "Modificar", "Remover"
            }
        ));
        jtTableDrinks.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtTableDrinks);

        jpMenu5.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 880, 200));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Almacén de bebidas");
        jpMenu5.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Buscar:");
        jpMenu5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 275, -1, -1));
        jpMenu5.add(jtfSearchDrink, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 274, 220, -1));

        jcbCategoryAllowedDrink.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccione --" }));
        jcbCategoryAllowedDrink.setFocusable(false);
        jpMenu5.add(jcbCategoryAllowedDrink, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 180, -1));

        jbtRegisterCategoryDrink.setText("Registrar categoria");
        jbtRegisterCategoryDrink.setFocusPainted(false);
        jpMenu5.add(jbtRegisterCategoryDrink, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, -1, -1));
        jpMenu5.add(jtfIDDrink, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 180, -1));
        jpMenu5.add(jtfNameDrink, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 180, -1));

        jsCantDrink.setFocusable(false);
        jpMenu5.add(jsCantDrink, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 180, -1));
        jpMenu5.add(jtfCostDrink, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 180, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Categorías disponibles");
        jpMenu5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ID");
        jpMenu5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Nombre");
        jpMenu5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Cantidad");
        jpMenu5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, -1));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Costo");
        jpMenu5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));

        jlImageDrink.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlImageDrink.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jpMenu5.add(jlImageDrink, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 30, 260, 150));

        jbtExamineDrink.setText("Examinar");
        jbtExamineDrink.setFocusPainted(false);
        jpMenu5.add(jbtExamineDrink, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 200, -1, -1));

        jbtRegisterDrink.setText("Registrar");
        jbtRegisterDrink.setFocusPainted(false);
        jpMenu5.add(jbtRegisterDrink, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 100, -1));

        jbtModifyDrink.setText("Modificar");
        jbtModifyDrink.setEnabled(false);
        jbtModifyDrink.setFocusPainted(false);
        jpMenu5.add(jbtModifyDrink, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 100, -1));

        jbtCancelDrink.setText("Cancelar");
        jbtCancelDrink.setEnabled(false);
        jbtCancelDrink.setFocusPainted(false);
        jpMenu5.add(jbtCancelDrink, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 200, 100, -1));

        jbtNewDrink.setText("Nuevo");
        jbtNewDrink.setFocusPainted(false);
        jpMenu5.add(jbtNewDrink, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 200, 100, -1));

        jbtPrintTableDrink.setText("Imprimir");
        jbtPrintTableDrink.setFocusPainted(false);
        jpMenu5.add(jbtPrintTableDrink, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 260, -1, -1));

        jpContainer.add(jpMenu5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-930, 13, 920, 520));

        jpiBackground.add(jpContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 950, 550));

        jmOptions.setText("Opciones");

        jmiRegisterEmployee.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jmiRegisterEmployee.setText("Registrar empleado");
        jmOptions.add(jmiRegisterEmployee);

        jmiRegisterMySQL.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jmiRegisterMySQL.setText("Registrar MySQL");
        jmOptions.add(jmiRegisterMySQL);

        jmiLogout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_MASK));
        jmiLogout.setText("Cerrar sesión");
        jmOptions.add(jmiLogout);

        jmbMenus.add(jmOptions);

        setJMenuBar(jmbMenus);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpiBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpiBackground, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    public javax.swing.JButton jbtBeverageWerehouse;
    public javax.swing.JButton jbtCancelDrink;
    public javax.swing.JButton jbtCancelMenu;
    public javax.swing.JButton jbtExamineDrink;
    public javax.swing.JButton jbtExamineMenu;
    public javax.swing.JButton jbtMakeOrder;
    public javax.swing.JButton jbtMenu;
    public javax.swing.JButton jbtModifyDrink;
    public javax.swing.JButton jbtModifyMenu;
    public javax.swing.JButton jbtNewDrink;
    public javax.swing.JButton jbtNewMenu;
    public javax.swing.JButton jbtOrders;
    public javax.swing.JButton jbtPerformOrder;
    public javax.swing.JButton jbtPrintTableDrink;
    public javax.swing.JButton jbtPrintTableMenu;
    public javax.swing.JButton jbtRegisterCategoryDrink;
    public javax.swing.JButton jbtRegisterCategoryMenu;
    public javax.swing.JButton jbtRegisterDrink;
    public javax.swing.JButton jbtRegisterMenu;
    public javax.swing.JButton jbtStatistics;
    public javax.swing.JButton jbtUpdateListOrders;
    public javax.swing.JComboBox<String> jcbCategoryAllowedDrink;
    public javax.swing.JComboBox<String> jcbCategoryAllowedMenu;
    public javax.swing.JLabel jlAccount;
    public javax.swing.JLabel jlImageDrink;
    public javax.swing.JLabel jlImageMenu;
    public javax.swing.JMenu jmOptions;
    public javax.swing.JMenuBar jmbMenus;
    public javax.swing.JMenuItem jmiLogout;
    public javax.swing.JMenuItem jmiRegisterEmployee;
    public javax.swing.JMenuItem jmiRegisterMySQL;
    private javax.swing.JPanel jpButtons;
    private javax.swing.JPanel jpContainer;
    public javax.swing.JPanel jpMenu1;
    public javax.swing.JPanel jpMenu2;
    public javax.swing.JPanel jpMenu3;
    public javax.swing.JPanel jpMenu4;
    public javax.swing.JPanel jpMenu5;
    private org.edisoncor.gui.panel.PanelImage jpiBackground;
    public javax.swing.JRadioButton jrbDisabledMenu;
    public javax.swing.JRadioButton jrbEnabledMenu;
    public javax.swing.JSpinner jsCantDrink;
    public javax.swing.JTable jtTableDrinks;
    public javax.swing.JTable jtTableListDrinksOrder;
    public javax.swing.JTable jtTableListMenusOrder;
    public javax.swing.JTable jtTableListOrder;
    public javax.swing.JTable jtTableMenu;
    public javax.swing.JTable jtTableOrders;
    public javax.swing.JTextField jtfCostDrink;
    public javax.swing.JTextField jtfCostMenu;
    public javax.swing.JTextField jtfCostTotalOrder;
    public javax.swing.JTextField jtfIDDrink;
    public javax.swing.JTextField jtfIDMenu;
    public javax.swing.JTextField jtfNameDrink;
    public javax.swing.JTextField jtfNameMenu;
    public javax.swing.JTextField jtfSearchDrink;
    public javax.swing.JTextField jtfSearchDrinkToOrder;
    public javax.swing.JTextField jtfSearchMenu;
    public javax.swing.JTextField jtfSearchMenuToOrder;
    public javax.swing.JTextField jtfSearchOrder;
    // End of variables declaration//GEN-END:variables
}
