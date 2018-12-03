package sep.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import sep.dto.CardDTO;
import sep.dto.CasopisDTO;
import sep.dto.MerchantDTO;
import sep.dto.URLDTO;
import sep.model.Casopis;
import sep.service.CasopisService;

@RestController
@RequestMapping(value = "/casopis")
public class CasopisController {

	@Autowired
	private CasopisService casopisService;

	@RequestMapping(value = "/getCasopisi", method = RequestMethod.GET)
	public ResponseEntity<?> getCasopisi() {
		List<Casopis> listaCasopisa = casopisService.getAll();
		ArrayList<CasopisDTO> listaCasopisaDTO = new ArrayList<CasopisDTO>();
		for (Casopis c : listaCasopisa) {
			CasopisDTO casopis = new CasopisDTO(c);
			listaCasopisaDTO.add(casopis);
		}
		return new ResponseEntity<>(listaCasopisaDTO, HttpStatus.OK);
	}

	@RequestMapping(value = "/proveriMerchanta", method = RequestMethod.POST)
	public boolean proveriMerchanta(@RequestBody MerchantDTO casopis) {
		List<Casopis> listaCasopisa = casopisService.getAll();

		for (Casopis c : listaCasopisa) {
			if (c.getMerchant_id().equals(casopis.getMerchant_id())
					&& c.getMerchant_password().equals(casopis.getMerchant_password())) {
				return true;
			}
		}
		return false;

	}

	@CrossOrigin
	@RequestMapping(value = "/kupiCasopis", method = RequestMethod.POST)
	public ResponseEntity<?> kupiCasopis(@RequestBody CardDTO casopis) {
		System.out.println("Stao tu");
		URLDTO urlDTO = new URLDTO();
		RestTemplate client1 = new RestTemplate();
		HttpHeaders headers1 = new HttpHeaders();
		CardDTO karticaCasopisa = new CardDTO();
		try {
			headers1.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<CardDTO> entity = new HttpEntity<>(casopis, headers1);
			karticaCasopisa = client1.postForObject("http://localhost:1235/payment/findCard", entity, CardDTO.class);

		} catch (Exception e) {
			System.out.println("Ne moze da dobijeKarticu");

		}
		String kupacBanka = casopis.getPan().substring(1, 7);
		String casopisBanka = karticaCasopisa.getPan().substring(1, 7);

		if (kupacBanka.equals(casopisBanka)) {

			RestTemplate client = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			try {
				headers.setContentType(MediaType.APPLICATION_JSON);
				HttpEntity<CardDTO> entity = new HttpEntity<>(casopis, headers);
				urlDTO = client.postForObject("http://localhost:1235/payment/izvrsiPlacanje", entity, URLDTO.class);
				return new ResponseEntity<>(urlDTO, HttpStatus.OK);
			} catch (Exception e) {
				System.out.println("Ne moze da posalje");
				return null;
			}
		}else {
			RestTemplate client = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			try {
				headers.setContentType(MediaType.APPLICATION_JSON);
				HttpEntity<CardDTO> entity = new HttpEntity<>(casopis, headers);
				urlDTO = client.postForObject("http://localhost:1237/platneKartice/usmeriNaBanku", entity, URLDTO.class);
				return new ResponseEntity<>(urlDTO, HttpStatus.OK);
			} catch (Exception e) {
				System.out.println("Ne moze da posalje");
				return null;
			}
		}
	}

}
