package rppstart.ctrls;

import java.math.BigDecimal;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import rva.jpa.Igrac;
import rva.jpa.Tim;
import rva.repository.IgracRepository;
import rva.repository.TimRepository;


@RestController
public class IgracRestController {

	@Autowired
	private IgracRepository igracRepository;
	
	@Autowired
	private TimRepository timRepository;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@GetMapping("igrac")
	public Collection<Igrac> getStavkePorudzbina() {
		return igracRepository.findAll();
	}
	
	@GetMapping("igrac/{id}")
	public Igrac getIgrac(@PathVariable("id") Integer id) {
		return igracRepository.getOne(id);
	}
	
	@GetMapping("igraciZaTimID/{id}")
	public void getGetIgracByTimID(@PathVariable("id") Integer id) {
		jdbcTemplate.execute("select * from Igrac i join Tim t on (i.Tim=t.id) where t.id="+id);
	}
	
	
	@PostMapping("igrac")
	public ResponseEntity<Igrac> insertIgrac(@RequestBody Igrac igrac) {
		if(!igracRepository.existsById(igrac.getId())) {
			igracRepository.save(igrac);
			return new ResponseEntity<Igrac> (HttpStatus.OK);
		}
		return new ResponseEntity<Igrac> (HttpStatus.CONFLICT);
	}
	
	@PutMapping("igrac")
	public ResponseEntity<Igrac> updateIgrac(@RequestBody Igrac igrac) {
		if(igracRepository.existsById(igrac.getId())) {
			igracRepository.save(igrac);
			return new ResponseEntity<Igrac> (HttpStatus.OK);
		}
		return new ResponseEntity<Igrac> (HttpStatus.NO_CONTENT);
	}
	@DeleteMapping("igrac/{id}")
	public ResponseEntity<Igrac> deleteIgrac(@PathVariable("id") Integer id) {
		if(igracRepository.existsById(id)) {
			igracRepository.deleteById(id);
			if (id == -100) 
				jdbcTemplate.execute("insert into igrac_porudzbine (id, porudzbina, redni_broj,"
						+ " artikl, kolicina, jedinica_mere, cena) "
						+ "values (-100, -100, 1, -100,20, 'komad', 100)");
			return new ResponseEntity<Igrac> (HttpStatus.OK);
		}
		return new ResponseEntity<Igrac> (HttpStatus.NO_CONTENT);
	}
}
