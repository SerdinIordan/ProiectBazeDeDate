/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Etapa;


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
public class EtapaDialog extends javax.swing.JFrame {

    /**
     * Creates new form EtapaDialog
     */
    
	public EtapaDialog(CautaEtapaApp theEmployeeSearchApp,
			EtapaDATA theEmployeeDAO, Etapa thePreviousEmployee, boolean theUpdateMode) {
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

    private void populateGui(Etapa theEmployee) {

        //String strI = Integer.toString(theEchipa.getCampCastigate());
        String strI=Integer.toString(theEmployee.getNumarEtapa());
        NumarEtapaTextField.setText(strI);
        DataEtapeiTextField.setText(theEmployee.getDataEtapei());		
	}
    public EtapaDialog(CautaEtapaApp theEmployeeSearchApp,
			EtapaDATA theEmployeeDAO) {
		this(theEmployeeSearchApp, theEmployeeDAO, null, false);
	}
        
        
        
    
    
    public EtapaDialog() {
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
        jLabel2 = new javax.swing.JLabel();
        NumarEtapaTextField = new javax.swing.JTextField();
        DataEtapeiTextField = new javax.swing.JTextField();
        OKButton = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Numar Etapa");

        jLabel2.setText("Data Etapei");

        NumarEtapaTextField.setToolTipText("");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(DataEtapeiTextField)
                            .addComponent(NumarEtapaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(OKButton)
                        .addGap(60, 60, 60)
                        .addComponent(CancelButton)))
                .addContainerGap(108, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(NumarEtapaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(DataEtapeiTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OKButton)
                    .addComponent(CancelButton))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OKButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKButtonActionPerformed
        // TODO add your handling code here:
        saveEtapa();
    }//GEN-LAST:event_OKButtonActionPerformed

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        dispose();
    }//GEN-LAST:event_CancelButtonActionPerformed

    protected void saveEtapa() {

		// get the employee info from gui
                String text1=NumarEtapaTextField.getText();
                int NumarEtapa=Integer.parseInt(text1);
                String DataEtapei=DataEtapeiTextField.getText();

		Etapa tempEmployee = null;

		if (updateMode) {
			tempEmployee = previousEmployee;
			
			tempEmployee.setNumarEtapa(NumarEtapa);
			tempEmployee.setDataEtapei(DataEtapei);
			
		} else {
			tempEmployee = new Etapa(NumarEtapa,DataEtapei);
		}

		try {
			// save to the database
			if (updateMode) {
				employeeDAO.updateEtapa(tempEmployee);
			} else {
				employeeDAO.addEtapa(tempEmployee);
			}

			// close dialog
			setVisible(false);
			dispose();

			// refresh gui list
			employeeSearchApp.refreshEmployeesView();

			// show success message
			JOptionPane.showMessageDialog(employeeSearchApp,
					"Etapa saved succesfully.", "Etapa Saved",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(employeeSearchApp,
					"Error saving etapa: " + exc.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
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
            java.util.logging.Logger.getLogger(EtapaDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EtapaDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EtapaDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EtapaDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EtapaDialog().setVisible(true);
            }
        });
    }
    
    
    
    private EtapaDATA employeeDAO;

	private CautaEtapaApp employeeSearchApp;

	private Etapa previousEmployee = null;
	private boolean updateMode = false;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelButton;
    private javax.swing.JTextField DataEtapeiTextField;
    private javax.swing.JTextField NumarEtapaTextField;
    private javax.swing.JButton OKButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}