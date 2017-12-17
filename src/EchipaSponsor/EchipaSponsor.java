/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EchipaSponsor;

 class EchipaSponsor {
     
        
     
        private int SponsorID;
        private int EchipaID;
        private int LuniDeContract;
       

	public EchipaSponsor(int SponsorID, int EchipaID , int LuniDeContract
			) {

		this.SponsorID=SponsorID;
                this.EchipaID=EchipaID;
                this.LuniDeContract=LuniDeContract;
	}
	
	/*public Employee(int id, String lastName, String firstName, String email,
			BigDecimal salary) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.salary = salary;
	}*/

    public int getSponsorID() {
        return SponsorID;
    }

    public void setSponsorID(int SponsorID) {
        this.SponsorID = SponsorID;
    }

    public int getEchipaID() {
        return EchipaID;
    }

    public void setEchipaID(int EchipaID) {
        this.EchipaID = EchipaID;
    }

    public int getLuniDeContract() {
        return LuniDeContract;
    }

    public void setLuniDeContract(int LuniDeContract) {
        this.LuniDeContract = LuniDeContract;
    }

	

	@Override
	public String toString() {
		return String
				.format("Employee [SponsorID=%s, EchipaID=%s, LuniDeContract=%s]",
						SponsorID, EchipaID, LuniDeContract);
	}
    
}
