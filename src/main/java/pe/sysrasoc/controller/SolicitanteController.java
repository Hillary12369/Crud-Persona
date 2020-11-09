package pe.sysrasoc.controller;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.sysrasoc.service.SolicitanteService;

@RestController
@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
@RequestMapping("/solicitante")
public class SolicitanteController {
	@Autowired
	private SolicitanteService solicitanteService;
	
	@GetMapping("/all")
	public Map<String, Object > listar(){
		return solicitanteService.readAll();
	}
	@GetMapping("/{id}")
	public Map<String, Object> read(@PathVariable int id ) {
		try {
			 return solicitanteService.read(id);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error");
			return null;
		}
	}
	@DeleteMapping("/delete/{id}")
	public int delete(@PathVariable int id ) {
		return solicitanteService.delete(id);
	}
}
