package rppstart.ctrls;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import rppstart.jpa.Igrac;
import rppstart.jpa.Tim;
import rppstart.repository.IgracRepository;
import rppstart.repository.TimRepository;


@CrossOrigin
@RestController
@Api(tags = {"Igrac CRUD operacije"})
public class IgracRestController {
	
	@Autowired
	private IgracRepository igracRepository;
	
	@Autowired
	private TimRepository timRepository;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@ApiOperation(value = "Vraća kolekciju svih igrača iz baze podataka")
	@GetMapping("/igrac")
	public Collection<Igrac> getIgraci() {
		return igracRepository.findAll();
	}

	@ApiOperation(value = "Vraća igrača iz baze podataka čija je id vrednost prosleđena kao path varijabla")
	@GetMapping("igrac/{id}")
	public Igrac getIgrac(@PathVariable("id") Integer id) {
		return igracRepository.getOne(id);
	}
	@ApiOperation(value = "Vraća kolekciju svih igrača iz baze podataka koji u prezimenu sadrže string prosleđen kao path varijabla")
	@GetMapping("igracPrezime/{prezime}")
	public Collection<Igrac> getIgracById(@PathVariable("prezime") String prezime) {
		return igracRepository.findByPrezimeOrderByPrezime(prezime);
	}
	@ApiOperation(value = "Vraća kolekciju svih igrača iz baze podataka koji pripadaju timu čija je id vrednost prosleđena kao path varijabla")
	@GetMapping("igracByTim/{id}")
	public Collection<Igrac> getIgracByTimID(@PathVariable("id") Integer id) {
		Tim t = timRepository.getOne(id);
		return igracRepository.findByTim(t);
	}
	@ApiOperation(value = "Upisuje igrača u bazu podataka")
	@PostMapping("igrac")
	public ResponseEntity<Igrac> insertIgrac(@RequestBody Igrac igrac) {
		if (!igracRepository.existsById(igrac.getId())) {
			igracRepository.save(igrac);
			return new ResponseEntity<Igrac>(HttpStatus.OK);
		}
		return new ResponseEntity<Igrac>(HttpStatus.CONFLICT);
	}
	@ApiOperation(value = "Modifikuje postojećeg igrača u bazi podataka")
	@PutMapping("igrac")
	public ResponseEntity<Igrac> updateIgrac(@RequestBody Igrac igrac) {
		if (igracRepository.existsById(igrac.getId())) {
			igracRepository.save(igrac);
			return new ResponseEntity<Igrac>(HttpStatus.OK);
		}
		return new ResponseEntity<Igrac>(HttpStatus.NO_CONTENT);
	}
	@ApiOperation(value = "Briše igrača iz baze podataka čiji je id vrednost prosleđena kao path varijabla")
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
