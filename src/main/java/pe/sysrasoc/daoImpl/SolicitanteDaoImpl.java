package pe.sysrasoc.daoImpl;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import oracle.jdbc.OracleTypes;
import pe.sysrasoc.dao.SolicitanteDao;
import pe.sysrasoc.entity.Solicitante;

@Repository

public class SolicitanteDaoImpl implements SolicitanteDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;

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
		return jdbcTemplate.update("call pk_solicitante.sp_delete_solicitante(?)", id);
	}

	@Override
	public Map<String, Object>read(int id) {
		System.out.println(id);
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("pk_solicitante").withProcedureName("sp_read_solicitante").declareParameters(new SqlOutParameter("t_solicitante", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()), new SqlParameter("idsoli", OracleTypes.NUMBER));
		SqlParameterSource in = new MapSqlParameterSource().addValue("idsoli", id);
		Map<String, Object> out = simpleJdbcCall.execute(in);
				
		// TODO Auto-generated method stub
		return simpleJdbcCall.execute(in);
	}

	@Override
	public Map<String, Object> readAll() {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withCatalogName("pk_solicitante") //nombre del paquete
				.withProcedureName("sp_listar_solicitante") //nombre del procedimiento
				.declareParameters(new SqlOutParameter("cursor_solicitante", OracleTypes.CURSOR, new ColumnMapRowMapper()));
				return simpleJdbcCall.execute();

	}
	@Override
	public void convertitMap(Map<String, Object> map) {
		Solicitante solicitante = new Solicitante();
		for (Entry<String, Object> entry : map.entrySet()) {
	        System.out.println("entry key : "+entry.getKey());
	        System.out.println("Object value :"+entry.getValue());     
		}
	}
}


