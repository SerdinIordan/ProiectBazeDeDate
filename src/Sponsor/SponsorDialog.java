/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sponsor;


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
public class SponsorDialog extends javax.swing.JFrame {

    /**
     * Creates new form SponsorDialog
     */
    public SponsorDialog(CautaSponsorApp theEmployeeSearchApp,
			SponsorDATA theEmployeeDAO, Sponsor thePreviousEmployee, boolean theUpdateMode) {
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
    
    private void populateGui(Sponsor theEmployee) {
                NumeSponsorTextField.setText(theEmployee.getNumeSponsor());
                DataFondariiTextField.setText(theEmployee.getDataFondarii());
                FondatorTextField.setText(theEmployee.getFondator());
                SediuTextField.setText(theEmployee.getSediu());
                IndustrieTextField.setText(theEmployee.getIndustrie());
                ProfitTextField.setText(theEmployee.getProfit().toString());
                String strI = Integer.toString(theEmployee.getNumarAngajati());
                NumarAngajatiTextField.setText(strI);
                WebsiteTextField.setText(theEmployee.getWebsite());		
	}
    
    public SponsorDialog(CautaSponsorApp theEmployeeSearchApp,
			SponsorDATA theEmployeeDAO) {
		this(theEmployeeSearchApp, theEmployeeDAO, null, false);
	}
    public SponsorDialog() {
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        NumeSponsorTextField = new javax.swing.JTextField();
        DataFondariiTextField = new javax.swing.JTextField();
        FondatorTextField = new javax.swing.JTextField();
        SediuTextField = new javax.swing.JTextField();
        IndustrieTextField = new javax.swing.JTextField();
        ProfitTextField = new javax.swing.JTextField();
        NumarAngajatiTextField = new javax.swing.JTextField();
        WebsiteTextField = new javax.swing.JTextField();
        OKButton = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nume Sponsor");

        jLabel2.setText("Data Fondarii");

        jLabel3.setText("Fondator");

        jLabel4.setText("Sediu");

        jLabel5.setText("Industrie");

        jLabel6.setText("Profit");

        jLabel7.setText("Numar Angajati");

        jLabel8.setText("Website");

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(NumeSponsorTextField)
                            .addComponent(DataFondariiTextField)
                            .addComponent(FondatorTextField)
                            .addComponent(SediuTextField)
                            .addComponent(IndustrieTextField)
                            .addComponent(ProfitTextField)
                            .addComponent(NumarAngajatiTextField)
                            .addComponent(WebsiteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(OKButton)
                        .addGap(66, 66, 66)
                        .addComponent(CancelButton)))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(NumeSponsorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(DataFondariiTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(FondatorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(SediuTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(IndustrieTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(ProfitTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(NumarAngajatiTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(WebsiteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OKButton)
                    .addComponent(CancelButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OKButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKButtonActionPerformed
        // TODO add your handling code here:
        saveSponsor();
    }//GEN-LAST:event_OKButtonActionPerformed

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        // TODO add your handling code here:
        setVisible(false);
	dispose();
        
    }//GEN-LAST:event_CancelButtonActionPerformed

    protected BigDecimal convertStringToBigDecimal(String salaryStr) {

		BigDecimal result = null;

		try {
			double salaryDouble = Double.parseDouble(salaryStr);

			result = BigDecimal.valueOf(salaryDouble);
		} catch (Exception exc) {
			System.out.println("Invalid value. Defaulting to 0.0");
			result = BigDecimal.valueOf(0.0);
		}

		return result;
	}
    
    
    protected void saveSponsor() {

		// get the employee info from gui
                String NumeSponsor=NumeSponsorTextField.getText();
                String DataFondarii=DataFondariiTextField.getText();
                String Fondator=FondatorTextField.getText();
                String Sediu=SediuTextField.getText();
                String Industrie=IndustrieTextField.getText();
                // int CampCastigate = Integer.parseInt(CampCastigateTextField.getText());
                
		String salaryStr = ProfitTextField.getText();
		BigDecimal Profit = convertStringToBigDecimal(salaryStr);
                
                int NumarAngajati=Integer.parseInt(NumarAngajatiTextField.getText());
                String Website=WebsiteTextField.getText();
               


		Sponsor tempEmployee = null;

		if (updateMode) {
			tempEmployee = previousEmployee;
			tempEmployee.setNumeSponsor(NumeSponsor);
                        tempEmployee.setDataFondarii(DataFondarii);
                        tempEmployee.setFondator(Fondator);
                        tempEmployee.setSediu(Sediu);
                        tempEmployee.setIndustrie(Industrie);
                        tempEmployee.setProfit(Profit);
                        tempEmployee.setNumarAngajati(NumarAngajati);
                        tempEmployee.setWebsite(Website);
			
			
		} else {
			tempEmployee = new Sponsor(NumeSponsor, DataFondarii, Fondator,Sediu,Industrie,Profit,NumarAngajati,Website);
		}

		try {
			// save to the database
			if (updateMode) {
				employeeDAO.updateSponsor(tempEmployee);
			} else {
				employeeDAO.addSponsor(tempEmployee);
			}

			// close dialog
			setVisible(false);
			dispose();

			// refresh gui list
			employeeSearchApp.refreshSponsorView();

			// show success message
			JOptionPane.showMessageDialog(employeeSearchApp,
					"Sponsor saved succesfully.", "Sponsor Saved",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(employeeSearchApp,
					"Error saving sponsor: " + exc.getMessage(), "Error",
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
            java.util.logging.Logger.getLogger(SponsorDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SponsorDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SponsorDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SponsorDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SponsorDialog().setVisible(true);
            }
        });
    }

    
    private SponsorDATA employeeDAO;

	private CautaSponsorApp employeeSearchApp;

	private Sponsor previousEmployee = null;
	private boolean updateMode = false;
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelButton;
    private javax.swing.JTextField DataFondariiTextField;
    private javax.swing.JTextField FondatorTextField;
    private javax.swing.JTextField IndustrieTextField;
    private javax.swing.JTextField NumarAngajatiTextField;
    private javax.swing.JTextField NumeSponsorTextField;
    private javax.swing.JButton OKButton;
    private javax.swing.JTextField ProfitTextField;
    private javax.swing.JTextField SediuTextField;
    private javax.swing.JTextField WebsiteTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables
}
