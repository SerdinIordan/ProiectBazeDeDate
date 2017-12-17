/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jucator;

import Echipa.Echipa;
import Echipa.equip;
import java.util.*;
import java.sql.*;
import java.io.*;
import java.math.BigDecimal;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.FlowLayout;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;



public class JucatorDATA {

	private Connection myConn;
	
	public JucatorDATA() throws Exception {
		
		// get db properties
		Properties props = new Properties();
		props.load(new FileInputStream("demo.properties"));
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String user = props.getProperty("user");
		String password = props.getProperty("password");
		String dburl = props.getProperty("dburl");
		
		// connect to database
                myConn=DriverManager.getConnection(dburl);
		//myConn = DriverManager.getConnection(dburl, user, password);
		
		System.out.println("DB connection successful to: " + dburl);
	}
	
	public void deleteJucator(int JucatorId) throws SQLException, Exception  {
		PreparedStatement myStmt = null;
                Connection myConn=null;

		try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String url="jdbc:sqlserver://localhost:1433; databaseName=Campionat; user=Serdin; password=12345";
                myConn=DriverManager.getConnection(url);
			// prepare statement
			myStmt = myConn.prepareStatement("delete from Jucator where JucatorID=?");
			
			// set param
			myStmt.setInt(1, JucatorId);
			
			// execute SQL
			myStmt.executeUpdate();			
		}
		finally {
			close(myStmt);
		}
	}
	
	public void updateJucator(Jucator theJucator) throws SQLException, Exception {
            PreparedStatement myStmt = null;
            Connection myConn=null;

		try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String url="jdbc:sqlserver://localhost:1433; databaseName=Campionat; user=Serdin; password=12345";
                myConn=DriverManager.getConnection(url);
			// prepare statement
			myStmt = myConn.prepareStatement("update Jucator"
					+ " set EchipaID=?, Nume=?, Prenume=?, DataNasterii=?,"
                                + "Inaltime=?, Greutate=?,Pozitie=?"
					+ " where JucatorID=?");
			
			// set params
                        myStmt.setInt(1, theJucator.getEchipaID());
                        myStmt.setString(2, theJucator.getNume());
                        myStmt.setString(3, theJucator.getPrenume());
                        myStmt.setString(4, theJucator.getDataNasterii());
                        myStmt.setFloat(5, theJucator.getInaltime());
                        myStmt.setInt(6, theJucator.getGreutate());
                        myStmt.setString(7, theJucator.getPozitie());
                        
                        myStmt.setInt(8, theJucator.getJucatorID());
                        
			
			// execute SQL
			myStmt.executeUpdate();			
		}
		finally {
			close(myStmt);
		}
		
	}
	
	public void addJucator(Jucator theJucator) throws Exception {
            Connection myConn=null;
            PreparedStatement myStmt = null;

		try {
			// prepare statement
                        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String url="jdbc:sqlserver://localhost:1433; databaseName=Campionat; user=Serdin; password=12345";
                myConn=DriverManager.getConnection(url);
			myStmt = myConn.prepareStatement("insert into Jucator"
					+ " (EchipaID, Nume, Prenume, DataNasterii,Inaltime,Greutate,Pozitie)"
					+ " values (?, ?, ?, ?, ?, ?, ?)");
			
			// set params
			myStmt.setInt(1, theJucator.getEchipaID());
                        myStmt.setString(2, theJucator.getNume());
                        myStmt.setString(3, theJucator.getPrenume());
                        myStmt.setString(4, theJucator.getDataNasterii());
                        myStmt.setFloat(5, theJucator.getInaltime());
                        myStmt.setInt(6, theJucator.getGreutate());
                        myStmt.setString(7, theJucator.getPozitie());
                        
                       
			
			// execute SQL
			myStmt.executeUpdate();			
		}
		finally {
			close(myStmt);
		}
		
	}
        
	public List<Jucator> getAllJucator() throws Exception {
		List<Jucator> list = new ArrayList<>();
		Connection myConn=null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
                     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String url="jdbc:sqlserver://localhost:1433; databaseName=Campionat; user=Serdin; password=12345";
                myConn=DriverManager.getConnection(url);
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery("select * from Jucator");
			
			while (myRs.next()) {
				Jucator tempEchipa = convertRowToJucator(myRs);
				list.add(tempEchipa);
			}

			return list;		
		}
		finally {
			close(myStmt, myRs);
		}
	}
        
        
        
	
        
        
        
        
	
	public List<Jucator> searchEchipe(String Nume) throws Exception {
		List<Jucator> list = new ArrayList<>();
                Connection myConn=null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String url="jdbc:sqlserver://localhost:1433; databaseName=Campionat; user=Serdin; password=12345";
                myConn=DriverManager.getConnection(url);
			Nume += "%";
			myStmt = myConn.prepareStatement("select * from Jucator where Nume like ?");
			
			myStmt.setString(1, Nume);
			
			myRs = myStmt.executeQuery();
			
			while (myRs.next()) {
				Jucator tempJucator = convertRowToJucator(myRs);
				list.add(tempJucator);
			}
			
			return list;
		}
		finally {
			close(myStmt, myRs);
		}
	}
	
	private Jucator convertRowToJucator(ResultSet myRs) throws SQLException {
		
                int JucatorID=myRs.getInt("JucatorID");
		int EchipaID = myRs.getInt("EchipaID");
                String Nume = myRs.getString("Nume");
                String Prenume = myRs.getString("Prenume");
                String DataNasterii = myRs.getString("DataNasterii");
                float Inaltime=myRs.getFloat("Inaltime");
                int Greutate = myRs.getInt("Greutate");
                String Pozitie = myRs.getString("Pozitie");
		Jucator tempJucator = new Jucator(JucatorID,EchipaID, Nume, Prenume, DataNasterii,Inaltime,Greutate,Pozitie);
		
		return tempJucator;
	}
        
        

	
	private static void close(Connection myConn, Statement myStmt, ResultSet myRs)
			throws SQLException {

		if (myRs != null) {
			myRs.close();
		}

		if (myStmt != null) {
			
		}
		
		if (myConn != null) {
			myConn.close();
		}
	}

	private void close(Statement myStmt, ResultSet myRs) throws SQLException {
		close(null, myStmt, myRs);		
	}
        private void close(ResultSet myRs) throws SQLException {
		close(null, null, myRs);		
	}

	private void close(Statement myStmt) throws SQLException {
		close(null, myStmt, null);		
	}
	
	/*public static void main(String[] args) throws Exception {
		
		/*EchipaDAO dao = new EchipaDAO();
                dao.interogare1();*/
                //JucatorDATA j=new JucatorDATA();
                //System.out.println(j.getAllJucator());
		/*System.out.println(dao.searchEchipe("Steaua"));

		System.out.println(dao.getAllEchipe());
                //System.out.println(dao.getNumeEchipaID(6));
                
                System.out.println(dao.Campionat());
                
                
                } */
               
        }



