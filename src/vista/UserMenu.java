/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import Controlador.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Conexion;

/**
 *
 * @author juanc
 */
public class UserMenu extends javax.swing.JFrame {
    Conexion conexion = new Conexion();
    Connection connection;
    //esta pa las querys
    Statement st;
    //esta pa los resultados del query
    ResultSet rs;
    //para traes la tabla
    DefaultTableModel contenidoTablaEmpleados;
    DefaultTableModel contenidoTablaDirecciones;
    ComboBoxModel enumZona;
    ComboBoxModel enumDepartamento;
    ComboBoxModel enumTipoCalle;
    /**
     * Creates new form UserMenu
     */
    public UserMenu() {
        enumZona = new DefaultComboBoxModel(EnumZona.values());
        enumDepartamento = new DefaultComboBoxModel(EnumMunicipios.values());
        enumTipoCalle = new DefaultComboBoxModel(EnumTipoCalle.values());
        initComponents();
        this.setLocationRelativeTo(this);
        listarEmpleados();
        listarDepartamentos();
    }
    public void eliminarDatosTablaEmpleado()
    {
        for (int i = 0; i < tblEmploy.getRowCount(); i++)
        {
            contenidoTablaEmpleados.removeRow(i);
            i-=1;
        }
    }
     public void eliminarDatosTablaDepartamento()
    {
        for (int i = 0; i < tblDepartamentos.getRowCount(); i++)
        {
            contenidoTablaDirecciones.removeRow(i);
            i-=1;
        }
        cbDepartament.setSelectedIndex(0);
        cbCalle.setSelectedIndex(0);
        cbZona.setSelectedIndex(0);
        txtNumero1.setText("");
        txtNumero2.setText("");
        txtNumero3.setText("");
    }
    public void  listarEmpleados()
    {
        String filtro = txtBusqueda.getText();
        if(filtro.isEmpty())
        {
        String query = "SELECT nombreEmp,apellidos,tipoDocumento,correo,nombreSucursal FROM empleado INNER JOIN sucursal ON Empleado.FK_idSucursal = sucursal.idSucurlsal;";
        try 
        {
            connection = conexion.getConnection();
            st = connection.createStatement();
            rs = st.executeQuery(query);
            Object[] empleados = new Object[6];
            contenidoTablaEmpleados = (DefaultTableModel)tblEmploy.getModel();
            while(rs.next())
            {
                
                empleados[0] = rs.getString("nombreEmp") ; 
                empleados[1] = rs.getString("apellidos") ; 
                empleados[2] = rs.getString("tipoDocumento");
                empleados[3] = rs.getString("documento");
                empleados[4] = rs.getString("correo");
                empleados[5] = rs.getString("nombreSucursal");
                contenidoTablaEmpleados.addRow(empleados);
                tblEmploy.setModel(contenidoTablaEmpleados);
            }
        }
        catch (SQLException e) 
        {
            System.out.println("No se pudo cargar la informacion de los empleados");
        }
        }
        else 
        {
            String query = "SELECT nombreEmp,apellidos,tipoDocumento,correo,nombreSucursal FROM empleado INNER JOIN sucursal ON Empleado.FK_idSucursal = sucursal.idSucurlsalWHERE nombreEmp LIKE %" + filtro+ "% OR apellido LIKE ' %" +filtro + "%;";
            try 
        {
            connection = conexion.getConnection();
            st = connection.createStatement();
            rs = st.executeQuery(query);
            Object[] empleados = new Object[6];
            contenidoTablaEmpleados = (DefaultTableModel)tblEmploy.getModel();
            while(rs.next())
            {
                empleados[0] = rs.getString("nombreEmp") ; 
                empleados[1] = rs.getString("apellidos") ; 
                empleados[2] = rs.getString("tipoDocumento");
                empleados[3] = rs.getString("documento");
                empleados[4] = rs.getString("correo");
                empleados[5] = rs.getString("nombreSucursal");
                contenidoTablaEmpleados.addRow(empleados);
                tblEmploy.setModel(contenidoTablaEmpleados);
            }
        }
        catch (SQLException e) 
        {
            System.out.println("No se pudo cargar la informacion de los empleados");
        }
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LineaProductos = new javax.swing.JTabbedPane();
        jPanel9 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmploy = new javax.swing.JTable();
        btnAddUser = new javax.swing.JButton();
        txtBusqueda = new javax.swing.JTextField();
        btnBusqueda = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cbDepartament = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbZona = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cbCalle = new javax.swing.JComboBox<>();
        txtNumero1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtNumero2 = new javax.swing.JTextField();
        txtNumero3 = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDepartamentos = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        txtSearchDepto = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnListarEmpleados = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/logo.png"))); // NOI18N

        jLabel5.setText("Empleados");

        jLabel6.setText("Mision TIC 2022");

        tblEmploy.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Apellidos", "Tipo Documento", "Documento", "Correo", "Sucursal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEmploy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmployMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEmploy);

        btnAddUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/avatar.png"))); // NOI18N
        btnAddUser.setText("Nuevo");
        btnAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddUserActionPerformed(evt);
            }
        });

        btnBusqueda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/showUser.png"))); // NOI18N
        btnBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBusquedaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel4)
                .addGap(203, 203, 203)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addComponent(jLabel5)
                .addGap(41, 41, 41)
                .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBusqueda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addComponent(btnAddUser)
                .addGap(42, 42, 42))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBusqueda))
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(btnAddUser)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        LineaProductos.addTab("Empleados", jPanel9);

        jPanel7.setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/logo.png"))); // NOI18N

        jLabel2.setText("Departamento");

        cbDepartament.setModel(enumDepartamento);

        jLabel3.setText("Zona");

        cbZona.setModel(enumZona);

        jLabel7.setText("Tipo Calle");

        cbCalle.setModel(enumTipoCalle);
        cbCalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCalleActionPerformed(evt);
            }
        });

        jLabel8.setText("#");

        jLabel9.setText("-");

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/confirmIcon.png"))); // NOI18N
        btnGuardar.setText("Añadir");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jLabel10.setText("Registro direccion");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(cbDepartament, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(cbCalle, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnGuardar)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtNumero1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jLabel8)))
                        .addGap(48, 48, 48)
                        .addComponent(txtNumero2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNumero3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(30, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbZona, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(73, 73, 73))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbDepartament, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cbZona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbCalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumero1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(txtNumero2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumero3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(btnGuardar)
                .addGap(47, 47, 47))
        );

        tblDepartamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Departamento", "Zona", "Direccion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDepartamentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDepartamentosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblDepartamentos);

        jLabel11.setText("Departamento");

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/showUser.png"))); // NOI18N

        btnListarEmpleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/avatar.png"))); // NOI18N
        btnListarEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarEmpleadosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(337, 337, 337)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearchDepto, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                                .addComponent(btnListarEmpleados)))))
                .addGap(23, 23, 23))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSearchDepto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11))
                    .addComponent(btnSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(btnListarEmpleados)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        LineaProductos.addTab("Sucursales", jPanel7);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LineaProductos)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LineaProductos)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusquedaActionPerformed
        this.listarEmpleados();

    }//GEN-LAST:event_btnBusquedaActionPerformed

    private void btnAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddUserActionPerformed
        AddUserForm addUser = new AddUserForm(this, rootPaneCheckingEnabled);
        addUser.setVisible(true);

    }//GEN-LAST:event_btnAddUserActionPerformed

    private void tblEmployMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmployMouseClicked
        int row = tblEmploy.getSelectedRow();
        if(row<0)
        {
            JOptionPane.showMessageDialog(this,"Seleciona un empleado",  "seleccion" , JOptionPane.WARNING_MESSAGE);
        }
        else
        {
            
           
            String nommbre = (String)tblEmploy.getValueAt(row, 0);
            String apellido = (String)tblEmploy.getValueAt(row, 1);
            String tipoDocumento  = (String)tblEmploy.getValueAt(row, 2);
            String documento = (String)tblEmploy.getValueAt(row, 3);
            String correo = (String)tblEmploy.getValueAt(row, 4);
            String sucursal = (String)tblEmploy.getValueAt(row, 5);
            String  query = "SELECT idEmp from empleado where documento = '"+ documento +"';" ;
            try 
            {
                connection = conexion.getConnection();
                st = connection.createStatement();
                rs = st.executeQuery(query);
                while(rs.next())
                {
                    int idEmpleado = rs.getInt("idEmp");  
                    ShowUserForm showUserForm = new ShowUserForm(this, rootPaneCheckingEnabled);
                    showUserForm.showUserInfo( nommbre,apellido , documento, correo , sucursal);
                    showUserForm.setVisible(rootPaneCheckingEnabled);
                }
                eliminarDatosTablaEmpleado();
                listarEmpleados();
            }
            catch (SQLException e)
            {
                System.out.println(e);
            }
            eliminarDatosTablaEmpleado();
            listarEmpleados();

            
        }
    }//GEN-LAST:event_tblEmployMouseClicked

    private void cbCalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCalleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCalleActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        String departamento = cbDepartament.getSelectedItem().toString();
        String zona = cbZona.getSelectedItem().toString();
        String tipoCalle = cbCalle.getSelectedItem().toString();
        String numero1 = txtNumero1.getText();
        String numero2 = txtNumero2.getText();
        String numero3 = txtNumero3.getText();
        String query = "INSERT INTO direcion (zona, tipoCalle , numero1 ,numero2 , numero3 , nombreDepartamento) VALUES ('" + zona + "','"+ tipoCalle + "','"+numero1 + "','"+numero2 + "','"+numero3 + "','"+departamento + ");";
        try 
        {
            connection = conexion.getConnection();
            st = connection.createStatement();
            st.executeUpdate(query);
            eliminarDatosTablaDepartamento();
            listarDepartamentos();
            SucursalForm sucursalForm = new SucursalForm(this,true);
            sucursalForm.setVisible(true);
            String queryIdDireccion = "SELECT idDirecion FROM direccion WHERE nombredepartamento = '"+departamento +"' AND zona = '"+ zona +"' AND tipoCalle = '"+tipoCalle +" 'AND numero1 = '"+ numero1 +"' AND numero2 ='"+numero2 +" 'AND numero3 = '"+ numero3 +"';";
            try 
            {
                st = connection.createStatement();
                rs = st.executeQuery(queryIdDireccion);
                while(rs.next())
                {
                int  idDireccion = rs.getInt("idDireccion");
                sucursalForm.recibirDatosDireccion(idDireccion);
                JOptionPane.showMessageDialog(this,"Se creo la nueva sucursal");
                }
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
            
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(this,"No fue posible crear la direcion", "Sucursales", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void tblDepartamentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDepartamentosMouseClicked
       
    }//GEN-LAST:event_tblDepartamentosMouseClicked

    private void btnListarEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarEmpleadosActionPerformed
       EmpleadosList empleadosList = new EmpleadosList(this, rootPaneCheckingEnabled);
       empleadosList.setVisible(rootPaneCheckingEnabled);
       int filaSelecionadad = tblDepartamentos.getSelectedRow();
       String sucursal = (String) tblDepartamentos.getValueAt(filaSelecionadad,0).toString();
       String query = "SELECT idSucursal From sucursal WHERE nombreSucursal = '"+ sucursal+"';";
        try 
        {
          connection = conexion.getConnection();
          st= connection.createStatement();
          rs = st.executeQuery(query);
          while(rs.next())
          {
              int  idSucursal = rs.getInt("idSucursal");
              EmpleadosList empleadoList = new EmpleadosList(this, rootPaneCheckingEnabled);
              empleadoList.recibirSucursal(idSucursal);
              empleadoList.setVisible(rootPaneCheckingEnabled);
          }
        }
        catch (SQLException e)
        {
            System.out.println(e);
        }
               
       
    }//GEN-LAST:event_btnListarEmpleadosActionPerformed
    public void listarDepartamentos() 
    {
        String busqueda = txtSearchDepto.getText();
        if (busqueda.isEmpty()) 
        {
            String query = "SELECT nombreSucursal, nombreDepartamento , CCONCAT('Zona ', zona , '.', tipoCalle, ' ' , numero1 , ' #No. ', numero2 , ' - ' , numero3  ) AS direccion FROM `sucursal` INNER JOIN `direccion` WHERE idDireccion = FK_idDireccion GROUP BY nombreDepartamento, nombreSucursal ORDER BY ombreDepartamento;";
            try 
            {
                connection = conexion.getConnection();
                st = connection.createStatement();
                rs = st.executeQuery(query);
                Object[] direccion = new Object[3];
                contenidoTablaDirecciones = (DefaultTableModel) tblDepartamentos.getModel();
                while (rs.next()) {
                    direccion[0] = rs.getString("nombreSucursal");
                    direccion[1] = rs.getString("nombreDerpartamento");
                    direccion[2] = rs.getString("direccion");
                    contenidoTablaDirecciones.addRow(direccion);
                    tblDepartamentos.setModel(contenidoTablaDirecciones);
                }
                JOptionPane.showMessageDialog(this, "Se creo la nueva Direcion");
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(this, "No fue posible cargar la informacion de la tabla", "Sucursales", JOptionPane.WARNING_MESSAGE);
            }
        }
        else
        {
              String query = "SELECT nombreSucursal, nombreDepartamento , CCONCAT('Zona ', zona , '.', tipoCalle, ' ' , numero1 , ' #No. ', numero2 , ' - ' , numero3  ) AS direccion FROM `sucursal` INNER JOIN `direccion` WHERE idDireccion = FK_idDireccion AND nombreDepartamento  LIKE '%" + busqueda + "%' GROUP BY nombreDepartamento, nombreSucursal ORDER BY ombreDepartamento;";
            try 
            {
                connection = conexion.getConnection();
                st = connection.createStatement();
                rs = st.executeQuery(query);
                Object[] direccion = new Object[3];
                contenidoTablaDirecciones = (DefaultTableModel) tblDepartamentos.getModel();
                while (rs.next()) {
                    direccion[0] = rs.getString("nombreSucursal");
                    direccion[1] = rs.getString("nombreDerpartamento");
                    direccion[2] = rs.getString("direccion");
                    contenidoTablaDirecciones.addRow(direccion);
                    tblDepartamentos.setModel(contenidoTablaDirecciones);
                }
                JOptionPane.showMessageDialog(this, "Se creo la nueva Direcion");
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(this, "No fue posible cargar la informacion de la tabla", "Sucursales", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane LineaProductos;
    private javax.swing.JButton btnAddUser;
    private javax.swing.JButton btnBusqueda;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnListarEmpleados;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cbCalle;
    private javax.swing.JComboBox<String> cbDepartament;
    private javax.swing.JComboBox<String> cbZona;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblDepartamentos;
    private javax.swing.JTable tblEmploy;
    private javax.swing.JTextField txtBusqueda;
    private javax.swing.JTextField txtNumero1;
    private javax.swing.JTextField txtNumero2;
    private javax.swing.JTextField txtNumero3;
    private javax.swing.JTextField txtSearchDepto;
    // End of variables declaration//GEN-END:variables
}