package pe.sysrasoc.daoImpl;

import java.sql.Types;
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
import pe.sysrasoc.dao.PersonaDao;
import pe.sysrasoc.entity.Persona;

@Component
public class PersonaDaoImpl implements PersonaDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;

	@Override
	public int create(Persona p) {
		// TODO Auto-generated method stub
		System.out.println(p.getNombre_persona());
		String sql="declare v_per persona%rowtype; begin v_per.nombre_persona:=?; v_per.apell_pat:=?; v_per.apell_mat:=?; v_per.dni:=?; v_per.correo:=?; v_per.telefono:=?; v_per.fecha_nac:=?; v_per.sexo:=?; pk_persona.sp_ins_persona(v_per); end;";
		return jdbcTemplate.update(sql,p.getNombre_persona(),p.getApell_pat(),p.getApell_mat(),p.getDni(),p.getCorreo(),p.getTelefono(),p.getFecha_nac(),p.getSexo());
	}

	@Override
	public int update(Persona p) {
		// TODO Auto-generated method stub
		System.out.println(p.getNombre_persona());
		String sql="declare v_per persona%rowtype; begin v_per.id_persona:=?; v_per.nombre_persona:=?; v_per.apell_pat:=?; v_per.apell_mat:=?; v_per.dni:=?; v_per.correo:=?;v_per.telefono:=?; v_per.fecha_nac:=?; v_per.sexo:=?; pk_persona.sp_upd_persona(v_per); end;";
		return jdbcTemplate.update(sql, p.getId_persona(),p.getNombre_persona(), p.getApell_pat(), p.getApell_mat(), p.getDni(), p.getCorreo(), p.getTelefono(),p.getFecha_nac(), p.getSexo());
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		System.out.println(id);
		return jdbcTemplate.update("delete from persona where id_persona=?", id);
	}

	@Override
	public Map<String, Object> read(int id) {
		System.out.println(id);
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
		.withCatalogName("pk_persona") //nombre del paquete
		.withProcedureName("sp_listar_id_persona") //nombre del procedimiento
		.declareParameters(new SqlOutParameter("CURSOR_PERSONA", OracleTypes.CURSOR, new ColumnMapRowMapper()), new SqlParameter("idpersona", Types.INTEGER));
		SqlParameterSource in = new MapSqlParameterSource().addValue("idpersona", id);
		return simpleJdbcCall.execute(in);
	}
	@Override
	public Map<String, Object> readAll() {
		// TODO Auto-generated method stub
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("pk_persona")
				.withProcedureName("sp_listar_persona")
				.declareParameters(new SqlOutParameter("cursor_persona", OracleTypes.CURSOR, new ColumnMapRowMapper()));
		return simpleJdbcCall.execute();
	}

	@Override
	public void convertitMap(Map<String, Object> map) {
		Persona persona = new Persona();
		for (Entry<String, Object> entry : map.entrySet()) {
			System.out.println("entry key : " + entry.getKey());
			System.out.println("Object value :" + entry.getValue());
		}
	}

}
