package rppstart.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import rppstart.jpa.Igrac;
import rppstart.jpa.Tim;


@Component
@Repository
public interface IgracRepository extends JpaRepository<Igrac, Integer>{
	Collection<Igrac> findByPrezimeOrderByPrezime(String prezime);
	Collection<Igrac> findByTim(Tim p);
	
	

}
