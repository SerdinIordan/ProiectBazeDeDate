/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Echipa;

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
import Rezultat.Rezultat;



public class EchipaDAO {

	private Connection myConn;
	
	public EchipaDAO() throws Exception {
		
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
	
	public void deleteEchipa(int EchipaId) throws SQLException, Exception  {
		PreparedStatement myStmt = null;
                Connection myConn=null;

		try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String url="jdbc:sqlserver://localhost:1433; databaseName=Campionat; user=Serdin; password=12345";
                myConn=DriverManager.getConnection(url);
			// prepare statement
			myStmt = myConn.prepareStatement("delete from Echipa where EchipaID=?");
			
			// set param
			myStmt.setInt(1, EchipaId);
			
			// execute SQL
			myStmt.executeUpdate();			
		}
		finally {
			close(myStmt);
		}
	}
	
	public void updateEchipa(Echipa theEchipa) throws SQLException, Exception {
            PreparedStatement myStmt = null;
            Connection myConn=null;

		try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String url="jdbc:sqlserver://localhost:1433; databaseName=Campionat; user=Serdin; password=12345";
                myConn=DriverManager.getConnection(url);
			// prepare statement
			myStmt = myConn.prepareStatement("update Echipa"
					+ " set NumeEchipa=?, Antrenor=?, Capitan=?, Buget=?,"
                                + "Stadion=?, Oras=?,CampCastigate=?"
					+ " where EchipaID=?");
			
			// set params
			myStmt.setString(1, theEchipa.getNumeEchipa());
			myStmt.setString(2, theEchipa.getAntrenor());
			myStmt.setString(3, theEchipa.getCapitan());
			myStmt.setBigDecimal(4, theEchipa.getBuget());
                        myStmt.setString(5, theEchipa.getStadion());
                        myStmt.setString(6, theEchipa.getOras());
                        myStmt.setInt(7, theEchipa.getCampCastigate());
                                                
			myStmt.setInt(8, theEchipa.getEchipaID());
			
			// execute SQL
			myStmt.executeUpdate();			
		}
		finally {
			close(myStmt);
		}
		
	}
	
	public void addEchipa(Echipa theEchipa) throws Exception {
            Connection myConn=null;
            PreparedStatement myStmt = null;

		try {
			// prepare statement
                        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String url="jdbc:sqlserver://localhost:1433; databaseName=Campionat; user=Serdin; password=12345";
                myConn=DriverManager.getConnection(url);
			myStmt = myConn.prepareStatement("insert into Echipa"
					+ " (NumeEchipa, Antrenor, Capitan, Buget,Stadion,Oras,CampCastigate)"
					+ " values (?, ?, ?, ?, ?, ?, ?)");
			
			// set params
			myStmt.setString(1, theEchipa.getNumeEchipa());
			myStmt.setString(2, theEchipa.getAntrenor());
			myStmt.setString(3, theEchipa.getCapitan());
			myStmt.setBigDecimal(4, theEchipa.getBuget());
                        myStmt.setString(5, theEchipa.getStadion());
                        myStmt.setString(6, theEchipa.getOras());
                        myStmt.setInt(7, theEchipa.getCampCastigate());
			
			// execute SQL
			myStmt.executeUpdate();			
		}
		finally {
			close(myStmt);
		}
		
	}
        
	public List<Echipa> getAllEchipe() throws Exception {
		List<Echipa> list = new ArrayList<>();
		Connection myConn=null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
                     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String url="jdbc:sqlserver://localhost:1433; databaseName=Campionat; user=Serdin; password=12345";
                myConn=DriverManager.getConnection(url);
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery("select * from Echipa");
			
			while (myRs.next()) {
				Echipa tempEchipa = convertRowToEchipa(myRs);
				list.add(tempEchipa);
			}

			return list;		
		}
		finally {
			close(myStmt, myRs);
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
        public List<equip> Campionat() throws Exception,SQLException {
		List<equip> list = new ArrayList<>();
		Connection myConn=null;
		Statement myStmt = null;
		ResultSet myRs = null;
                Statement myStmt1 = null;
                ResultSet myRs1 = null;
                
                
                
		
               try {
                     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String url="jdbc:sqlserver://localhost:1433; databaseName=Campionat; user=Serdin; password=12345";
                myConn=DriverManager.getConnection(url);
			myStmt1 = myConn.createStatement();
			//myRs = myStmt.executeQuery("select * from Rezultat");
			myRs1=myStmt1.executeQuery("select * from Echipa");
                        while (myRs1.next()){
                            Echipa tempEchipa = convertRowToEchipa(myRs1);
                             String nume=getNumeEchipaID(tempEchipa.getEchipaID());
                             int puncte=0;
                             int mj=0;
                             int v=0;
                             int e=0;
                             int i=0;
                             int gd=0;
                             int gp=0;
                             int poz=0;
                             equip init=new equip(nume,puncte,mj,v,e,i,gd,gp,poz);
                             list.add(init);
                        }
                }
		finally{
                        close(myStmt1, myRs1);
                        }
                try {
                     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String url="jdbc:sqlserver://localhost:1433; databaseName=Campionat; user=Serdin; password=12345";
                myConn=DriverManager.getConnection(url);
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery("select * from Rezultat");
                        while (myRs.next()) {
				Rezultat tempRezultat = convertRowToRezultat(myRs);
				//citirea unei linii/ a unui Rezultat                                                              
                                
                                        if (tempRezultat.getNumarGoluri1()<tempRezultat.getNumarGoluri2()){
                                            
                                            String nume1;
                                    nume1=getNumeEchipaID(tempRezultat.getEchipaID1()); //echipa pierzatoare
                                   
                                   int puncte1=0;
                                   int mj1=1;
                                   int v1=0;
                                   int e1=0;
                                   int i1=1;
                                   int gd1=tempRezultat.getNumarGoluri1();
                                   int gp1=tempRezultat.getNumarGoluri2();
                                   int poz1=0;
                                   equip ep=new equip(nume1,puncte1,mj1,v1,e1,i1,gd1,gp1,poz1);
                                   
                                   for (int i=0;i<list.size();i++)
                                       if (ep.Nume.compareTo(list.get(i).Nume)==0){
                                           list.get(i).Puncte=list.get(i).Puncte+puncte1;
                                           list.get(i).Mj=list.get(i).Mj+mj1;
                                           list.get(i).victorii=list.get(i).victorii+v1;
                                           list.get(i).egaluri=list.get(i).egaluri+e1;
                                           list.get(i).infrangeri=list.get(i).infrangeri+i1;
                                           list.get(i).goluridate=gd1;
                                           list.get(i).goluriprimite=gp1;
                                       } 
                                  
                                   String nume2;
                                    nume2=getNumeEchipaID(tempRezultat.getEchipaID2()); //echipa cast
                                    // aflam numele echipei cast
                                    int puncte2=3;
                                    int mj2=1;
                                    int v2=1;
                                   int e2=0;
                                   int i2=0;
                                    int gd2=tempRezultat.getNumarGoluri2();
                                   int gp2=tempRezultat.getNumarGoluri1();
                                   int poz2=0;
                                   equip ec=new equip(nume2,puncte2,mj2,v2,e2,i2,gd2,gp2,poz2);
                                   //vedem daca echipa castigatoare se afla in lista 
                                   for (int i=0;i<list.size();i++)
                                       if (ec.Nume.compareTo(list.get(i).Nume)==0){
                                           list.get(i).Puncte=list.get(i).Puncte+puncte2;
                                           list.get(i).Mj=list.get(i).Mj+mj2;
                                           list.get(i).victorii=list.get(i).victorii+v2;
                                           list.get(i).egaluri=list.get(i).egaluri+e2;
                                           list.get(i).infrangeri=list.get(i).infrangeri+i2;
                                           list.get(i).goluridate=gd2;
                                           list.get(i).goluriprimite=gp2;
                                       } 
                               }else 
                                            if ((tempRezultat.getNumarGoluri1()==tempRezultat.getNumarGoluri2())){
                                          
                                            String nume1;
                                    nume1=getNumeEchipaID(tempRezultat.getEchipaID1()); //echipa pierzatoare
                                    //System.out.println(nume1);
                                   //aflam numele echipei pierzatoare
                                   int puncte1=1;
                                   int mj1=1;
                                   int v1=0;
                                   int e1=1;
                                   int i1=0;
                                   int gd1=tempRezultat.getNumarGoluri1();
                                   int gp1=tempRezultat.getNumarGoluri2();
                                   int poz1=0;
                                   equip ep=new equip(nume1,puncte1,mj1,v1,e1,i1,gd1,gp1,poz1);
                                   //System.out.println(ep);
                                   //vedem daca echipa pierzatoare se afla in lista 
                                   for (int i=0;i<list.size();i++)
                                       if (ep.Nume.compareTo(list.get(i).Nume)==0){
                                           list.get(i).Puncte=list.get(i).Puncte+puncte1;
                                           list.get(i).Mj=list.get(i).Mj+mj1;
                                           list.get(i).victorii=list.get(i).victorii+v1;
                                           list.get(i).egaluri=list.get(i).egaluri+e1;
                                           list.get(i).infrangeri=list.get(i).infrangeri+i1;
                                           list.get(i).goluridate=gd1;
                                           list.get(i).goluriprimite=gp1;
                                       } 
                                   //procedam la fel si cu echipa castigatoare
                                   String nume2;
                                    nume2=getNumeEchipaID(tempRezultat.getEchipaID2()); //echipa cast
                                    // aflam numele echipei cast
                                    int puncte2=1;
                                    int mj2=1;
                                    int v2=0;
                                   int e2=1;
                                   int i2=0;
                                   int gd2=tempRezultat.getNumarGoluri2();
                                   int gp2=tempRezultat.getNumarGoluri1();
                                   int poz2=0;
                                   equip ec=new equip(nume2,puncte2,mj2,v2,e2,i2,gd2,gp2,poz2);
                                   //vedem daca echipa castigatoare se afla in lista 
                                   for (int i=0;i<list.size();i++)
                                       if (ec.Nume.compareTo(list.get(i).Nume)==0){
                                           list.get(i).Puncte=list.get(i).Puncte+puncte2;
                                            list.get(i).Mj=list.get(i).Mj+mj2;
                                            list.get(i).victorii=list.get(i).victorii+v2;
                                           list.get(i).egaluri=list.get(i).egaluri+e2;
                                           list.get(i).infrangeri=list.get(i).infrangeri+i2;
                                           list.get(i).goluridate=gd2;
                                           list.get(i).goluriprimite=gp2;
                                       } 
                               } else
                                if (tempRezultat.getNumarGoluri1()>tempRezultat.getNumarGoluri2()){
                                            //System.out.println(tempRezultat.getNumarGoluri1());
                                            // System.out.println(tempRezultat.getNumarGoluri2());
                                            String nume1;
                                    nume1=getNumeEchipaID(tempRezultat.getEchipaID1()); //echipa pierzatoare
                                   int mj1=1;
                                   int puncte1=3;
                                    int v1=1;
                                   int e1=0;
                                   int i1=0;
                                   int gd1=tempRezultat.getNumarGoluri1();
                                   int gp1=tempRezultat.getNumarGoluri2();
                                   int poz1=0;
                                   equip ep=new equip(nume1,puncte1,mj1,v1,e1,i1,gd1,gp1,poz1);
                                   //System.out.println(ep);
                                   //vedem daca echipa pierzatoare se afla in lista 
                                   for (int i=0;i<list.size();i++)
                                       if (ep.Nume.compareTo(list.get(i).Nume)==0){
                                           list.get(i).Puncte=list.get(i).Puncte+puncte1;
                                           list.get(i).Mj=list.get(i).Mj+mj1;
                                           list.get(i).victorii=list.get(i).victorii+v1;
                                           list.get(i).egaluri=list.get(i).egaluri+e1;
                                           list.get(i).infrangeri=list.get(i).infrangeri+i1;
                                           list.get(i).goluridate=gd1;
                                           list.get(i).goluriprimite=gp1;
                                       } 
                                   //procedam la fel si cu echipa castigatoare
                                   String nume2;
                                   //int poz2;
                                    nume2=getNumeEchipaID(tempRezultat.getEchipaID2()); //echipa cast
                                    // aflam numele echipei cast
                                    int puncte2=0;
                                    int mj2=1;
                                    int v2=0;
                                   int e2=0;
                                   int i2=1;
                                   int gd2=tempRezultat.getNumarGoluri2();
                                   int gp2=tempRezultat.getNumarGoluri1();
                                   int poz2=0;
                                   equip ec=new equip(nume2,puncte2,mj2,v2,e2,i2,gd2,gp2,poz2);
                                   //vedem daca echipa castigatoare se afla in lista 
                                   for (int i=0;i<list.size();i++)
                                       if (ec.Nume.compareTo(list.get(i).Nume)==0){
                                           list.get(i).Puncte=list.get(i).Puncte+puncte2;
                                           list.get(i).Mj=list.get(i).Mj+mj2;
                                           list.get(i).victorii=list.get(i).victorii+v2;
                                           list.get(i).egaluri=list.get(i).egaluri+e2;
                                           list.get(i).infrangeri=list.get(i).infrangeri+i2;
                                            list.get(i).goluridate=gd2;
                                           list.get(i).goluriprimite=gp2;
                                       } 
                               }
                                              
                                
                              //  list.add(tempEchipa);
			}
                        //ordonarea listei 
                  
                        boolean swapped = true;
                        int j = 0;
                        equip tmp;
                        while (swapped) {
                        swapped = false;
                        j++;
            for (int i = 0; i < list.size() - j; i++) {                                       
                  if  (list.get(i).Puncte<list.get(i+1).Puncte) {                          
                        tmp = list.get(i);
                        list.set(i, list.get(i+1));
                        //list.get(i)=list.get(i+1);
                       // list.get(i+1) = tmp;
                        list.set(i+1,tmp);
                        swapped = true;
                  }
            }                
      }
                        int pozit=1;
                        for (int i=0;i<list.size();i++)
                        {list.get(i).pozitie=pozit;
                        pozit++;
                        }
   
                        
                        
                        

			return list;		
		}
		finally {
			close(myStmt, myRs);
		}
                
                
                
            }
		
                        
                       
        
        
        
        
	
	public List<Echipa> searchEchipe(String Nume) throws Exception {
		List<Echipa> list = new ArrayList<>();
                Connection myConn=null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String url="jdbc:sqlserver://localhost:1433; databaseName=Campionat; user=Serdin; password=12345";
                myConn=DriverManager.getConnection(url);
			Nume += "%";
			myStmt = myConn.prepareStatement("select * from Echipa where NumeEchipa like ?");
			
			myStmt.setString(1, Nume);
			
			myRs = myStmt.executeQuery();
			
			while (myRs.next()) {
				Echipa tempEchipa = convertRowToEchipa(myRs);
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
		
		EchipaDAO dao = new EchipaDAO();
                System.out.println(dao.getAllEchipe());
                //dao.interogare1();
		/*System.out.println(dao.searchEchipe("Steaua"));

		System.out.println(dao.getAllEchipe());
                //System.out.println(dao.getNumeEchipaID(6));
                
                System.out.println(dao.Campionat());*/
                double value = -9.0;

        System.out.println( Math.sqrt(value));
int i = (int) Math.random();
if (1==2){
    System.out.println("da");
}
                System.out.println( i);
                } 
     
        }



