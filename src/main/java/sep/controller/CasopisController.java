package sep.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sep.dto.CasopisDTO;
import sep.model.Casopis;
import sep.service.CasopisService;

@RestController
@RequestMapping(value = "/casopis")
public class CasopisController {
	
	@Autowired
	private CasopisService casopisService;
	

	@RequestMapping(
			value = "/getCasopisi",
			method = RequestMethod.GET
	)
	public ResponseEntity<?> getCasopisi() {
		List<Casopis> listaCasopisa = casopisService.getAll();
		ArrayList<CasopisDTO> listaCasopisaDTO = new ArrayList<CasopisDTO>();
		for(Casopis c : listaCasopisa) {
			CasopisDTO casopis = new CasopisDTO(c);
			listaCasopisaDTO.add(casopis);
		}
		return new ResponseEntity<>(listaCasopisaDTO, HttpStatus.OK);
	}

}
