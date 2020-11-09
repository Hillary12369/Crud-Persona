package pe.sysrasoc.dao;

import java.util.List;
import java.util.Map;

import pe.sysrasoc.entity.Persona;


public interface PersonaDao {
	int create (Persona p);
	int update (Persona p);
	int delete (int id);
	Map<String, Object> read(int id);
	Map<String, Object> readAll();
	void convertitMap(Map<String, Object> map);

}
