package sep.dto;

import sep.model.Casopis;

public class CasopisDTO extends Casopis{
	
	public CasopisDTO(Casopis c) {
		this.setAmount(c.getAmount());
		this.setId(c.getId());
		this.setISSN(c.getISSN());
		this.setMerchant_id(c.getMerchant_id());
		this.setMerchant_password(c.getMerchant_password());
		this.setNaziv(c.getNaziv());
	}
	
}
