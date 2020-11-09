package pe.sysrasoc.service;

import java.util.List;
import java.util.Map;

import pe.sysrasoc.entity.Solicitante;


public interface SolicitanteService {
	int create (Solicitante s);
	int update (Solicitante s);
	int delete (int id);
	Map<String, Object> read(int id);
	Map<String, Object> readAll();


}
