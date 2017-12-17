/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EchipaSponsor;


import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;
public class EchipaSponsorDialog extends javax.swing.JFrame {

    /**
     * Creates new form EchipaSponsorDialog
     */
    public EchipaSponsorDialog(CautaEchipaSponsorApp theEmployeeSearchApp,
			EchipaSponsorDATA theEmployeeDAO, EchipaSponsor thePreviousEmployee, boolean theUpdateMode) {
		this();
		employeeDAO = theEmployeeDAO;
		employeeSearchApp = theEmployeeSearchApp;

		previousEmployee = thePreviousEmployee;
		
		updateMode = theUpdateMode;

		if (updateMode) {
			setTitle("Update Employee");
			
			populateGui(previousEmployee);
		}
	}
    private void populateGui(EchipaSponsor theEmployee) {

        
                int i1=theEmployee.getSponsorID();
                String SponsorID=Integer.toString(i1);
                SponsorIDTextField.setText(SponsorID);
                int i2=theEmployee.getEchipaID();
                String EchipaID=Integer.toString(i2);
                EchipaIDTextField.setText(EchipaID);
                int i3=theEmployee.getLuniDeContract();
                String LunideContract=Integer.toString(i3);
                LunideContractTextField.setText(LunideContract);
				
	}
    
    public EchipaSponsorDialog(CautaEchipaSponsorApp theEmployeeSearchApp,
			EchipaSponsorDATA theEmployeeDAO) {
		this(theEmployeeSearchApp, theEmployeeDAO, null, false);
	}
    
    
    
    public EchipaSponsorDialog() {
        initComponents();
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
        OKButton = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        SponsorIDTextField = new javax.swing.JTextField();
        EchipaIDTextField = new javax.swing.JTextField();
        LunideContractTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        OKButton.setText("OK");
        OKButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKButtonActionPerformed(evt);
            }
        });

        CancelButton.setText("Cancel");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Sponsor ID");

        jLabel3.setText("Echipa ID");

        jLabel4.setText("Luni de Contract");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(OKButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(SponsorIDTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                    .addComponent(EchipaIDTextField)
                    .addComponent(LunideContractTextField)
                    .addComponent(CancelButton))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(SponsorIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(EchipaIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(LunideContractTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OKButton)
                    .addComponent(CancelButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        dispose();
    }//GEN-LAST:event_CancelButtonActionPerformed

    private void OKButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKButtonActionPerformed
        // TODO add your handling code here:
        saveEchipaSponsor();
    }//GEN-LAST:event_OKButtonActionPerformed

    protected void saveEchipaSponsor() {

		// get the employee info from gui
                 //int CampCastigate = Integer.parseInt(CampCastigateTextField.getText());
                 int SponsorID=Integer.parseInt(SponsorIDTextField.getText());
                 int EchipaID=Integer.parseInt(EchipaIDTextField.getText());
                 int LuniDeContract=Integer.parseInt(LunideContractTextField.getText());
                 
		

		EchipaSponsor tempEmployee = null;

		if (updateMode) {
			tempEmployee = previousEmployee;
			tempEmployee.setSponsorID(SponsorID);
                        tempEmployee.setEchipaID(EchipaID);
                        tempEmployee.setLuniDeContract(LuniDeContract);
			
		} else {
			tempEmployee = new EchipaSponsor(SponsorID,EchipaID, LuniDeContract);
		}

		try {
			// save to the database
			if (updateMode) {
				employeeDAO.updateEchipaSponsor(tempEmployee);
			} else {
				employeeDAO.addEchipaSponsor(tempEmployee);
			}

			// close dialog
			setVisible(false);
			dispose();

			// refresh gui list
			employeeSearchApp.refreshEmployeesView();

			// show success message
			JOptionPane.showMessageDialog(employeeSearchApp,
					"SponsorID saved succesfully.", "SponsorID Saved",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(employeeSearchApp,
					"Error saving SponsorID: " + exc.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}

	}
    
    
    
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
            java.util.logging.Logger.getLogger(EchipaSponsorDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EchipaSponsorDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EchipaSponsorDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EchipaSponsorDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EchipaSponsorDialog().setVisible(true);
            }
        });
    }

    
    private EchipaSponsorDATA employeeDAO;

	private CautaEchipaSponsorApp employeeSearchApp;

	private EchipaSponsor previousEmployee = null;
	private boolean updateMode = false;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelButton;
    private javax.swing.JTextField EchipaIDTextField;
    private javax.swing.JTextField LunideContractTextField;
    private javax.swing.JButton OKButton;
    private javax.swing.JTextField SponsorIDTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}