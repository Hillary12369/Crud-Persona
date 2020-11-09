package pe.sysrasoc.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.sysrasoc.dao.SolicitanteDao;
import pe.sysrasoc.entity.Solicitante;
import pe.sysrasoc.service.SolicitanteService;

@Service
public class SolicitanteServiceImpl implements SolicitanteService{
	@Autowired
	private SolicitanteDao solicitantedao;

	@Override
	public int create(Solicitante s) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Solicitante s) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return solicitantedao.delete(id);
	}

	@Override
	public Map<String, Object> read(int id) {
		// TODO Auto-generated method stub
		return solicitantedao.read(id);
	}

	@Override
	public Map<String, Object> readAll() {
		// TODO Auto-generated method stub
		return solicitantedao.readAll();
	}
}
