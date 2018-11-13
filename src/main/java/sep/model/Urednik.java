package sep.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Urednik {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(length=50,nullable=false)
	private String email;
	
	@Column(length=50,nullable=false)
	private String ime;
	
	@Column(length=50,nullable=false)
	private String prezime;
	
	@Column(length=50,nullable=false)
	private String lozinka;
	
	@Column(length=20,nullable=false)
	private String kontaktTelefon;
	
	@Column(length=60,nullable=false)
	private String adresa;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_uredjivackog_odbora")
    private UredjivackiOdbor uredjivackiOdbor;
	
	public Urednik() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}

	public String getKontaktTelefon() {
		return kontaktTelefon;
	}

	public void setKontaktTelefon(String kontaktTelefon) {
		this.kontaktTelefon = kontaktTelefon;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public UredjivackiOdbor getUredjivackiOdbor() {
		return uredjivackiOdbor;
	}

	public void setUredjivackiOdbor(UredjivackiOdbor uredjivackiOdbor) {
		this.uredjivackiOdbor = uredjivackiOdbor;
	}
	
	
}
