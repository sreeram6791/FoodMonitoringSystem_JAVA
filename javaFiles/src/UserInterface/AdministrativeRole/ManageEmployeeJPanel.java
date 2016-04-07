/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.AdministrativeRole;

import Business.Employee.Employee;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rama
 */
public class ManageEmployeeJPanel extends javax.swing.JPanel {
    private final JPanel container;
    private final OrganizationDirectory organizationDir;

    /**
     * Creates new form AdminWorkAreaJpanel
     */
    public ManageEmployeeJPanel(JPanel userProcessContainer,OrganizationDirectory organizationDir) {
        initComponents();
        this.container = userProcessContainer;
        this.organizationDir = organizationDir;
        
        populateOrganizationComboBox();
        populateOrganizationEmpComboBox();
    }

    public void populateOrganizationComboBox(){
        organizationJComboBox.removeAllItems();
        
        for (Organization organization : organizationDir.getOrganizationList()){
            organizationJComboBox.addItem(organization);
        }
    }
    
    public void populateOrganizationEmpComboBox(){
        organizationEmpJComboBox.removeAllItems();
        
        for (Organization organization : organizationDir.getOrganizationList()){
            organizationEmpJComboBox.addItem(organization);
        }
    }
    
    private void populateTable(Organization organization){
        DefaultTableModel model = (DefaultTableModel) organizationJTable.getModel();
        
        model.setRowCount(0);
        
        for (Employee employee : organization.getEmployeeDirectory().getEmployeeList()){
            Object[] row = new Object[2];
            row[0] = employee.getId();
            row[1] = employee.getName();
            model.addRow(row);
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

        jLabel1 = new javax.swing.JLabel();
        BACK = new javax.swing.JLabel();
        BACK2 = new javax.swing.JLabel();
        exit = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        organizationEmpJComboBox = new javax.swing.JComboBox();
        organizationJComboBox = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        organizationJTable = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        nameJTextField = new javax.swing.JTextField();
        BackGround = new javax.swing.JLabel();
        Forward = new javax.swing.JLabel();
        exit1 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(780, 580));
        setPreferredSize(new java.awt.Dimension(790, 585));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("URW Gothic L", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(254, 254, 254));
        jLabel1.setText("Organization");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 150, 40));

        BACK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/Basic/Previous-26.png"))); // NOI18N
        BACK.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BACK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                BACKMouseReleased(evt);
            }
        });
        add(BACK, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, 30));

        BACK2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/Basic/Close Window-26.png"))); // NOI18N
        BACK2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BACK2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                BACK2MouseReleased(evt);
            }
        });
        add(BACK2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 30));

        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/Basic/Checkmark-26.png"))); // NOI18N
        exit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                exitMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                exitMouseReleased(evt);
            }
        });
        add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 380, 30, 30));

        jLabel2.setBackground(new java.awt.Color(210, 214, 218));
        jLabel2.setFont(new java.awt.Font("URW Gothic L", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Create Employee");
        jLabel2.setOpaque(true);
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 30));

        jLabel7.setFont(new java.awt.Font("URW Gothic L", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(254, 254, 254));
        jLabel7.setText("Organization");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 150, 40));

        organizationEmpJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        organizationEmpJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                organizationEmpJComboBoxActionPerformed(evt);
            }
        });
        add(organizationEmpJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 320, 120, -1));

        organizationJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        organizationJComboBox.setBorder(null);
        organizationJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                organizationJComboBoxActionPerformed(evt);
            }
        });
        add(organizationJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, 120, -1));

        organizationJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
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
        jScrollPane1.setViewportView(organizationJTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 540, 90));

        jLabel10.setFont(new java.awt.Font("URW Gothic L", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(254, 254, 254));
        jLabel10.setText("User Name");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 370, 150, 40));

        nameJTextField.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        nameJTextField.setForeground(new java.awt.Color(1, 1, 1));
        nameJTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nameJTextField.setBorder(null);
        nameJTextField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        nameJTextField.setMinimumSize(new java.awt.Dimension(20, 17));
        nameJTextField.setOpaque(false);
        add(nameJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 380, 250, 30));

        BackGround.setFont(new java.awt.Font("URW Gothic L", 0, 9)); // NOI18N
        BackGround.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/Basic/background_4_800x600.png"))); // NOI18N
        BackGround.setBorder(null);
        BackGround.setCursor(new java.awt.Cursor(java.awt.Cursor.E_RESIZE_CURSOR));
        BackGround.setOpaque(true);
        add(BackGround, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 600));

        Forward.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/Basic/Next-26.png"))); // NOI18N
        Forward.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(Forward, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, -1, 30));

        exit1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/Basic/Exit Sign-26.png"))); // NOI18N
        exit1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exit1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                exit1MousePressed(evt);
            }
        });
        add(exit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, 30, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void BACK2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BACK2MouseReleased

        System.exit(0);
    }//GEN-LAST:event_BACK2MouseReleased

    private void exitMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_exitMousePressed

    private void exit1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_exit1MousePressed

    private void organizationJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_organizationJComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_organizationJComboBoxActionPerformed

    private void exitMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseReleased
  
        Organization organization = (Organization) organizationEmpJComboBox.getSelectedItem();
        String name = nameJTextField.getText();
        
        organization.getEmployeeDirectory().createEmployee(name);
        populateTable(organization);
        
        
    }//GEN-LAST:event_exitMouseReleased

    private void BACKMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BACKMouseReleased

        container.remove(this);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.previous(container);
        
    }//GEN-LAST:event_BACKMouseReleased

    private void organizationEmpJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_organizationEmpJComboBoxActionPerformed

         Organization organization = (Organization) organizationJComboBox.getSelectedItem();
        if (organization != null){
            populateTable(organization);
        }
        
    }//GEN-LAST:event_organizationEmpJComboBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BACK;
    private javax.swing.JLabel BACK2;
    private javax.swing.JLabel BackGround;
    private javax.swing.JLabel Forward;
    private javax.swing.JLabel exit;
    private javax.swing.JLabel exit1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameJTextField;
    private javax.swing.JComboBox organizationEmpJComboBox;
    private javax.swing.JComboBox organizationJComboBox;
    private javax.swing.JTable organizationJTable;
    // End of variables declaration//GEN-END:variables
}