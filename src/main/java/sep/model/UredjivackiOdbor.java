package sep.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class UredjivackiOdbor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToMany(mappedBy = "uredjivackiOdbor", cascade = CascadeType.REMOVE)
    protected List<Urednik> urednici;
	
	@Column(nullable=false)
	private Long idGlavnogUrednika;
	
	@OneToMany(mappedBy = "uredjivackiOdbor", cascade = CascadeType.REMOVE)
    protected List<Casopis> casopisi;
	
	public UredjivackiOdbor() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Urednik> getUrednici() {
		return urednici;
	}

	public void setUrednici(List<Urednik> urednici) {
		this.urednici = urednici;
	}

	public Long getIdGlavnogUrednika() {
		return idGlavnogUrednika;
	}

	public void setIdGlavnogUrednika(Long idGlavnogUrednika) {
		this.idGlavnogUrednika = idGlavnogUrednika;
	}

	public List<Casopis> getCasopisi() {
		return casopisi;
	}

	public void setCasopisi(List<Casopis> casopisi) {
		this.casopisi = casopisi;
	}
	
	
	
	
	
	

}
