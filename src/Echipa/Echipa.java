/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Echipa;

import java.math.BigDecimal;
public class Echipa {

	private int EchipaID;
	private String NumeEchipa;
	private String Antrenor;
	private String Capitan;
	private BigDecimal Buget;
        private String Stadion;
        private String Oras;
        private int CampCastigate;

	public Echipa(String NumeEchipa,String Antrenor,String Capitan,BigDecimal Buget,
                String Stadion,String Oras,int CampCastigate) {

		this(0, NumeEchipa,  Antrenor,Capitan, Buget, Stadion,Oras,CampCastigate);
	}
	
	public Echipa(int EchipaID,String NumeEchipa,String Antrenor,String Capitan,BigDecimal Buget,
                String Stadion,String Oras,int CampCastigate) {
		super();
		this.EchipaID=EchipaID;
                this.NumeEchipa=NumeEchipa;
                this.Antrenor=Antrenor;
                this.Capitan=Capitan;
                this.Buget=Buget;
                this.Oras=Oras;
                this.Stadion=Stadion;
                this.CampCastigate=CampCastigate;
	}

    public int getEchipaID() {
        return EchipaID;
    }

    public void setEchipaID(int EchipaID) {
        this.EchipaID = EchipaID;
    }

    public String getNumeEchipa() {
        return NumeEchipa;
    }

    public void setNumeEchipa(String NumeEchipa) {
        this.NumeEchipa = NumeEchipa;
    }

    public String getAntrenor() {
        return Antrenor;
    }

    public void setAntrenor(String Antrenor) {
        this.Antrenor = Antrenor;
    }

    public String getCapitan() {
        return Capitan;
    }

    public void setCapitan(String Capitan) {
        this.Capitan = Capitan;
    }

    public BigDecimal getBuget() {
        return Buget;
    }

    public void setBuget(BigDecimal Buget) {
        this.Buget = Buget;
    }

    public String getStadion() {
        return Stadion;
    }

    public void setStadion(String Stadion) {
        this.Stadion = Stadion;
    }

    public String getOras() {
        return Oras;
    }

    public void setOras(String Oras) {
        this.Oras = Oras;
    }

    public int getCampCastigate() {
        return CampCastigate;
    }

    public void setCampCastigate(int CampCastigate) {
        this.CampCastigate = CampCastigate;
    }
        
	

	@Override
	public String toString() {
		return String
				.format("Employee [EchipaID=%s, NumeEchipa=%s, Antrenor=%s, Capitan=%s, Buget=%s"
                                        + "Stadion=%s,Oras=%s,CampCastigate=%s]",
						EchipaID, NumeEchipa, Antrenor, Capitan, Buget,Stadion,Oras,CampCastigate);
	}
	
	
		
}
