/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rezultat;


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



public class RezultatDATA {

	private Connection myConn;
	
	public RezultatDATA() throws Exception {
		
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
		
		//System.out.println("DB connection successful to: " + dburl);
	}
	
	public void deleteRezultat(int RezultatId) throws SQLException, Exception  {
		PreparedStatement myStmt = null;
                Connection myConn=null;

		try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String url="jdbc:sqlserver://localhost:1433; databaseName=Campionat; user=Serdin; password=12345";
                myConn=DriverManager.getConnection(url);
			// prepare statement
			myStmt = myConn.prepareStatement("delete from Rezultat where RezultatID=?");
			
			// set param
			myStmt.setInt(1, RezultatId);
			
			// execute SQL
			myStmt.executeUpdate();			
		}
		finally {
			close(myStmt);
		}
	}
	
	public void updateRezultat(Rezultat theEchipa) throws SQLException, Exception {
            PreparedStatement myStmt = null;
            Connection myConn=null;

		try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String url="jdbc:sqlserver://localhost:1433; databaseName=Campionat; user=Serdin; password=12345";
                myConn=DriverManager.getConnection(url);
			// prepare statement
			myStmt = myConn.prepareStatement("update Rezultat"
					+ " set EtapaID=?, EchipaID1=?, EchipaID2=?, NumarGoluri1=?,"
                                + "NumarGoluri2=?"
					+ " where RezultatID=?");
			
			// set params
                        
                        myStmt.setInt(1, theEchipa.getEtapaID());
                       //String Nume1=
                        myStmt.setInt(2, theEchipa.getEchipaID1());
                        myStmt.setInt(3, theEchipa.getEchipaID2());
                        myStmt.setInt(4, theEchipa.getNumarGoluri1());
                        myStmt.setInt(5, theEchipa.getNumarGoluri2());
                        
                        myStmt.setInt(6, theEchipa.getRezultatID());
                        
                        
			
			// execute SQL
			myStmt.executeUpdate();			
		}
		finally {
			close(myStmt);
		}
		
	}
	
	public void addRezultat(Rezultat theEchipa) throws Exception {
            Connection myConn=null;
            PreparedStatement myStmt = null;

		try {
			// prepare statement
                        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String url="jdbc:sqlserver://localhost:1433; databaseName=Campionat; user=Serdin; password=12345";
                myConn=DriverManager.getConnection(url);
			myStmt = myConn.prepareStatement("insert into Rezultat"
					+ " (EtapaID, EchipaID1, EchipaID2, NumarGoluri1,NumarGoluri2)"
					+ " values (?, ?, ?, ?, ?)");
			
			// set params
                        myStmt.setInt(1, theEchipa.getEtapaID());
                        myStmt.setInt(2, theEchipa.getEchipaID1());
                        myStmt.setInt(3, theEchipa.getEchipaID2());
                        myStmt.setInt(4, theEchipa.getNumarGoluri1());
                        myStmt.setInt(5, theEchipa.getNumarGoluri2());
			
			// execute SQL
			myStmt.executeUpdate();			
		}
		finally {
			close(myStmt);
		}
		
	}
        
	public List<Rezultat> getAllRezultate() throws Exception {
		List<Rezultat> list = new ArrayList<>();
		Connection myConn=null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
                     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String url="jdbc:sqlserver://localhost:1433; databaseName=Campionat; user=Serdin; password=12345";
                myConn=DriverManager.getConnection(url);
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery("select * from Rezultat");
			
			while (myRs.next()) {
				Rezultat tempEchipa = convertRowToRezultat(myRs);
				list.add(tempEchipa);
			}

			return list;		
		}
		finally {
			close(myStmt, myRs);
		}
	}
        
        
        public int getEchipaIDNume(String Nume) throws SQLException,Exception {
        Connection myConn=null;
	PreparedStatement myStmt = null;
	ResultSet myRs = null;
        String NumeEchipa=null;
        int id=0;
        try {
			// prepare statement
                        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String url="jdbc:sqlserver://localhost:1433; databaseName=Campionat; user=Serdin; password=12345";
                myConn=DriverManager.getConnection(url);
			myStmt = myConn.prepareStatement("select * from Echipa where NumeEchipa=? ");
			
			// set params
			
			myStmt.setString(1,  Nume);
			// execute SQL
			myRs = myStmt.executeQuery();
                        while (myRs.next()){
                        Echipa tempEchipa = convertRowToEchipa(myRs);
                        id=tempEchipa.getEchipaID();
                        //NumeEchipa=tempEchipa.getNumeEchipa();
                        }
                        return id;
                      
			/*while (myRs.next()) {
				Echipa tempEchipa = convertRowToEchipa(myRs);
                                System.out.println(tempEchipa);
			}*/
			
		}
		finally {
			close(myStmt);
		}   
            
        }
        
        
        
	
        public String getNumeEchipaID(int id) throws SQLException,Exception {
        Connection myConn=null;
	PreparedStatement myStmt = null;
	ResultSet myRs = null;
        String NumeEchipa=null;
        try {
			// prepare statement
                        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String url="jdbc:sqlserver://localhost:1433; databaseName=Campionat; user=Serdin; password=12345";
                myConn=DriverManager.getConnection(url);
			myStmt = myConn.prepareStatement("select * from Echipa where EchipaID=? ");
			
			// set params
			
			myStmt.setInt(1, id);
			// execute SQL
			myRs = myStmt.executeQuery();
                        while (myRs.next()){
                        Echipa tempEchipa = convertRowToEchipa(myRs);
                        NumeEchipa=tempEchipa.getNumeEchipa();
                        }
                        return NumeEchipa;
                      
			/*while (myRs.next()) {
				Echipa tempEchipa = convertRowToEchipa(myRs);
                                System.out.println(tempEchipa);
			}*/
			
		}
		finally {
			close(myStmt);
		}   
            
        }
       
                        
                       
        
        
        
        
	
	public List<Rezultat> searchRezultat(int Nume) throws Exception {
		List<Rezultat> list = new ArrayList<>();
                Connection myConn=null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String url="jdbc:sqlserver://localhost:1433; databaseName=Campionat; user=Serdin; password=12345";
                myConn=DriverManager.getConnection(url);
			//Nume += "%";
			myStmt = myConn.prepareStatement("select * from Rezultat where EtapaID like ?");
			
			myStmt.setInt(1, Nume);
			
			myRs = myStmt.executeQuery();
			
			while (myRs.next()) {
				Rezultat tempEchipa = convertRowToRezultat(myRs);
				list.add(tempEchipa);
			}
			
			return list;
		}
		finally {
			close(myStmt, myRs);
		}
	}
	
	private Echipa convertRowToEchipa(ResultSet myRs) throws SQLException {
		
		int EchipaID = myRs.getInt("EchipaID");
		String NumeEchipa = myRs.getString("NumeEchipa");
		String Antrenor = myRs.getString("Antrenor");
		String Capitan = myRs.getString("Capitan");
		BigDecimal Buget = myRs.getBigDecimal("Buget");
		String Stadion = myRs.getString("Stadion");
                String Oras=myRs.getString("Oras");
                int CampCastigate = myRs.getInt("CampCastigate");
		Echipa tempEchipa = new Echipa(EchipaID, NumeEchipa, Antrenor, Capitan, Buget,Stadion,Oras,CampCastigate);
		
		return tempEchipa;
	}
        private Rezultat convertRowToRezultat(ResultSet myRs) throws SQLException {
		
                int RezultatID = myRs.getInt("RezultatID");
                int EtapaID = myRs.getInt("EtapaID");
                int EchipaID1 = myRs.getInt("EchipaID1");
                int EchipaID2 = myRs.getInt("EchipaID2");
                int NumarGoluri1 = myRs.getInt("NumarGoluri1");
                int NumarGoluri2 = myRs.getInt("NumarGoluri2");
                Rezultat tempRezultat = new Rezultat(RezultatID, EtapaID, EchipaID1, EchipaID2, NumarGoluri1,NumarGoluri2);
		                                	
		return tempRezultat;
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
	
	public static void main(String[] args) throws Exception {
		
            RezultatDATA d=new RezultatDATA();
            System.out.println(d.getAllRezultate());
            //System.out.println(d.getEchipaIDNume("Steaua"));
		//EchipaDAO dao = new EchipaDAO();
                //System.out.println(dao.getAllEchipe());
                //dao.interogare1();
		/*System.out.println(dao.searchEchipe("Steaua"));

		System.out.println(dao.getAllEchipe());
                //System.out.println(dao.getNumeEchipaID(6));
                
                System.out.println(dao.Campionat());*/
                
                
                } 
     
        }




