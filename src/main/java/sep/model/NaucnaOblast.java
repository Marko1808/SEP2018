package sep.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class NaucnaOblast {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(length=50,nullable=false)
	private String naziv;
	
	/*@ManyToMany(mappedBy = "naucnaOblast", cascade = CascadeType.REMOVE)
    protected List<Casopis> casopisi;*/
	
	/*@ManyToMany(mappedBy = "naucnaOblast", cascade = CascadeType.REMOVE)
    protected List<Recenzent> recenzenti;*/
	
	/*@ManyToMany(mappedBy = "naucnaOblast", cascade = CascadeType.REMOVE)
    protected List<Recenzent> a;*/
	
	
	@OneToMany(mappedBy = "naucnaOblast", cascade = CascadeType.REMOVE)
    protected List<Rad> radovi;
	
	public NaucnaOblast() {
		
	}


	public List<Rad> getRadovi() {
		return radovi;
	}

	public void setRadovi(List<Rad> radovi) {
		this.radovi = radovi;
	}

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
	
	
}
