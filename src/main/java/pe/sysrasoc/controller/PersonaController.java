package pe.sysrasoc.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.sysrasoc.entity.Persona;
import pe.sysrasoc.service.PersonaService;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/persona")
public class PersonaController {
	@Autowired
	private PersonaService personaService;
	@GetMapping("/all")
	public Map<String, Object> listar() {
		return personaService.readAll();
	}
	@GetMapping("/{id}")
	public Map<String, Object> read(@PathVariable int id ) {
		try {
			 return personaService.read(id);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error");
			return null;
		}
	}
	@DeleteMapping("/delete/{id}")
	public int delete(@PathVariable int id) {
		return personaService.delete(id);
	}
	//PostMapping permite registrar un nueva persona
	@PostMapping("/add")
	public int create(@RequestBody Persona p) {
		return personaService.create(p);
	}
	//PutMappin permite modificar persona
	@PutMapping("/update/{id}")
	public int edit(@RequestBody Persona p, @PathVariable int id) {
		//Map<String, Object> map = personaService.read(id);
		System.out.println(p.getNombre_persona());
		p.setId_persona(id);
		return personaService.update(p);
	}

}
