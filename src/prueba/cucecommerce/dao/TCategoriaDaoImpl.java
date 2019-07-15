package prueba.cucecommerce.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Component;

import prueba.cucecommerce.pojo.CategoriaRowMapper;
import prueba.cucecommerce.pojo.TCategoria;

@Component("tCategoriaDao")
public class TCategoriaDaoImpl implements TCategoriaDao{
	//Sacar el DataSource para usarlo en el call 'store procedure'
//	private SimpleJdbcCall procReadActor;
	
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Autowired
	private void SetDataSoruce(DataSource dataSource){
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		//
//		this.procReadActor =
//                new SimpleJdbcCall(dataSource)
//                        .withProcedureName("sp_listarCategoriaSuperior");
	}
	
	//@Override	
	public boolean save(TCategoria tCategoria) {
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("codigo", tCategoria.getCodigo());
		paramMap.addValue("nombre", tCategoria.getNombre());
		paramMap.addValue("visible", tCategoria.isVisible());
		paramMap.addValue("categoria_superior", tCategoria.getCategoria_superior());
		
		
		return jdbcTemplate.update("INSERT INTO t_categoria (codigo,nombre,visible,categoria_superior) "
				+ "VALUES (:codigo, :nombre, :visible, :categoria_superior)", paramMap) == 1;
	}

	public ArrayList<TCategoria> findAll(){
		return (ArrayList<TCategoria>) jdbcTemplate.query("SELECT * FROM t_categoria", new RowMapper<TCategoria>(){

			//@Override
			public TCategoria mapRow(ResultSet rs, int rowNum) throws SQLException {
				TCategoria tCategoria = new TCategoria();
				tCategoria.setCodigo(rs.getInt("codigo"));
				tCategoria.setNombre(rs.getString("nombre"));
				tCategoria.setVisible(rs.getBoolean("visible"));
				tCategoria.setCategoria_superior(rs.getInt("categoria_superior"));
				return tCategoria;
			}
			
		});
	}
	
	public List<TCategoria> findCategories(){
		return jdbcTemplate.query("SELECT codigo,nombre FROM t_categoria WHERE codigo=categoria_superior AND visible=1", new RowMapper<TCategoria>(){

			//@Override
			public TCategoria mapRow(ResultSet rs, int rowNum) throws SQLException {
				TCategoria tCategoria = new TCategoria();
				tCategoria.setCodigo(rs.getInt("codigo"));
				tCategoria.setNombre(rs.getString("nombre"));
//				tCategoria.setVisible(rs.getBoolean("visible"));
//				tCategoria.setCategoria_superior(rs.getInt("categoria_superior"));
				//puse estos valores por defecto //no los necesito
				tCategoria.setVisible(true);
				tCategoria.setCategoria_superior(0);
				return tCategoria;
			}
			
		});
	}
	
	public List<TCategoria> findSubCategories(TCategoria tCategoria){	
		
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("codigo", tCategoria.getCodigo());
	
		return jdbcTemplate.query("SELECT codigo,nombre FROM t_categoria WHERE codigo<>categoria_superior AND visible=1 AND categoria_superior=:codigo",paramMap, new RowMapper<TCategoria>(){

			//@Override
			public TCategoria mapRow(ResultSet rs, int rowNum) throws SQLException {
				TCategoria tCategoria = new TCategoria();
				tCategoria.setCodigo(rs.getInt("codigo"));
				tCategoria.setNombre(rs.getString("nombre"));
//				tCategoria.setVisible(rs.getBoolean("visible"));
//				tCategoria.setCategoria_superior(rs.getInt("categoria_superior"));
				//puse estos valores por defecto //no los necesito
				tCategoria.setVisible(true);
				tCategoria.setCategoria_superior(0);
				return tCategoria;
			}
			
		});
	}
	
//	public boolean esSuperior(TCategoria tCategoria){
//		
//		MapSqlParameterSource paramMap = new MapSqlParameterSource();
//		paramMap.addValue("codigo", tCategoria.getCodigo());
//		jdbcTemplate.query("SELECT count(*) AS cantidad FROM t_categoria WHERE categoria_superior=:codigo AND codigo<>:codigo", paramMap, new RowMapper<TCategoria>(){
//
//			//@Override
//			public TCategoria mapRow(ResultSet rs, int rowNum) throws SQLException {
//				TCategoria tCategoria = new TCategoria();
//				tCategoria.setCodigo(0);
//				tCategoria.setNombre(null);
////				tCategoria.setVisible(rs.getBoolean("visible"));
////				tCategoria.setCategoria_superior(rs.getInt("categoria_superior"));
//				//puse estos valores por defecto //no los necesito
//				tCategoria.setVisible(true);
//				tCategoria.setCategoria_superior(0);
//				return tCategoria;
//			}
//			
//		});
//		
//		return false;
//	}
	
	
	public boolean esSuperior(TCategoria tCategoria){
		
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("codigo", tCategoria.getCodigo());
		return jdbcTemplate.queryForObject("SELECT count(*) AS cantidad FROM t_categoria WHERE categoria_superior=:codigo AND codigo=:codigo", paramMap, new RowMapper<Boolean>(){

			//@Override
			public Boolean mapRow(ResultSet rs, int rowNum) throws SQLException {
				Integer cantidad = rs.getInt("cantidad");
//				System.out.println("++++++ ++++ " + cantidad);
				return cantidad>0;
			}
			
		});
		
//		return false;
	}	
}
