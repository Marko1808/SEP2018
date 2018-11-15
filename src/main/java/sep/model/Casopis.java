package sep.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Casopis {
	
	/*enum NacinPlacanja{
		NAPLATA_CITAOCIMA, NAPLATA_AUTORIMA
	}*/
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(length=50,nullable=false)
	private String naziv;
	
	@Column(length=50,nullable=false)
	private String ISSN;
	
	@Column(length=30,nullable=false)
	private String merchant_id;
	
	@Column(length=100,nullable=false)
	private String merchant_password;
	
	@Column(length=100,nullable=false)
	private BigDecimal amount;
	
	/*@Enumerated(EnumType.STRING)
	private NacinPlacanja nacinPlacanja;*/
	
	/*@ManyToMany(mappedBy = "casopis", cascade = CascadeType.REMOVE)
    protected List<NaucnaOblast> naucneOblasti;*/
	
	/*@ManyToMany(mappedBy = "casopis", cascade = CascadeType.REMOVE)
    protected List<Rad> radovi;*/
	
	/*@ManyToMany(mappedBy = "casopis", cascade = CascadeType.REMOVE)
    protected List<Recenzent> recenzenti;*/

	/*@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_uredjivackog_odbora")
    private UredjivackiOdbor uredjivackiOdbor;*/
	
	public Casopis() {
		
	}

	/*public NacinPlacanja getNacinPlacanja() {
		return nacinPlacanja;
	}

	public void setNacinPlacanja(NacinPlacanja nacinPlacanja) {
		this.nacinPlacanja = nacinPlacanja;
	}*/

	/*public UredjivackiOdbor getUredjivackiOdbor() {
		return uredjivackiOdbor;
	}

	public void setUredjivackiOdbor(UredjivackiOdbor uredjivackiOdbor) {
		this.uredjivackiOdbor = uredjivackiOdbor;
	}
*/
	
	public Long getId() {
		return id;
	}

	public String getMerchant_id() {
		return merchant_id;
	}

	public void setMerchant_id(String merchant_id) {
		this.merchant_id = merchant_id;
	}

	public String getMerchant_password() {
		return merchant_password;
	}

	public void setMerchant_password(String merchant_password) {
		this.merchant_password = merchant_password;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getISSN() {
		return ISSN;
	}

	public void setISSN(String iSSN) {
		ISSN = iSSN;
	}

}
