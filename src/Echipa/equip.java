/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Echipa;

/**
 *
 * @author Serdin
 */
public class equip {
    String Nume;
    int Puncte;
    int Mj;
    int victorii;
    int egaluri;
    int infrangeri;
    int goluridate;
    int goluriprimite;
    int pozitie;
    public equip(){}
    public equip(String Nume,int Puncte,int Mj,int victorii,int egaluri,int infrangeri
    ,int goluridate,int goluriprimite,int pozitie){
        this.Nume=Nume;
        this.Puncte=Puncte;
        this.Mj=Mj;
        this.victorii=victorii;
        this.egaluri=egaluri;
        this.infrangeri=infrangeri;
        this.goluridate=goluridate;
        this.goluriprimite=goluriprimite;
        this.pozitie=pozitie;
        
    }

    public int getPozitie() {
        return pozitie;
    }

    public void setPozitie(int pozitie) {
        this.pozitie = pozitie;
    }
    
    public String getNume(){
        return Nume;
    }
    public void setNume(String Nume){
        this.Nume=Nume;
    }
    public int getPuncte(){
        return Puncte;
    }
    public void setPuncte(int Puncte){
        this.Puncte=Puncte;
    }
    public int getMj(){
        return Mj;
    }
    public void setMj(int Mj){
        this.Mj=Mj;
    }

    public int getVictorii() {
        return victorii;
    }

    public void setVictorii(int victorii) {
        this.victorii = victorii;
    }

    public int getEgaluri() {
        return egaluri;
    }

    public void setEgaluri(int egaluri) {
        this.egaluri = egaluri;
    }

    public int getInfrangeri() {
        return infrangeri;
    }

    public void setInfrangeri(int infrangeri) {
        this.infrangeri = infrangeri;
    }

    public int getGoluridate() {
        return goluridate;
    }

    public void setGoluridate(int goluridate) {
        this.goluridate = goluridate;
    }

    public int getGoluriprimite() {
        return goluriprimite;
    }

    public void setGoluriprimite(int goluriprimite) {
        this.goluriprimite = goluriprimite;
    }
    
    
    
    @Override
	public String toString() {
		return String
				.format("Equip [Nume=%s, Puncte=%s, Meciuri Jucate=%s,Victorii=%s,Egaluri=%s,Infrangeri=%s"
                                        + " GoluriDate=%s, GoluriPrimite=%s,Pozitie=%s   ",
						Nume,Puncte,Mj,victorii,egaluri,infrangeri,goluridate,goluriprimite,pozitie);
	}
    
    
    
    
    
    
    
}
