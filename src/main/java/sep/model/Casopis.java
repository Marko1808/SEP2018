package sep.model;

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
	
	enum NacinPlacanja{
		NAPLATA_CITAOCIMA, NAPLATA_AUTORIMA
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(length=50,nullable=false)
	private String naziv;
	
	@Column(length=50,nullable=false)
	private String ISSN;
	
	@Enumerated(EnumType.STRING)
	private NacinPlacanja nacinPlacanja;
	
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

	public NacinPlacanja getNacinPlacanja() {
		return nacinPlacanja;
	}

	public void setNacinPlacanja(NacinPlacanja nacinPlacanja) {
		this.nacinPlacanja = nacinPlacanja;
	}

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
