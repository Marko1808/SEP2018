package sep.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sep.model.Casopis;
import sep.repository.CasopisRepository;

@Service
public class CasopisService {

	@Autowired 
	private CasopisRepository casopisRepository;
	
	public List<Casopis> getAll() {
		return casopisRepository.findAll();
	}
	
	public Casopis findById(Long id){
		return casopisRepository.findOne(id);
	}
}
