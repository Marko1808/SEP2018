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
public class OceneRadova {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false)
	private double ocena;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_recenzenta")
    private Recenzent recenzent;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_urednika")
    private Urednik urednik;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_rada")
    private Rad rad;
	
	public OceneRadova() {
		
	}
	
	

	public Rad getRad() {
		return rad;
	}



	public void setRad(Rad rad) {
		this.rad = rad;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getOcena() {
		return ocena;
	}

	public void setOcena(double ocena) {
		this.ocena = ocena;
	}

	public Recenzent getRecenzent() {
		return recenzent;
	}

	public void setRecenzent(Recenzent recenzent) {
		this.recenzent = recenzent;
	}

	public Urednik getUrednik() {
		return urednik;
	}

	public void setUrednik(Urednik urednik) {
		this.urednik = urednik;
	}
	
	
	
	
	
}
