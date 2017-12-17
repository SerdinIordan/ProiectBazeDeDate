/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EchipaSponsor;

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



public class EchipaSponsorDATA {

	private Connection myConn;
	
	public EchipaSponsorDATA() throws Exception {
		
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
	
	public void deleteEchipaSponsor(int EchipaId) throws SQLException, Exception  {
		PreparedStatement myStmt = null;
                Connection myConn=null;

		try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String url="jdbc:sqlserver://localhost:1433; databaseName=Campionat; user=Serdin; password=12345";
                myConn=DriverManager.getConnection(url);
			// prepare statement
			myStmt = myConn.prepareStatement("delete from SponsorEchipa where SponsorID=? ");
			
			// set param
			myStmt.setInt(1, EchipaId);
			
			// execute SQL
			myStmt.executeUpdate();			
		}
		finally {
			close(myStmt);
		}
	}
	
	public void updateEchipaSponsor(EchipaSponsor theEchipa) throws SQLException, Exception {
            PreparedStatement myStmt = null;
            Connection myConn=null;

		try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String url="jdbc:sqlserver://localhost:1433; databaseName=Campionat; user=Serdin; password=12345";
                myConn=DriverManager.getConnection(url);
			// prepare statement
			myStmt = myConn.prepareStatement("update SponsorEchipa"
					+ " set SponsorID=?, EchipaID=?, LuniDeContract=?"
					+ " where SponsorID=?");
			
			// set params
                        myStmt.setInt(1, theEchipa.getSponsorID());
                        myStmt.setInt(2, theEchipa.getEchipaID());
                        myStmt.setInt(3, theEchipa.getLuniDeContract());
			
                                                
			myStmt.setInt(4, theEchipa.getSponsorID());
			
			// execute SQL
			myStmt.executeUpdate();			
		}
		finally {
			close(myStmt);
		}
		
	}
	
	public void addEchipaSponsor(EchipaSponsor theEchipa) throws Exception {
            Connection myConn=null;
            PreparedStatement myStmt = null;

		try {
			// prepare statement
                        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String url="jdbc:sqlserver://localhost:1433; databaseName=Campionat; user=Serdin; password=12345";
                myConn=DriverManager.getConnection(url);
			myStmt = myConn.prepareStatement("insert into SponsorEchipa"
					+ " (SponsorID, EchipaID, LuniDeContract)"
					+ " values (?, ?, ?)");
			
			// set params
			myStmt.setInt(1, theEchipa.getSponsorID());
                        myStmt.setInt(2, theEchipa.getEchipaID());
			myStmt.setInt(3, theEchipa.getLuniDeContract());
			
			// execute SQL
			myStmt.executeUpdate();			
		}
		finally {
			close(myStmt);
		}
		
	}
        
	public List<EchipaSponsor> getAllEchipaSponsor() throws Exception {
		List<EchipaSponsor> list = new ArrayList<>();
		Connection myConn=null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
                     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String url="jdbc:sqlserver://localhost:1433; databaseName=Campionat; user=Serdin; password=12345";
                myConn=DriverManager.getConnection(url);
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery("select * from SponsorEchipa");
			
			while (myRs.next()) {
				EchipaSponsor tempEchipa = convertRowToEchipaSponsor(myRs);
				list.add(tempEchipa);
			}

			return list;		
		}
		finally {
			close(myStmt, myRs);
		}
	}
        
        
        
	
		
                        
                       
        
        
        
        
	
	public List<EchipaSponsor> searchEchipaSponsor(int Nume) throws Exception {
		List<EchipaSponsor> list = new ArrayList<>();
                Connection myConn=null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String url="jdbc:sqlserver://localhost:1433; databaseName=Campionat; user=Serdin; password=12345";
                myConn=DriverManager.getConnection(url);
			myStmt = myConn.prepareStatement("select * from SponsorEchipa where SponsorID like ?");
			
			myStmt.setInt(1, Nume);
			
			myRs = myStmt.executeQuery();
			
			while (myRs.next()) {
				EchipaSponsor tempEchipa = convertRowToEchipaSponsor(myRs);
				list.add(tempEchipa);
			}
			
			return list;
		}
		finally {
			close(myStmt, myRs);
		}
	}
	
	private EchipaSponsor convertRowToEchipaSponsor(ResultSet myRs) throws SQLException {
		
		int EchipaID = myRs.getInt("EchipaID");
                int SponsorID = myRs.getInt("SponsorID");
                int LuniDeContract = myRs.getInt("LuniDeContract");
		EchipaSponsor tempEchipa = new EchipaSponsor(SponsorID, EchipaID, LuniDeContract);
		
		return tempEchipa;
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
	
	//public static void main(String[] args) throws Exception {
		
            //EchipaSponsorDATA d=new EchipaSponsorDATA();
            //System.out.println(d.a);
            
            /*
		EchipaDAO dao = new EchipaDAO();
                System.out.println(dao.getAllEchipe());
                //dao.interogare1();
		System.out.println(dao.searchEchipe("Steaua"));

		System.out.println(dao.getAllEchipe());
                //System.out.println(dao.getNumeEchipaID(6));
                
                System.out.println(dao.Campionat());*/
                
                
          //      } 
     
        }



