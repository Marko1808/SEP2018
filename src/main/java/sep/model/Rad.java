package sep.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Rad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(length=50,nullable=false)
	private String naziv;
	
	@Column(length=100,nullable=false)
	private String apstrakt;
	
	@Column(length=100,nullable=false)
	private String kljucniPojmovi;
	
	@Column
	private Boolean prihvacen;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_naucne_oblasti")
    private NaucnaOblast naucnaOblast;
	
	@OneToMany(mappedBy = "rad", cascade = CascadeType.REMOVE)
    protected List<Koautor> koautori;
	
	@OneToMany(mappedBy = "rad", cascade = CascadeType.REMOVE)
    protected List<OceneRadova> ocene;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_autora")
    private AutorRada autor;
	
	public Rad() {
		
	}
	
	

	public String getKljucniPojmovi() {
		return kljucniPojmovi;
	}



	public void setKljucniPojmovi(String kljucniPojmovi) {
		this.kljucniPojmovi = kljucniPojmovi;
	}



	public List<OceneRadova> getOcene() {
		return ocene;
	}



	public void setOcene(List<OceneRadova> ocene) {
		this.ocene = ocene;
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

	public String getApstrakt() {
		return apstrakt;
	}

	public void setApstrakt(String apstrakt) {
		this.apstrakt = apstrakt;
	}

	public Boolean getPrihvacen() {
		return prihvacen;
	}

	public void setPrihvacen(Boolean prihvacen) {
		this.prihvacen = prihvacen;
	}

	public NaucnaOblast getNaucnaOblast() {
		return naucnaOblast;
	}

	public void setNaucnaOblast(NaucnaOblast naucnaOblast) {
		this.naucnaOblast = naucnaOblast;
	}

	public List<Koautor> getKoautori() {
		return koautori;
	}

	public void setKoautori(List<Koautor> koautori) {
		this.koautori = koautori;
	}

	public AutorRada getAutor() {
		return autor;
	}

	public void setAutor(AutorRada autor) {
		this.autor = autor;
	}
	
	
}
