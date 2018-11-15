package sep.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sep.model.Casopis;

public interface CasopisRepository extends JpaRepository<Casopis, Long> {
	
}
