package rppstart.ctrls;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import rppstart.jpa.Igrac;
import rppstart.jpa.Tim;
import rppstart.repository.IgracRepository;
import rppstart.repository.TimRepository;

@Component
@CrossOrigin
@RestController
@ComponentScan
public class IgracRestController {
	
	@Autowired
	private IgracRepository igracRepository;
	
	@Autowired
	private TimRepository timRepository;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@GetMapping("igrac")
	public Collection<Igrac> getIgraci() {
		return igracRepository.findAll();
	}

	@GetMapping("igrac/{id}")
	public Igrac getIgrac(@PathVariable("id") Integer id) {
		return igracRepository.getOne(id);
	}
	
	@GetMapping("igracPrezime/{prezime}")
	public Collection<Igrac> getIgracById(@PathVariable("prezime") String prezime) {
		return igracRepository.findByPrezimeOrderByPrezime(prezime);
	}
	
	@GetMapping("igracByTim/{id}")
	public Collection<Igrac> getIgracByTimID(@PathVariable("id") Integer id) {
		Tim t = timRepository.getOne(id);
		return igracRepository.findByTim(t);
	}
	
	@PostMapping("igrac")
	public ResponseEntity<Igrac> insertIgrac(@RequestBody Igrac igrac) {
		if (!igracRepository.existsById(igrac.getId())) {
			igracRepository.save(igrac);
			return new ResponseEntity<Igrac>(HttpStatus.OK);
		}
		return new ResponseEntity<Igrac>(HttpStatus.CONFLICT);
	}
	
	@PutMapping("igrac")
	public ResponseEntity<Igrac> updateIgrac(@RequestBody Igrac igrac) {
		if (igracRepository.existsById(igrac.getId())) {
			igracRepository.save(igrac);
			return new ResponseEntity<Igrac>(HttpStatus.OK);
		}
		return new ResponseEntity<Igrac>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("igrac/{id}")
	public ResponseEntity<Igrac> deleteIgrac(@PathVariable("id") Integer id) {
		if(igracRepository.existsById(id)) {
			igracRepository.deleteById(id);
			
			if(id == -100) {
				jdbcTemplate.execute("insert into igrac (id, ime, prezime, broj_reg, datum_rodjenja, nacionalnost, tim) values (-100, 'test', 'test', '555', to_date('28.03.2022.', 'dd.mm.yyyy.'), 3, 4)");
			}
			return new ResponseEntity<Igrac>(HttpStatus.OK);
		}
		return new ResponseEntity<Igrac>(HttpStatus.NO_CONTENT);
	}

}
