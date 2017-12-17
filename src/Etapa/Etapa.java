/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Etapa;


public class Etapa {

	private int EtapaID;
        private int NumarEtapa;
        private String DataEtapei;
	public Etapa( int NumarEtapa, String DataEtapei
			) {

		this(0, NumarEtapa, DataEtapei);
	}
	
	public Etapa(int EtapaID, int NumarEtapa, String DataEtapei
		) {
		super();
                this.EtapaID=EtapaID;
                this.NumarEtapa=NumarEtapa;
                this.DataEtapei=DataEtapei;
		
	}

    public int getEtapaID() {
        return EtapaID;
    }

    public void setEtapaID(int EtapaID) {
        this.EtapaID = EtapaID;
    }

    public int getNumarEtapa() {
        return NumarEtapa;
    }

    public void setNumarEtapa(int NumarEtapa) {
        this.NumarEtapa = NumarEtapa;
    }

    public String getDataEtapei() {
        return DataEtapei;
    }

    public void setDataEtapei(String DataEtapei) {
        this.DataEtapei = DataEtapei;
    }

	

	@Override
	public String toString() {
		return String
				.format("Etapa [EtapaID=%s, NumarEtapa=%s, DataEtapei=%s]",
						EtapaID, NumarEtapa, DataEtapei);
	}
	
	
		
}
