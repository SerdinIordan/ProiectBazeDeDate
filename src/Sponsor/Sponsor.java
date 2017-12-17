/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sponsor;
import java.math.BigDecimal;

public class Sponsor {
        
	private int SponsorID;
	private String NumeSponsor;
	private String DataFondarii;
	private String Fondator;
        private String Sediu;
        private String Industrie;
	private BigDecimal Profit;
        private int NumarAngajati;
        private String Website;

	public Sponsor(String NumeSponsor, String DataFondarii,String Fondator,String Sediu,String Industrie,
			BigDecimal Profit,int NumarAngajati,String Website) {

		this(0, NumeSponsor, DataFondarii, Fondator, Sediu,Industrie,Profit,NumarAngajati,Website);
	}
        
        
	
	public Sponsor(int SponsorID,String NumeSponsor, String DataFondarii,String Fondator,String Sediu,String Industrie,
			BigDecimal Profit,int NumarAngajati,String Website) {
		super();
                this.SponsorID=SponsorID;
                this.NumeSponsor=NumeSponsor;
                this.DataFondarii=DataFondarii;
                this.Fondator=Fondator;
                this.Sediu=Sediu;
                this.Industrie=Industrie;
                this.Profit=Profit;
                this.NumarAngajati=NumarAngajati;
                this.Website=Website;
               
	}

    public int getSponsorID() {
        return SponsorID;
    }

    public void setSponsorID(int SponsorID) {
        this.SponsorID = SponsorID;
    }

    public String getNumeSponsor() {
        return NumeSponsor;
    }

    public void setNumeSponsor(String NumeSponsor) {
        this.NumeSponsor = NumeSponsor;
    }

    public String getDataFondarii() {
        return DataFondarii;
    }

    public void setDataFondarii(String DataFondarii) {
        this.DataFondarii = DataFondarii;
    }

    public String getFondator() {
        return Fondator;
    }

    public void setFondator(String Fondator) {
        this.Fondator = Fondator;
    }

    public String getSediu() {
        return Sediu;
    }

    public void setSediu(String Sediu) {
        this.Sediu = Sediu;
    }

    public String getIndustrie() {
        return Industrie;
    }

    public void setIndustrie(String Industrie) {
        this.Industrie = Industrie;
    }

    public BigDecimal getProfit() {
        return Profit;
    }

    public void setProfit(BigDecimal Profit) {
        this.Profit = Profit;
    }

    public int getNumarAngajati() {
        return NumarAngajati;
    }

    public void setNumarAngajati(int NumarAngajati) {
        this.NumarAngajati = NumarAngajati;
    }

    public String getWebsite() {
        return Website;
    }

    public void setWebsite(String Website) {
        this.Website = Website;
    }
        
	

	@Override
	public String toString() {
		return String
				.format("Employee [SponsorID=%s, NumeSponsor=%s, DataFondarii=%s,Fondator=%s, Sediu=%s, Industrie=%s,Profit=%s,NumarAngajati=%s,Website=%s]",
						SponsorID, NumeSponsor,DataFondarii,Fondator, Sediu, Industrie,Profit,NumarAngajati,Website);
        }}
