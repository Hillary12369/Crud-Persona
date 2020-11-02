package pe.sysrasoc.service;

import java.util.List;
import java.util.Map;

import pe.sysrasoc.entity.Persona;


public interface PersonaService {
	int create (Persona p);
	int update (Persona p);
	int delete (int id);
	Persona read (int id);
	List<Map<String, Object>> readAll();

}
