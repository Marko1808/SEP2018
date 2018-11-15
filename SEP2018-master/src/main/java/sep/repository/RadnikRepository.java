package sep.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sep.model.Radnik;

public interface RadnikRepository extends JpaRepository<Radnik, Long> {
	
	Radnik findByEmailIgnoreCase(String email);

}
