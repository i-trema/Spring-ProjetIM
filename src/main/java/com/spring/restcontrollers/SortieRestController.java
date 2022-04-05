package com.spring.restcontrollers;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entities.Sortie;
import com.spring.services.SortieService;





@RestController
@RequestMapping("api/sortie")
public class SortieRestController {
@Autowired
SortieService sortieService;
	
@GetMapping("")
public Page<Sortie> getSorties(Pageable pageable)
{
	 return sortieService.findAll(pageable);
}
@GetMapping("{id}")
public Optional<Sortie> findSorties(@PathVariable int id)
{
	 return sortieService.findById(id);
}
@GetMapping("titre/{titre}")
public List<Sortie> findSortiesByTitre(@PathVariable String titre)
{
	 return sortieService.findByTitre(titre);
}
@GetMapping("destination/{destination}")
public List<Sortie> findSortiesByDestination(@PathVariable String destination)
{
	 return sortieService.findByDestination(destination);
}
@GetMapping("depart/{depart}")
public List<Sortie> findSortiesByDepart(@PathVariable String depart)
{
	 return sortieService.findByDepart(depart);
}
@GetMapping("retour/{retour}")
public List<Sortie> findSortiesByretour(@PathVariable String retour)
{
	 return sortieService.findByRetour(retour);
}
@GetMapping("responsable/{responsable}")
public List<Sortie> findSortiesByAdmin(@PathVariable String responsable)
{
	 return sortieService.findByAdmin(responsable);
}
@GetMapping("description/{description}")
public List<Sortie> findSortiesByDescription(@PathVariable String description)
{
	 return sortieService.findByDescriptionContaining(description);
}

@PostMapping("")
public Sortie addSortie(@Valid @RequestBody Sortie sortie) 
{
return sortieService.save(sortie);	

}
@DeleteMapping("{id}")
public void deleteSortie(@PathVariable int id) {
	sortieService.deleteById(id);
}




}

