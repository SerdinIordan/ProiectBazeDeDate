/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rezultat;

import Echipa.Echipa;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Serdin
 */
public class Rezultat {

    
	private int RezultatID;
        private int EtapaID;
        private int EchipaID1;
        private int EchipaID2;
        private int NumarGoluri1;
        private int NumarGoluri2;
        private String NumeEchipa1;
        private String NumeEchipa2;
        
        public Rezultat(int EtapaID,int EchipaID1,int EchipaID2,
                int NumarGoluri1, int NumarGoluri2,String NumeEchipa1,String NumeEchipa2) {

		this(0, EtapaID,  EchipaID1,EchipaID2, NumarGoluri1, NumarGoluri2,NumeEchipa1,NumeEchipa2);
	}
        public Rezultat(int RezultatID,int EtapaID,int EchipaID1,int EchipaID2,
                int NumarGoluri1, int NumarGoluri2,String NumeEchipa1,String NumeEchipa2
               ) 
        {
		super();
		this.RezultatID=RezultatID;
                this.EtapaID=EtapaID;
                this.EchipaID1=EchipaID1;
                this.EchipaID2=EchipaID2;
                this.NumarGoluri1=NumarGoluri1;
                this.NumarGoluri2=NumarGoluri2;
                this.NumeEchipa1=NumeEchipa1;
                this.NumeEchipa2=NumeEchipa2;
	}
	

	public Rezultat(int EtapaID,int EchipaID1,int EchipaID2,
                int NumarGoluri1, int NumarGoluri2) {

		this(0, EtapaID,  EchipaID1,EchipaID2, NumarGoluri1, NumarGoluri2);
	}
	
	public Rezultat(int RezultatID,int EtapaID,int EchipaID1,int EchipaID2,
                int NumarGoluri1, int NumarGoluri2
               ) 
        {
		super();
		this.RezultatID=RezultatID;
                this.EtapaID=EtapaID;
                this.EchipaID1=EchipaID1;
                this.EchipaID2=EchipaID2;
                this.NumarGoluri1=NumarGoluri1;
                this.NumarGoluri2=NumarGoluri2;
	}

        
     
        
        
        
        
        
        
      
    public int getRezultatID() {
        return RezultatID;
    }


    public void setRezultatID(int RezultatID) {
        this.RezultatID = RezultatID;
    }

    public int getEtapaID() {
        return EtapaID;
    }

    public void setEtapaID(int EtapaID) {
        this.EtapaID = EtapaID;
    }
    
    public int getEchipaID1() {
        return EchipaID1;
    }

    public void setEchipaID1(int EchipaID1) {
        this.EchipaID1 = EchipaID1;
    }
    public int getEchipaID2() {
        return EchipaID2;
    }

    public void setEchipaID2(int EchipaID2) {
        this.EchipaID2 = EchipaID2;
    }
    public int getNumarGoluri1() {
        return NumarGoluri1;
    }

    public void setNumarGoluri1(int NumarGoluri1) {
        this.NumarGoluri1 = NumarGoluri1;
    }
    public int getNumarGoluri2() {
        return NumarGoluri2;
    }

    public void setNumarGoluri2(int NumarGoluri2) {
        this.NumarGoluri2 = NumarGoluri2;
    }
    
    
    
    
    
   
        
	

	@Override
	public String toString() {
		return String
				.format("Rezultat [RezultatID=%s, EtapaID=%s, EchipaID1=%s, EchipaID2=%s, "
                                        + "NumarGoluri1=%s,NumarGoluri2=%s]",
						RezultatID, EtapaID, EchipaID1, EchipaID2, NumarGoluri1,NumarGoluri2);
	}
	
	
		
}

