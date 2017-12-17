/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jucator;
public class Jucator {

	private int JucatorID;
        private int EchipaID;
        private String Nume;
        private String Prenume;
        private String DataNasterii;
        private float Inaltime;
        private int Greutate;
        private String Pozitie;
	public Jucator(int EchipaID,String Nume,String Prenume,String DataNasterii,
			float Inaltime,int Greutate,String Pozitie) {

		this(0,EchipaID , Nume, Prenume, DataNasterii,Inaltime,Greutate,Pozitie);
	}
	
	public Jucator(int JucatorID, int EchipaID, String Nume, String Prenume,String DataNasterii,
			float Inaltime,int Greutate,String Pozitie) {
		super();
                this.JucatorID=JucatorID;
                this.EchipaID=EchipaID;
                this.Nume=Nume;
                this.Prenume=Prenume;
                this.DataNasterii=DataNasterii;
                this.Inaltime=Inaltime;
                this.Greutate=Greutate;
                this.Pozitie=Pozitie;
		
	}

    public int getJucatorID() {
        return JucatorID;
    }

    public void setJucatorID(int JucatorID) {
        this.JucatorID = JucatorID;
    }

    public int getEchipaID() {
        return EchipaID;
    }

    public void setEchipaID(int EchipaID) {
        this.EchipaID = EchipaID;
    }

    public String getNume() {
        return Nume;
    }

    public void setNume(String Nume) {
        this.Nume = Nume;
    }

    public String getPrenume() {
        return Prenume;
    }

    public void setPrenume(String Prenume) {
        this.Prenume = Prenume;
    }

    public String getDataNasterii() {
        return DataNasterii;
    }

    public void setDataNasterii(String DataNasterii) {
        this.DataNasterii = DataNasterii;
    }

    public float getInaltime() {
        return Inaltime;
    }

    public void setInaltime(float Inaltime) {
        this.Inaltime = Inaltime;
    }

    public int getGreutate() {
        return Greutate;
    }

    public void setGreutate(int Greutate) {
        this.Greutate = Greutate;
    }

    public String getPozitie() {
        return Pozitie;
    }

    public void setPozitie(String Pozitie) {
        this.Pozitie = Pozitie;
    }
        

	@Override
	public String toString() {
		return String
				.format("Employee [JucatorID=%s, EchipaID=%s, Nume=%s, Prenume=%s, DataNasterii=%s,Inaltime=%s,Greutate=%s,Pozitie=%s]",
						JucatorID, EchipaID, Nume, Prenume, DataNasterii,Inaltime,Greutate,Pozitie);
	}
	
	
		
}


