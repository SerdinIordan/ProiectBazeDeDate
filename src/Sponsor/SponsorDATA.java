/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sponsor;



import java.util.*;
import java.sql.*;
import java.io.*;
import java.math.BigDecimal;




public class SponsorDATA {

	private Connection myConn;
	
	public SponsorDATA() throws Exception {
		
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
	
	public void deleteSponsor(int EchipaId) throws SQLException, Exception  {
		PreparedStatement myStmt = null;
                Connection myConn=null;
                
		try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String url="jdbc:sqlserver://localhost:1433; databaseName=Campionat; user=Serdin; password=12345";
                myConn=DriverManager.getConnection(url);
			// prepare statement
			myStmt = myConn.prepareStatement("delete from Sponsor where SponsorID=?");
			
			// set param
			myStmt.setInt(1, EchipaId);
			
			// execute SQL
			myStmt.executeUpdate();			
		}
		finally {
			close(myStmt);
		}
	}
	
	public void updateSponsor(Sponsor theEchipa) throws SQLException, Exception {
            PreparedStatement myStmt = null;
            Connection myConn=null;

		try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String url="jdbc:sqlserver://localhost:1433; databaseName=Campionat; user=Serdin; password=12345";
                myConn=DriverManager.getConnection(url);
			// prepare statement
			myStmt = myConn.prepareStatement("update Sponsor"
					+ " set NumeSponsor=?, DataFondarii=?, Fondator=?, Sediu=?,"
                                + "Industrie=?, Profit=?,NumarAngajati=?,Website=?"
					+ " where SponsorID=?");
			
			// set params
                        myStmt.setString(1, theEchipa.getNumeSponsor());
                        myStmt.setString(2, theEchipa.getDataFondarii());
                        myStmt.setString(3, theEchipa.getFondator());
                        myStmt.setString(4, theEchipa.getSediu());
                        myStmt.setString(5, theEchipa.getIndustrie());
                        myStmt.setBigDecimal(6, theEchipa.getProfit());
                        myStmt.setInt(7, theEchipa.getNumarAngajati());
                        myStmt.setString(8, theEchipa.getWebsite());
                        myStmt.setInt(9, theEchipa.getSponsorID());
                        
			
			// execute SQL
			myStmt.executeUpdate();			
		}
		finally {
			close(myStmt);
		}
		
	}
	
	public void addSponsor(Sponsor theSponsor) throws Exception {
            Connection myConn=null;
            PreparedStatement myStmt = null;

		try {
			// prepare statement
                        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String url="jdbc:sqlserver://localhost:1433; databaseName=Campionat; user=Serdin; password=12345";
                myConn=DriverManager.getConnection(url);
			myStmt = myConn.prepareStatement("insert into Sponsor"
					+ " (NumeSponsor, DataFondarii, Fondator, Sediu,Industrie,Profit,NumarAngajati,Website)"
					+ " values (?, ?, ?, ?, ?, ?, ?, ?)");
			
			// set params
                        
			myStmt.setString(1, theSponsor.getNumeSponsor());
                        myStmt.setString(2, theSponsor.getDataFondarii());
                        myStmt.setString(3, theSponsor.getFondator());
                        myStmt.setString(4, theSponsor.getSediu());
                        myStmt.setString(5, theSponsor.getIndustrie());
                        myStmt.setBigDecimal(6, theSponsor.getProfit());
                        myStmt.setInt(7, theSponsor.getNumarAngajati());
                        myStmt.setString(8, theSponsor.getWebsite());
                        
			
			// execute SQL
			myStmt.executeUpdate();			
		}
		finally {
			close(myStmt);
		}
		
	}
        
	public List<Sponsor> getAllSponsor() throws Exception {
		List<Sponsor> list = new ArrayList<>();
		Connection myConn=null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
                     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String url="jdbc:sqlserver://localhost:1433; databaseName=Campionat; user=Serdin; password=12345";
                myConn=DriverManager.getConnection(url);
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery("select * from Sponsor");
			
			while (myRs.next()) {
				Sponsor tempSponsor = convertRowToSponsor(myRs);
				list.add(tempSponsor);
			}

			return list;		
		}
		finally {
			close(myStmt, myRs);
		}
	}
        
        
        
        
        
        
	
	public List<Sponsor> searchSponsor(String Nume) throws Exception {
		List<Sponsor> list = new ArrayList<>();
                Connection myConn=null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String url="jdbc:sqlserver://localhost:1433; databaseName=Campionat; user=Serdin; password=12345";
                myConn=DriverManager.getConnection(url);
			Nume += "%";
			myStmt = myConn.prepareStatement("select * from Sponsor where NumeSponsor like ?");
			
			myStmt.setString(1, Nume);
			
			myRs = myStmt.executeQuery();
			
			while (myRs.next()) {
				Sponsor tempSponsor = convertRowToSponsor(myRs);
				list.add(tempSponsor);
			}
			
			return list;
		}
		finally {
			close(myStmt, myRs);
		}
	}
	
       
        private Sponsor convertRowToSponsor(ResultSet myRs) throws SQLException {
		
                int SponsorID=myRs.getInt("SponsorID");
                String NumeSponsor=myRs.getString("NumeSponsor");
                String DataFondarii=myRs.getString("DataFondarii");
                String Fondator=myRs.getString("Fondator");
                String Sediu=myRs.getString("Sediu");
                String Industrie=myRs.getString("Industrie");
                BigDecimal Profit = myRs.getBigDecimal("Profit");
                int NumarAngajati=myRs.getInt("NumarAngajati");
                String Website=myRs.getString("Website");
                
                
               Sponsor tempSponsor = new Sponsor(SponsorID, NumeSponsor, DataFondarii, Fondator, Sediu,Industrie,Profit,NumarAngajati,Website);
		                                	
		return tempSponsor;
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
		
		SponsorDATA dao = new SponsorDATA();
                System.out.println(dao.getAllSponsor());
		/*System.out.println(dao.searchEchipe("Steaua"));

		System.out.println(dao.getAllEchipe());
                //System.out.println(dao.getNumeEchipaID(6));
                
                System.out.println(dao.Campionat());
                
                
                } */
               
        }



